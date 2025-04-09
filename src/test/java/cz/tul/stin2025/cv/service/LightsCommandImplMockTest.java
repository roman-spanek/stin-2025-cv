package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.common.ControllerStatus;
import cz.tul.stin2025.cv.exceptions.ControllerException;
import cz.tul.stin2025.cv.model.CommandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LightsCommandImplMockTest {

    @InjectMocks
    private LightsCommandImpl lightsCommand;

    @Mock
    private CommandEntity mockCommandEntity;

    @Spy
    private CommandEntity spyCommandEntity;

    @BeforeEach
    void setUp() {
        // Initialize spy manually if needed
        spyCommandEntity = spy(new CommandEntity());
    }

    @Test
    void switchOn_shouldCallSetStatusExactlyOnce() {
        // Arrange
        when(mockCommandEntity.getControlName()).thenReturn("light");

        // Act
        lightsCommand.switchOn(mockCommandEntity);

        // Assert
        verify(mockCommandEntity, times(1)).setStatus(ControllerStatus.ON);
        verify(mockCommandEntity, never()).setStatus(ControllerStatus.OFF);
    }

    @Test
    void switchOff_shouldCallMethodsInOrder() {
        // Arrange
        when(mockCommandEntity.getControlName()).thenReturn("light");

        // Act
        lightsCommand.switchOff(mockCommandEntity);

        // Assert - verifying order of method calls
        inOrder(mockCommandEntity).verify(mockCommandEntity).getControlName();
        inOrder(mockCommandEntity).verify(mockCommandEntity).setStatus(ControllerStatus.OFF);
    }

    @Test
    void switchOn_withSpyObject_demonstratesRealMethodCalls() {
        // Arrange
        spyCommandEntity.setControlName("light");

        // Act
        lightsCommand.switchOn(spyCommandEntity);

        // Assert
        verify(spyCommandEntity).setStatus(ControllerStatus.ON);
        assertEquals(ControllerStatus.ON, spyCommandEntity.getStatus());
    }

    @Test
    void switchOn_withAnyString_shouldThrowException() {
        // Arrange
        when(mockCommandEntity.getControlName()).thenReturn("unsupportedControlName");

        // Act & Assert
        assertThrows(ControllerException.class, () -> {
            lightsCommand.switchOn(mockCommandEntity);
        });
    }

    @Test
    void switchOff_verifyNoMoreInteractions() {
        // Arrange
        when(mockCommandEntity.getControlName()).thenReturn("light");

        // Act
        lightsCommand.switchOff(mockCommandEntity);

        // Assert
        verify(mockCommandEntity).getControlName();
        verify(mockCommandEntity).setStatus(ControllerStatus.OFF);
        verifyNoMoreInteractions(mockCommandEntity);
    }

    @Test
    void switchOn_demonstrateDoThrow() {
        // Arrange
        doThrow(new RuntimeException("Test exception"))
                .when(mockCommandEntity).setStatus(any(ControllerStatus.class));
        when(mockCommandEntity.getControlName()).thenReturn("light");

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            lightsCommand.switchOn(mockCommandEntity);
        });
    }
}