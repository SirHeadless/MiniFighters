package com.sirheadless.battle;

import com.sirheadless.battle.armies.Armies;
import com.sirheadless.battle.armies.army.Army;
import com.sirheadless.battle.structures.Structures;
import com.sirheadless.battle.structures.structure.Structure;
import com.sirheadless.player.Player;

import java.util.UUID;

public interface Battle {

    UUID getUUId();

    Armies getArmies();

    Structures getStructures();

    Army findArmyForPlayer(Player player);

    Structure findStructureForPlayer(Player player);

}
