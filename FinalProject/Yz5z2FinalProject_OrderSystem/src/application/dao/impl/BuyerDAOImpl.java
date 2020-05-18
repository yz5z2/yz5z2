/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.dao.BaseDAO;
import static application.dao.BaseDAO.jutil;
import application.dao.BuyerDAO;
import application.model.Buyer;
import application.utils.DateUtil;
import java.sql.ResultSet;
import java.time.LocalDateTime;


public class BuyerDAOImpl  extends BaseDAO implements BuyerDAO {

    @Override
    public boolean buyerRegister(Buyer buyer) throws Exception {
		String sql = "INSERT INTO buyer(bno,name,password,phone,address,regdate) VALUES(?,?,?,?,?,?)";
                System.out.println(buyer.getBno()+"  "+ buyer.getName()+"  "+buyer.getPassword()+"  "+buyer.getPhone()+"  "+buyer.getAddress());
                  System.out.println( LocalDateTime.now());
		return jutil.executeUpdate(sql, buyer.getBno(), buyer.getName(), buyer.getPassword(),buyer.getPhone(),buyer.getAddress(),DateUtil.format(LocalDateTime.now()) ) > 0;
    }

    @Override
    public String buyerLogin(String bno, String pwd) throws Exception {
	String sql = "SELECT name FROM buyer WHERE bno=? AND password=?";
		ResultSet rs = jutil.executeQuery(sql, bno, pwd);
		if (rs.next() && rs.getString(1) != null) {
			return rs.getString(1);
		}
		return null;
    }

    @Override
    public boolean buyerUpdatePwd(String bno, String newPwd) throws Exception {
		String sql = "UPDATE buyer SET password=? WHERE bno=?";
		return jutil.executeUpdate(sql, newPwd, bno) > 0;
    }

    @Override
    public Buyer findBuyer(String bno) throws Exception {
             	Buyer buyer = null;
		String sql = "SELECT name,phone,address FROM buyer where bno = ?";
		ResultSet rs = jutil.executeQuery(sql,bno);
		while (rs.next()) {
                buyer = new Buyer(bno,rs.getString(1), rs.getString(2), rs.getString(3));
                }
            return buyer;
    }

 
}
