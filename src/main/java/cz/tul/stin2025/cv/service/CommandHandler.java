package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.common.ControllerStatus;
import cz.tul.stin2025.cv.model.CommandEntity;
import cz.tul.stin2025.cv.model.CommandHistory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Setter
@Getter
public class CommandHandler {
    private HashMap<String, Command> commands;
    private CommandHistory commandHistory = new CommandHistory();

    public void switchOn(CommandEntity commandEntity) {
        commands.get(commandEntity.getControlName()).switchOn(commandEntity);
        commandHistory.push(commandEntity);
    }

    public void switchOff( CommandEntity commandEntity) {
        commands.get(commandEntity.getControlName()).switchOff(commandEntity);
        commandHistory.push(commandEntity);
    }

    public void undo() {
        CommandEntity lastCommand = commandHistory.pop();
        if (lastCommand != null) {
            if (lastCommand.getStatus() == ControllerStatus.ON) {
                commands.get(lastCommand.getControlName()).switchOff(lastCommand);
            } else {
                commands.get(lastCommand.getControlName()).switchOn(lastCommand);
            }
        }
    }
}
