package cz.tul.stin2025.cv.config;

import cz.tul.stin2025.cv.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
public class CommandHandlerConfig {

    @Bean
    public CommandHandler commandHandler() {
        CommandHandler commandHandler = new CommandHandler();
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("light", new LightsCommandImpl()); //?
        List<Command> windowCommands = List.of(new ACCommand(), new LightsCommandImpl());
        commands.put("window", new WindowCommandImpl(windowCommands)); //?
        commandHandler.setCommands(commands);
        return commandHandler;
    }
}
