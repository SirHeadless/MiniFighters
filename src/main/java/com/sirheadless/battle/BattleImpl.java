package com.sirheadless.battle;

import com.sirheadless.battle.armies.Armies;
import com.sirheadless.battle.armies.army.Army;
import com.sirheadless.battle.structures.Structures;
import com.sirheadless.battle.structures.structure.Structure;
import com.sirheadless.player.Player;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class BattleImpl implements Battle {

    @NonNull
    private final UUID UUId;
    @NonNull
    private Armies armies;
    @NonNull
    private Structures structures;


    @Override
    public Army findArmyForPlayer(Player player) {
        return armies.findArmyForPlayer(player);
    }

    @Override
    public Structure findStructureForPlayer(Player player) {
        return structures.findStructureForPlayer(player);
    }
}
