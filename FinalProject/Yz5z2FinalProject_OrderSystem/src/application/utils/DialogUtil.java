package application.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DialogUtil {
	/**
	 * @param title
	 * @param contentText
	 * @param buttonTypes
	 * @return
	 */
	public static Dialog<?> getDialog(String title,String contentText){
		Dialog<?> dialog = new Dialog<>();
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
		dialog.setTitle(title);
		dialog.setContentText(contentText);
		return dialog;
	}
        
        public static boolean  confirmDialog(String header, String content) {
		boolean[] isClickedOk = new boolean[] {false};
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("CONFIRM");
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait().filter(response->response==ButtonType.OK)
		.ifPresent(response->isClickedOk[0] = true);
		
		return isClickedOk[0];
	}
}
