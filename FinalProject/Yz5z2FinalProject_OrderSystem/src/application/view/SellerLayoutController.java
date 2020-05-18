/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.view;

import application.factory.ServiceFactory;
import application.model.Detail;
import application.model.Food;
import application.model.Order;
import application.service.SellerService;
import application.utils.DialogUtil;
import application.utils.ValidateUtil;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author Yz5z2
 */
public class SellerLayoutController {
    
private SellerService sellerService = ServiceFactory.getSellerServiceInstance();
	private MainApp mainApp;
	@FXML
	private Label adminName;
	
        @FXML
	private Label orderIdText;
        
        @FXML
	private Label foodIdText;
        
        @FXML
	private BorderPane orderHistory;
        @FXML
	private BorderPane orderDetail;


	@FXML
	private BorderPane foodListPane;
      
	@FXML
	private Button foodListBtn;
	@FXML
	private TableView<Food> foodListTable;
	@FXML
	private TableColumn<Food, String> foodFidCol;
	@FXML
	private TableColumn<Food, String> foodNameCol;
	@FXML
	private TableColumn<Food, String> foodCategoryCol;
	@FXML
	private TableColumn<Food, Double> foodPriceCol;
	@FXML
	private TableColumn<Food, Integer> foodAmountCol;
        @FXML
	private TableColumn<Food, Integer> foodStatusCol;
        
        @FXML
	private TableColumn<Food, String> foodEditCol;

	@FXML
	private BorderPane foodInsertPane;
	@FXML
	private Button foodInsertBtn;
	@FXML
	private TextField fidText;
	@FXML
	private TextField fnameText;
	@FXML
	private ChoiceBox<String> fcategoryChoice;
	@FXML
	private TextField fpriceText;
	@FXML
	private TextField famountText;
	@FXML
	private Label fidMsg;
	@FXML
	private Label fnameMsg;
	@FXML
	private Label fpriceMsg;
	@FXML
	private Label famountMsg;

        @FXML
        private BorderPane foodEditPane;
        @FXML
	private TextField fEditName;
        @FXML
	private TextField fEditPrice;

	@FXML
	private ChoiceBox<String> fEditCategoryChoice;
        
	@FXML
	private TextField fEditAmount;
        
        @FXML
	private ChoiceBox<Integer> fEditStatusChoice;
        
         //order
	@FXML
	private TableView<Order> orderHistoryTable;
	@FXML
	private TableColumn<Order, String> orderIdCol;
      
        @FXML
	private TableColumn<Order, String>  orderNameCol;
        
	@FXML
	private TableColumn<Order, String>  orderPhoneCol;
        
        @FXML
	private TableColumn<Order, String>  orderAddressCol;
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
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setName(String name) {
		this.adminName.setText(name);
	}

	@FXML
	private void initialize() {
              initOrderListCellValueFactory();
              orderHistory.setVisible(false);
              orderDetail.setVisible(false);
	}

        private void initFoodEdit() {      
		fEditName.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFoodName();
		});
		fEditAmount.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFoodAmount();
		});
		fEditAmount.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFoodPrice();
		});
            fEditCategoryChoice.setItems(FXCollections.observableArrayList("Staple Food", "Vegetable Dish", "Meat Dish", "Soup Porridge"));
            fEditStatusChoice.setItems(FXCollections.observableArrayList(1,0));
            
        }
	private void initFoodInsert() {
		fidText.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFid();
		});
		fnameText.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFoodName();
		});
		famountText.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFoodAmount();
		});
		fpriceText.focusedProperty().addListener((observable, ov, nv) -> {
			if (!nv)
				validateFoodPrice();
		});
		fcategoryChoice.setItems(FXCollections.observableArrayList("Staple Food", "Vegetable Dish", "Meat Dish", "Soup Porridge"));
	}

	class FoodCellEditCommit<T> implements EventHandler<TableColumn.CellEditEvent<Food, T>> {
		private String type;

		public FoodCellEditCommit(String type) {
			this.type = type;
		}

		@Override
		public void handle(TableColumn.CellEditEvent<Food, T> e) {
			Food food = e.getRowValue();
			String msg = null;
			switch (type) {
			case "name":
				msg = "Food Name";
				food.setName((String) e.getNewValue());
				break;
			case "amount":
				msg = "Available Quantity";
				food.setAmount((Integer) e.getNewValue());
				break;
			case "price":
				msg = "Food Price";
				food.setPrice((Double) e.getNewValue());
			}
			if (sellerService.updateFood(food)) {
				DialogUtil.getDialog("Prompt", msg + "Successfully modified!").show();
			} else {
				DialogUtil.getDialog("Prompt", msg + "Unsuccessfully modified!").show();
			}
		}
	}

	private boolean validateFid() {
		if (ValidateUtil.validateEmpty(fidText.getText(), fidMsg)
				&& ValidateUtil.validateRegex(fidText.getText(), "\\d+", fidMsg))
			return true;
		return false;
	}

	private boolean validateFoodName() {
		if (ValidateUtil.validateEmpty(fnameText.getText(), fnameMsg)
				&& ValidateUtil.validateRegex(fnameText.getText(), "[a-zA-Z\\u4e00-\\u9fa5]+", fnameMsg))
			return true;
		return false;
	}

	private boolean validateFoodAmount() {
		if (ValidateUtil.validateEmpty(famountText.getText(), famountMsg)
				&& ValidateUtil.validateRegex(famountText.getText(), "\\d+", famountMsg))
			return true;
		return false;
	}

	private boolean validateFoodPrice() {
		if (ValidateUtil.validateEmpty(fpriceText.getText(), fpriceMsg)
				&& ValidateUtil.validateRegex(fpriceText.getText(), "\\d+(\\.\\d+)?", fpriceMsg))
			return true;
		return false;
	}

	private boolean validateFood() {
		return validateFid() && validateFoodName() && validateFoodAmount() && validateFoodPrice();
	}



	private void initFoodTableFactory() {
		foodFidCol.setCellValueFactory(data -> data.getValue().fidProperty());
		foodNameCol.setCellValueFactory(data -> data.getValue().nameProperty());
		foodNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		foodNameCol.setOnEditCommit(new FoodCellEditCommit<String>("name"));
		foodCategoryCol.setCellValueFactory(data -> data.getValue().categoryProperty());
		foodPriceCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
		foodPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double>() {
			@Override
			public Double fromString(String string) {
				return Double.parseDouble(string);
			}

			@Override
			public String toString(Double object) {
				return String.valueOf(object);
			}
		}));
		foodPriceCol.setOnEditCommit(new FoodCellEditCommit<Double>("price"));
		foodAmountCol.setCellValueFactory(new PropertyValueFactory<Food, Integer>("amount"));
		foodAmountCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
			@Override
			public Integer fromString(String string) {
				return Integer.parseInt(string);
			}

			@Override
			public String toString(Integer object) {
				return String.valueOf(object);
			}
		}));
		foodAmountCol.setOnEditCommit(new FoodCellEditCommit<Integer>("amount"));
                foodStatusCol.setCellValueFactory(new PropertyValueFactory<Food, Integer>("status"));
		foodStatusCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
			@Override
			public Integer fromString(String string) {
				return Integer.parseInt(string);
			}

			@Override
			public String toString(Integer object) {
				return String.valueOf(object);
			}
		}));
		foodStatusCol.setOnEditCommit(new FoodCellEditCommit<Integer>("status"));
                
             
                Callback<TableColumn<Food, String>, TableCell<Food, String>> editColFactory = new Callback<TableColumn<Food, String>, TableCell<Food, String>>() {
			@Override
			public TableCell<Food, String> call(TableColumn<Food, String> param) {
				final TableCell<Food, String> cell = new TableCell<Food, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setText("");
							setGraphic(null);
						} else {
							final Button detailBtn = new Button("Edit");
                                                        detailBtn.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
                                                                    param.getTableView().getSelectionModel().select(getIndex());
                                                                    Food item = foodListTable.getSelectionModel().getSelectedItem();
                                                                    foodEditPane.setVisible(true);
                                                                    foodListPane.setVisible(false);
                                                                    foodIdText.setText(item.getFid());
                                                                    updateFoodCellValueFactory(item.getFid());
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
		foodEditCol.setCellFactory(editColFactory);
                updateFoodTable();

	}
      private void updateFoodCellValueFactory(String fid) {
		
                Food food = sellerService.findFoodByFid(fid);
                if (food!=null){
                    fEditName.setText(food.getName());
                    fEditCategoryChoice.setValue(food.getCategory()); 
                    fEditPrice.setText(String.valueOf(food.getPrice()));
                    fEditAmount.setText(String.valueOf(food.getAmount()));
                    fEditStatusChoice.setValue(food.getStatus());
                }

	}
    private void updateFoodTable(){
        List<Food> foodList = sellerService.findAllFood();
        if(foodList!=null){
            foodListTable.setItems(FXCollections.observableArrayList(foodList));
         }
    }        
    private void initOrderListCellValueFactory() {
		orderIdCol.setCellValueFactory(cellData -> cellData.getValue().getOidProperty());
                orderNameCol.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
                orderPhoneCol.setCellValueFactory(cellData -> cellData.getValue().getPhoneProperty());
                orderAddressCol.setCellValueFactory(cellData -> cellData.getValue().getAddressProperty());
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
                orderDetailTable.setItems(FXCollections.observableArrayList(sellerService.findOrderDetailByOid(oid)));

	}
        
        

	private void hideAllPane() {

		foodListPane.setVisible(false);
                foodEditPane.setVisible(false);
		foodInsertPane.setVisible(false);
                orderHistory.setVisible(false);
                orderDetail.setVisible(false);
	}



	



	@FXML
	private void handleFoodListBtn() {
                initFoodEdit();
		initFoodTableFactory();
		hideAllPane();
		foodListPane.setVisible(true);
	}

	@FXML
	private void handleFoodInsertBtn() {
		initFoodInsert();
		hideAllPane();
		foodInsertPane.setVisible(true);
	}

	@FXML
	private void handleFoodResetBtn() {
		fidText.setText("");
		fnameText.setText("");
		famountText.setText("");
		fpriceText.setText("");
	}

	@FXML
	private void handleFoodSubmitBtn() {
                System.out.println(foodIdText.getText());
                System.out.println(fEditName.getText());
                System.out.println(fEditCategoryChoice.getValue());
                System.out.println(Double.parseDouble(fEditPrice.getText()));
                System.out.println(Integer.parseInt(fEditAmount.getText()));
                System.out.println(fEditStatusChoice.getValue());
		if (sellerService.updateFood(new Food(foodIdText.getText(), fEditName.getText(), fEditCategoryChoice.getValue(),
				Double.parseDouble(fEditPrice.getText()),Integer.parseInt(fEditAmount.getText()),fEditStatusChoice.getValue()))) {
			DialogUtil.getDialog("Prompt", "Food information update success!").showAndWait();
			handleFoodListBtn();
		} else {
			DialogUtil.getDialog("Prompt", "Failed to update food information!").show();
		}
	}
	@FXML
	private void handleFoodInsertSubmitBtn() {
		if (!validateFood()) {
			DialogUtil.getDialog("Prompt", "The input is incorrect, please re-enter!").show();
			return;
		}
                 System.out.println(fcategoryChoice.getValue());
		if (sellerService.insertFood(new Food(fidText.getText(), fnameText.getText(), fcategoryChoice.getValue(),
				Double.parseDouble(fpriceText.getText()),Integer.parseInt(famountText.getText()),1 ))) {
			DialogUtil.getDialog("Prompt", "Food information increase success!").showAndWait();
                        handleFoodResetBtn();
			handleFoodListBtn();
		} else {
			DialogUtil.getDialog("Prompt", "Failed to increase food information!").show();
		}
	}
           @FXML
        private void handleUpdateAndQueryOrderHistory(){
            List<Order> orderList = sellerService.findAllOrder();
            if(orderList!=null){                   
                orderHistoryTable.setItems(FXCollections.observableArrayList(orderList));
            }else{
                DialogUtil.getDialog("Prompt", "You have no order!").show();
            }
        }
        @FXML
        private void handleFoodOrderBtn(){
          	foodListPane.setVisible(false);
                foodEditPane.setVisible(false);
		foodInsertPane.setVisible(false);
                orderHistory.setVisible(true);
                orderDetail.setVisible(false);
        }
        @FXML
        private void handlebackOrderHistoryBtn(){
                foodListPane.setVisible(false);
                foodEditPane.setVisible(false);
		foodInsertPane.setVisible(false);
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