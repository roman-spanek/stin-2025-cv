package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.model.CommandEntity;
import cz.tul.stin2025.cv.common.ControllerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class DeviceServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private DeviceService deviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateDevice_shouldReturnUpdatedCommandEntity() {
        // Arrange
        CommandEntity command = new CommandEntity();
        command.setControlName("light");
        command.setStatus(ControllerStatus.ON);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CommandEntity> request = new HttpEntity<>(command, headers);

        when(restTemplate.postForObject(anyString(), any(HttpEntity.class), eq(CommandEntity.class)))
                .thenReturn(command);

        // Act
        CommandEntity result = deviceService.updateDevice("light", ControllerStatus.ON);

        // Assert
        assertNotNull(result);
        assertEquals("light", result.getControlName());
        assertEquals(ControllerStatus.ON, result.getStatus());
        verify(restTemplate, times(1)).postForObject(anyString(), any(HttpEntity.class), eq(CommandEntity.class));
    }

    @Test
    void getDevice_shouldReturnCommandEntity() {
        // Arrange
        CommandEntity command = new CommandEntity();
        command.setControlName("light");

        when(restTemplate.getForObject(anyString(), eq(CommandEntity.class)))
                .thenReturn(command);

        // Act
        CommandEntity result = deviceService.getDevice("light");

        // Assert
        assertNotNull(result);
        assertEquals("light", result.getControlName());
        verify(restTemplate, times(1)).getForObject(anyString(), eq(CommandEntity.class));
    }
}