package org.rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Axus";

    @Test
    public void test_HeroShouldGainXp_WhenTargetDie() {

        Weapon weapon = Mockito.mock(Weapon.class);
        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weapon);
        hero.attack(target);

        assertEquals(TARGET_XP, hero.getExperience());
    }
}
