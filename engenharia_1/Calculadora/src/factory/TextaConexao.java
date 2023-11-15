/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author gabal
 */
public class TextaConexao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getconnection();
        System.out.println("Conexão aberta");
        connection.close();
    }
    
}
