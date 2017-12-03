package com.sirheadless.battle.structures.structure.building;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class BuildingTest {

    private Class classToTest;

    private Building testInstance;

    public BuildingTest(Class classToTest) {
        this.classToTest = classToTest;
    }

    @Parameterized.Parameters
    public static Collection classForWhichToRunTheTest() {
        Object[] classes = new Object[]{ResourceFactory.class, UnitFactory.class};
        return Arrays.asList(classes);
    }

    @Before
    public void setup() throws NoSuchMethodException {
        Constructor c = classToTest.getConstructor(UUID.class);
        try {
            this.testInstance = (Building) c.newInstance(UUID.randomUUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_beKindAsClassName_when_always() {
        assertEquals(testInstance.getKind(), testInstance.getClass().getSimpleName());
    }


}