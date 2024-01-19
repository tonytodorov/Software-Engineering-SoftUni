import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_SoftUniCoursePlanning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> program = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {

            String[] text = command.split(":");
            String operation = text[0];
            String lessonTitle = text[1];

            boolean isLessonExist = isLessonExist(program, lessonTitle);

            if (operation.equals("Add")) {
                if (!isLessonExist) {
                    program.add(lessonTitle);
                }
            } else if (operation.equals("Insert")) {
                if (!isLessonExist) {
                    int index = Integer.parseInt(text[2]);
                    program.add(index, lessonTitle);
                }
            } else if (operation.equals("Remove")) {
                String exercise = lessonTitle + "-Exercise";
                boolean isExerciseExist = isExerciseExist(program, lessonTitle);

                program.remove(String.valueOf(lessonTitle));

                if (isLessonExist && isExerciseExist) {
                    program.remove(exercise);
                }
            } else if (operation.equals("Swap")) {
                String secondLessonTitle = text[2];
                String firstExercise = lessonTitle + "-Exercise";
                String secondExercise = secondLessonTitle + "-Exercise";

                boolean isSecondLessonExist = isLessonExist(program, secondLessonTitle);
                boolean isFirstLessonHaveExercise = isExerciseExist(program, firstExercise);
                boolean isSecondLessonHaveExercise = isExerciseExist(program, secondExercise);


                if (isLessonExist && isSecondLessonExist) {

                    if (isFirstLessonHaveExercise) {
                        int firstLessonIndex = elementIndex(program, lessonTitle);
                        int secondLessonIndex = elementIndex(program, secondLessonTitle);
                        int secondExerciseIndex = elementIndex(program, secondExercise);

                        String temp = program.get(firstLessonIndex);
                        program.set(firstLessonIndex, program.get(secondLessonIndex));
                        program.set(secondLessonIndex, temp);
                        program.add(secondExerciseIndex + 1, firstExercise);
                        program.remove(firstLessonIndex + 1);
                    } else if (isSecondLessonHaveExercise) {
                        int firstLessonIndex = elementIndex(program, lessonTitle);
                        int secondLessonIndex = elementIndex(program, secondLessonTitle);
                        int secondExerciseIndex = elementIndex(program, secondExercise);

                        String temp = program.get(firstLessonIndex);
                        program.set(firstLessonIndex, program.get(secondLessonIndex));
                        program.set(secondLessonIndex, temp);
                        program.add(firstLessonIndex + 1, secondExercise);
                        program.remove(secondExerciseIndex + 1);
                    } else {
                        int firstLessonIndex = elementIndex(program, lessonTitle);
                        int secondLessonIndex = elementIndex(program, secondLessonTitle);

                        String temp = program.get(firstLessonIndex);
                        program.set(firstLessonIndex, program.get(secondLessonIndex));
                        program.set(secondLessonIndex, temp);

                    }
                }
            } else if (operation.equals("Exercise")) {
                String exercise = lessonTitle + "-Exercise";
                boolean isExerciseExist = isExerciseExist(program, exercise);

                if (isLessonExist && !isExerciseExist) {
                    int lessonIndex = elementIndex(program, lessonTitle);
                    program.add(lessonIndex + 1, exercise);
                }

                if (!isLessonExist) {
                    program.add(lessonTitle);
                    program.add(exercise);
                }
            }

            command = scanner.nextLine();
        }

        printList(program);
    }


    public static boolean isLessonExist(List<String> program, String lessonTitle) {

        for (String lesson : program) {
            if (lesson.equals(lessonTitle)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isExerciseExist(List<String> program, String exercise) {

        for (String lesson : program) {
            if (lesson.equals(exercise)) {
                return true;
            }
        }

        return false;
    }

    public static int elementIndex(List<String> program, String element) {

        int index = 0;

        for (int i = 0; i < program.size(); i++) {
            if (program.get(i).equals(element)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void printList(List<String> list) {

        int count = 1;

        for (String element : list) {
            System.out.printf("%d.%s%n", count, element);
            count++;
        }
    }
}
