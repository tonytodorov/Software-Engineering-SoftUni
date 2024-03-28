package harpoonDiver.core;


import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.*;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;
import static harpoonDiver.common.ExceptionMessages.DIVER_DOES_NOT_EXIST;
import static harpoonDiver.common.ExceptionMessages.DIVER_INVALID_KIND;

public class ControllerImpl implements Controller {

    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private int countSearchedSites = 0;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {

        BaseDiver baseDiver;

        if (kind.equals("DeepWaterDiver")) {
            baseDiver = new DeepWaterDiver(diverName);
        } else if (kind.equals("OpenWaterDiver")) {
            baseDiver = new OpenWaterDiver(diverName);
        } else if (kind.equals("WreckDiver")) {
            baseDiver = new WreckDiver(diverName);
        } else {
            throw new IllegalArgumentException(DIVER_INVALID_KIND);
        }

        diverRepository.add(baseDiver);
        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);

        Arrays.stream(seaCreatures)
                .forEach(s -> divingSite.getSeaCreatures().add(s));

        divingSiteRepository.add(divingSite);
        return String.format(DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);

        if (null == diver) {
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }

        diverRepository.remove(diver);
        return String.format(DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        Collection<Diver> diverCollection = diverRepository.getCollection();

        List<Diver> suitableDivers = diverCollection.stream()
                .filter(diver -> diver.getOxygen() > 30)
                .collect(Collectors.toList());

        if (suitableDivers.isEmpty()) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }

        DivingSite divingSite = divingSiteRepository.byName(siteName);

        Diving diving = new DivingImpl();
        diving.searching(divingSite, suitableDivers);

        countSearchedSites++;

        long excludedDivers = suitableDivers.stream()
                .filter(suitableDiver -> suitableDiver.getOxygen() <= 0)
                .count();

        return String.format(SITE_DIVING, siteName, excludedDivers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_DIVING_SITES, countSearchedSites));
        sb.append(System.lineSeparator());
        sb.append(FINAL_DIVERS_STATISTICS);

        diverRepository.getCollection().forEach(diver -> {
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_DIVER_NAME, diver.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_DIVER_OXYGEN, diver.getOxygen()));
            sb.append(System.lineSeparator());

            if (diver.getSeaCatch().getSeaCreatures().isEmpty()) {
                sb.append(String.format(FINAL_DIVER_CATCH, "None"));
            } else {
                String seaCatch = String.join(FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch().getSeaCreatures());
                sb.append(String.format(FINAL_DIVER_CATCH, seaCatch));
            }

        });

        return sb.toString();
    }
}
