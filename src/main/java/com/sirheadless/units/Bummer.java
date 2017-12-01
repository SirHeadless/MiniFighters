package com.sirheadless.units;

import com.sirheadless.util.Position;
import lombok.Data;
import lombok.NonNull;

@Data
public class Bummer implements Unit {

    @NonNull private final String name = "Bummer";
    @NonNull private Position position = Position.NOT_ON_BOARD;
    @NonNull private final int moveRange = 2;
    @NonNull private final int fireRange = 1;

}
