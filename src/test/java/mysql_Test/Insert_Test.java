package mysql_Test;

import org.testng.annotations.Test;

import static mysql.InsertHelper.getInsert;
import static mysql.SelectHelper.getSelect;

public class Insert_Test {

    @Test(priority = 1)
    public void insertUser1() {
        getInsert().insertInto("user").columns("id, first_name, last_name, age").values("'21', 'Hanna', 'LastHanna', '25'").execute();
        getSelect().select("*").from("user").where("id=21").getListData().forEach(System.out::println);
    }
    @Test(priority = 2)
    public void insertUser2() {
        getInsert().insertInto("user").columns("id, first_name, last_name, age").values("'22', 'Hanna1', 'LastHanna1'").execute();
        getSelect().select("*").from("user").where("id=22").getListData().forEach(System.out::println);
    }
    @Test(priority = 3)
    public void insertUser3() {
        getInsert().insertInto("user").columns("id").values("23").execute();
        getSelect().select("*").from("user").where("id=23").getListData().forEach(System.out::println);
    }
}
