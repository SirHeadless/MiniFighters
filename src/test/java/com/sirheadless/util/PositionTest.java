package com.sirheadless.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void should_XAndYBeMinus1_when_NOTONBOARDElement(){
        Position not_on_board_position = Position.NOT_ON_BOARD;

        assertTrue(not_on_board_position.getCoordX() < 0);
        assertTrue(not_on_board_position.getCoordY() < 0);
    }

    @Test
    public void should_haveTheCorrectionCoordinates_when_afterInstantiate() {
        Position position = new Position(1,2);

        assertEquals(position.getCoordX(), 1);
        assertEquals(position.getCoordY(), 2);
    }

}