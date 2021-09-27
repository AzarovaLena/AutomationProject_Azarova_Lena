package patterns.Herokuapp.Builder;

public class LoginPage_Builder {
    String userName;
    String password;


    public static class Builder {
        private LoginPage_Builder loginPage_builder;

        public Builder() {
            loginPage_builder = new LoginPage_Builder();
        }

        public LoginPage_Builder.Builder withUserName(String userName) {
            loginPage_builder.userName = userName;
            return this;
        }

        public LoginPage_Builder.Builder withPassword(String password) {
            loginPage_builder.password = password;
            return this;
        }

        public LoginPage_Builder build() {
            return loginPage_builder;
        }
    }
}
