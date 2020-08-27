package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {

    public Connection connection;
    public Statement statement;
    public ResultSet rs;

    public Connect() {
    }

    public Connect(Connection connection, Statement statement, ResultSet rs) {
        this.connection = connection;
        this.statement = statement;
        this.rs = rs;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2S5DPSD;DatabaseName=TaskManagement_DB_JAVA", null, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


}
