package student_system;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {

    private Map<String, Student> repository;

    public StudentRepository() {
        this.repository = new HashMap<>();
    }

    public boolean containsKey(String name) {
        return repository.containsKey(name);
    }

    public void create(String name, Student student) {
        repository.putIfAbsent(name, student);
    }

    public Student get(String name) {
        return repository.get(name);
    }

}
