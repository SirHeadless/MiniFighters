package com.sirheadless.battle.armies.army;

import com.sirheadless.battle.armies.army.units.Unit;
import com.sirheadless.player.Player;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ArmyImpl implements Army {

    @NonNull
    private final UUID UUId;
    @NonNull
    private final Player player;
    @NonNull
    private List<Unit> units = new ArrayList<>();

    public boolean addUnit(Unit unit) {
        return units.add(unit);
    }

    public boolean removeUnit(Unit unit) {
        return units.remove(unit);
    }


//    public Army findElementWithUUId(UUID UUId){
//        units.findElementWithUUId(uuIdElement);
//    }
}
