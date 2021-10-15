package mysql;

public class UpdateHelper extends DBConnector{
    private String table;
    private String set;
    private String where;

    public static UpdateHelper getUpdate() {
        return new UpdateHelper();
    }

    public UpdateHelper table (String table) {
        this.table = table;
        return this;
    }

    public UpdateHelper set(String set) {
        this.set = set;
        return this;
    }

    public UpdateHelper where(String where) {
        this.where = where;
        return this;
    }

    public void executeUp() {
        try {
            getStatement().executeUpdate("update " + table + " set" + set +  " where " + where);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
