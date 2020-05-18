/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.view;

import application.factory.ServiceFactory;
import application.utils.DialogUtil;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Yz5z2
 */
public class LoginLayoutController {
    	private MainApp mainApp;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField userPwd;
	@FXML
	private RadioButton buyer;
	@FXML
	private RadioButton seller;
	@FXML
	private ToggleGroup idGroup;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void initialize() {
		idGroup = new ToggleGroup();
		idGroup.getToggles().addAll(buyer, seller);
		idGroup.selectToggle(buyer);
		userName.setFocusTraversable(false);
		userPwd.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
			if (e.getCode().equals(KeyCode.ENTER))
				handleSubmitBtn();
		});
	}

	@FXML
	private void handleSubmitBtn() {
		String name = userName.getText();
		String pwd = userPwd.getText();
		if (name.equals("") || pwd.equals("")) {
			DialogUtil.getDialog("Prompt", "Username or Password cannot be empty!").show();
		} else {
			if (idGroup.getSelectedToggle().equals(seller)) {
				String seller = ServiceFactory.getSellerServiceInstance().login(name, pwd);
                                 System.out.println(seller);
                                    System.out.println(name);
                                    System.out.println(pwd);
				if (seller!= null) {
                                    System.out.println("seller login success!");
					mainApp.showSellerLayout(seller);
				}else{
					DialogUtil.getDialog("Prompt", "wrong UserName or Password!").show();
				}
			} else {
				String uname = ServiceFactory.getBuyerServiceInstance().login(name, pwd);
                                 System.out.println(uname);
                                    System.out.println(name);
                                    System.out.println(pwd);
				if (uname!= null) {
                                    System.out.println("buyer login success!");
                                    mainApp.showBuyerLayout(uname,name);
				}else{
					DialogUtil.getDialog("Prompt", "wrong UserName or Password!").show();
				}
			}
		}
	}
        @FXML
        private void handleRegistBtn(){
            mainApp.showRegisterLayout();
        }

        
	@FXML
	private void handleExitBtn(){
		System.exit(0);
	}
        
     
}
