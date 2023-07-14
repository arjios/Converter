package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ft5.converter.controllers.CurrencyController;
import br.com.ft5.converter.dto.CurrencyDTO;

public class CardLayoutDemo extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;

	final static String BUTTONPANEL = "Conversor de Temperatura";
	final static String TEXTPANEL = "Conversor de Moedas";
	final static String JPANEL = "Retornar";
	final static String TEMPERATURE = "Temperatura";
	final static String CURRENCY = "Moeda";
	final static String CONTINUE = "Continuar";
	final static String EXIT = "Sair";

	JPanel cards;
	Dimension dimension = new Dimension(600, 400);

	private String[] moedas = { "USD-BRL", "BRL-EUR", "BRL-GBP", "BRL-ARS", "BRL-CLP", "BRL-CNY", "BRL-KRW", "BRL-JPY",
			"USD-BRL", "EUR-BRL", "GBP-BRL", "ARS-BRL", "CLP-BRL", "CNY-BRL", "KRW-BRL", "JPY-BRL" };
	private String[] temperaturas = { "Kelvin-Celsius", "Kelvin-Fahrenheit", "Celsius-Fahrenheit", "Celsius-Kelvin",
			"Fahrenheit-Kelvin", "Fahrenheit-Kelvin" };

	JComboBox<String> jcbInput = new JComboBox<String>(moedas);
	JTextField jtextField = new JTextField(11);
	JLabel jlResult = new JLabel("  ");

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(CardLayoutDemo::new);
	}
	
	public CardLayoutDemo() {

		setTitle("Conversor");
		setLayout(new BorderLayout());
		setMinimumSize(dimension);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpPanelLabelTitle = new JPanel();
		jpPanelLabelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpPanelLabelTitle.setBorder(BorderFactory.createEtchedBorder());
		JLabel jlMainTitle = new JLabel("Alura - Oracle Next One FT5");
		jpPanelLabelTitle.add(jlMainTitle);
		add(jpPanelLabelTitle, BorderLayout.NORTH);

		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem submenu01 = new JMenuItem("Conversor de Temperatura");
		submenu01.setActionCommand(BUTTONPANEL);
		submenu01.addActionListener(this);
		JMenuItem submenu02 = new JMenuItem("Conversor de Moedas");
		submenu02.setActionCommand(TEXTPANEL);
		submenu02.addActionListener( this);

		JMenuItem submenu03 = new JMenuItem("Retornar");
		submenu03.setActionCommand(JPANEL);
		submenu03.addActionListener(this);

		menu.add(submenu01);
		menu.add(submenu02);
		menu.add(submenu03);
		menubar.add(menu);
		setJMenuBar(menubar);

		// cria o painel de botoes
		JPanel card1 = new JPanel();
		card1.add(new JButton("Button 1"));
		card1.add(new JButton("Button 2"));
		card1.add(new JButton("Button 3"));
		// cria o painel de campos de texto

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
		JPanel jpInput = new JPanel();
		FlowLayout flInput = new FlowLayout(FlowLayout.CENTER);		
		jpInput.setLayout(flInput);
		
		JPanel jpCombo = new JPanel();
		jpCombo.setLayout(new BorderLayout());
		
		JLabel jlCombo = new JLabel("Escolha a moeda para converter: ");
		
		jcbInput.setEditable(false);
		jcbInput.addActionListener(this);
		
		JPanel jpText = new JPanel();
		jpText.setLayout(new BorderLayout());
		

		
		JLabel jlText = new JLabel("Digite um valor para converter: ");
//		jtextField.setText();
		jtextField.addKeyListener(this);
		
		FlowLayout flTextField = new FlowLayout(FlowLayout.CENTER);
		JPanel jpTextField = new JPanel();
		jpTextField.setLayout(flTextField);
		
		FlowLayout flResult = new FlowLayout(FlowLayout.CENTER);
		JPanel jpResult = new JPanel();
		jpResult.setLayout(flResult);
		JLabel jlResultText = new JLabel("Valor convertido: ");

		jpResult.add(jlResultText);
		jpResult.add(jlResult);
		
		jpInput.add(jlCombo);
		jpInput.add(jcbInput);
		jpCombo.add(jpInput, BorderLayout.NORTH);
		
		jpTextField.add(jlText);
		jpTextField.add(jtextField);
		
		jpCombo.add(jpTextField, BorderLayout.CENTER);
		
		jpCombo.add(jpResult, BorderLayout.SOUTH);

		
//		JPanel card2 = new JPanel(new FlowLayout());
//		card2.add(new JTextField("TextField", 20));
//		card2.add(new JTextField("TextField2", 20));

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		JPanel jpanelMainConverterView = new JPanel(); // variável de instancia
		jpanelMainConverterView.setLayout(new BorderLayout());

		JPanel jpMainButtons = new JPanel();
		jpMainButtons.setLayout(new FlowLayout());
		JButton jbTemperature = new JButton("Temperatura");
		jbTemperature.setActionCommand(TEMPERATURE);
		jbTemperature.addActionListener(this);
		JButton jbCurrency = new JButton("Moeda");
		jbCurrency.setActionCommand(CURRENCY);
		jbCurrency.addActionListener(this);
		jpMainButtons.add(jbTemperature);
		jpMainButtons.add(jbCurrency);
		jpanelMainConverterView.add(jpMainButtons, BorderLayout.CENTER);

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		JPanel jpMainConverter = new JPanel();
		jpMainConverter.setLayout(new BorderLayout());
		JPanel jpMainExit = new JPanel();
		jpMainExit.setBorder(BorderFactory.createEtchedBorder());
		FlowLayout flMainExit = new FlowLayout(FlowLayout.RIGHT);
		jpMainExit.setLayout(flMainExit);
		JButton jbExit = new JButton("Sair");
		jbExit.addActionListener(this);
		jpMainExit.add(jbExit);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		JPanel jpanelConverterTemperature = new JPanel();
		jpanelConverterTemperature.setLayout(new BorderLayout());

//		jpMainExit.setLayout(new FlowLayout());

		JPanel jpInputTemp = new JPanel();
		FlowLayout flInputTemp = new FlowLayout(FlowLayout.CENTER);
		jpInputTemp.setLayout(flInputTemp);
		JPanel jpComboTemp = new JPanel();
		jpComboTemp.setLayout(new BorderLayout());
		JLabel jlComboTemp = new JLabel("Escolha a temperatura para converter: ");
		JComboBox<String> jcbTemp = new JComboBox<String>(temperaturas);
		jpInputTemp.add(jlComboTemp);
		jpInputTemp.add(jcbTemp);
		jpComboTemp.add(jpInputTemp, BorderLayout.NORTH);

//		jbExit.addActionListener(new ChangeCardlayoutListener());
//		jpMainExit.add(jbExit);
//		jpanelConverterTemperature.add(jpMainExit, BorderLayout.SOUTH);
//		this.add(jpanelConverterTemperature);		

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//		jpMainConverter.add(jpText, BorderLayout.NORTH);
		jpMainConverter.add(jpanelMainConverterView, BorderLayout.CENTER);
		jpMainConverter.add(jpMainExit, BorderLayout.SOUTH);

		// este painel é quem será o container para o cardlayout
		// organizar os outros dois paineis
		cards = new JPanel(new CardLayout());
		cards.add(jpMainConverter, JPANEL);
		cards.add(jpComboTemp, BUTTONPANEL);
		cards.add(jpCombo, TEXTPANEL);

		getContentPane().add(cards, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();

		if (action.equals("Sair")) {
			System.exit(0);
		}
		if (action.equals("Temperatura")) {
			System.out.println(action);
			action = BUTTONPANEL;
		}
		if (action.equals("Moeda")) {
			System.out.println(action);
			action = TEXTPANEL;
		}
    	if(action.equals("comboBoxChanged")) {
			String m = jcbInput.getSelectedItem().toString();

    	}
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, action);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		char ch = ke.getKeyChar();
		if( ch == '\n') {
			System.out.println("ENTER");
			System.out.println(jtextField.getText());
    		CurrencyController currencyController = new CurrencyController();
    		CurrencyDTO dto = currencyController.convertController(jcbInput.getSelectedItem().toString(), Double.parseDouble(jtextField.getText()));
    		System.out.println("Moeda escolhida: " + jcbInput.getSelectedItem().toString() + " " + dto.getName());
    		System.out.println("Valor convertido: " + dto.getValue());
			jlResult.setText(dto.getValue().toString());
		}
		if((ch < '0' || ch > '9' || ch == '.') && (ch != KeyEvent.VK_BACK_SPACE)) {
			ke.consume();	
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {

	}
}
