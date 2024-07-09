package model;

import java.util.UUID;

public class ToDo {
    private UUID UserId;
    private String name;
    private boolean complete;

    public ToDo(UUID userId, String name, boolean complete) {
        this.UserId = userId;
        this.name = name;
        this.complete = complete;
    }

    public UUID getUserId() {
        return UserId;
    }

    public String getName() {
        return name;
    }

    public boolean isComplete() {
        return complete;
    }
}
