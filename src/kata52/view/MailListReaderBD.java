package kata52.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import kata52.model.Mail;

public class MailListReaderBD {
    public List<Mail> read(String BD,String tabla,String columna) {
        Connection conexion=connect(BD);
        return selectfromdb(columna,"SELECT "+columna+" FROM "+tabla,conexion);
    }
    private Connection connect(String bdurl) {
        String url = "jdbc:sqlite:"+bdurl;
        Connection conn = null;
        try {
        conn = DriverManager.getConnection(url);
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private static List<Mail> selectfromdb(
            String columna,String select,Connection conexion){
        ArrayList<Mail> lista=new ArrayList<>();
        try (
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(select))
        {
            // Bucle sobre el conjunto de registros. como son correos todos los
            //que hay dentro no necesito pasarle el patron
            while (rs.next()) {
                lista.add(new Mail(rs.getString(columna)));
            }
        } 
        catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        return lista;
    }
}
