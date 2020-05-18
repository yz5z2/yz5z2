# FINAL PROJECT DOCUMENTATION
# Order System
The project name is Order System, it is a restaurant ordering platform for sellers and buyers. The following will introduce the project structure.

UI: This project was created using JavaFX，there are four .fxml documents in the project including BuyerLayout.fxm, SellerLayout.fxml, RegistLayout.fxml and
LoginLayout.fxml
## Architecture: 
Model { Buyer.java ,Seller.java, Food.java, CartFood.java, Order.java, Detail.java}
Dao {BuyerDao.java ,SellerDAO.java,... }
Servcie { BuyerService.java ,SellerService,...}
Controller { BuyerLayoutController.java,LoginLayoutController.java,...} Views { The four .fxml documents in the UI }
## Required Elements:
## 1. Object Oriented Elements: 
### a. Classes
i. Buyer.java
ii. Seller.java,
iii. Food.java,
iv. CartFood.java,
v. Order.java
vi. Detail.java
### b. sub-class
i. BuyerLayoutController.java
ii. SellerLayoutController.java
iii. LoginLayoutController.java
iv. RegistLayoutController.java
### c. Abstract-Class:
i. BaseDao.java
### d. Interface:
All interfaces in the package (application.dao and application.service )
i. FoodDAO.java
ii. BuyerService.java
iii. ...
## 2. Code elements Utilized:
### a.Collection Classes Utilized:
i. In the package( dao, service) and their implementation classes for List <>
ii. BuyerLayoutController.java, SellerLayoutController.java Callback<TableColumn<Order, String>, TableCell<Order, String>> choiceColFactory = new Callback<TableColumn<Order, String>, TableCell<Order, String>>() {}
iii. BuyerLayoutController.java
Utilizes ObservableList<> for Schedule display in TableView <Line 117>
### b.Exception Handling:
i. In the package(application.dao) Try-Catch utilized to catch Exception,beacase it interact with the database
## 3. Clearly Defined Model:
a. User: Buyer.java Seller.java
b. Food: Food.java CartFood.java
c. Order: Order.java Detail.java
## 4. Multiples Scenes with dynamic scene display: 
### a. LoginLayout.fxml
i. Jump to various page (BuyerLayout.fxml, SellerLayout.fxml) according to different roles(seller and buyer)
ii. The page can regist new buyer
### b. BuyerLayout.fxml,
i. Food on sale
ii. Place an order
iii. My order inquiry
iv. Single order details
### c. SellerLayout.fxml
i. Food management (add food, modify food)
ii. All order inquiries
iii. Single order details, including buyer information
## 5. Saving and Loading Data:
In the view package, there are many buttons and controller.java interaction, data loading and saving. For local testing, you need to modify the account and password of the mysql database of JDBCUtil.java in the package application.utils; the default account of the seller's home is 1111 password admin.
