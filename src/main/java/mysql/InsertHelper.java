package mysql;

public class InsertHelper extends DBConnector{
    private String table;
    private String columns;
    private String values;

    public static InsertHelper getInsert() {
        return new InsertHelper();
    }

    public InsertHelper insertInto (String table) {
        this.table = table;
        return this;
    }

    public InsertHelper columns (String columns) {
        this.columns = columns;
        return this;
    }

    public InsertHelper values (String values) {
        this.values = values;
        return this;
    }

    public void execute() {
        try {
            getStatement().executeUpdate("INSERT INTO " + table + " ( " + columns + " ) " + " VALUES " + "( " + values + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
