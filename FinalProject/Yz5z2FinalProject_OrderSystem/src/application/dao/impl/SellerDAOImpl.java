/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.dao.BaseDAO;
import application.dao.SellerDAO;
import java.sql.ResultSet;


public class SellerDAOImpl  extends BaseDAO implements SellerDAO {

    @Override
    public String sellerLogin(String sno, String pwd) throws Exception {
		String sql = "SELECT name FROM seller WHERE sno=? AND password=?";
		ResultSet rs = jutil.executeQuery(sql, sno, pwd);
		if (rs.next() && rs.getString(1) != null) {
			return rs.getString(1);
		}
		return null;
    }
}
    
