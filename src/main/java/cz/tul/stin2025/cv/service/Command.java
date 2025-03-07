package cz.tul.stin2025.cv.service;

import cz.tul.stin2025.cv.model.CommandEntity;

public interface Command {
    void switchOn(CommandEntity commandEntity);
    void switchOff(CommandEntity commandEntity);
}
