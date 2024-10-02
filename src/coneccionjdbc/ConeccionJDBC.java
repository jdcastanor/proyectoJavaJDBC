
package coneccionjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConeccionJDBC {
 
    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/adso";
        Connection conexion;
        Statement statement; 
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            
            //Consulta a la DB
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre"));   
            }
            
            //Insertar datos 
            statement.execute("INSERT INTO `clientes`(`edad`, `nombre`) VALUES ('45','Cristina')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));   
            }
            
            //Actualización de datos
            statement.execute("UPDATE `clientes` SET `nombre` = 'Rosario' , `edad` = '18' WHERE `clientes`.`idclientes` = 15;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));   
            }
            
            //Elimiar Datos
            statement.execute("DELETE FROM `clientes` WHERE `idclientes`= 16");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));   
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
