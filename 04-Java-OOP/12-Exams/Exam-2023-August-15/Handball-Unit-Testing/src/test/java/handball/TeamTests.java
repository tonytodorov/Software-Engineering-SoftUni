package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTests {

    private static final String TEAM_NAME = "Barcelona";
    private static final String HANDBALL_PLAYER_NAME = "George";
    private static final int TEAM_POSITION = 2;
    private static final int BELOW_ZERO_TEAM_POSITION = -17;
    private static final String DUMMY_PLAYER = "Test";

    Team team;

    @Before
    public void setUp() {
        team = new Team(TEAM_NAME, TEAM_POSITION);
        team.add(new HandballPlayer(HANDBALL_PLAYER_NAME));
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_WhenPositionIsBelowZero() {
        team = new Team(TEAM_NAME, BELOW_ZERO_TEAM_POSITION);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsNull() {
        team = new Team(null, TEAM_POSITION);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_WhenNameIsEmpty() {
        team = new Team("", TEAM_POSITION);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectTeamName() {
        String actualName = team.getName();
        assertEquals(TEAM_NAME, actualName);
    }

    @Test
    public void test_GetPositionMethod_ShouldReturnCorrectTeamPosition() {
        int actualPosition = team.getPosition();
        assertEquals(TEAM_POSITION, actualPosition);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectNumberOfPlayersInTeam() {
        int actualCount = team.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_AddMethod_ShouldAddPlayerCorrect() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddMethod_ShouldThrowException_WhenTeamSizeIsEqualPlayersCollection() {
        team = new Team(TEAM_NAME, 0);
        team.add(new HandballPlayer(HANDBALL_PLAYER_NAME));
    }

    @Test
    public void test_RemoveMethod_ShouldRemovePlayerCorrect() {
        team.remove(HANDBALL_PLAYER_NAME);
        assertEquals(0, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveMethod_ShouldThrowException_WhenPlayerDoNotInCollection() {
        team.remove(DUMMY_PLAYER);
    }

    @Test
    public void test_PlayerForAnotherTeamMethod_ShouldReturnCorrectPlayer() {
        HandballPlayer handballPlayer = team.playerForAnotherTeam(HANDBALL_PLAYER_NAME);
        assertFalse(handballPlayer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveMethod_ShouldThrowException_WhenPlayerDoNotExist() {
        team.playerForAnotherTeam(DUMMY_PLAYER);
    }

}
