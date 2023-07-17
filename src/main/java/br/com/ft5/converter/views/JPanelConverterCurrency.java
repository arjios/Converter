package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ft5.converter.controllers.CurrencyController;
import br.com.ft5.converter.dto.CurrencyDTO;

public class JPanelConverterCurrency extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	private String[] moedas = { "USD-BRL", "BRL-EUR", "BRL-GBP", "BRL-ARS", "BRL-CLP", "BRL-CNY", "BRL-KRW", "BRL-JPY",
			"USD-BRL", "EUR-BRL", "GBP-BRL", "ARS-BRL", "CLP-BRL", "CNY-BRL", "KRW-BRL", "JPY-BRL" };
	
	private String valueString = "0.00";
	private Double valueDouble = 0.00;
	
	// --- Main
	private BorderLayout borderLayoutMainCurrency = new BorderLayout();
 	private JPanel jpanelMainCurrency = new JPanel();
	
	// --- North
	private FlowLayout flowLayoutChoiceCurrency = new FlowLayout();
	private JPanel jpanelChoiceCurrency = new JPanel();
	private JLabel jlabelChoiceCurrency = new JLabel("Escolha a moeda para converter: ");
	private JComboBox<String> jcomboChoiceCurrency = new JComboBox<>(moedas);
	
	// --- Center
	private FlowLayout flowLayoutInputCurrency = new FlowLayout();
	private JPanel jpanelInputCurrency = new JPanel();
	private JLabel jlabelInputCurrency = new JLabel("Digite o valor da moeda para converter, depois <ENTER>: ");
	private JTextField jtextInputCurrency = new JTextField(10);
	
	// --- South
	private FlowLayout flowLayoutResultCurrency = new FlowLayout();
	private JPanel jpanelResultCurrency = new JPanel();
	private JLabel jlabelResultCurrency = new JLabel("Valor convertido ");
	private JLabel jlabelValueCurrency = new JLabel(" ");
	
	public JPanelConverterCurrency() {
		setLayout(new BorderLayout());
		
		// --- North
		flowLayoutChoiceCurrency.setAlignment(FlowLayout.LEFT);
		jpanelChoiceCurrency.setLayout(flowLayoutChoiceCurrency);
		jpanelChoiceCurrency.add(jlabelChoiceCurrency);
		jpanelChoiceCurrency.add(jcomboChoiceCurrency);
		
		// --- Center
		flowLayoutInputCurrency.setAlignment(FlowLayout.LEFT);
		jpanelInputCurrency.setLayout(flowLayoutInputCurrency);
		jpanelInputCurrency.add(jlabelInputCurrency);
		jtextInputCurrency.setHorizontalAlignment(JTextField.RIGHT);
		jtextInputCurrency.setText(valueString);
		jtextInputCurrency.addKeyListener(this);
		jpanelInputCurrency.add(jtextInputCurrency);
		
		// -- South
		flowLayoutResultCurrency.setAlignment(FlowLayout.LEFT);
		jpanelResultCurrency.setLayout(flowLayoutResultCurrency);
		jpanelResultCurrency.add(jlabelResultCurrency);
		jpanelResultCurrency.add(jlabelValueCurrency);
			
		// --- North and South
		jpanelMainCurrency.setLayout(borderLayoutMainCurrency);
		jpanelMainCurrency.add(jpanelInputCurrency, BorderLayout.NORTH);
		jpanelMainCurrency.add(jpanelResultCurrency, BorderLayout.CENTER);
		
		
		add(jpanelChoiceCurrency, BorderLayout.NORTH);
		add(jpanelMainCurrency, BorderLayout.CENTER);

		setVisible(true);		
	}

	public String[] getMoedas() {
		return moedas;
	}

	public void setMoedas(String[] moedas) {
		this.moedas = moedas;
	}

	public JPanel getJpanelChoiceCurrency() {
		return jpanelChoiceCurrency;
	}

	public void setJpanelChoiceCurrency(JPanel jpanelChoiceCurrency) {
		this.jpanelChoiceCurrency = jpanelChoiceCurrency;
	}

	public JLabel getJlabelChoiceCurrency() {
		return jlabelChoiceCurrency;
	}

	public void setJlabelChoiceCurrency(JLabel jlabelChoiceCurrency) {
		this.jlabelChoiceCurrency = jlabelChoiceCurrency;
	}

	public JComboBox<String> getJcomboChoiceCurrency() {
		return jcomboChoiceCurrency;
	}

	public void setJcomboChoiceCurrency(JComboBox<String> jcomboChoiceCurrency) {
		this.jcomboChoiceCurrency = jcomboChoiceCurrency;
	}

	public JPanel getJpanelInputCurrency() {
		return jpanelInputCurrency;
	}

	public void setJpanelInputCurrency(JPanel jpanelInputCurrency) {
		this.jpanelInputCurrency = jpanelInputCurrency;
	}

	public JLabel getJlabelInputCurrency() {
		return jlabelInputCurrency;
	}

	public void setJlabelInputCurrency(JLabel jlabelInputCurrency) {
		this.jlabelInputCurrency = jlabelInputCurrency;
	}

	public JTextField getJtextInputCurrency() {
		return jtextInputCurrency;
	}

	public void setJtextInputCurrency(String jtextInnputCurrencyText) {
		this.jtextInputCurrency.setText(jtextInnputCurrencyText);
	}

	public JPanel getJpanelResultCurrency() {
		return jpanelResultCurrency;
	}

	public void setJpanelResultCurrency(JPanel jpanelResultCurrency) {
		this.jpanelResultCurrency = jpanelResultCurrency;
	}

	public JLabel getJlabelResultCurrency() {
		return jlabelResultCurrency;
	}

	public void setJlabelResultCurrency(JLabel jlabelResultCurrency) {
		this.jlabelResultCurrency = jlabelResultCurrency;
	}

	public JLabel getJlabelValueCurrency() {
		return jlabelValueCurrency;
	}

	public void setJlabelValueCurrency(String jlabelValueCurrencyText) {
		this.jlabelValueCurrency.setText(jlabelValueCurrencyText);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		char ch = ke.getKeyChar();
		if( ch == '\n') {
    		CurrencyController currencyController = new CurrencyController();
    		CurrencyDTO dto = currencyController.convertController(jcomboChoiceCurrency.getSelectedItem().toString(), Double.parseDouble(jtextInputCurrency.getText().replace(",", "")));
    		jlabelValueCurrency.setText((dto.getName().toString().replace("/", " para ")) + "=> " + NumberFormat.getNumberInstance().format(dto.getValue()));
		}
		if((ch >= '0' && ch <= '9') ) {
			ke.consume();
			if(!valueString.equals("0.00") || ch != '0') {
				if(valueString.equals("0.00")) {
					valueString = String.valueOf(ch);
					valueDouble = (Double.parseDouble(valueString)*0.01);
					Double textoDouble =((Double.parseDouble(jtextInputCurrency.getText()))) + valueDouble;
					jtextInputCurrency.setText(String.valueOf(textoDouble));
				} else {
					valueString = String.valueOf(ch);
					valueDouble = (Double.parseDouble(valueString)*0.01);
					Double textoDouble =((Double.parseDouble(jtextInputCurrency.getText()
							.replace(",", "")))*10.0) + valueDouble;
					jtextInputCurrency.setText(String.valueOf(NumberFormat
							.getNumberInstance(new Locale("en", "US")).format(textoDouble)));
				}
			} 
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
	
	}

	@Override
	public void keyReleased(KeyEvent ke) {

	}
	
}
