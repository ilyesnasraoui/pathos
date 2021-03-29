/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import IntService.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import model.Rate;
import utils.Database;

/**
 *
 * @author elyes
 */
public class ServiceRate implements IService<Rate> {
    
 Connection cnx ;
    public ServiceRate() {
         cnx = Database.getInstance().getConn();
        
    }
    
    @Override
    public void add(Rate t) throws SQLException {
        
        String req1 = " SELECT count(*) FROM `rate` WHERE rate.id_film='"+t.getId_film()+"' and rate.id_user='"+t.getId_user()+"'";
        /*PreparedStatement pt = cnx.prepareStatement(req1);
        pt.setInt(2, t.getId_user());
        pt.setInt(1, t.getId_film());*/
        Statement st = cnx.createStatement();
       ResultSet rs = st.executeQuery(req1);
       rs.next();
        System.out.println("resut"+rs.getInt(1));
        if(rs.getInt(1)==0)
        {
         String req2 = " INSERT INTO `rate` (`id_user`, `id_film`, `note`) VALUES (?, ?, ?)";
        PreparedStatement pt2 = cnx.prepareStatement(req2);
        pt2.setInt(1, t.getId_user());
        pt2.setInt(2, t.getId_film());
        pt2.setInt(3, t.getNote());
        pt2.executeUpdate();   
        }
        else {
            //UPDATE `rate` SET `note` = '6' WHERE `rate`.`id_rate` = 1;
        String req3 = " UPDATE `rate` SET `note` = ? WHERE `rate`.`id_film` = ? and `rate`.`id_user` = ?";
        PreparedStatement pt3 = cnx.prepareStatement(req3);
        pt3.setInt(3, t.getId_user());
        pt3.setInt(2, t.getId_film());
        pt3.setInt(1, t.getNote());
        pt3.executeUpdate();
        }
        //INSERT INTO `rate` (`id_user`, `id_film`, `note`) VALUES ('2', '1', '5');
    
    }

    @Override
    public List<Rate> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Rate t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Rate t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
