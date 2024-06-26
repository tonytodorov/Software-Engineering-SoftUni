package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizards = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());

        List<Magician> blackWidow = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());


        return null;
    }
}
