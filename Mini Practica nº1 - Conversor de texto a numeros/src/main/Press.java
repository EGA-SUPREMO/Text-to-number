package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Press extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2296325698531203260L;

	/**
	 * Create the panel.
	 */
	public Press() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel cp = new JPanel();
		setContentPane(cp);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{322, 0};
		gridBagLayout.rowHeights = new int[]{22, 154, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		cp.setLayout(gridBagLayout);
		
		JLabel lblEscribeElTexto = new JLabel("Escribe el texto que quieres quitar:");
		lblEscribeElTexto.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblEscribeElTexto = new GridBagConstraints();
		gbc_lblEscribeElTexto.insets = new Insets(0, 0, 5, 0);
		gbc_lblEscribeElTexto.anchor = GridBagConstraints.WEST;
		gbc_lblEscribeElTexto.fill = GridBagConstraints.VERTICAL;
		gbc_lblEscribeElTexto.gridx = 0;
		gbc_lblEscribeElTexto.gridy = 0;
		cp.add(lblEscribeElTexto, gbc_lblEscribeElTexto);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 1;
		cp.add(textPane, gbc_textPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		cp.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main.quitarE(textPane.getText());
				dispose();
				
			}
		});
		panel.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
	
}