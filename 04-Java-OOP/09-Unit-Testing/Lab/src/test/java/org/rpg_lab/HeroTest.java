package org.rpg_lab;

public class HeroTest {

    public void test_HeroShouldGainXp_WhenTargetDie() {
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 0;
            }

            @Override
            public boolean isDead() {
                return false;
            }
        };

        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };


    }

}
