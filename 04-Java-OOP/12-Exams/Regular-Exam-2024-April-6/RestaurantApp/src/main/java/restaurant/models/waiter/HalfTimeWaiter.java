package restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {

    public HalfTimeWaiter(String name) {
        super(name, 4);
    }

    @Override
    public void work() {
        super.setEfficiency(super.getEfficiency() - 2);

        if (super.getEfficiency() < 0) {
            super.setEfficiency(0);
        }
    }
}
