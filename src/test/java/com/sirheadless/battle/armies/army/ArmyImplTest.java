package com.sirheadless.battle.armies.army;

import com.sirheadless.battle.armies.army.units.Runner;
import com.sirheadless.battle.armies.army.units.Unit;
import com.sirheadless.player.Player;
import com.sirheadless.player.PlayerImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ArmyImplTest {

    private final UUID unchangedArmyUUId = UUID.randomUUID();
    private final UUID armyWithUnitUUId = UUID.randomUUID();
    private Army unchangedArmy;
    private Army armyWithUnit;
    private Player player;
    private Unit unitInArmy = new Runner(UUID.randomUUID());

    @Before
    public void setup() {

        player = new PlayerImpl(UUID.randomUUID(), PlayerImpl.Color.BLUE, 2000f);
        unchangedArmy = new ArmyImpl(unchangedArmyUUId, player);

        armyWithUnit = new ArmyImpl(armyWithUnitUUId, player);
        armyWithUnit.addUnit(unitInArmy);

    }

    @Test
    public void when_armyIsInstantiaded_should_containPlayerAndEmptyUnits() {

        assertEquals(unchangedArmy.getUUId(), unchangedArmyUUId);
        assertEquals(unchangedArmy.getPlayer(), player);
        assertEquals(unchangedArmy.getUnits(), Collections.EMPTY_LIST);
    }


    @Test
    public void should_addUnit_when_callAddUnit() {
        Unit unit = new Runner(UUID.randomUUID());
        unchangedArmy.addUnit(unit);

        List<Unit> expectedUnits = Arrays.asList(unit);

        assertEquals(unchangedArmy.getUnits(), expectedUnits);
    }

    @Test
    public void should_removeUnit_when_callRemoveUnit() {
        armyWithUnit.removeUnit(unitInArmy);

        assertEquals(armyWithUnit.getUnits(), Collections.EMPTY_LIST);
    }

}