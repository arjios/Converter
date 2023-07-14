package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
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
	
	// jpMain = cards
	private CardLayout cardLayout = new CardLayout();
	private Container jpMain = new JPanel();
	
	
	public MainConverterView() throws HeadlessException {
		super("Conversor");
		setLayout(new BorderLayout());
		setMinimumSize(dimension);
		
		jpMain.setLayout(new CardLayout());
		jpMain.add("Main", new JPanelMainConverterView());
		jpMain.add("Currency", new JPanelConverterCurrency());
		jpMain.add("Temperature", new JPanelConverterTemperature());
		cardLayout = (CardLayout) jpMain.getLayout();
		cardLayout.show(jpMain, "Main");
		
		JPanel jpMainExit = new JPanel();
		jpMainExit.setLayout(new FlowLayout());
		JButton jbExit = new JButton("Sair");
		jbExit.addActionListener(this);
		jpMainExit.add(jbExit);
		
		getContentPane().add(MainTitle(), BorderLayout.NORTH);
		getContentPane().add(jpMain, BorderLayout.CENTER);
		getContentPane().add(jpMainExit, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	private JPanel MainTitle() {
		JPanel jpPanelLabelTitle = new JPanel();
		jpPanelLabelTitle.setLayout(new FlowLayout());
		jpPanelLabelTitle.setBorder(BorderFactory.createEtchedBorder());		
		JLabel jlMainTitle = new JLabel("Alura - Oracle Next One FT5");

		jpPanelLabelTitle.add(jlMainTitle);
		return jpPanelLabelTitle;
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		String option = ae.getActionCommand().toString();
		if(option.equals("Sair")) {
			System.exit(0);
		}
		if(option.equals("Temperatura")) {
			cardLayout.show(jpMain, "Temperature");
			System.out.println("Temperatura");
		}
		if(option.equals("Moeda")) {
			cardLayout.show(jpMain, "Currency");
			System.out.println("Moeda");
		}
		
	}

}
