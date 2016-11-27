package com.cs304.frontend.views;

import com.cs304.data_managers.CustomerDM;
import com.cs304.frontend.Error_Pop;
import com.cs304.frontend.Success_Pop;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javafx.scene.input.KeyCode.J;
import static oracle.net.aso.C09.l;
import static oracle.net.aso.C09.t;
import static oracle.net.aso.C09.w;

public class Pro_Inf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void New_Inf() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro_Inf frame = new Pro_Inf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pro_Inf() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Prod ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mater_Ui matss = new Mater_Ui();
				setVisible(false);
				dispose();
				matss.New_Mat();
			}
		});
		btnNewButton.setBounds(50, 10, 150, 25);
		contentPane.add(btnNewButton);

		JTextField textField_input = new JTextField();
		textField_input.setBounds(250, 10, 100 , 25);
		contentPane.add(textField_input);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds (50,50, 100, 25);
		contentPane.add(lblNewLabel_2);

		JTextArea nameArea = new JTextArea();
		nameArea.setBounds(200,50, 150, 25);
		nameArea.setColumns(10);
		nameArea.setRows(1);
		contentPane.add(nameArea);







	}
}


