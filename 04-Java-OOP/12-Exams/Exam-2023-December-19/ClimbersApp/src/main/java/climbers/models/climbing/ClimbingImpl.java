package climbers.models.climbing;

import climbers.models.climber.BaseClimber;
import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing {

    private BaseClimber baseClimber;
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {

        Collection<String> mountains = mountain.getPeaksList();

        climbers.forEach(climber -> {

            while (climber.canClimb() && mountains.iterator().hasNext()) {
                climber.climb();
                String climb = mountains.iterator().next();
                climber.getRoster().getPeaks().add(climb);
                mountains.remove(climb);
            }
        });

    }
}
