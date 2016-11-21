package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class User_Ui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_Use() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Ui frame = new User_Ui();
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
	public User_Ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Use_Add ms = new Use_Add();
				setVisible(false);
				dispose();
				ms.New_Add();
			}
		});
		btnNewButton.setBounds(125, 10, 200, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Use_Rem ms = new Use_Rem();
				setVisible(false);
				dispose();
				ms.New_Rem();
			}
		});
		btnNewButton_1.setBounds(125, 55, 200, 25);
		contentPane.add(btnNewButton_1);
		

		
		
		
		JButton btnNewButton_4 = new JButton("List User Names");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Use_Lis ms = new Use_Lis();
				setVisible(false);
				dispose();
				ms.New_Lis();
			}
		});
		btnNewButton_4.setBounds(125, 145, 200, 25);
		contentPane.add(btnNewButton_4);
		
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
