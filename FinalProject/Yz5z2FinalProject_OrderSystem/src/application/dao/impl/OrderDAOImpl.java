/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.dao.BaseDAO;
import static application.dao.BaseDAO.jutil;
import application.dao.OrderDAO;
import application.model.Order;
import application.utils.DateUtil;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    @Override
    public boolean createOrder(Order order) throws Exception {
     String sql = "INSERT INTO order_master(oid,bno,name,phone,address,orderamount,status,createdate,updatedate) VALUES(?,?,?,?,?,?,?,?,?)";
		return jutil.executeUpdate(sql,order.getOid(),order.getBno(),order.getName(),order.getPhone(),order.getAddress(),order.getOrderAmount(),order.getStatus(),DateUtil.format(LocalDateTime.now()),DateUtil.format(LocalDateTime.now()) ) > 0;
    }
   
    @Override
    public List<Order> findOrderStatistics() throws Exception{
        	List<Order> list = null;
		String sql = "SELECT oid,bno,name,phone,address,orderamount,createdate from order_master";
		ResultSet rs = jutil.executeQuery(sql);
		while (rs.next()) {
			if (list == null)
				list = new ArrayList<>();
			list.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) ,rs.getDouble(6),rs.getString(7)));
		}
		return list;
	}

    @Override
    public List<Order> findOwnOrderList(String bno) throws Exception {
        	List<Order> list = null;
		String sql = "SELECT oid,orderamount,createdate from order_master where bno= ?";
		ResultSet rs = jutil.executeQuery(sql, bno);
		while (rs.next()) {
			if (list == null)
				list = new ArrayList<>();
			list.add(new Order(rs.getString(1), bno,rs.getDouble(2), rs.getString(3)));
		}
		return list;
	}

    
}
