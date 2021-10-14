package mysql_Test;

import org.testng.annotations.Test;

import static mysql.SelectHelper.getSelect;
import static mysql.UpdateHelper.getUpdate;

public class Update_Test {

    @Test
    public void updateUser1() {
        getUpdate().update("user").set("id= 112").where("id= 22").execute();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }
}
