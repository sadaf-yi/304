package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Use_Add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_Add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Use_Add frame = new Use_Add();
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
	public Use_Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Back to Main");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_5.setBounds(125, 190, 200, 25);
		contentPane.add(btnNewButton_5);
	}

}
