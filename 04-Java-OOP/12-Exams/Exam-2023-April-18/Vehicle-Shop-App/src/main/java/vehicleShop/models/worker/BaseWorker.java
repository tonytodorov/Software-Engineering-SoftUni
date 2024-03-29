package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

import static vehicleShop.common.ExceptionMessages.*;

public abstract class BaseWorker implements Worker {

    private String name;
    private int strength;
    private Collection<Tool> tools;

    protected BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(WORKER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(WORKER_STRENGTH_LESS_THAN_ZERO);
        }

        this.strength = strength;

    }

    @Override
    public void working() {
        if (this.getClass().getSimpleName().equals("SecondShift")) {
            this.strength -= 15;
        } else {
            this.strength -= 10;
        }

        if (this.strength < 0) {
            this.strength = 0;
        }
    }

    @Override
    public void addTool(Tool tool) {
        tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.strength > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return tools;
    }
}
