import java.sql.*;

public class CRUD {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/doctor";

    // Defining Database credentials
   
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String args[]){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "show tables";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String id  = rs.getString(1);
                //Display values
                System.out.print("" + id);

            }
            rs.close();
            stmt.close();
            conn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
