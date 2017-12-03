package com.sirheadless.battle.structures.structure;

import com.sirheadless.battle.structures.structure.building.Building;
import com.sirheadless.player.Player;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class StructureImpl implements Structure {

    @NonNull
    private final UUID UUId;
    @NonNull
    private final Player player;
    @NonNull
    private List<Building> buildings = new ArrayList<>();

    public boolean addBuilding(Building building) {
        return buildings.add(building);
    }

    public boolean removeBuilding(Building building) {
        return buildings.remove(building);
    }

}
