package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.common.ControllerStatus;
import cz.tul.stin2025.cv.exceptions.ControllerException;
import cz.tul.stin2025.cv.model.CommandEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LightsCommandImpl implements Command{
    @Override
    public void switchOn(CommandEntity commandEntity) {
        if (commandEntity == null) {
            log.error("CommandEntity is null.");
            throw new ControllerException("CommandEntity is null.");
        }
        if (commandEntity.getControlName().equals("light")) { //?
            commandEntity.setStatus(ControllerStatus.ON);
        log.info("Light is {}", ControllerStatus.ON);
        } else {
            //vs 1
            notSupported(commandEntity);
            // vs 2
            //log.error(" {} is not supported.", commandEntity.getControlName());
            //throw new ControllerException(commandEntity.getControlName() + " is not supported.");
        }

    }

    @Override
    public void switchOff(CommandEntity commandEntity) {
        if (commandEntity.getControlName().equals("light")) {
            commandEntity.setStatus(ControllerStatus.OFF);
            log.info("Light is {}", ControllerStatus.OFF);
        } else {
            //vs 1
            commandEntity = new CommandEntity();
            notSupported(commandEntity);
        }
    }

    private void notSupported (CommandEntity commandEntity) {
        if (commandEntity == null) {
            log.error("CommandEntity is null.");
            throw new ControllerException("CommandEntity is null.");
        }
        log.error(" {} is not supported.", commandEntity.getControlName());
        throw new ControllerException(commandEntity.getControlName() + " is not supported.");
    }

}
