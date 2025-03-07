package cz.tul.stin2025.cv.common;

import lombok.Getter;

@Getter
public enum ControllerStatus {
    ON("ON"),
    OFF("OFF");

    private final String controllerStatus;

    ControllerStatus(String controllerStatus) {
        this.controllerStatus = controllerStatus;
    }
}
