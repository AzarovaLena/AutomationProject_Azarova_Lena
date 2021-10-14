package mysql;

public class DeleteHelper extends DBConnector{
    private String table;
    private String where;


    public static DeleteHelper getDelete() {
        return new DeleteHelper();
    }

    public DeleteHelper deleteFrom (String deleteFrom) {
        this.table = deleteFrom;
        return this;
    }

    public DeleteHelper where (String where) {
        this.where = where;
        return this;
    }


    public void execute() {
        try {
            getStatement().executeUpdate("DELETE FROM " + table + " WHERE " + where);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
