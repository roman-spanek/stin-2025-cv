package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.exceptions.ControllerException;
import cz.tul.stin2025.cv.model.CommandEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Data
@Service
@AllArgsConstructor
public class WindowCommandImpl implements Command {
    private List<Command> commands;

    @Override
    public void switchOn(CommandEntity commandEntity) {
        if (commandEntity.getControlName().equals("window")) {
            commandEntity.setControlName("AC");
            commands.get(0).switchOn(commandEntity);
            commandEntity.setControlName("light");
            commands.get(1).switchOff(commandEntity);
        } else {
            log.error(" {} is not supported.", commandEntity.getControlName());
            throw new ControllerException(commandEntity.getControlName() + " is not supported.");
        }
    }

    @Override
    public void switchOff(CommandEntity commandEntity) {
        if (commandEntity.getControlName().equals("window")) {
            commands.get(0).switchOff(commandEntity);
            commands.get(1).switchOn(commandEntity);
        } else {
            log.error(" {} is not supported.", commandEntity.getControlName());
            throw new ControllerException(commandEntity.getControlName() + " is not supported.");
        }
    }
}
