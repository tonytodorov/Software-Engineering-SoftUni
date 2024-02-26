package traffic_lights;

public enum TrafficLights {

    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN");

    private String name;

    TrafficLights(String name) {
        this.name = name;
    }

    public static String getName(TrafficLights trafficLights) {
        return trafficLights.name;
    }

}
