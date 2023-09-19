import java.util.Scanner;

public class AreaOfFigures {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a, b, c, r, d, h, squareArea, rectangleArea, circleArea, triangleArea;
        String typeOfFigure = scanner.nextLine();

        if(typeOfFigure.equals("square")){
            a = scanner.nextDouble();
            squareArea = a * a;
            System.out.printf("%.3f", squareArea);
        }else if(typeOfFigure.equals("rectangle")){
            b = Double.parseDouble(scanner.nextLine());
            c = scanner.nextDouble();
            rectangleArea = b * c;
            System.out.printf("%.3f", rectangleArea);
        }else if(typeOfFigure.equals("circle")){
            r = scanner.nextDouble();
            circleArea = Math.PI * r * r;
            System.out.printf("%.3f", circleArea);
        }else{
            d = Double.parseDouble(scanner.nextLine());
            h = scanner.nextDouble();
            triangleArea = (d * h) / 2;
            System.out.printf("%.3f", triangleArea);
        }
    }
}
