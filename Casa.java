import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;




@SuppressWarnings("serial")
public class Casa extends JButton{
	JButton botao;
	public Casa (int x, int y, String text) {   
		botao = new JButton();
		
		botao.setText(text); 
		botao.setSize(90,90);
	    botao.setLocation(x+5,y);
	    botao.setFont(new Font("Ravie", 1, 18));
	    botao.setForeground(new Color(1, 1, 1)); 
	    botao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(1, 1, 1), 1));
	    botao.setRequestFocusEnabled(false);
	    botao.setRolloverEnabled(false);
	    botao.setMargin(new Insets(2, 1000, 2, 14));	    
	    botao.setBackground(new Color(100,100,100));
	    Font f = new Font("Arial",0,40);
	    botao.setFont(f);
	}
}
