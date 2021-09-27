package patterns.Saucedemo.ValueObject;

public class CheckOutPage_ValueObject {
    private String firstName;
    private String lastName;
    private Integer zipCode;

    public CheckOutPage_ValueObject(String firstName, String lastName, Integer zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public CheckOutPage_ValueObject() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CharSequence getZipCode() {
        return zipCode.toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
