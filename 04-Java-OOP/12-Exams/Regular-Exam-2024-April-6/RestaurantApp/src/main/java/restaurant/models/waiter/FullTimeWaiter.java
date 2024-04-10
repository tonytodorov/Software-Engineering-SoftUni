package restaurant.models.waiter;

public class FullTimeWaiter extends BaseWaiter {

    public FullTimeWaiter(String name) {
        super(name, 8);
    }

    @Override
    public void work() {
        super.setEfficiency(super.getEfficiency() - 1);

        if (super.getEfficiency() < 0) {
            super.setEfficiency(0);
        }
    }
}
