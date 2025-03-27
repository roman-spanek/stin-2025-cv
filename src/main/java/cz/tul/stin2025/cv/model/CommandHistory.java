package cz.tul.stin2025.cv.model;

import lombok.Data;

import java.util.Stack;

@Data
public class CommandHistory {
    private Stack<CommandEntity> history = new Stack<>();

    public void push(CommandEntity commandEntity) {
        history.push(commandEntity);
    }

    public CommandEntity pop() {
        return history.isEmpty() ? null : history.pop();
    }
}
