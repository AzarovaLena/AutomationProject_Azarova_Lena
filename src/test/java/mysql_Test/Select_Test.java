package mysql_Test;

import org.testng.annotations.Test;

import static mysql.SelectHelper.getSelect;

public class Select_Test {

    @Test (priority = 1)
    public void selectByFirstName() {
        getSelect().select("first_name").from("user").where("first_name LIKE 'Use%'").getListData().forEach(System.out::println);

    }
    @Test (priority = 2)
    public void selectById() {
        getSelect().select("*").from("user").where("id>10").getListData().forEach(System.out::println);

    }
    @Test (priority = 3)
    public void selectByAge() {
        getSelect().select("last_name").from("user").where("age>40 and age<60").getListData().forEach(System.out::println);

    }
}
