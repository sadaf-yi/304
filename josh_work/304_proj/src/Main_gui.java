import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

import views.Main_selections;
import viewsUser.Main_selections_user;

public class Main_gui extends JFrame {
	private int typenum = 0;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_gui frame = new Main_gui();
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
	public Main_gui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Owner");
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(154, 63, 150, 30);
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			typenum = 2;
			}
		});
		
	
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Employee");
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(154, 97, 150, 30);
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			typenum = 1;
			}
		});
		contentPane.setLayout(null);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Click to Login");
		btnNewButton.setBounds(12, 152, 400, 50);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if (typenum == 2)
			{	
			Main_selections ms = new Main_selections();
			setVisible(false);
			dispose();
			ms.New_Window();
			}
			else if (typenum == 1)
			{	
				Main_selections_user msu = new Main_selections_user();
				setVisible(false);
				dispose();
				msu.New_Window();
				}
			else
			{
				Error_Pop ep = new Error_Pop();
				
				ep.New_Pop();
			}
			}
			
		});
		contentPane.add(btnNewButton);
	}
}
