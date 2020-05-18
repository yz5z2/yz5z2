package application.view;

import application.factory.ServiceFactory;
import application.model.Buyer;
import application.service.BuyerService;
import application.utils.DialogUtil;
import application.utils.VerificationCodeTool;
import java.util.Map;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**   
* @author Yz5z2  
*
*/

public class RegistLayoutController {
    
        private BuyerService buyerService = ServiceFactory.getBuyerServiceInstance();
	private MainApp mainApp;
	
	//back login
	@FXML
	private ImageView backToLoginView;
	
	@FXML
	private Label userNameErrorInfo;
	
	@FXML
	private Label passwordErrorInfo;
	
	
	@FXML
	private Label verificationAnswerErrorInfo;
	
        @FXML
        private TextField userAccountField;
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField passwordField;
	
        @FXML 
        private TextField phoneField;
                
	@FXML 
        private TextField addressField;
        
	@FXML
	private Label verificationCode;
	
	@FXML
	private TextField verificationCodeAnswerField;
	
	@FXML 
	private Button registButton;
	
	private int realVerCodeAnswer;
	
	
	@FXML
	private void handleRegistBtnAction() {
		System.out.println("HandleRegistButtonAction");
		
		initErroLabel();
		
                String account = userAccountField.getText();
		String userName = userNameField.getText();
		String password = passwordField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
            
	
		
		//code flag
		boolean isCorrectVerCodeAn = false;
		
		//check code
		try {
			int userVerCodeAnswer = Integer.parseInt(verificationCodeAnswerField.getText());
			if(this.realVerCodeAnswer == userVerCodeAnswer) {
				isCorrectVerCodeAn = true;
			}else {
				this.verificationAnswerErrorInfo.setText("Verification code error");
			}
		}catch(Exception e) {
			this.verificationAnswerErrorInfo.setText("Verification code error");
		}
		
		
		if(isCorrectVerCodeAn) {
			if(account!=null && userName!=null && password!=null) {
                                    Buyer buyer = new Buyer(account,userName,password,phone,address);
                                    Buyer checkBuyer = buyerService.findBuyerByBno(account);
                                    if(checkBuyer==null){
					if(buyerService.insertBuyer(buyer)) {							
							
								boolean isGoToSystemView = DialogUtil.confirmDialog("success", "Press OK to log in to the main interface, cancel to return to the login interface");
								if(isGoToSystemView) {
									
									mainApp.showBuyerLayout(userName, userName);
								}else {
									mainApp.showLoginLayout();
								}
							}else {
								DialogUtil.getDialog("failed", "Please re-register");
							}
                                    }else{
                                        DialogUtil.getDialog("Error", "The account has been registered!").show();
                                    }
                                   
					
				}else {
					passwordErrorInfo.setText("input null");
				}
			
		}
		//update code
		setVerCode();
	}
	
	@FXML
	private void HandleBackToLoginAction() {
	mainApp.showLoginLayout();
	}
	
	
	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {	
		setVerCode();
	}
	
	
	private void initErroLabel() {
		this.userNameErrorInfo.setText("");
		this.passwordErrorInfo.setText("");
		this.verificationAnswerErrorInfo.setText("");
		this.verificationAnswerErrorInfo.setText("");	
	}
	
	/**
	 *	code
	 */
	private void setVerCode() {
		Map<String, Integer> verCodeAndAnswer = VerificationCodeTool.generateArithmeticVerification();
		verCodeAndAnswer.forEach((verCode,answer)->{
			verificationCode.setText(verCode);
			this.realVerCodeAnswer = answer;
		});
	}
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
}
