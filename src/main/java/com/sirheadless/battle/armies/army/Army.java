package com.sirheadless.battle.armies.army;

import com.sirheadless.battle.armies.army.units.Unit;
import com.sirheadless.player.Player;

import java.util.List;
import java.util.UUID;

public interface Army {

    UUID getUUId();

    Player getPlayer();

    List<Unit> getUnits();

    boolean addUnit(Unit unit);

    boolean removeUnit(Unit unit);

}
