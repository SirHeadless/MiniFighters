package com.sirheadless.util;

import lombok.Data;
import lombok.NonNull;

@Data
public class Position {

    public final static Position NOT_ON_BOARD = new Position(-1,-1);

    @NonNull private int coordX;
    @NonNull private int coordY;

}
