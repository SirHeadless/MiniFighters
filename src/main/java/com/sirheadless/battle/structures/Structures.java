package com.sirheadless.battle.structures;

import com.sirheadless.battle.structures.structure.Structure;
import com.sirheadless.battle.structures.structure.building.Building;
import com.sirheadless.player.Player;

import java.util.List;
import java.util.UUID;

public interface Structures {

    UUID getUUId();

    List<Structure> getStructures();

    boolean addBuilding(Player player, Building building);

    boolean removeBuilding(Building building);

    Structure findStructureForPlayer(Player player);
}
