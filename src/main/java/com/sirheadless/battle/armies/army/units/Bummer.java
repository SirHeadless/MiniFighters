package com.sirheadless.battle.armies.army.units;

import com.sirheadless.util.Position;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class Bummer implements Unit {

    @NonNull
    private final UUID UUId;
    @NonNull private final String name = "Bummer";
    private Position position;
    @NonNull private final int moveRange = 2;
    @NonNull private final int fireRange = 1;

}
