package com.sirheadless.units;

import com.sirheadless.util.Position;

public interface Unit {

    String getName();
    Position getPosition();
    int getMoveRange();
    int getFireRange();



}
