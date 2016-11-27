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

import static java.awt.SystemColor.text;
import static javafx.scene.input.KeyCode.J;
import static javafx.scene.input.KeyCode.M;
import static oracle.net.aso.C09.*;

public class Pro_Inf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea_1;
	private JTextField textField_2;
	private JTextField textField_input;
	private JTextArea nameArea;
	private JTextArea stockArea;
	private JTextArea recArea;
	private JTextArea matArea;

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
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Prod ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_input.getText().equals(""));

			}
		});
		btnNewButton.setBounds(50, 10, 100, 25);
		contentPane.add(btnNewButton);

		textField_input = new JTextField();
		textField_input.setBounds(200, 10, 100 , 25);
		contentPane.add(textField_input);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds (50,50, 100, 25);
		contentPane.add(lblNewLabel_2);

		nameArea = new JTextArea();
		nameArea.setBounds(200,50, 150, 25);
		nameArea.setColumns(10);
		nameArea.setRows(1);
		contentPane.add(nameArea);

		JLabel stocklab = new JLabel("Stock");
		stocklab.setBounds (50,90, 100, 25);
		contentPane.add(stocklab);

		stockArea = new JTextArea();
		stockArea.setBounds(200,90, 150, 25);
		stockArea.setColumns(10);
		stockArea.setRows(1);
		contentPane.add(stockArea);

		JLabel reclab = new JLabel("Recipe");
		reclab.setBounds (50,140, 100, 25);
		contentPane.add(reclab);

		recArea = new JTextArea();
		recArea.setBounds(50,170, 300, 200);
		recArea.setColumns(10);
		recArea.setRows(8);
		contentPane.add(recArea);

		JLabel matlab = new JLabel("Material Used");
		matlab.setBounds (50,370, 100, 25);
		contentPane.add(matlab);

		matArea = new JTextArea();
		matArea.setBounds(50,400, 300, 200);
		matArea.setColumns(10);
		matArea.setRows(8);
		contentPane.add(matArea);

		JButton btnNewButton_4 = new JButton("Back to Main");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_4.setBounds(50,625, 250, 60);
		contentPane.add(btnNewButton_4);










	}
}


