package application.factory;

import application.service.BuyerService;
import application.service.SellerService;
import application.service.impl.BuyerServiceImpl;
import application.service.impl.SellerServiceImpl;

/**
 *
 * @author Yz5z2
 */
public class ServiceFactory {
	private static BuyerService buyerService = null;
	private static SellerService sellerService = null;

	public static BuyerService getBuyerServiceInstance() {
		if (buyerService == null)
			buyerService = new BuyerServiceImpl();
		return buyerService;
	}

	public static SellerService getSellerServiceInstance() {
		if (sellerService == null)
			sellerService = new SellerServiceImpl();
		return sellerService;
	}
}
