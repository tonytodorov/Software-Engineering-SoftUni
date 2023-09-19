import java.util.Scanner;

public class TradeCommissions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city;
        double saleVolume, commission = -1;

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
                commission = saleVolume * 0.045;
            }else if (saleVolume <= 1000){
                commission = saleVolume * 0.075;
            }else if (saleVolume <= 10000){
                commission = saleVolume * 0.1;
            }else {
                commission = saleVolume * 0.13;
            }
        }

        if(city.equals("Plovdiv")){
            if(saleVolume <= 500){
                commission = saleVolume * 0.055;
            }else if (saleVolume <= 1000){
                commission = saleVolume * 0.08;
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
