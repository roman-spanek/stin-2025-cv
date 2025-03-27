package cz.tul.stin2025.cv.controller;

import cz.tul.stin2025.cv.model.CommandEntity;
import cz.tul.stin2025.cv.service.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command")
public class CommandController {

    @Autowired
    private CommandHandler commandHandler;

    @PostMapping("/switchOn")
    public void switchOn(@RequestBody CommandEntity commandEntity) {
        commandHandler.switchOn(commandEntity);
    }

    @PostMapping("/switchOff")
    public void switchOff(@RequestBody CommandEntity commandEntity) {
        commandHandler.switchOff(commandEntity);
    }
    
    @PostMapping("/undo")
    public void undo() {
        commandHandler.undo();
    }
}