package com.sirheadless.player;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class PlayerImplTest {

    private static final double DELTA = 1e-15;

    private PlayerImpl.Color playerColor;
    private float playerStartDeposit;
    private Player player;
    private UUID playerUUId = UUID.randomUUID();

    @Before
    public void setup() {
        playerColor = PlayerImpl.Color.BLUE;
        playerStartDeposit = 2000f;

        player = new PlayerImpl(playerUUId, playerColor, playerStartDeposit);
    }

    @Test
    public void when_createPlayer_should_initiatedCorrectly() {

        assertEquals(player.getUUId(), playerUUId);
        assertEquals(player.getColor(), playerColor);
        assertEquals(player.getDeposit(), playerStartDeposit, DELTA);
    }

    @Test
    public void should_reduceDepositeByAmount_when_callWithdrawWithAmount() {
        float amountToWithdraw = 200f;
        player.withdrawCredit(amountToWithdraw);

        assertEquals(player.getDeposit(), playerStartDeposit - amountToWithdraw, DELTA);
    }

    @Test
    public void should_increaseDepositeByAmount_when_callTransferWithAmount() {
        float amountToTransfer = 300f;
        player.transferCredit(amountToTransfer);

        assertEquals(player.getDeposit(), playerStartDeposit + amountToTransfer, DELTA);
    }

}