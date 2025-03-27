package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.common.ControllerStatus;
import cz.tul.stin2025.cv.exceptions.ControllerException;
import cz.tul.stin2025.cv.model.CommandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightsCommandImplTest {

    private LightsCommandImpl lightsCommand;
    private CommandEntity commandEntity;

    @BeforeEach
    void setUp() {
        lightsCommand = new LightsCommandImpl();
    }

    @Test
    void switchOnLightControlNameShouldSetStatusOn() {
        //set
        CommandEntity commandEntity = new CommandEntity();
        commandEntity.setControlName("light");
        commandEntity.setStatus(ControllerStatus.OFF);
        //act
        lightsCommand.switchOn(commandEntity);
        //assert
        assertEquals(ControllerStatus.ON, commandEntity.getStatus());
    }

    @Test
    void switchOnNonLightControlNameShouldThrowException() {
        //set
        CommandEntity commandEntity = new CommandEntity();
        commandEntity.setControlName("fan");
        commandEntity.setStatus(ControllerStatus.OFF);
        //act
        ControllerException exception = assertThrows(ControllerException.class, () -> {
            lightsCommand.switchOn(commandEntity);
        });
        //assert
        assertEquals("fan is not supported.", exception.getMessage());
    }

}
