package model;

import java.util.UUID;

public class ToDo {
    private UUID id;
    private UUID UserId;
    private String name;
    private boolean complete = false;

    public ToDo() {
        this.id = UUID.randomUUID();
    }

    public ToDo(UUID userId, String name) {
        this();
        this.UserId = userId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
