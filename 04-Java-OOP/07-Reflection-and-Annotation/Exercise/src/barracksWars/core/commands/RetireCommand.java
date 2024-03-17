package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];
        this.getRepository().removeUnit(unitType);

        return unitType + " retired!";
    }
}
