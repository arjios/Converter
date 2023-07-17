package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelConverterTemperature extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private String[] temperaturas = { "Kelvin-Celsius", "Kelvin-Fahrenheit", "Celsius-Fahrenheit", "Celsius-Kelvin",
			"Fahrenheit-Kelvin", "Fahrenheit-Kelvin" };

//	// --- Main
//	private BorderLayout borderLayoutMainTemperature = new BorderLayout();
//	private JPanel jpanelMainTemperature = new JPanel();
	
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
	private JLabel jlabelResultTemperature = new JLabel("Valor convertido: ");
	private JLabel jlabelValueTemperature = new JLabel(" ");
	
	public JPanelConverterTemperature() {
		setLayout(new BorderLayout());
		
		// --- North
		flowLayoutChoiceTemperature.setAlignment(FlowLayout.CENTER);
		jpanelChoiceTemperature.setLayout(flowLayoutChoiceTemperature);
		jpanelChoiceTemperature.add(jlabelChoiceTemperature);
		jpanelChoiceTemperature.add(jcomboChoiceTemperature);
		
		// --- Center
		flowLayoutInputTemperature.setAlignment(FlowLayout.CENTER);
		jpanelInputTemperature.setLayout(flowLayoutInputTemperature);
		jpanelInputTemperature.add(jlabelInputTemperature);
		jpanelInputTemperature.add(jtextInputTemperature);
		
		// -- South
		flowLayoutResultTemperature.setAlignment(FlowLayout.CENTER);
		jpanelResultTemperature.setLayout(flowLayoutResultTemperature);
		jpanelResultTemperature.add(jlabelResultTemperature);
		jpanelResultTemperature.add(jlabelValueTemperature);
			
		add(jpanelChoiceTemperature, BorderLayout.NORTH);
		add(jpanelInputTemperature, BorderLayout.CENTER);
		add(jpanelResultTemperature, BorderLayout.SOUTH);
		setVisible(true);		
	}

	public String[] getMoedas() {
		return temperaturas;
	}

	public void setMoedas(String[] temperaturas) {
		this.temperaturas = temperaturas;
	}
//
//	public JPanel getJpanelMainTemperature() {
//		return jpanelMainTemperature;
//	}
//
//	public void setJpanelMainTemperature(JPanel jpanelMainTemperature) {
//		this.jpanelMainTemperature = jpanelMainTemperature;
//	}

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
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
		
	}
}
