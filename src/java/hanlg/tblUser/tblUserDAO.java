/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblUser;

import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class tblUserDAO implements Serializable {

    private List<tblUserDTO> UserInfor;

    public tblUserDTO checkLogin(String email, String password)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String fullname = null;
        String role = null;
        String status = null;
       boolean result = true; 
       tblUserDTO user = null;
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
         
                String sql = "select email, name, password, rolename,statusname "
                        + "from tblUser "
                        + "left JOIN tblStatus "
                        + "on tblUser.status = tblStatus.statusid "
                        + "left JOIN tblRole "
                        + "on tblUser.role = tblRole.roleid "
                        + "where email=? "
                        + "and password =?";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement luôn tạo ra 
                //object rỗng
                stm.setString(1, email);
                stm.setString(2, password);
                //4.Execute query
                rs = stm.executeQuery(); //là con trỏ trỏ tới 1 vùng nhớ của
                //mảng ==> không bao giờ = null
                if (rs.next()) {
                 
                    fullname = rs.getString("name");
                    role = rs.getString("rolename");
                    status = rs.getString("statusname");
                     user = new tblUserDTO(email, fullname, password, role, status);
                    if (this.UserInfor == null) {
                    this.UserInfor = new ArrayList<>();
                }
                   this.UserInfor.add(user);
                  
                   
                }
            }//end if connection is connected
         finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            
            
        } 
       
        return user;
    
    }
 public boolean InsertDB(String email, String fullname, String password)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;

        int result = 0;
       
        try {
          con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblUser(email,name,password,role,status) VALUES "
                    + "(? , ? , ? , ? , ? )";

            pst = con.prepareStatement(sql);
             pst.setString(1, email);
            pst.setString(2, fullname);
             pst.setString(3, password);
            pst.setInt(4, 2);
            pst.setInt(5, 1);
            result = pst.executeUpdate();
            if (result != 0) {
                return true;
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
     
        return false;
    }
    public List<tblUserDTO> getUserInfor() {
        return UserInfor;
    }

}
