public class BlankReceipt {

    public static void main(String[] args) {

        upperPart();
        middlePart();
        downPart();
    }


    public static void upperPart(){
        System.out.println("CASH RECEIPT");
        System.out.println("------------------------------");
    }

    public static void middlePart(){
        System.out.println("Charged to____________________");
        System.out.println("Received by___________________");
    }

    public static void downPart(){
        System.out.println("------------------------------");
        System.out.println("(c) SoftUni");
    }
}
