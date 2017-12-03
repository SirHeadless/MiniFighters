package com.sirheadless.battle.structures.structure.building;

import com.sirheadless.util.Position;

import java.util.UUID;

public interface Building {

    UUID getUUId();

    String getKind();

    Position getPosition();

}
