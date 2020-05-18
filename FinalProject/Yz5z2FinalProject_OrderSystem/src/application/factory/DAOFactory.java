package application.factory;

import application.dao.BuyerDAO;
import application.dao.SellerDAO;
import application.dao.FoodDAO;
import application.dao.DetailDAO;
import application.dao.OrderDAO;
import application.dao.impl.BuyerDAOImpl;
import application.dao.impl.SellerDAOImpl;
import application.dao.impl.FoodDAOImpl;
import application.dao.impl.DetailDAOImpl;
import application.dao.impl.OrderDAOImpl;


/**
 *
 * @author Yz5z2
 */
public class DAOFactory {
	private static BuyerDAO buyerDao = null;
        private static SellerDAO sellerDao = null;
        private static FoodDAO foodDao = null;
        private static DetailDAO detailDao = null;
        private static OrderDAO orderDao = null;

	public static BuyerDAO getBuyerDAOInstance() {
		if (buyerDao == null)
			buyerDao = new BuyerDAOImpl();
		return buyerDao;
	}

	public static SellerDAO getSellerDAOInstance() {
		if (sellerDao == null)
			sellerDao = new SellerDAOImpl();
		return sellerDao;
	}
        
        	public static FoodDAO getFoodDAOInstance() {
		if (foodDao == null)
			foodDao = new FoodDAOImpl();
		return foodDao;
	}

	public static DetailDAO getDetailDAOInstance() {
		if (detailDao == null)
			detailDao = new DetailDAOImpl();
		return detailDao;
	}
        
        	public static OrderDAO getOrderDAOInstance() {
		if (orderDao == null)
			orderDao = new OrderDAOImpl();
		return orderDao;
	}



}
