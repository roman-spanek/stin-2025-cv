package cz.tul.stin2025.cv.config;

import cz.tul.stin2025.cv.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
public class CommandHandlerConfig {

    @Bean
    public CommandHandler commandHandler(@Value("${control.ligts}") String commnadlight) {
        CommandHandler commandHandler = new CommandHandler();
        HashMap<String, Command> commands = new HashMap<>();
        commands.put(commnadlight, new LightsCommandImpl()); //?
        List<Command> windowCommands = List.of(new ACCommand(), new LightsCommandImpl());
        commands.put("window", new WindowCommandImpl(windowCommands)); //?
        commandHandler.setCommands(commands);
        return commandHandler;
    }
}
