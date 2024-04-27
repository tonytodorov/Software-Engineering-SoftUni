package builder;

public class Address {


    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;

    private Address() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Address address;

        private Builder() {
            this.address = new Address();
        }

        public Builder withFirstName(String firstName) {
            address.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            address.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            address.email = email;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            address.telephoneNumber = telephoneNumber;
            return this;
        }

        public Address build() {
            return address;
        }
    }
}
