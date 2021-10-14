package mysql_Test;

import org.testng.annotations.Test;

import static mysql.DeleteHelper.getDelete;
import static mysql.SelectHelper.getSelect;

public class Delete_Test {

    @Test(priority = 1)
    public void deleteUser1() {
        getDelete().deleteFrom("user").where("id=23").execute();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Test(priority = 1)
    public void deleteUser2() {
        getDelete().deleteFrom("user").where("first_name='Hanna'").execute();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }
}
