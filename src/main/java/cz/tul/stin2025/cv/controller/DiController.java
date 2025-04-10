package cz.tul.stin2025.cv.controller;

import cz.tul.stin2025.di.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/di")
public class DiController {

    private final LoggerService loggerService;

    public DiController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @PostMapping("/log")
    public void switchOn(@RequestBody String message) {
        loggerService.log(message);
    }
}
