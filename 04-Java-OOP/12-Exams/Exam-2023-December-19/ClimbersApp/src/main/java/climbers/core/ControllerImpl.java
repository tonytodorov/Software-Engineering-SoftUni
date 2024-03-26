package climbers.core;

import climbers.common.ExceptionMessages;
import climbers.models.climber.BaseClimber;
import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.CLIMBER_DOES_NOT_EXIST;
import static climbers.common.ExceptionMessages.THERE_ARE_NO_CLIMBERS;

public class ControllerImpl implements Controller {

    private Repository<Climber> climberRepository;
    private Repository<Mountain> mountainRepository;
    private int countClimbedMountain = 0;


    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {

        BaseClimber baseClimber;

        if (type.equals("RockClimber")) {
            baseClimber = new RockClimber(climberName);
        } else if (type.equals("WallClimber")) {
            baseClimber = new WallClimber(climberName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }

        climberRepository.add(baseClimber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);

        Arrays.stream(peaks)
                .forEach(peak -> mountain.getPeaksList().add(peak));

        mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = climberRepository.byName(climberName);

        if (null == climber) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }

        climberRepository.remove(climber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {

        Collection<Climber> climbers = climberRepository.getCollection();

        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }

        Mountain mountain = mountainRepository.byName(mountainName);

        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);

        countClimbedMountain++;

        long excludedClimbers = climbers.stream()
                .filter(climber -> climber.getStrength() <= 0)
                .count();

        return String.format(PEAK_CLIMBING, mountainName, excludedClimbers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_MOUNTAIN_COUNT, countClimbedMountain));
        sb.append(System.lineSeparator());
        sb.append(FINAL_CLIMBERS_STATISTICS);

        climberRepository.getCollection().forEach(climber -> {
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_CLIMBER_NAME, climber.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            sb.append(System.lineSeparator());

            if (climber.getRoster().getPeaks().isEmpty()) {
                sb.append("None");
            } else {
                String peaks = String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks());
                sb.append(String.format(FINAL_CLIMBER_PEAKS, peaks));
            }

        });

        return sb.toString();
    }
}
