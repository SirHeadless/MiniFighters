package com.sirheadless.battle.structures;

import com.sirheadless.battle.structures.structure.Structure;
import com.sirheadless.battle.structures.structure.building.Building;
import com.sirheadless.player.Player;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
public class StructuresImpl implements Structures {

    @NonNull
    private final UUID UUId;
    @NonNull
    private List<Structure> structures;


    @Override
    public boolean addBuilding(Player player, Building building) {
        Structure structure = findStructureForPlayer(player);
        if (structure != null) {
            return structure.addBuilding(building);
        }
        return false;
    }

    @Override
    public boolean removeBuilding(Building building) {
        for (Structure structure : structures) {
            if (structure.removeBuilding(building)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Structure findStructureForPlayer(Player player) {
        return structures.stream().filter(structure -> structure.getPlayer().equals(player)).findFirst().get();
    }
}
