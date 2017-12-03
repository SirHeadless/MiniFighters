package com.sirheadless.battle.armies.army.units;

import com.sirheadless.util.Position;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class Runner implements Unit {

    @NonNull
    private final UUID UUId;
    @NonNull private final String name = "Runner";
    private Position position;
    @NonNull private final int moveRange = 3;
    @NonNull private final int fireRange = 1;

}
