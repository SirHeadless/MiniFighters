package com.sirheadless.battle.structures.structure;

import com.sirheadless.battle.structures.structure.building.Building;
import com.sirheadless.battle.structures.structure.building.UnitFactory;
import com.sirheadless.player.Player;
import com.sirheadless.player.PlayerImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class StructureImplTest {

    private final UUID unchangedStructureUUId = UUID.randomUUID();
    private final UUID structureWithBuildingsUUId = UUID.randomUUID();
    private Structure unchangedStructure;
    private Structure structureWithBuildings;
    private Player player;
    private Building buildingInStructure = new UnitFactory(UUID.randomUUID());

    @Before
    public void setup() {
        player = new PlayerImpl(UUID.randomUUID(), PlayerImpl.Color.BLUE, 2000);
        unchangedStructure = new StructureImpl(unchangedStructureUUId, player);

        structureWithBuildings = new StructureImpl(structureWithBuildingsUUId, player);
        structureWithBuildings.addBuilding(buildingInStructure);
    }

    @Test
    public void when_strucutreIsInstantiated_should_containPlayerAndEmpytBuildings() {
        assertEquals(unchangedStructure.getUUId(), unchangedStructureUUId);
        assertEquals(unchangedStructure.getPlayer(), player);
        assertEquals(unchangedStructure.getBuildings(), Collections.EMPTY_LIST);
    }

    @Test
    public void should_addBuilding_when_callAddBuilding() {
        Building building = new UnitFactory(UUID.randomUUID());
        unchangedStructure.addBuilding(building);

        List<Building> expectedBuildings = Arrays.asList(building);

        assertEquals(unchangedStructure.getBuildings(), expectedBuildings);
    }

    @Test
    public void should_removeBuilding_when_callRemoveBuilding() {
        structureWithBuildings.removeBuilding(buildingInStructure);

        assertEquals(structureWithBuildings.getBuildings(), Collections.EMPTY_LIST);
    }
}