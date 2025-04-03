package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.model.CommandEntity;
import cz.tul.stin2025.cv.common.ControllerStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class DeviceService {
    private final String API_URL = "http://idnes.cz:8080/api/test";
    private final RestTemplate restTemplate;

    public DeviceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CommandEntity updateDevice(String controlName, ControllerStatus status) {
        CommandEntity command = new CommandEntity();
        command.setControlName(controlName);
        command.setStatus(status);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CommandEntity> request = new HttpEntity<>(command, headers);

        return restTemplate.postForObject(API_URL, request, CommandEntity.class);
    }

    public CommandEntity getDevice(String controlName) {
        return restTemplate.getForObject(API_URL + "?controlName=" + controlName, CommandEntity.class);
    }
}