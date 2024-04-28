package builder;

public class Main {

    public static void main(String[] args) {
        Address address = Address.builder()
                .withFirstName("Ivan")
                .withEmail("ivan@gmail.bg")
                .withTelephoneNumber("0881731998")
                .build();



        System.out.println(address);
    }
}
