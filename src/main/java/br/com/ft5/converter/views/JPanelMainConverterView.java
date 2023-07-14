package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMainConverterView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	public JPanelMainConverterView() {
		JPanel jpanelMainConverterView = new JPanel(); //variável de instancia
		jpanelMainConverterView.setLayout(new BorderLayout());
		
		JPanel jpMainButtons = new JPanel();
		jpMainButtons.setLayout(new FlowLayout());
		JButton jbTemperature = new JButton("Temperatura");
		jbTemperature.addActionListener(this);
		JButton jbCurrency = new JButton("Moeda");
		jbCurrency.addActionListener(this);
		jpMainButtons.add(jbTemperature);
		jpMainButtons.add(jbCurrency);

		jpanelMainConverterView.add(jpMainButtons, BorderLayout.CENTER);		
		this.add(jpanelMainConverterView);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand().toString();
		if(action.equals("Sair")) {
			System.exit(0);
		}
		if(action.equals("Temperatura")) {
			System.out.println("Temperatura");
		}
		if(action.equals("Moeda")) {
			System.out.println("Moeda");
		}

	}

}
