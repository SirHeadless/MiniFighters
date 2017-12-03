package com.sirheadless.battle.armies;

import com.sirheadless.battle.armies.army.Army;
import com.sirheadless.battle.armies.army.units.Unit;
import com.sirheadless.player.Player;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
public class ArmiesImpl implements Armies {

    @NonNull
    private final UUID UUId;
    @NonNull
    private List<Army> armies;


    public boolean addUnit(Player player, Unit unit) {
        Army army = findArmyForPlayer(player);
        if (army != null) {
            return army.addUnit(unit);
        }
        return false;
    }

    public boolean removeUnit(Unit unit) {
        for (Army army : armies) {
            if (army.removeUnit(unit)) {
                return true;
            }
        }
        return false;
    }

    public Army findArmyForPlayer(final Player player) {
        return armies.stream().filter(army -> army.getPlayer().equals(player)).findFirst().get();
    }

    @Override
    public Army findUnitByUUId(UUID UUId) {
        return armies.stream().filter(army -> army.getUUId().equals(UUId)).findFirst().get();
    }


}
