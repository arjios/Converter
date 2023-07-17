package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Antonio Alves do Rosario Junior
 *
 */

public class MainConverterView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	final static String TEMPERATURE = "Temperatura";
	final static String CURRENCY = "Moeda";
	final static String RETORNAR = "Retornar";
	final static String EXIT = "Sair";
	
	private Dimension dimension = new Dimension(600, 200);
	
	JPanelConverterCurrency jpanelConverterCurrency = new JPanelConverterCurrency();

	private JPanel jpanelCards;
	private JPanel jpMain = new JPanel();
	
	// --- North
	private JPanel jpanelTitle = new JPanel();
	private FlowLayout flowLayoutTitle = new FlowLayout();
	private JLabel jlabelTitle = new JLabel("Alura - Oracle Next One FT5");
	
	// --- Center
	private JPanel jpCenter = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	
	// --- South
	private JPanel jpanelCenterButtons = new JPanel();
	private FlowLayout flowLayoutButtons = new FlowLayout();
	private JButton jbuttonReturn = new JButton(RETORNAR);
	private JButton jbuttonExit = new JButton(EXIT);
	
	public MainConverterView() {
		super("Conversor");
		setMinimumSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// --- North
		jpanelTitle.setLayout(flowLayoutTitle);
		jpanelTitle.setBorder(BorderFactory.createEtchedBorder());
		jpanelTitle.add(jlabelTitle);
		
		// --- Center
		jpCenter.setLayout(cardLayout);
		jpCenter.setBorder(BorderFactory.createEtchedBorder());
		JPanelMainConverterView jpanelMainConverterView = new JPanelMainConverterView();
		jpanelMainConverterView.getJbuttonTemperature().setActionCommand(TEMPERATURE);
		jpanelMainConverterView.getJbuttonTemperature().addActionListener(this);
		jpanelMainConverterView.getJbuttonCurrency().addActionListener(this);
		jpCenter.add(jpanelMainConverterView.getJpanelChoice());
		
		// --- South
		flowLayoutButtons.setAlignment(FlowLayout.RIGHT);
		jpanelCenterButtons.setLayout(flowLayoutButtons);
		jpanelCenterButtons.setBorder(BorderFactory.createEtchedBorder());
		jbuttonReturn.addActionListener(this);
		jbuttonReturn.setVisible(false);
		jbuttonExit.setPreferredSize(jbuttonReturn.getPreferredSize());
		jbuttonExit.setActionCommand(EXIT);
		jbuttonExit.addActionListener(this);
		jpanelCenterButtons.add(jbuttonReturn);
		jpanelCenterButtons.add(jbuttonExit);
		jpMain.add(jpanelCenterButtons);
		
		// --- Temperature Converter
		JPanelConverterTemperature jpanelConverterTemperature = new JPanelConverterTemperature();
//		JPanelConverterCurrency jpanelConverterCurrency = new JPanelConverterCurrency();
		
		jpanelCards = new JPanel(new CardLayout());
		jpanelCards.add(jpCenter, RETORNAR);
		jpanelCards.add(jpanelConverterTemperature, TEMPERATURE);
		jpanelCards.add(jpanelConverterCurrency, CURRENCY);
		

		
		jpMain.setLayout(new BorderLayout());
		jpMain.add(jpanelTitle, BorderLayout.NORTH);
		jpMain.add(jpanelCenterButtons, BorderLayout.SOUTH);
		
		jpMain.add(jpanelCards, BorderLayout.CENTER);
		
		add(jpMain, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();

		if (action.equals(TEMPERATURE)) {
			jbuttonReturn.setVisible(true);
			jbuttonExit.setVisible(false);
			action = TEMPERATURE;
			System.out.println(action);
		}
		if (action.equals(CURRENCY)) {
			jbuttonReturn.setVisible(true);
			jbuttonExit.setVisible(false);
			action = CURRENCY;
			System.out.println(action);
		}
		if(action.equals(RETORNAR)) {
			System.out.println(action);
			jbuttonReturn.setVisible(false);
			jbuttonExit.setVisible(true);
			jpanelConverterCurrency.setJtextInputCurrency("0.00");
			jpanelConverterCurrency.setJlabelValueCurrency("");
			action = RETORNAR;
		}
		if(action.equals(EXIT)) {
			System.out.println(action);
			System.exit(0);
		}
        CardLayout cl = (CardLayout) (jpanelCards.getLayout());
        cl.show(jpanelCards, action);
	}

}
