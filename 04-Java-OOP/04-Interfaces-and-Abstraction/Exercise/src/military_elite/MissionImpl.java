package military_elite;

public class MissionImpl implements Mission {

    private String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    private void setState(String state) {
        this.state = State.valueOf(state);
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }
}
