import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Batch {
    //Defining DB URL
    static final String DB_URL = "jdbc:mysql://localhost/db";
    static Logger logger = Logger.getLogger(Batch.class.getName());

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            conn.setAutoCommit(false);

            String sql ="insert into users (name,city) values('Adnan','Delhi')";
            stmt.addBatch(sql);

            sql ="insert into users (name,city) values('Dekksha','Mumabi')";
            stmt.addBatch(sql);

            sql ="update users set city = 'Ooty' where id = 4";
            stmt.addBatch(sql);

            sql ="delete from users where id = 10";
            stmt.addBatch(sql);

            int[] count = stmt.executeBatch();
            conn.commit();
            logger.setLevel(Level.INFO);
            logger.info( "fdd "+count);




            sql = "select * from users";
            ResultSet rs = stmt.executeQuery(sql);
            System.err.println("Name \tCity \t Id");
            System.err.println("------------------");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                System.out.println(name+"\t"+city+"\t"+id);

            }


            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
