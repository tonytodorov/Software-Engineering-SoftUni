package singleton;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<String, Integer> memory = new HashMap<>();
    private static Database instance;

    private Database() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connection established");
    }

    public static Database getInstance() {
        if (null == instance) {
            instance = new Database();
        }

        return instance;
    }


    // Simulate CRUD
    public void create(String key, int value) {
        memory.put(key, value);
    }

    public int read(String key) {
        return memory.get(key);
    }

    public void update(String key, int value) {
        create(key, value);
    }

    public int delete(String key) {
        return memory.remove(key);
    }

}
