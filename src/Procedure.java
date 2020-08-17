import java.sql.*;

public class Procedure {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String args[]){
        Connection conn = null;
        CallableStatement procedure = null;
        //Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            procedure = conn.prepareCall("{call getSalesDetails(?)}");
            procedure.setInt(1,4);
            ResultSet rs = procedure.executeQuery();

            while (rs.next()){
                System.out.print(rs.getInt(1)+"\n");
                System.out.print(rs.getString(2)+"\n");
                System.out.print(rs.getString(3)+"\n");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
