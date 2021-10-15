package mysql_Test;

import org.testng.annotations.Test;

import static mysql.SelectHelper.getSelect;
import static mysql.UpdateHelper.getUpdate;

public class Update_Test {

    @Test
    public void updateUser1() {
        getUpdate().table("user").set("id=120").where("id=201").executeUp();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }
}
