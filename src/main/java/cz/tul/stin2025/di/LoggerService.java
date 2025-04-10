package cz.tul.stin2025.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggerService {

    public void log(String message) {
        log.error("TEST {}", message);
    }
}
