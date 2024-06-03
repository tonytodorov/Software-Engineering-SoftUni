import java.util.Scanner;

public class _08_TheHeiganDance {

    private static String PLAYER_POSITION = "P";
    private static String DESTROYED = "D";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] gameBoard = new String[15][15];
        int playerHP = 18_500;
        double heiganHP = 3_000_000;

        fillGameBoard(gameBoard);

        int center = gameBoard.length / 2;
        gameBoard[center][center] = PLAYER_POSITION;

        int hitPointsHeigan = Integer.parseInt(scanner.nextLine());
        int additionDamage = 0;

        boolean isHeiganDied = false;
        String lastSpell = "";

        while (playerHP >= 0) {
            String[] command = scanner.nextLine().split(" ");

            String spell = command[0];
            int rowAttack = Integer.parseInt(command[1]);
            int colAttack = Integer.parseInt(command[2]);

            lastSpell = spell;

            if (gameBoard[rowAttack][colAttack].equals(PLAYER_POSITION)) {

            }
            hitNeighbourCells(gameBoard, rowAttack, colAttack);
            hitDiagonalCells(gameBoard, rowAttack, colAttack);

            printMatrix(gameBoard);

            if (additionDamage > 0) {
                playerHP -= additionDamage;
                heiganHP -= hitPointsHeigan;
                additionDamage = 0;
                continue;
            }

            if (spell.equals("Cloud")) {
                playerHP -= 3500;
                additionDamage += 3500;
            } else if (spell.equals("Eruption")) {
                playerHP -= 6000;
            }

            heiganHP -= hitPointsHeigan;

            if (heiganHP < 0) {
                isHeiganDied = true;
                break;
            }
        }

        if (isHeiganDied) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", playerHP);
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }

        System.out.printf("Final position: %d, %d");
    }

    public static void fillGameBoard(String[][] gameBoard) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = "X";
            }
        }
    }

    public static void printMatrix(String[][] gameBoard) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void hitNeighbourCells(String[][] gameBoard, int rowAttack, int colAttack) {

        int upperElement = rowAttack - 1;

        if (upperElement >= 0) {
            gameBoard[upperElement][colAttack] = DESTROYED;
        }

        int downElement = rowAttack + 1;

        if (downElement < gameBoard.length - 1) {
            gameBoard[downElement][colAttack] = DESTROYED;
        }

        int leftElement = colAttack - 1;

        if (leftElement >= 0) {
            gameBoard[rowAttack][leftElement] = DESTROYED;
        }

        int rightElement = colAttack + 1;

        if (rightElement < gameBoard.length - 1) {
            gameBoard[rowAttack][rightElement] = DESTROYED;
        }
    }

    public static void hitDiagonalCells(String[][] gameBoard, int rowAttack, int colAttack) {

        int leftTopElementRow = rowAttack - 1;
        int leftTopElementCol = colAttack - 1;

        if (leftTopElementRow >= 0 && leftTopElementCol >= 0) {
            gameBoard[leftTopElementRow][leftTopElementCol] = DESTROYED;
        }

        int leftDownElementRow = rowAttack + 1;
        int leftDownElementCol = colAttack - 1;

        if (leftDownElementRow < gameBoard.length - 1 && leftDownElementCol >= 0) {
            gameBoard[leftDownElementRow][leftDownElementCol] = DESTROYED;
        }

        int rightTopElementRow = rowAttack - 1;
        int rightTopElementCol = colAttack + 1;

        if (rightTopElementRow >= 0 && rightTopElementCol < gameBoard.length - 1) {
            gameBoard[rightTopElementRow][rightTopElementCol] = DESTROYED;
        }

        int rightDownElementRow = rowAttack + 1;
        int rightDownElementCol = colAttack + 1;

        if (rightDownElementRow < gameBoard.length - 1 && rightDownElementCol < gameBoard.length - 1) {
            gameBoard[rightDownElementRow][rightDownElementCol] = DESTROYED;
        }
    }

}
