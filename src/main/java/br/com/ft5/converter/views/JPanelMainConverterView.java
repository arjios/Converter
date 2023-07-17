package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMainConverterView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	// --- North
	private JPanel jpanelChoice = new JPanel();
	private FlowLayout flowLayoutChoice = new FlowLayout();
	private JButton jbuttonTemperature = new JButton("Temperatura");
	private JButton jbuttonCurrency = new JButton("Moeda");

	public JPanelMainConverterView() {
		setLayout(new BorderLayout());

		// --- North
		setJpanelChoice(jpanelChoice);
		add(getJpanelChoice());
		
		setVisible(true);
	}
	
	public void setJpanelChoice(JPanel jpanelChoice) {
		flowLayoutChoice.setAlignment(FlowLayout.CENTER);
		jpanelChoice.setLayout(flowLayoutChoice);
		jpanelChoice.add(jbuttonTemperature);
		jbuttonCurrency.setPreferredSize(jbuttonTemperature.getPreferredSize());
		jpanelChoice.add(jbuttonCurrency);
	}
	
	public JPanel getJpanelChoice() {
		return jpanelChoice;
	}

	public FlowLayout getFlowLayoutChoice() {
		return flowLayoutChoice;
	}

	public void setFlowLayoutChoice(FlowLayout flowLayoutChoice) {
		this.flowLayoutChoice = flowLayoutChoice;
	}

	public JButton getJbuttonTemperature() {
		return jbuttonTemperature;
	}

	public void setJbuttonTemperature(JButton jbuttonTemperature) {
		this.jbuttonTemperature = jbuttonTemperature;
	}

	public JButton getJbuttonCurrency() {
		return jbuttonCurrency;
	}

	public void setJbuttonCurrency(JButton jbuttonCurrency) {
		this.jbuttonCurrency = jbuttonCurrency;
	}

}
