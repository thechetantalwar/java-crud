import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {

    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/doctor";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "update Patient set Name = 'Chetan Talwar' where SSN = 23";
            //sql = "insert into Patient values (23,'Chetan','Chandigarh','2323',23,2)";
            stmt.executeUpdate(sql);

            sql = "select * from Patient";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
            stmt.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
