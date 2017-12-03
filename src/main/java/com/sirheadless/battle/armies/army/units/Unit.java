package com.sirheadless.battle.armies.army.units;

import com.sirheadless.util.Position;
import com.sirheadless.util.UUIdElement;

public interface Unit extends UUIdElement {

    String getName();
    Position getPosition();
    int getMoveRange();
    int getFireRange();



}
