package student_system;

public class StudentSystem {

    private final StudentRepository studentRepository;

    public StudentSystem() {
        this.studentRepository = new StudentRepository();
    }

    public void command(String[] args) {

        String command = args[0];
        String name = args[1];

        if ("Create".equals(command)) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);

            Student student = new Student(name, age, grade);

            studentRepository.create(name, student);
        } else  {
            if (studentRepository.containsKey(name)) {
                Student student = studentRepository.get(name);
                System.out.println(student);
            }
        }
    }
}
