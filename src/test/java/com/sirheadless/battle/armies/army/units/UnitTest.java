package com.sirheadless.battle.armies.army.units;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class UnitTest {

    private Class classToTest;

    private Unit testInstance;

    public UnitTest(Class classToTest) {
        this.classToTest = classToTest;
    }

    @Parameterized.Parameters
    public static Collection classesForWhichToRunTheTests() {
        Object[] classes = new Object[]{Runner.class, Bummer.class};
        return Arrays.asList(classes);
    }

    @Before
    public void setup() throws NoSuchMethodException {
        Constructor c = classToTest.getConstructor(UUID.class);
        try {
            this.testInstance = (Unit) c.newInstance(UUID.randomUUID());
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
        assertEquals(testInstance.getPosition(), null);
    }

    @Test
    public void should_haveRangesHigherEqualsNull_when_instantiated(){
        assertTrue(testInstance.getFireRange() >= 0);
        assertTrue(testInstance.getMoveRange() >= 0);
    }


}