package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.model.CommandEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Data
public class CommandHandler {
    private HashMap<String, Command> commands;

    public void switchOn(CommandEntity commandEntity) {
        commands.get(commandEntity.getControlName()).switchOn(commandEntity);
    }

    public void switchOff( CommandEntity commandEntity) {
        commands.get(commandEntity.getControlName()).switchOff(commandEntity);
    }
}
