/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.view;

import application.factory.ServiceFactory;
import application.model.CartFood;
import application.model.Detail;
import application.model.Food;
import application.model.Order;
import application.service.BuyerService;
import application.utils.DialogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 *
 * @author Yz5z2
 */
public class BuyerLayoutController {
    private final BuyerService buyerService = ServiceFactory.getBuyerServiceInstance();
	private MainApp mainApp;
	private String currentBno;
	@FXML
	private Label userName;
        @FXML
	private Label orderIdText;
        
        @FXML
	private BorderPane orderHistory;
        @FXML
	private BorderPane orderDetail;
        
	@FXML
	private TableView<Food> stapleTable;
	@FXML
	private TableView<Food> vegetablesTable;
	@FXML
	private TableView<Food> meatTable;
	@FXML
	private TableView<Food> gruelTable;

	@FXML
	private TableColumn<Food, String> stapleIdTableCol;
	@FXML
	private TableColumn<Food, String> vegetablesIdTableCol;
	@FXML
	private TableColumn<Food, String> meatIdTableCol;
	@FXML
	private TableColumn<Food, String> gruelIdTableCol;

	@FXML
	private TableColumn<Food, String> stapleNameTableCol;
	@FXML
	private TableColumn<Food, String> vegetablesNameTableCol;
	@FXML
	private TableColumn<Food, String> meatNameTableCol;
	@FXML
	private TableColumn<Food, String> gruelNameTableCol;

	@FXML
	private TableColumn<Food, Double> staplePriceTableCol;
	@FXML
	private TableColumn<Food, Double> vegetablesPriceTableCol;
	@FXML
	private TableColumn<Food, Double> meatPriceTableCol;
	@FXML
	private TableColumn<Food, Double> gruelPriceTableCol;

	@FXML
	private TableColumn<Food, Integer> stapleCountTableCol;
	@FXML
	private TableColumn<Food, Integer> vegetablesCountTableCol;
	@FXML
	private TableColumn<Food, Integer> meatCountTableCol;
	@FXML
	private TableColumn<Food, Integer> gruelCountTableCol;

	@FXML
	private TableColumn<Food, String> stapleBtnTableCol;
	@FXML
	private TableColumn<Food, String> vegetablesBtnTableCol;
	@FXML
	private TableColumn<Food, String> meatBtnTableCol;
	@FXML
	private TableColumn<Food, String> gruelBtnTableCol;

	@FXML
	private TableView<CartFood> boughtTable;
	public ObservableSet<String> boughtNameSet = FXCollections.observableSet();
	public ObservableSet<CartFood> boughtFoodBeanSet = FXCollections.observableSet();
	public ObservableList<CartFood> boughtFoodBeanList = FXCollections.observableArrayList(boughtFoodBeanSet);

	@FXML
	private TableColumn<CartFood, String> boughtNameCol;
	@FXML
	private TableColumn<CartFood, Double> boughtPriceCol;
	@FXML
	private TableColumn<CartFood, Integer> boughtCountCol;
	@FXML
	private TableColumn<CartFood, Double> boughtTotalCol;

	@FXML
	private Label sumPrice;
	private double sumPriceTemp;

	@FXML
	private Button decreaseBtn;
	@FXML
	private Button increaseBtn;
	@FXML
	private Button delBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Button payBtn;
        //order
	@FXML
	private TableView<Order> orderHistoryTable;
	@FXML
	private TableColumn<Order, String> orderIdCol;
	@FXML
	private TableColumn<Order, Double> orderPriceCol;
	@FXML
	private TableColumn<Order, String> orderTimeCol;
	@FXML
	private TableColumn<Order, String> orderChoiceCol;
        //detail
        @FXML
	private TableView<Detail> orderDetailTable;
	@FXML
	private TableColumn<Detail, String> detailIdCol;
	@FXML
	private TableColumn<Detail, String> detailNameCol;
	@FXML
	private TableColumn<Detail, Double> detailPriceCol;
	@FXML
	private TableColumn<Detail, Integer> detailAmountCol;
//       	@FXML
//	private TableColumn<Detail, Double> detailTotalCol; 
     
	private StringProperty currentOid = new SimpleStringProperty();
	private ToggleGroup toggleGroup = new ToggleGroup();
	private Integer[] currentCombo;
	private Map<String, Integer> categoryDict;
	private boolean comboLock = false;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setName(String name) {
		this.userName.setText(name);
	}

	public void setUno(String bno) {
		this.currentBno = bno;
	}

	@FXML
	private void initialize() {
		categoryDict = new HashMap<>();
		categoryDict.put("Staple Food", 0);
		categoryDict.put("Vegetable Dish", 1);
		categoryDict.put("Meat Dish", 2);
		categoryDict.put("Soup Porridge", 3);
		initFoodListCellValueFactory();
		initCartFoodCellValueFactory();
                initOrderListCellValueFactory();
                orderHistory.setVisible(true);
                orderDetail.setVisible(false);
                        
	}

	private void initFoodListCellValueFactory() {
		stapleIdTableCol.setCellValueFactory(cellData -> cellData.getValue().fidProperty());
		stapleNameTableCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		staplePriceTableCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
		stapleCountTableCol.setCellValueFactory(new PropertyValueFactory<Food, Integer>("amount"));

		vegetablesIdTableCol.setCellValueFactory(cellData -> cellData.getValue().fidProperty());
		vegetablesNameTableCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		vegetablesPriceTableCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
		vegetablesCountTableCol.setCellValueFactory(new PropertyValueFactory<Food, Integer>("amount"));

		meatIdTableCol.setCellValueFactory(cellData -> cellData.getValue().fidProperty());
		meatNameTableCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		meatPriceTableCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
		meatCountTableCol.setCellValueFactory(new PropertyValueFactory<Food, Integer>("amount"));

		gruelIdTableCol.setCellValueFactory(cellData -> cellData.getValue().fidProperty());
		gruelNameTableCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		gruelPriceTableCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
		gruelCountTableCol.setCellValueFactory(new PropertyValueFactory<Food, Integer>("amount"));

		Callback<TableColumn<Food, String>, TableCell<Food, String>> buyBtnFactory = new Callback<TableColumn<Food, String>, TableCell<Food, String>>() {
			@Override
			public TableCell<Food, String> call(TableColumn<Food, String> param) {
				final TableCell<Food, String> cell = new TableCell<Food, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (!empty) {
							final Button buyBtn = new Button("Select");
							buyBtn.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									param.getTableView().getSelectionModel().select(getIndex());
									Food item = null;
									if (stapleTable.getSelectionModel().getSelectedItem() != null)
										item = stapleTable.getSelectionModel().getSelectedItem();
									else if (vegetablesTable.getSelectionModel().getSelectedItem() != null)
										item = vegetablesTable.getSelectionModel().getSelectedItem();
									else if (meatTable.getSelectionModel().getSelectedItem() != null)
										item = meatTable.getSelectionModel().getSelectedItem();
									else
										item = gruelTable.getSelectionModel().getSelectedItem();

									if (item.getAmount() == 0)
										DialogUtil.getDialog("Error", "Not enough currently available!").show();
									else {
										// add food
										if (updateBoughtTable(item))
											item.setAmount(item.getAmount() - 1);
										updateSumPrice();
									}
									boughtTable.refresh();
								}
							});
							setGraphic(buyBtn);
							setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						}
					};
				};
				return cell;
			}

		};
		stapleBtnTableCol.setCellFactory(buyBtnFactory);
		vegetablesBtnTableCol.setCellFactory(buyBtnFactory);
		meatBtnTableCol.setCellFactory(buyBtnFactory);
		gruelBtnTableCol.setCellFactory(buyBtnFactory);
                        
                List<Food> stapleList = buyerService.findAllFoodByCategory("Staple Food");
                if(stapleList!=null){
                    stapleTable.setItems(FXCollections.observableArrayList(stapleList));
                }
                
                List<Food> vegetableList = buyerService.findAllFoodByCategory("Vegetable Dish");
                if(vegetableList!=null){
                    vegetablesTable.setItems(FXCollections.observableArrayList(vegetableList));
                }
                
                List<Food> meatList = buyerService.findAllFoodByCategory("Meat Dish");
                if(meatList!=null){
                    meatTable.setItems(FXCollections.observableArrayList(meatList));
                }
                
                List<Food> soupList = buyerService.findAllFoodByCategory("Soup Porridge");
                if(soupList!=null){
                    gruelTable.setItems(FXCollections.observableArrayList(soupList));
                }

	}

	private void initCartFoodCellValueFactory() {
		boughtNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		boughtPriceCol.setCellValueFactory(new PropertyValueFactory<CartFood, Double>("price"));
		boughtCountCol.setCellValueFactory(new PropertyValueFactory<CartFood, Integer>("amount"));
		boughtTotalCol.setCellValueFactory(new PropertyValueFactory<CartFood, Double>("total"));
		boughtTable.setItems(boughtFoodBeanList);
	}
	private void initOrderListCellValueFactory() {
		orderIdCol.setCellValueFactory(cellData -> cellData.getValue().getOidProperty());
		orderPriceCol.setCellValueFactory(new PropertyValueFactory<Order, Double>("orderAmount"));
                orderTimeCol.setCellValueFactory(new PropertyValueFactory<Order, String>("createDate"));
                
                Callback<TableColumn<Order, String>, TableCell<Order, String>> choiceColFactory = new Callback<TableColumn<Order, String>, TableCell<Order, String>>() {
			@Override
			public TableCell<Order, String> call(TableColumn<Order, String> param) {
				final TableCell<Order, String> cell = new TableCell<Order, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setText("");
							setGraphic(null);
						} else {
							final Button detailBtn = new Button("Detail");
                                                        detailBtn.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
                                                                    param.getTableView().getSelectionModel().select(getIndex());
                                                                    Order item = orderHistoryTable.getSelectionModel().getSelectedItem();

                                                                     orderHistory.setVisible(false);
                                                                       orderDetail.setVisible(true);
                                                                    orderIdText.setText(item.getOid());
                                                                    updateOrderDetailCellValueFactory(item.getOid());
                                                                }
                                                        });
                                                        setGraphic(detailBtn);
							setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//							
						}

					}
				};
				return cell;
			}

		};
		orderChoiceCol.setCellFactory(choiceColFactory);
	}
	private void updateOrderDetailCellValueFactory(String oid) {
		detailIdCol.setCellValueFactory(new PropertyValueFactory<Detail, String>("did"));
		detailNameCol.setCellValueFactory(new PropertyValueFactory<Detail, String>("name"));
                detailPriceCol.setCellValueFactory(new PropertyValueFactory<Detail, Double>("price"));
                detailAmountCol.setCellValueFactory(new PropertyValueFactory<Detail, Integer>("quantity"));
                orderDetailTable.setItems(FXCollections.observableArrayList(buyerService.findOrderDetailByOid(oid)));

	}
	// update bought food
	private boolean updateBoughtTable(Food food) {
		boolean flag = true;
		boolean temp = true;
		if (toggleGroup.getSelectedToggle() == null)
			comboLock = false;
		int preSize = boughtNameSet.size();
		boughtNameSet.add(food.getName());
		String itemName = food.getName();
		if (boughtNameSet.size() == preSize) {
			if (boughtFoodBeanSet.size() != 0) {
				Iterator<CartFood> iter = boughtFoodBeanSet.iterator();
				while (iter.hasNext()) {
					CartFood item = iter.next();
					if (item.getName().equals(itemName)) {
						if (!comboLock) {
							item.setAmount(item.getAmount() + 1);
						} else if (findBoughtCategoryCount()
								.get(item.getCategory()) < currentCombo[categoryDict.get(item.getCategory())]) {
							item.setAmount(item.getAmount() + 1);
						} else
							flag = false;
					}
				}
			} else {
				flag = false;
			}
		} else {
			if (!comboLock) {
				boughtFoodBeanSet
						.add(new CartFood(food.getFid(), food.getName(), food.getCategory(), food.getPrice(),1));
			} else if (findBoughtCategoryCount()
					.get(food.getCategory()) < currentCombo[categoryDict.get(food.getCategory())]) {
				boughtFoodBeanSet
						.add(new CartFood(food.getFid(), food.getName(), food.getCategory(),food.getPrice(),1));
			} else {
				temp = false;
				flag = false;
			}
		}
		boughtFoodBeanList.clear();
		boughtFoodBeanList.addAll(boughtFoodBeanSet);
		updateSumPrice();
		if (!temp)
			boughtNameSet.remove(food.getName());
		boughtTable.refresh();
		return flag;
	}
	private Map<String, Integer> findBoughtCategoryCount() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Staple Food", 0);
		map.put("Vegetable Dish", 0);
		map.put("Meat Dish", 0);
		map.put("Soup Porridge", 0);
		boughtTable.getItems().forEach(item -> {
			map.replace(item.getCategory(), map.get(item.getCategory()) + item.getAmount());
		});
		return map;
	}

	private void updateSumPrice() {
		if (!comboLock) {
			sumPriceTemp = 0;
			boughtTable.getItems().forEach(t -> sumPriceTemp += t.getTotal());
			sumPrice.setText(String.valueOf(sumPriceTemp));
			boughtTable.refresh();
		}
	}

        
        @FXML
        private void handleUpdateAndQueryOrderHistory(){
            List<Order> orderList = buyerService.findOwnOrderList(currentBno);
            if(orderList!=null){                   
                orderHistoryTable.setItems(FXCollections.observableArrayList(orderList));
            }else{
                DialogUtil.getDialog("Prompt", "You have no order!").show();
            }
        }
	@FXML
	private void handleStapleMouseExits() {
		stapleTable.getSelectionModel().clearSelection();
	}

	@FXML
	private void handleVegetablesMouseExits() {
		vegetablesTable.getSelectionModel().clearSelection();
	}

	@FXML
	private void handleMeatMouseExits() {
		meatTable.getSelectionModel().clearSelection();
	}

	@FXML
	private void handleGruelMouseExits() {
		gruelTable.getSelectionModel().clearSelection();
	}

	
	@FXML
	private void handleDecreaseBtn() {
		CartFood foodBean = boughtTable.getSelectionModel().getSelectedItem();
		if (foodBean == null) {
			DialogUtil.getDialog("Error", "No food is selected!").show();
		} else {
			if (foodBean.getAmount() == 1) {
				boughtFoodBeanSet.remove(foodBean);
				boughtNameSet.remove(foodBean.getName());
				boughtFoodBeanList.clear();
				boughtFoodBeanList.addAll(boughtFoodBeanSet);
			} else
				foodBean.setAmount(foodBean.getAmount() - 1);
			backFoodUtil(foodBean, 1);
			updateSumPrice();
		}
	}

	private boolean backFoodTable(CartFood foodBean, TableView<Food> tableview, int num) {
		Iterator<Food> iter = tableview.getItems().iterator();
		while (iter.hasNext()) {
			Food food = iter.next();
			if (food.getName().equals(foodBean.getName())) {
				if (num < 0 && food.getAmount() == 0)
					return false;
				food.setAmount(food.getAmount() + num);
				return true;
			}
		}
		return false;
	}
	private void backFoodUtil(CartFood foodBean, int num) {
		String category = foodBean.getCategory();
		if (category.equals("Staple Food"))
			backFoodTable(foodBean, stapleTable, num);
		else if (category.equals("Vegetable Dish"))
			backFoodTable(foodBean, vegetablesTable, num);
		else if (category.equals("Meat Dish"))
			backFoodTable(foodBean, meatTable, num);
		else
			backFoodTable(foodBean, gruelTable, num);
	}


	@FXML
	private void handleIncreaseBtn() {
		CartFood foodBean = boughtTable.getSelectionModel().getSelectedItem();
		if (foodBean == null) {
			DialogUtil.getDialog("Error", "No food is selected!").show();
		} else {
			String category = foodBean.getCategory();
			boolean flag = false;
			if (category.equals("Staple Food"))
				flag = backFoodTable(foodBean, stapleTable, 1);
			else if (category.equals("Vegetable Dish"))
				flag = backFoodTable(foodBean, vegetablesTable, 1);
			else if (category.equals("Meat Dish"))
				flag = backFoodTable(foodBean, meatTable, 1);
			else
				flag = backFoodTable(foodBean, gruelTable, 1);
			if (flag)
				foodBean.setAmount(foodBean.getAmount() + 1);
			updateSumPrice();
		}
	}

	@FXML
	private void handleDelBtn() {
		CartFood foodBean = boughtTable.getSelectionModel().getSelectedItem();
		if (foodBean == null) {
			DialogUtil.getDialog("Error", "No food is selected!").show();
		} else {
			backFoodUtil(foodBean, foodBean.getAmount());
			boughtFoodBeanSet.remove(foodBean);
			boughtNameSet.remove(foodBean.getName());
			boughtFoodBeanList.clear();
			boughtFoodBeanList.addAll(boughtFoodBeanSet);
			updateSumPrice();
		}
	}

	@FXML
	private void handleClearBtn() {
		Iterator<CartFood> iter = boughtTable.getItems().iterator();
		while (iter.hasNext()) {
			CartFood foodBean = iter.next();
			backFoodUtil(foodBean, foodBean.getAmount());
		}
		boughtNameSet.clear();
		boughtFoodBeanSet.clear();
		boughtFoodBeanList.clear();
		boughtTable.getItems().clear();
		updateSumPrice();
	}

	@FXML
	private void handlePayBtn() {
		boolean isCombo = toggleGroup.getSelectedToggle() != null;
		boolean flag = true;
		if (!isCombo && boughtTable.getItems().size() == 0) {
			DialogUtil.getDialog("Prompt", "No food is selected!").show();
			return;
		}
		if (boughtTable.getItems().size() != 0) {
                    buyerService.createOrder(boughtFoodBeanList, currentBno);
                    flag = true;
		}else{
                    flag = false;
                }

		if (flag) {
			DialogUtil.getDialog("Prompt", "successfully ordered!").show();
			boughtNameSet.clear();
			boughtFoodBeanSet.clear();
			boughtFoodBeanList.clear();
			updateSumPrice();
			boughtTable.refresh();
                        initFoodListCellValueFactory();
                        handleUpdateAndQueryOrderHistory();
		} else {
			DialogUtil.getDialog("Prompt", "Order failed!").show();
		}

	}

//	@FXML
//	private void handleUpdatePwdBtn() {
//		mainApp.showUpdatePwdLayout(currentBno);
//	}
        
        @FXML
        private void handlebackOrderHistoryBtn(){
                orderHistory.setVisible(true);
                orderDetail.setVisible(false);
        }

        @FXML
	private void handleAboutBtn() {
            DialogUtil.getDialog("About", "This is an Order System, it is a restaurant ordering platform for sellers and buyers!").show();
	}
        
	@FXML
	private void handleExitBtn() {
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Prompt");
		dialog.setContentText("Are you sure to exit this program?");
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.CANCEL);
		dialog.showAndWait();
		if (dialog.getResult().equals(ButtonType.YES))
			mainApp.showLoginLayout();
	}
}
