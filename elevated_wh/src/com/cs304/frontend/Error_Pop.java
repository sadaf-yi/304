package com.cs304.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error_Pop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_Pop() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error_Pop frame = new Error_Pop();
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
	public Error_Pop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUsernameOrPassword = new JLabel("Please Select User Type");
		lblUsernameOrPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUsernameOrPassword, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
