
package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Text L00, L01, L02, L03, L04;

    @FXML
    private Text L10, L11, L12, L13, L14;

    @FXML
    private Text L20, L21, L22, L23, L24;

    @FXML
    private Text L30, L31, L32, L33, L34;

    @FXML
    private Text L40, L41, L42, L43, L44;

    @FXML
    private Text L50, L51, L52, L53, L54;
    
    @FXML
    private Rectangle S00; @FXML private Rectangle S01; @FXML private Rectangle S02; @FXML private Rectangle S03; @FXML private Rectangle S04;

    @FXML
    private Rectangle S10; @FXML private Rectangle S11; @FXML private Rectangle S12; @FXML private Rectangle S13; @FXML private Rectangle S14;

    @FXML
    private Rectangle S20; @FXML private Rectangle S21; @FXML private Rectangle S22; @FXML private Rectangle S23; @FXML private Rectangle S24;

    @FXML
    private Rectangle S30; @FXML private Rectangle S31; @FXML private Rectangle S32; @FXML private Rectangle S33; @FXML private Rectangle S34;

    @FXML
    private Rectangle S40; @FXML private Rectangle S41; @FXML private Rectangle S42; @FXML private Rectangle S43; @FXML private Rectangle S44;

    @FXML
    private Rectangle S50; @FXML private Rectangle S51; @FXML private Rectangle S52; @FXML private Rectangle S53; @FXML private Rectangle S54;
    
    
    @FXML
    private Text L1, L2, L3;
    @FXML
    private Text LQ, LW, LE, LR, LT, LY, LU, LI, LO, LP;
    @FXML
    private Text LA, LS, LD, LF, LG, LH, LJ, LK, LL;
    @FXML
    private Text LZ, LX, LC, LV, LB, LN, LM;

    @FXML
    private Rectangle RQ; @FXML private Rectangle RW; @FXML private Rectangle RE; @FXML private Rectangle RR; @FXML private Rectangle RT; @FXML private Rectangle RY; @FXML private Rectangle RU; @FXML private Rectangle RI; @FXML private Rectangle RO; @FXML private Rectangle RP;
    
    @FXML
    private Rectangle RA; @FXML private Rectangle RS; @FXML private Rectangle RD; @FXML private Rectangle RF; @FXML private Rectangle RG; @FXML private Rectangle RH; @FXML private Rectangle RJ; @FXML private Rectangle RK; @FXML private Rectangle RL;

    @FXML
    private Rectangle RZ; @FXML private Rectangle RX; @FXML private Rectangle RC; @FXML private Rectangle RV; @FXML private Rectangle RB; @FXML private Rectangle RN; @FXML private Rectangle RM;

    
    
    @FXML
    private Text Title;
    
    @FXML
    private ImageView EndBackground;
    
    @FXML
    private ImageView YouWin;
    
    @FXML
    private ImageView YouLose;

    @FXML
    private Text WannaPlayAgain;
    
    @FXML
    private Button Yes;
    
    @FXML
    private Button No;
    
    @FXML
    private Text CorrectWordWas;
    
    @FXML
    private Text CorrectWord;

    @FXML
    private Text Streak;
    
    @FXML
    private Text ERR_INPUT;
    
    @FXML
    private TextField TextIn;
    
    final String[] Words = {"WHALE", "SQUID", "DIMES", "CROWN", "PRINT", "BLACK",
    		"GROUT", "RATIO", "HYPER", "NYMPH", "POISE", "BREAD", "SENSE",
    		"QUOTE", "WRONG", "RIGHT", "ZESTY", "LEAST", "SLATE", "STALE",
    		"STEAL", "DRUNK", "DRANK", "DRINK", "TASTE", "TEACH"};
    
    String Word = Words[(int) (Math.random() * Words.length)];    
    
    final Color yellow = Color.rgb(184, 165, 22);

    final Color green = Color.rgb(58, 136, 58);

    final Color grey = Color.rgb(80, 80, 80);
    
    final Color white = Color.rgb(255, 255, 255);
   
    int count = 0;
    
	int streak = 0;
    
    void colorChangeYellow(Rectangle s) {
        s.setFill(yellow);
        s.setStroke(yellow);
    }

    void colorChangeGreen(Rectangle s) {
        s.setFill(green);
        s.setStroke(green);
    }

    void colorChangeGrey(Rectangle s) {
        s.setFill(grey);
        s.setStroke(grey);
    }
    
    void colorReset(Rectangle s) {
        s.setFill(white);
        s.setStroke(grey);
    }
    
    
    @FXML
    void Guesses(ActionEvent event) {
    	Text[][] TextArray = {{L00, L01, L02, L03, L04},
    			{L10, L11, L12, L13, L14},
    			{L20, L21, L22, L23, L24},
    			{L30, L31, L32, L33, L34},
    			{L40, L41, L42, L43, L44},
    			{L50, L51, L52, L53, L54}};
    	
    	String w = TextIn.getText().toString().toUpperCase();
    	
    	
    	// Error Message(s)
		if(w.length()!=5||!w.matches("[a-zA-Z]+")) {
		    ERR_INPUT.setVisible(true);
		} else {
		    ERR_INPUT.setVisible(false);
		    //Regular Run
		    for (int i = 0; i < w.length(); i++){
		        TextArray[count][i].setText(Character.toString(w.charAt(i)));
		    }
		    TextIn.clear();
		    count++;
		    CheckWord(w); // CHECKS WORD TO SET THE CORRECT COLORS
		    Keyboard(w);
		}
    			
    	// If You Win
    	if(w.equalsIgnoreCase(Word)) {
    		EndBackground.setVisible(true);;
        	YouWin.setVisible(true);
        	WannaPlayAgain.setVisible(true);
    		Yes.setVisible(true);
        	No.setVisible(true);
        	CorrectWordWas.setVisible(true);
        	CorrectWord.setText(Word);
        	CorrectWord.setVisible(true);
        	Streak.setText(Streak.getText()+1);
            streak++;
        	Streak.setText(Integer.toString(streak));
    	}else if(count==6) {			// If You Lose
    		EndBackground.setVisible(true);
    		YouLose.setVisible(true);
        	WannaPlayAgain.setVisible(true);
    		Yes.setVisible(true);
        	No.setVisible(true);
        	CorrectWordWas.setVisible(true);
        	CorrectWord.setText(Word);
        	CorrectWord.setVisible(true);
        	streak=0;
        	Streak.setText(Integer.toString(streak));
    	}
    	
    }
    
    void CheckWord(String guess) {
        Rectangle[][] RectArray = {{S00, S01, S02, S03, S04},
        		{S10, S11, S12, S13, S14}, 
        		{S20, S21, S22, S23, S24}, 
        		{S30, S31, S32, S33, S34}, 
        		{S40, S41, S42, S43, S44}, 
        		{S50, S51, S52, S53, S54}};
        
        //Text[][] KeyboardArray = {
        
        for(int i = 0; i < guess.length(); i++) {
         	 if(Word.charAt(i) == guess.charAt(i)) {
         	    colorChangeGreen(RectArray[count-1][i]);
         	} else if (Word.contains(String.valueOf(guess.charAt(i)))) {
           	    colorChangeYellow(RectArray[count-1][i]);
         	} else {
         		colorChangeGrey(RectArray[count-1][i]);
         	}
        }
    }
    
    @FXML
    void Keyboard (String guess) {
    	Text[][] keyArray = {
    		    {LQ, LW, LE, LR, LT, LY, LU, LI, LO, LP},
    		    {LA, LS, LD, LF, LG, LH, LJ, LK, LL},
    		    {LZ, LX, LC, LV, LB, LN, LM}};
    	
    	for(int i = 0; i < guess.length(); i++) {
        	 if(Word.charAt(i) == guess.charAt(i)) {
        		 //colorChangeGreen(RectArray[count-1][i]);
        		 colorChangeGreen(RQ);
        	} else if (Word.contains(String.valueOf(guess.charAt(i)))) {
          	    //colorChangeYellow(RectArray[count-1][i]);
        	} else {
        		//colorChangeGrey(RectArray[count-1][i]);
        	}
       }
    }
    
    @FXML
    void PlayAgain(ActionEvent event) {
    	
    	count = 0;
    	
    	Yes.setVisible(false);
    	No.setVisible(false);
    	WannaPlayAgain.setVisible(false);
    	YouWin.setVisible(false);
    	YouLose.setVisible(false);
    	EndBackground.setVisible(false);
    	CorrectWordWas.setVisible(false);
    	CorrectWord.setVisible(false);
    	
    	Word = Words[(int) Math.floor(Math.random() * Words.length)];
    	
    	Rectangle[][] RectArray = {{S00, S01, S02, S03, S04},
        		{S10, S11, S12, S13, S14}, 
        		{S20, S21, S22, S23, S24}, 
        		{S30, S31, S32, S33, S34}, 
        		{S40, S41, S42, S43, S44}, 
        		{S50, S51, S52, S53, S54}};
    	
    	Text[][] TextArray = {{L00, L01, L02, L03, L04},
    			{L10, L11, L12, L13, L14},
    			{L20, L21, L22, L23, L24},
    			{L30, L31, L32, L33, L34},
    			{L40, L41, L42, L43, L44},
    			{L50, L51, L52, L53, L54}};
    	
    	for(int x = 0; x < TextArray.length; x++) {
        	for(int y = 0; y < TextArray.length; y++) {
        		TextArray[y][x].setText("");
        		colorReset(RectArray[y][x]);

        	}
    	}
    }
    
    @FXML
    void DonePlaying(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    @FXML
    void QButton(ActionEvent event) {
    	if (LP instanceof Text) {
    		
    	}
    	//StringBuilder aa = new StringBuilder(this.get())
    	StringBuilder sb = new StringBuilder(TextIn.getText());
    	sb.append("Q");
    	TextIn.setText(sb.toString());
    	//TextIn.setText(LP.get);
    }
   
    @FXML
    void addA(ActionEvent event) {
    	StringBuilder sb = new StringBuilder(TextIn.getText());
    	sb.append("a");
    	TextIn.setText(sb.toString());
    	b.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.UP) {
				b.setId(b.getId());
				} else if (event.getCode() == KeyCode.DOWN) {
				b.setId(b.getId());
				} else if (event.getCode() == KeyCode.LEFT) {
				b.setId(b.getId());
				} else if (event.getCode() == KeyCode.RIGHT) {
				b.setId(b.getId()+2);
				} 
			}
		});
    	b.setOnAction(new EventHandler<KeyEvent>90)() {
    		
    	};
    }
    
   
    @FXML
    Button b;
    

}
