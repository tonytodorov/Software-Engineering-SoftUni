import java.util.Scanner;

public class FitnessCenter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfVisitorInFitness, countBackExercise = 0,
                countChestExercise = 0, countLegsExercise = 0,
                countAbsExercise = 0, countProteinShakes = 0,
                countProteinBars = 0, countWorkouts = 0, countBuyProteins = 0;
        String typeOfExercise;
        double percentOfWorkouts, percentOfBuyProteins;

        numberOfVisitorInFitness = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfVisitorInFitness; i++) {
            typeOfExercise = scanner.nextLine();

            switch (typeOfExercise) {
                case "Back":            countBackExercise++;    break;
                case "Chest":           countChestExercise++;   break;
                case "Legs":            countLegsExercise++;    break;
                case "Abs":             countAbsExercise++;     break;
                case "Protein shake":   countProteinShakes++;   break;
                case "Protein bar":     countProteinBars++;     break;
            }

            if(typeOfExercise.equals("Back") || typeOfExercise.equals("Chest")
                    || typeOfExercise.equals("Legs") || typeOfExercise.equals("Abs")){
                countWorkouts++;
            }else{
                countBuyProteins++;
            }
        }

        percentOfWorkouts = (double)countWorkouts / numberOfVisitorInFitness * 100;
        percentOfBuyProteins = (double)countBuyProteins / numberOfVisitorInFitness * 100;

        System.out.printf("%d - back%n" +
                        "%d - chest%n" +
                        "%d - legs%n" +
                        "%d - abs%n" +
                        "%d - protein shake%n" +
                        "%d - protein bar%n" +
                        "%.2f%% - work out%n" +
                        "%.2f%% - protein", countBackExercise, countChestExercise,
                countLegsExercise, countAbsExercise, countProteinShakes,
                countProteinBars, percentOfWorkouts, percentOfBuyProteins);

    }
}
