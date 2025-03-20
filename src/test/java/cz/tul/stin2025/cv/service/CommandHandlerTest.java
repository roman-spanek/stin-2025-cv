package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.common.ControllerStatus;
import cz.tul.stin2025.cv.model.CommandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommandHandlerTest {

    private CommandHandler commandHandler;
    private Command mockCommand;
    private CommandEntity commandEntity;

    @BeforeEach
    public void setUp() {
        commandHandler = new CommandHandler();
        mockCommand = Mockito.mock(Command.class);
        commandEntity = new CommandEntity();
        commandEntity.setControlName("testControl");
        commandEntity.setStatus(ControllerStatus.ON);

        HashMap<String, Command> commands = new HashMap<>();
        commands.put("testControl", mockCommand);
        commandHandler.setCommands(commands);
    }

    @Test
    public void testSwitchOn() {
        commandHandler.switchOn(commandEntity);
        verify(mockCommand, times(1)).switchOn(commandEntity);
        assertEquals(1, commandHandler.getCommandHistory().getHistory().size());
    }

    @Test
    public void testSwitchOff() {
        commandHandler.switchOff(commandEntity);
        verify(mockCommand, times(1)).switchOff(commandEntity);
        assertEquals(1, commandHandler.getCommandHistory().getHistory().size());
    }

    @Test
    public void testUndoSwitchOn() {
        commandHandler.switchOn(commandEntity);
        commandHandler.undo();
        verify(mockCommand, times(1)).switchOn(commandEntity);
        verify(mockCommand, times(1)).switchOff(commandEntity);
    }

    @Test
    public void testUndoSwitchOff() {
        commandEntity.setStatus(ControllerStatus.OFF);
        commandHandler.switchOff(commandEntity);
        commandHandler.undo();
        verify(mockCommand, times(1)).switchOff(commandEntity);
        verify(mockCommand, times(1)).switchOn(commandEntity);
    }
}