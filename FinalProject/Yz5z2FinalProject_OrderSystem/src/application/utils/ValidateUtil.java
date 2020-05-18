package application.utils;

import javafx.scene.control.Label;

public class ValidateUtil {
	public static boolean validateEmpty(String text, Label label) {
		if (text.equals("") || text == null) {
			label.setText("The content can not be blank!");
			return false;
		}
		label.setText("");
		return true;
	}

	public static boolean validateRegex(String text, String regex, Label label) {
		if (!text.matches(regex)) {
			label.setText("The content format is incorrect!");
			return false;
		}
		label.setText("");
		return true;
	}
}
