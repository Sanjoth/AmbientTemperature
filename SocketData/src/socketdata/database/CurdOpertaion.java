/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketdata.database;


import com.sun.xml.internal.ws.api.server.Module;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanjoth Shaw
 */
public class CurdOpertaion {
    public void save(String ip,String reading,String temp){
        try {
            ConnectionHandler conHandler = new ConnectionHandler();

           // String query = "insert into temprature_data (Client_IP,Module,Temp) values (?,?,?)";
       // String query =   "INSERT INTO temprature_data(Client_IP,Module,Temp,DateTime)VALUES('?','?','?')";
        String query =   "INSERT INTO temp(Client_IP,Module,Temp,Datetime)VALUES(?,?,?,NOW())";
            Connection con = conHandler.getConnection();
            PreparedStatement pstm =  con.prepareStatement(query);
            pstm.setString(1,ip);
            pstm.setString(2,reading);
            pstm.setString(3,temp.replace("\u0000", "").trim());
           // pstm.setString(5,NOW());
            int i = pstm.executeUpdate();
            if(i < 0){
                System.out.println("Inserted into Database Success");
            }
            conHandler.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(CurdOpertaion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
