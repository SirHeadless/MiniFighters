package com.sirheadless.units;

import com.sirheadless.util.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class UnitTest {

    private Class ClassToTest;

    private Unit testInstance;

    public UnitTest(Class ClassToTest){
        this.ClassToTest = ClassToTest;
    }

    @Before
    public void setup() throws NoSuchMethodException {
        Constructor c = ClassToTest.getConstructor();
        try {
            this.testInstance = (Unit) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_haveNameLikeClassName_when_always(){
        assertEquals(testInstance.getName(),testInstance.getClass().getSimpleName());
    }

    @Test
    public void should_haveOutOfBoardPosition_when_instantiated(){
        assertEquals(testInstance.getPosition(), Position.NOT_ON_BOARD);
    }

    @Test
    public void should_haveRangesHigherEqualsNull_when_instantiated(){
        assertTrue(testInstance.getFireRange() >= 0);
        assertTrue(testInstance.getMoveRange() >= 0);
    }


    @Parameterized.Parameters
    public static Collection classesForWhichToRunTheTests(){
        Object[] classes = new Object[] {Runner.class, Bummer.class};
        return Arrays.asList(classes);
    }


}