package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainConverterView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Dimension dimension = new Dimension(600, 400);
	
	private JPanel jpMain = new JPanel();
	private JPanel jpNorth = new JPanel();
	private JPanel jpCenter = new JPanel();
	private JPanel jpSouth = new JPanel();
	private JLabel jlMain = new JLabel("Alura - Oracle Next One FT5");
	private JButton jbTemperature = new JButton("Temperatura");
	private JButton jbCurrency = new JButton("Moeda");
	private JButton jbContinue = new JButton("Continuar");
	private JButton jbExit = new JButton("Sair");
	
	public MainConverterView() throws HeadlessException {
		this.setTitle("Conversor");
		this.setMinimumSize(dimension);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createMainConverterView() {
		jpMain.setBorder(BorderFactory.createEtchedBorder());
		jpMain.add(jlMain);
		
		jpNorth.setLayout(new FlowLayout());
		jbTemperature.addActionListener(this);
		jbCurrency.addActionListener(this);
		jpNorth.add(jbTemperature);
		jpNorth.add(jbCurrency);
		
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		jbContinue.addActionListener(this);
		jbExit.addActionListener(this);
		jpSouth.setLayout(fl);
		jpSouth.add(jbContinue);
		jbContinue.setEnabled(false);
		jpSouth.add(jbExit);
		
		jpSouth.setBorder(BorderFactory.createEtchedBorder());


		this.add(jpMain, BorderLayout.NORTH);
		this.add(jpNorth, BorderLayout.CENTER);
		this.add(jpSouth, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println(ae.getActionCommand());
		String choice = ae.getActionCommand().toString();
		if(choice.equals("Sair")) {
			System.exit(0);			
		}
		if(choice.equals("Continuar")) {
			jbTemperature.setVisible(true);
			jbCurrency.setVisible(true);
			jbContinue.setEnabled(false);
		}
		if(choice.equals("Moeda")) {
			jbContinue.setEnabled(true);
			jbTemperature.setVisible(false);
			jbCurrency.setVisible(false);
		}
		if(choice.equals("Temperatura")) {
			jbContinue.setEnabled(true);
			jbTemperature.setVisible(false);
			jbCurrency.setVisible(false);
		}
		
	}
	
	

}
