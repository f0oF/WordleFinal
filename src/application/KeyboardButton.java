package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class KeyboardButton extends Button{
	
	private TextField t;
	
	KeyboardButton(TextField tf){
		t = tf;
	}
	
	public void handle(KeyEvent event) {
		StringBuilder sb = new StringBuilder(t.getText());
    	sb.append("a");
    	t.setText(sb.toString());
	}

}
