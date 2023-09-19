import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps, stepsToHome, neededSteps = 10000, sum = 0;

        String command;
        command = scanner.nextLine();
        boolean isGoalReached = false;

        while (!command.equals("Going home")){
            steps = Integer.parseInt(command);
            sum += steps;

            if(sum > neededSteps){
                isGoalReached = true;
                break;
            }

            command = scanner.nextLine();
        }

        if(command.equals("Going home")){
            stepsToHome = Integer.parseInt(scanner.nextLine());
            sum += stepsToHome;
        }


        if (isGoalReached){
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", sum - neededSteps);
        }else{
            System.out.printf("%d more steps to reach goal.", neededSteps - sum);
        }

    }
}
