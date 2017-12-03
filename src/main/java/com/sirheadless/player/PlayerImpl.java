package com.sirheadless.player;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class PlayerImpl implements Player {

    @NonNull
    private final UUID UUId;
    @NonNull
    private final Color color;
    @NonNull
    private float deposit;

    public void withdrawCredit(float amount) {
        this.deposit -= amount;
    }

    public void transferCredit(float amount) {
        this.deposit += amount;
    }

    public enum Color {
        RED("red"),
        GREEN("green"),
        BLUE("blue"),
        YELLOW("yellow");

        String type;

        Color(String type) {
            this.type = type;
        }

    }

}
