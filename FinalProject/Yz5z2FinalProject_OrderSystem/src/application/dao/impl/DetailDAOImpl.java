/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.dao.BaseDAO;
import static application.dao.BaseDAO.jutil;
import application.dao.DetailDAO;
import application.model.Detail;
import application.utils.DateUtil;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DetailDAOImpl extends BaseDAO implements DetailDAO {
    
    @Override
    public boolean insertDetail(Detail detail,String oid) throws Exception {
        	String sql = "INSERT INTO order_detail(did,oid,fid,name,price,quantity,createdate,updatedate) VALUES(?,?,?,?,?,?,?,?)";
		return jutil.executeUpdate(sql,detail.getDid(),oid,detail.getFid(),detail.getName(),detail.getPrice(),detail.getQuantity(),DateUtil.format(LocalDateTime.now()),DateUtil.format(LocalDateTime.now()) ) > 0;
    }
    @Override
    public List<Detail> findAllByOrderId(String oid) throws Exception {
     	List<Detail> list = null;
		String sql = "SELECT did,fid,name,price,quantity FROM order_detail where oid =?";
		ResultSet rs = jutil.executeQuery(sql,oid);
		while (rs.next()) {
			if (list == null)
				list = new ArrayList<>();
			list.add(new Detail(rs.getString(1), oid,rs.getString(2), rs.getString(3),rs.getDouble(4),rs.getInt(5)));
		}
		return list;
    
    }

 

  
    
}
