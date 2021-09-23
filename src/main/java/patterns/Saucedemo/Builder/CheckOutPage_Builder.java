package patterns.Saucedemo.Builder;

public class CheckOutPage_Builder {
    String firstName;
    String lastName;
    String zipCode;

    public static class Builder {
        private CheckOutPage_Builder checkOutPage_builder;

        public Builder() {
            checkOutPage_builder = new CheckOutPage_Builder();
        }

        public Builder withFirstName(String firstName) {
            checkOutPage_builder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            checkOutPage_builder.lastName = lastName;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            checkOutPage_builder.zipCode = zipCode;
            return this;
        }

        public CheckOutPage_Builder build() {
            return checkOutPage_builder;
        }
    }
}
