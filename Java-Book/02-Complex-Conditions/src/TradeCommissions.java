import java.util.Scanner;

public class TradeCommissions {

    public  static double commission = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city;
        double saleVolume;

        city = scanner.nextLine();
        saleVolume = Double.parseDouble(scanner.nextLine());

        if(city.equals("Sofia")){
            if(saleVolume <= 500){
                commission = saleVolume * 0.05;
            }else if (saleVolume <= 1000){
                commission = saleVolume * 0.07;
            }else if (saleVolume <= 10000){
                commission = saleVolume * 0.08;
            }else {
                commission = saleVolume * 0.12;
            }
        }

        if(city.equals("Varna")){
            if(saleVolume <= 500){
                commission = saleVolume * 0.45;
            }else if (saleVolume <= 1000){
                commission = saleVolume * 0.75;
            }else if (saleVolume <= 10000){
                commission = saleVolume * 0.1;
            }else {
                commission = saleVolume * 0.13;
            }
        }

        if(city.equals("Plovdiv")){
            if(saleVolume <= 500){
                commission = saleVolume * 0.55;
            }else if (saleVolume <= 1000){
                commission = saleVolume * 0.8;
            }else if (saleVolume <= 10000){
                commission = saleVolume * 0.12;
            }else {
                commission = saleVolume * 0.145;
            }
        }

        if(commission >= 0){
            System.out.printf("%.2f", commission);
        }else{
            System.out.println("error");
        }

    }
}
