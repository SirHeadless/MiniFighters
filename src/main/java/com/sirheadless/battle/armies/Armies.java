package com.sirheadless.battle.armies;

import com.sirheadless.battle.armies.army.Army;
import com.sirheadless.battle.armies.army.units.Unit;
import com.sirheadless.player.Player;

import java.util.List;
import java.util.UUID;

public interface Armies {

    UUID getUUId();

    List<Army> getArmies();

    boolean addUnit(Player player, Unit unit);

    boolean removeUnit(Unit unit);

    Army findArmyForPlayer(Player player);

    Army findUnitByUUId(UUID UUId);
}
