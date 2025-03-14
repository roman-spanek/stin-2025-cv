package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.common.ControllerStatus;
import cz.tul.stin2025.cv.exceptions.ControllerException;
import cz.tul.stin2025.cv.model.CommandEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ACCommand implements Command {

    @Override
    public void switchOn(CommandEntity commandEntity) {
        if (commandEntity.getControlName().equals("AC")) { //?
            commandEntity.setStatus(ControllerStatus.ON);
            log.info("AC is {}", ControllerStatus.ON);
        } else {
            log.error(" {} is not supported.", commandEntity.getControlName());
            throw new ControllerException(commandEntity.getControlName() + " is not supported.");
        }
    }

    @Override
    public void switchOff(CommandEntity commandEntity) {
        if (commandEntity.getControlName().equals("AC")) {
            commandEntity.setStatus(ControllerStatus.OFF);
            log.info("AC is {}", ControllerStatus.OFF);
        } else {
            log.error(" {} is not supported.", commandEntity.getControlName());
            throw new ControllerException(commandEntity.getControlName() + " is not supported.");
        }
    }
}
