package viewsUser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Order_Ui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_Ord() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_Ui frame = new Order_Ui();
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
	public Order_Ui() {
		setTitle("Order Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ord_New ms = new Ord_New();
				setVisible(false);
				dispose();
				ms.New_New();
			}
		});
		btnNewButton.setBounds(125, 10, 200, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ord_Del ms = new Ord_Del();
				setVisible(false);
				dispose();
				ms.New_Del();
			}
		});
		btnNewButton_1.setBounds(125, 55, 200, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ship Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ord_Shi ms = new Ord_Shi();
				setVisible(false);
				dispose();
				ms.New_Shi();
			}
		});
		btnNewButton_2.setBounds(125, 100, 200, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reserve Product");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ord_Res ms = new Ord_Res();
				setVisible(false);
				dispose();
				ms.New_Res();
			}
		});
		btnNewButton_3.setBounds(125, 145, 200, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back to Main");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_selections_user ms = new Main_selections_user();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_4.setBounds(125, 2, 200, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("List Orders");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ord_Lis ms = new Ord_Lis();
				setVisible(false);
				dispose();
				ms.New_Lis();
			}
		});
		btnNewButton_5.setBounds(125, 190, 200, 25);
		contentPane.add(btnNewButton_5);
	}
}
