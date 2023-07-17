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

import br.com.ft5.converter.controllers.TemperatureController;

public class JPanelConverterTemperature extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;

	private String[] temperaturas = { "Kelvin-Celsius", "Kelvin-Fahrenheit", "Celsius-Fahrenheit", "Celsius-Kelvin",
			"Fahrenheit-Celsius", "Fahrenheit-Kelvin" };
	
	private String valueString = "0.00";
	private Double valueDouble = 0.00;

	// --- Main
	private BorderLayout borderLayoutMainTemperature = new BorderLayout();
	private JPanel jpanelMainTemperature = new JPanel();
	
	// --- North
	private FlowLayout flowLayoutChoiceTemperature = new FlowLayout();
	private JPanel jpanelChoiceTemperature = new JPanel();
	private JLabel jlabelChoiceTemperature = new JLabel("Escolha a unidade de temperatura para converter: ");
	private JComboBox<String> jcomboChoiceTemperature = new JComboBox<>(temperaturas);
	
	// --- Center
	private FlowLayout flowLayoutInputTemperature = new FlowLayout();
	private JPanel jpanelInputTemperature = new JPanel();
	private JLabel jlabelInputTemperature = new JLabel("Digite o valor unidade de temperatura para converter: ");
	private JTextField jtextInputTemperature = new JTextField(10);
	
	// --- South
	private FlowLayout flowLayoutResultTemperature = new FlowLayout();
	private JPanel jpanelResultTemperature = new JPanel();
	private JLabel jlabelResultTemperature = new JLabel("Valor convertido de ");
	private JLabel jlabelValueTemperature = new JLabel(" ");
	
	public JPanelConverterTemperature() {
		setLayout(new BorderLayout());
		
		// --- North
		flowLayoutChoiceTemperature.setAlignment(FlowLayout.LEFT);
		jpanelChoiceTemperature.setLayout(flowLayoutChoiceTemperature);
		jpanelChoiceTemperature.add(jlabelChoiceTemperature);
		jpanelChoiceTemperature.add(jcomboChoiceTemperature);
		
		// --- Center
		flowLayoutInputTemperature.setAlignment(FlowLayout.LEFT);
		jpanelInputTemperature.setLayout(flowLayoutInputTemperature);
		jpanelInputTemperature.add(jlabelInputTemperature);
		jtextInputTemperature.setHorizontalAlignment(JTextField.RIGHT);
		jtextInputTemperature.setText(valueString);
		jtextInputTemperature.addKeyListener(this);
		jpanelInputTemperature.add(jtextInputTemperature);
		
		// -- South
		flowLayoutResultTemperature.setAlignment(FlowLayout.LEFT);
		jpanelResultTemperature.setLayout(flowLayoutResultTemperature);
		jpanelResultTemperature.add(jlabelResultTemperature);
		jpanelResultTemperature.add(jlabelValueTemperature);
		
		// --- North and South
		jpanelMainTemperature.setLayout(borderLayoutMainTemperature);
		jpanelMainTemperature.add(jpanelInputTemperature, BorderLayout.NORTH);
		jpanelMainTemperature.add(jpanelResultTemperature, BorderLayout.CENTER);
			
		add(jpanelChoiceTemperature, BorderLayout.NORTH);
		add(jpanelMainTemperature, BorderLayout.CENTER);
		
		setVisible(true);		
	}

	public String[] getMoedas() {
		return temperaturas;
	}

	public void setMoedas(String[] temperaturas) {
		this.temperaturas = temperaturas;
	}

	public JPanel getJpanelChoiceTemperature() {
		return jpanelChoiceTemperature;
	}

	public void setJpanelChoiceTemperature(JPanel jpanelChoiceTemperature) {
		this.jpanelChoiceTemperature = jpanelChoiceTemperature;
	}

	public JLabel getJlabelChoiceTemperature() {
		return jlabelChoiceTemperature;
	}

	public void setJlabelChoiceTemperature(JLabel jlabelChoiceTemperature) {
		this.jlabelChoiceTemperature = jlabelChoiceTemperature;
	}

	public JComboBox<String> getJcomboChoiceTemperature() {
		return jcomboChoiceTemperature;
	}

	public void setJcomboChoiceTemperature(JComboBox<String> jcomboChoiceTemperature) {
		this.jcomboChoiceTemperature = jcomboChoiceTemperature;
	}

	public JPanel getJpanelInputTemperature() {
		return jpanelInputTemperature;
	}

	public void setJpanelInputTemperature(JPanel jpanelInputTemperature) {
		this.jpanelInputTemperature = jpanelInputTemperature;
	}

	public JLabel getJlabelInputTemperature() {
		return jlabelInputTemperature;
	}

	public void setJlabelInputTemperature(JLabel jlabelInputTemperature) {
		this.jlabelInputTemperature = jlabelInputTemperature;
	}

	public JTextField getJtextInputTemperature() {
		return jtextInputTemperature;
	}

	public void setJtextInputTemperature(JTextField jtextInnputTemperature) {
		this.jtextInputTemperature = jtextInnputTemperature;
	}

	public JPanel getJpanelResultTemperature() {
		return jpanelResultTemperature;
	}

	public void setJpanelResultTemperature(JPanel jpanelResultTemperature) {
		this.jpanelResultTemperature = jpanelResultTemperature;
	}

	public JLabel getJlabelResultTemperature() {
		return jlabelResultTemperature;
	}

	public void setJlabelResultTemperature(JLabel jlabelResultTemperature) {
		this.jlabelResultTemperature = jlabelResultTemperature;
	}

	public JLabel getJlabelValueTemperature() {
		return jlabelValueTemperature;
	}

	public void setJlabelValueTemperature(JLabel jlabelValueTemperature) {
		this.jlabelValueTemperature = jlabelValueTemperature;
	}



	@Override
	public void keyTyped(KeyEvent ke) {
		char ch = ke.getKeyChar();
		if( ch == '\n') {
			TemperatureController temperatureController = new TemperatureController();
			Double temp = temperatureController.convertController(jcomboChoiceTemperature.getSelectedItem().toString(), Double.parseDouble(jtextInputTemperature.getText().replace(",", "")));
    		jlabelValueTemperature.setText(jcomboChoiceTemperature.getSelectedItem().toString() + "=> " + NumberFormat.getNumberInstance().format(temp));
		}
		if((ch >= '0' && ch <= '9') ) {
			ke.consume();
			if(!valueString.equals("0.00") || ch != '0') {
				if(valueString.equals("0.00")) {
					valueString = String.valueOf(ch);
					valueDouble = (Double.parseDouble(valueString)*0.01);
					Double textoDouble =((Double.parseDouble(jtextInputTemperature.getText()))) + valueDouble;
					jtextInputTemperature.setText(String.valueOf(textoDouble));
				} else {
					valueString = String.valueOf(ch);
					valueDouble = (Double.parseDouble(valueString)*0.01);
					Double textoDouble =((Double.parseDouble(jtextInputTemperature.getText()
							.replace(",", "")))*10.0) + valueDouble;
					jtextInputTemperature.setText(String.valueOf(NumberFormat
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
