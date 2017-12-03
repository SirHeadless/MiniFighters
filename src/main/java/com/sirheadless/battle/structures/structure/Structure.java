package com.sirheadless.battle.structures.structure;

import com.sirheadless.battle.structures.structure.building.Building;
import com.sirheadless.player.Player;

import java.util.List;
import java.util.UUID;

public interface Structure {

    UUID getUUId();

    Player getPlayer();

    List<Building> getBuildings();

    boolean addBuilding(Building building);

    boolean removeBuilding(Building building);
}
