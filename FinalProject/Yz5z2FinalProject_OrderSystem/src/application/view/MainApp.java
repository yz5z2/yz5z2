/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.view;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.view.LoginLayoutController;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Yz5z2
 */
public class MainApp extends Application {
	private Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		this.stage.setTitle("Order System");
		this.stage.getIcons().add(new Image("file:" + MainApp.class.getResource("logo.png").getPath()));
		showLoginLayout();
	}

	public void showLoginLayout() {
		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("LoginLayout.fxml"));
			AnchorPane page = loader.load();
			((LoginLayoutController) loader.getController()).setMainApp(this);
			stage.setScene(new Scene(page));
			stage.setResizable(false);
			stage.sizeToScene();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
        public void showRegisterLayout() {
                stage.close();
		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("RegistLayout.fxml"));
			BorderPane page = loader.load();
			RegistLayoutController controller = loader.getController();
			controller.setMainApp(this);
			stage.setScene(new Scene(page));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showBuyerLayout(String name,String bno) {
		stage.close();
		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("BuyerLayout.fxml"));
			AnchorPane page = loader.load();
			BuyerLayoutController controller = loader.getController();
			controller.setMainApp(this);
			controller.setName(name);
			controller.setUno(bno);
			stage.setScene(new Scene(page));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showSellerLayout(String name) {
		stage.close();
		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("SellerLayout.fxml"));
			AnchorPane page = loader.load();
			SellerLayoutController controller = loader.getController();
			controller.setMainApp(this);
			controller.setName(name);
			stage.setScene(new Scene(page));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}

