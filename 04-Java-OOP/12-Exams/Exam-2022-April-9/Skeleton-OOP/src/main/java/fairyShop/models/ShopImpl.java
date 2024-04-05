package fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {
        helper.getInstruments().forEach(instrument -> {

            while (!instrument.isBroken() && helper.canWork() && !present.isDone()) {
                helper.work();
                present.getCrafted();
                instrument.use();
            }
        });
    }
}
