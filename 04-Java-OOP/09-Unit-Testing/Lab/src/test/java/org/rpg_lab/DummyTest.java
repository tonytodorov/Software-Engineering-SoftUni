package org.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 20;
    private static final int DUMMY_DAMAGE = 2;

    Dummy dummy;
    Dummy deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void test_DummyShouldLosesHealth_WhenAttacked() {
        dummy.takeAttack(DUMMY_DAMAGE);
        assertEquals(DUMMY_HEALTH - DUMMY_DAMAGE, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void test_DeadDummyThrowException_WhenAttacked() {
        deadDummy.takeAttack(DUMMY_DAMAGE);
        assertTrue(dummy.isDead());
    }

    @Test
    public void test_DeadDummyShouldGiveXpPoint() {
        int xpPoint = deadDummy.giveExperience();
        assertEquals(xpPoint, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void test_DeadDummyShouldNotGiveXpPoint() {
        int xpPoint = dummy.giveExperience();
        assertEquals(xpPoint, dummy.giveExperience());
    }

}
