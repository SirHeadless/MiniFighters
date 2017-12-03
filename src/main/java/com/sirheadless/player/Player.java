package com.sirheadless.player;

import java.util.UUID;

public interface Player {

    UUID getUUId();

    Object getColor();

    float getDeposit();

    void setDeposit(float deposit);

    void withdrawCredit(float amount);

    void transferCredit(float amount);


}
