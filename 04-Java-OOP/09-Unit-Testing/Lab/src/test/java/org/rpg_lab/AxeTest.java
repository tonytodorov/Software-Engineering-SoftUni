package org.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 25;

    Axe axe;
    Dummy dummy;
    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void test_WeaponShould_LosesDurability_AfterEachAttack() {
        axe.attack(dummy);
        assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void test_WeaponShouldAttackWhenBroken() {
        axe.attack(dummy);
        axe.attack(dummy);
        assertEquals(0, axe.getDurabilityPoints());
    }



}
