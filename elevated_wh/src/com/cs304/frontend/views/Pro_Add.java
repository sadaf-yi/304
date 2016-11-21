package com.cs304.frontend.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cs304.data_managers.ProductDM;
import com.cs304.data_managers.RecipeUsesDM;

import net.miginfocom.swing.MigLayout;

public class Pro_Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JLabel lblRecipe;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	
	/**
	 * @wbp.nonvisual location=462,17
	 */
	private JPanel popup_panel;
	

	/**
	 * Launch the application.
	 */
	public static void New_Add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro_Add frame = new Pro_Add();
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
	public Pro_Add() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		popup_panel = new JPanel();
		popup_panel.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[70px][114px][][138px][][][][]", "[][19px][][19px][19px][19px][][][][164px][][][][][][][][]"));
		
		lblRecipe = new JLabel("RECIPE");
		contentPane.add(lblRecipe, "cell 0 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel = new JLabel("Name");
		contentPane.add(lblNewLabel, "cell 0 1,alignx right,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "flowx,cell 1 1 3 1,alignx left,aligny center");
		textField.setColumns(10);
		
		JTextField textField13 = new JTextField();
		textField13.setColumns(10);
		contentPane.add(textField13, "cell 4 1 3 1,alignx left,aligny center");
		
		JTextField textField14 = new JTextField();
		textField14.setColumns(10);
		contentPane.add(textField14, "cell 4 3 3 1,alignx left,aligny center");
		
		
		JTextField textField15 = new JTextField();
		textField15.setColumns(10);
		contentPane.add(textField15, "cell 4 5 3 1,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Procedure");
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx center,aligny center");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "flowx,cell 1 3 3 1,alignx left,growy");
		textField_2.setColumns(10);
		
		String[] sa = {"MAT ID", "MAT NAME", "QUANTITY", "PHONE"};
		DefaultTableModel tableModel = new DefaultTableModel(sa, 0);
		
		JLabel lblNewLabel_1 = new JLabel("Size");
		contentPane.add(lblNewLabel_1, "cell 0 5,alignx right,aligny center");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "flowx,cell 1 5 3 1,alignx left,aligny center");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		contentPane.add(lblNewLabel_2, "cell 0 6,alignx center,aligny center");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 6 3 1,alignx left,aligny center");
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Find Mat Num");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_3, "cell 4 6,alignx left,growy");
		
		JButton btnNewButton_2 = new JButton("Add Material");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Submit Product");
	
		contentPane.add(btnNewButton_1, "cell 1 7,alignx left");
		contentPane.add(btnNewButton_2, "cell 4 7,alignx left,growy");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		table = new JTable(tableModel);
		
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, "cell 0 9 5 9,grow");
		
		
		JLabel lblNewLabel_5_1 = new JLabel("Quantity");
		contentPane.add(lblNewLabel_5_1, "cell 3 3");
		
		lblNewLabel_4 = new JLabel("MatID");
		contentPane.add(lblNewLabel_4, "cell 3 1");
		
		
		JLabel lblNewLabel_11 = new JLabel("Unit");
		contentPane.add(lblNewLabel_11, "cell 3 5");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int rows = table.getRowCount();
				 int cols = table.getColumnCount();
				 String[][] results_recipes;
				 for (int x = 0; x < rows; x++)
				 {
					 for (int y = 0; y < cols; y++)
					 {
						 String res_s = (String) table.getModel().getValueAt(rows, cols);
					 }
					 
				 }
				 }
			
			RecipeUsesDM mdm = new RecipeUsesDM();
			ProductDM pdm = new ProductDM();
		//	mdm.AddMaterialsUsed(res_s);
			//pdm.InsertProduct(textField.getText(),textField_2.getText(),textField_1.getText(),textField_3.getText())
			
		
		});
		
	}

}
