package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private int countCraftedPresents;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;

        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper currentHelper = helperRepository.findByName(helperName);

        if (null == currentHelper) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        currentHelper.addInstrument(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);

        presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> readyHelpers = helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (readyHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present currentPresent = presentRepository.findByName(presentName);

        Shop shop = new ShopImpl();
        readyHelpers.forEach(helper -> shop.craft(currentPresent, helper));

        countCraftedPresents++;

        long brokenInstruments = readyHelpers.stream()
                .filter(helper -> helper.getInstruments()
                        .stream()
                        .filter(Instrument::isBroken)
                        .isParallel())
                .count();


        return String.format(PRESENT_DONE, presentName,
                String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));
    }

    @Override
    public String report() {
        return String.format("%d presents are done!%n" +
                        "%s",
                countCraftedPresents, helperRepository.getModels()
                        .stream()
                        .map(Helper::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
