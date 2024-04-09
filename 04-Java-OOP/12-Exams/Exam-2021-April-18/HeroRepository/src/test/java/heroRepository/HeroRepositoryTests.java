package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class HeroRepositoryTests {


    private static final String HERO_NAME = "Hero";
    private static final int HERO_LEVEL = 102;


    HeroRepository heroRepository;
    Hero hero;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hero = new Hero(HERO_NAME, HERO_LEVEL);
        heroRepository.create(hero);
    }

    @Test
    public void test_ConstructorShouldCreateCorrectObject() {

    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectSizeOfHeroCollection() {
        int actualHeroCount = heroRepository.getCount();
        assertEquals(1, actualHeroCount);
    }

    @Test
    public void test_CreateMethod_ShouldCreateHeroCorrect() {
        String newHero = heroRepository.create(new Hero("Test", 12));
        assertEquals("Successfully added hero Test with level 12", newHero);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateMethod_ShouldThrowException_WhenHeroNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateMethod_ShouldThrowException_WhenHeroExist() {
        heroRepository.create(new Hero(HERO_NAME, HERO_LEVEL));
    }

    @Test
    public void test_RemoveMethod_ShouldRemoveHeroCorrect() {
        boolean removeHero = heroRepository.remove(HERO_NAME);
        assertTrue(removeHero);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveMethod_ShouldThrowException_WhenHeroNameNull() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveMethod_ShouldThrowException_WhenHeroNameEmpty() {
        heroRepository.remove("");
    }

    @Test
    public void test_GetHeroWithHighestLevelMethod_ShouldReturnCorrectHero() {
        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        assertEquals(hero, heroWithHighestLevel);
    }

    @Test
    public void test_GetHeroWithHighestLevelMethod_ShouldReturnNull_WhenHeroCollectionEmpty() {
        heroRepository = new HeroRepository();
        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        assertNull(heroWithHighestLevel);
    }

    @Test
    public void test_GetHeroMethod_ShouldReturnCorrectHeroByName() {
        Hero actualHero = heroRepository.getHero(HERO_NAME);
        assertEquals(hero, actualHero);
    }

    @Test
    public void test_GetHeroMethod_ShouldReturnNull_WhenHeroDoesNotExist() {
        Hero actualHero = heroRepository.getHero("Test");
        assertNull(actualHero);
    }

    @Test
    public void test_GetHeroesMethod_ShouldReturnAllHeroes() {
        Collection<Hero> heroes = heroRepository.getHeroes();
        boolean contains = heroes.contains(hero);
        assertTrue(contains);
    }



}
