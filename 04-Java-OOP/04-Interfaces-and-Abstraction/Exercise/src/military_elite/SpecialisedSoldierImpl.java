package military_elite;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    @Override
    public Corp getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = Corp.valueOf(corp);
    }
}
