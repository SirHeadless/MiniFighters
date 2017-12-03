package com.sirheadless.battle.armies;

import com.sirheadless.battle.armies.army.Army;
import com.sirheadless.battle.armies.army.ArmyImpl;
import com.sirheadless.battle.armies.army.units.Bummer;
import com.sirheadless.battle.armies.army.units.Runner;
import com.sirheadless.battle.armies.army.units.Unit;
import com.sirheadless.player.Player;
import com.sirheadless.player.PlayerImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArmiesImplTest {

    private Army armyGreen;
    private Army armyBlue;

    private Armies armies;

    private List<Unit> unitsInArmies = new ArrayList<>();

    @Before
    public void setup() {
        armyGreen = createArmy(PlayerImpl.Color.GREEN);
        armyBlue = createArmy(PlayerImpl.Color.BLUE);

        addTwoUnitsToArmy(armyGreen);
        addTwoUnitsToArmy(armyBlue);

        List<Army> armyList = new ArrayList<>(Arrays.asList(armyBlue, armyGreen));

        armies = new ArmiesImpl(UUID.randomUUID(), armyList);

    }

    @Test
    public void should_findArmy_when_callFindArmyForPlayer() {
        Army foundArmy = armies.findArmyForPlayer(armyGreen.getPlayer());

        assertEquals(armyGreen, foundArmy);
    }

    @Test
    public void should_returnTrue_when_callAddUnit() {
        Unit unitToAdd = new Runner(UUID.randomUUID());

        assertTrue(armies.addUnit(armyBlue.getPlayer(), unitToAdd));
    }

    @Test
    public void should_returnTrue_when_callRemoveUnit() {
        Unit unitToRemove = armyGreen.getUnits().get(0);

        assertTrue(armies.removeUnit(unitToRemove));
    }


    private Army createArmy(PlayerImpl.Color color) {
        Player player = new PlayerImpl(UUID.randomUUID(), color, 2000);
        return new ArmyImpl(UUID.randomUUID(), player);
    }

    private void addTwoUnitsToArmy(Army army) {
        addRunnerToArmy(army);
        addBummerToArmy(army);
    }

    private void addRunnerToArmy(Army army) {
        Unit runner = new Runner(UUID.randomUUID());
        army.addUnit(runner);

        unitsInArmies.add(runner);
    }

    private void addBummerToArmy(Army army) {
        Unit bummer = new Bummer(UUID.randomUUID());
        army.addUnit(bummer);

        unitsInArmies.add(bummer);
    }
}