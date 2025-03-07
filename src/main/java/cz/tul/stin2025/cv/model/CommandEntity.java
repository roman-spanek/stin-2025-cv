package cz.tul.stin2025.cv.model;

import cz.tul.stin2025.cv.common.ControllerStatus;
import lombok.Data;

@Data
public class CommandEntity {
    private String ControlName;
    private ControllerStatus status;
}
