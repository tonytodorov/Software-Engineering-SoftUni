package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {


    private static final String TEAM_NAME = "Juventus";
    private static final int TEAM_VACANT_POSITION = 1;
    private static final String FOOTBALLER_NAME = "Ibrahimovic";
    private static final String DUMMY_FOOTBALLER = "Test";

    FootballTeam footballTeam;
    Footballer footballer;

    @Before
    public void setUp() {
        footballTeam = new FootballTeam(TEAM_NAME, TEAM_VACANT_POSITION);
        footballer = new Footballer(FOOTBALLER_NAME);
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenVacantPositionBelowZero() {
        footballTeam = new FootballTeam(TEAM_NAME, -12);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenTeamNameNull() {
        footballTeam = new FootballTeam(null, TEAM_VACANT_POSITION);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenTeamNameEmpty() {
        footballTeam = new FootballTeam("", TEAM_VACANT_POSITION);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectTeamName() {
        String actualTeamName = footballTeam.getName();
        assertEquals(TEAM_NAME, actualTeamName);
    }

    @Test
    public void test_GetVacantPositionMethod_ShouldReturnCorrectTeamVacantPosition() {
        int actualVacantPositions = footballTeam.getVacantPositions();
        assertEquals(TEAM_VACANT_POSITION, actualVacantPositions);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectCountOfFootballers() {
        int actualFootballersCount = footballTeam.getCount();
        assertEquals(1, actualFootballersCount);
    }

    @Test
    public void test_AddFootballerMethod_ShouldAddFootballerCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddFootballerMethod_ShouldThrowException_WhenCountOfFootballersEqualTeamVacantPosition() {
        footballTeam = new FootballTeam(TEAM_NAME, 0);
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void test_RemoveFootballerMethod_ShouldRemoveFootballerCorrect() {
        footballTeam.removeFootballer(footballer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveFootballerMethod_ShouldThrowException_WhenFootballerDoesNotExist() {
        footballTeam.removeFootballer(DUMMY_FOOTBALLER);
    }

    @Test
    public void test_FootballerForSale_ShouldSellFootballerCorrect() {
        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FootballerForSale_ShouldThrowException_WhenFootballerDoesNotExist() {
        footballTeam.footballerForSale(DUMMY_FOOTBALLER);
    }



}
