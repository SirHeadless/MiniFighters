package com.sirheadless.battle.structures;

import com.sirheadless.battle.structures.structure.Structure;
import com.sirheadless.battle.structures.structure.StructureImpl;
import com.sirheadless.battle.structures.structure.building.Building;
import com.sirheadless.battle.structures.structure.building.ResourceFactory;
import com.sirheadless.battle.structures.structure.building.UnitFactory;
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

public class StructuresImplTest {

    private Structure structureGreen;
    private Structure structureBlue;

    private Structures structures;

    private List<Building> buildingsInStructures = new ArrayList<>();

    @Before
    public void setup() {
        structureBlue = createStructure(PlayerImpl.Color.BLUE);
        structureGreen = createStructure(PlayerImpl.Color.GREEN);

        addTwoBuildingsToStructure(structureBlue);
        addTwoBuildingsToStructure(structureGreen);

        List<Structure> structuresList = new ArrayList<>(Arrays.asList(structureBlue, structureGreen));

        structures = new StructuresImpl(UUID.randomUUID(), structuresList);
    }

    @Test
    public void should_findStructure_when_callFindStructureForPlayer() {
        Structure foundStructure = structures.findStructureForPlayer(structureBlue.getPlayer());

        assertEquals(structureBlue, foundStructure);
    }

    @Test
    public void should_returnTrue_when_callAddBuilding() {
        Building buildingToAdd = new UnitFactory(UUID.randomUUID());

        assertTrue(structures.addBuilding(structureBlue.getPlayer(), buildingToAdd));
    }

    @Test
    public void should_returnTrue_when_callRemoveBuilding() {
        Building buildingToRemove = structureBlue.getBuildings().get(0);

        assertTrue(structures.removeBuilding(buildingToRemove));
    }

    private Structure createStructure(PlayerImpl.Color color) {
        Player player = new PlayerImpl(UUID.randomUUID(), color, 2000);
        return new StructureImpl(UUID.randomUUID(), player);
    }

    private void addTwoBuildingsToStructure(Structure structure) {
        addResourceFactoryToStructure(structure);
        addUnitFactoryToStructure(structure);
    }

    private void addUnitFactoryToStructure(Structure structure) {
        Building unitFactory = new UnitFactory(UUID.randomUUID());
        structure.addBuilding(unitFactory);

        buildingsInStructures.add(unitFactory);
    }

    private void addResourceFactoryToStructure(Structure structure) {
        Building resourceFactory = new ResourceFactory(UUID.randomUUID());
        structure.addBuilding(resourceFactory);

        buildingsInStructures.add(resourceFactory);
    }

}