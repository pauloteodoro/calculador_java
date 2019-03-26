import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;




@SuppressWarnings({ "serial" })
public class TelaCalculadora extends JFrame{
	final String[][] labels = {
			{"7", "8", "9", "+"},
			{"4", "5", "6", "-"},
			{"1", "2", "3", "*"},
			{"0", "C", "=", "/"}
	};
	int cont = 0;
	JLabel telinha = new JLabel("");
	JLabel total = new JLabel("");
	Map<String, JButton> botoes = new HashMap<>();
	
	
	public TelaCalculadora (){
		setSize(400,600);
		setTitle("Calculadora");
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);                        
		getContentPane().setBackground(new Color(105,105,105));
		
		Telinha();
		TelaMostra();
		Botaoo();
		adicionaEventoBotao();
		adicionaEventoMais();
		adicionaEventoMenos();
		adicionaEventoMultiplicacao();
		adicionaEventoDivisao();
		adicionaEventoReset();
		adicionaEventoIgual();
		setVisible(true);		
	}
	
	public void Botaoo () {    
		int lar = (getWidth()) / 4;
		int alt = (400) / 4;
		
		for(Integer x = 0, i = 0; x < getWidth(); x += lar, i++){
			for(Integer y = 0, j = 0; y < 400; y += alt, j++){
				Casa casa = new Casa(x, y + 160, labels[j][i]);
				botoes.put(labels[j][i], casa.botao);
				add(casa.botao);
			}
		}		
	}
	
	String AuxLeitura="", AuxArmazenamento="",auxNUmString = "";
	int aint=0,Aint=0,ParOperador=0,NumTelaINt=0;	
	
	
	public void adicionaEventoBotao() {
	
	
		
		for (Integer i = 0 ; i < 10; i++) {
			botoes.get(i.toString()).addActionListener(event -> {
				JButton botao = (JButton) event.getSource();				
				telinha.setText(botao.getText());
				AuxLeitura=AuxLeitura+botao.getText();
				telinha.setText(    AuxLeitura);
			});	
		}
	}
	 
	
	public void adicionaEventoMais() {
		botoes.get("+").addActionListener(event -> {
			
			AuxArmazenamento = AuxLeitura;
			AuxLeitura ="";			
			ParOperador=1;	
		});
	}
	
	public void adicionaEventoMenos() {
		botoes.get("-").addActionListener(event -> {
			
			AuxArmazenamento = AuxLeitura;
			AuxLeitura ="";
			ParOperador=2;
		});
	}
	
	public void adicionaEventoMultiplicacao() {
		botoes.get("*").addActionListener(event -> {
			
			AuxArmazenamento = AuxLeitura;
			AuxLeitura ="";
			ParOperador=3;				
		});
	}
	
	public void adicionaEventoDivisao() {
		botoes.get("/").addActionListener(event -> {			
			AuxArmazenamento = AuxLeitura;
			AuxLeitura ="";
			ParOperador=4;				
		});
	}
	
	
	public void adicionaEventoIgual() {
		botoes.get("=").addActionListener(event -> {	
				
			if(ParOperador == 1) {
				aint = Integer.parseInt(AuxArmazenamento);
				Aint = Integer.parseInt(AuxLeitura);	
				NumTelaINt = Aint;				
				Aint = aint + Aint;				
				AuxArmazenamento = "" + Aint;
				auxNUmString = "" + NumTelaINt;				
				AuxLeitura = "" + aint;
				telinha.setText(AuxArmazenamento);
				total.setText(AuxLeitura + " + " + auxNUmString + " = "+ AuxArmazenamento );
				AuxLeitura=AuxArmazenamento;
				
				
			}
			if(ParOperador == 2) {
				aint = Integer.parseInt(AuxArmazenamento);
				Aint = Integer.parseInt(AuxLeitura);	
				NumTelaINt = Aint;
				Aint = aint - Aint;				
				AuxArmazenamento = "" + Aint;
				auxNUmString = "" + NumTelaINt;
				AuxLeitura = "" + aint;
				telinha.setText(AuxArmazenamento);
				total.setText(AuxLeitura+ " - " + auxNUmString + " = " + AuxArmazenamento);
				AuxLeitura=AuxArmazenamento;
			}
			if(ParOperador == 3) {
				aint = Integer.parseInt(AuxArmazenamento);
				Aint = Integer.parseInt(AuxLeitura);	
				NumTelaINt = Aint;
				Aint = aint * Aint;				
				AuxArmazenamento = "" + Aint;
				auxNUmString = "" + NumTelaINt;
				AuxLeitura = "" + aint;
				telinha.setText(AuxArmazenamento);
				total.setText(AuxLeitura+ " * " + auxNUmString + " = "+ AuxArmazenamento );
				AuxLeitura=AuxArmazenamento;
			}
			if(ParOperador == 4) {
				aint = Integer.parseInt(AuxArmazenamento);
				Aint = Integer.parseInt(AuxLeitura);
				NumTelaINt = Aint;
				Aint = aint / Aint;				
				AuxArmazenamento = "" + Aint;
				auxNUmString = "" + NumTelaINt;
				AuxLeitura = "" + aint;
				telinha.setText(AuxArmazenamento);
				total.setText(AuxLeitura+ " / " + auxNUmString + " = "+ AuxArmazenamento);
				AuxLeitura=AuxArmazenamento;				
			}		
			
			
		});
	}
	
	public void adicionaEventoReset() {
		botoes.get("C").addActionListener(event -> {
			
			telinha.setText(null);	
			total.setText(null);
			AuxLeitura = "";
			AuxArmazenamento = "";
			auxNUmString = "";
			NumTelaINt =0;
			Aint = 0;
			aint =0;
			ParOperador=0;	
		});
	}
	
	public void Telinha() {
		
		telinha.setSize(400,70);
		telinha.setAlignmentX(Component.RIGHT_ALIGNMENT);
		telinha.setLocation(0, 70);
		telinha.setBorder(BorderFactory.createLineBorder(Color.black));
		telinha.setOpaque(true);
		telinha.setBackground(new Color(168,168,168));
		telinha.setHorizontalAlignment(SwingConstants.RIGHT);
		telinha.setVerticalAlignment(SwingConstants.CENTER);
		setLayout(null);
		
		setLocationRelativeTo(null);
		
		Font f = new Font("Verdana",0,50);
	    telinha.setFont(f);
		add(telinha);
	}
	
	
	public void TelaMostra () {
		
		total.setSize(400,70);
		total.setAlignmentX(Component.LEFT_ALIGNMENT);		
		total.setLocation(0, 0);		
		total.setOpaque(true);
		total.setBackground(new Color(255,255,255));
		total.setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Font f = new Font("Verdana",0,25);
	    total.setFont(f);  
		add(total);
	}
		
		
}
	


