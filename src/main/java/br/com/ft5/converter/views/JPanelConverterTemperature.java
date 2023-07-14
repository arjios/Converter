package br.com.ft5.converter.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelConverterTemperature extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	public JPanelConverterTemperature() {
		JPanel jpanelConverterTemperature = new JPanel(); 
		jpanelConverterTemperature.setLayout(new BorderLayout());

		JPanel jpMainExit = new JPanel();
		jpMainExit.setLayout(new FlowLayout());
		JButton jbExit = new JButton("Sair");
		jbExit.addActionListener(this);
		jpMainExit.add(jbExit);
		jpanelConverterTemperature.add(jpMainExit, BorderLayout.SOUTH);
		this.add(jpanelConverterTemperature);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
		
	}
}
