package patterns.herokuapp.valueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginPage_ValueObject {
    private String userName;
    private String password;

}
