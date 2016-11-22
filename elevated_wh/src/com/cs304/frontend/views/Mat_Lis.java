package com.cs304.frontend.views;

import com.cs304.data_managers.CustomerDM;
import com.cs304.data_managers.MaterialDM;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import static oracle.net.aso.C09.i;
import static oracle.net.aso.C09.m;

public class Mat_Lis extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void New_Lis() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mat_Lis frame = new Mat_Lis();
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
	public Mat_Lis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{145, 0, 150, 0};
		gbl_contentPane.rowHeights = new int[]{170, 25, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		String[] sa = {};
		DefaultTableModel tableModel = new DefaultTableModel(sa, 0);
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;


		contentPane.add(scrollPane, gbc_scrollPane);

		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});

		MaterialDM cdm = new MaterialDM();
		String[][] results_s = cdm.getAllMaterialTuples();
		String string = new String();
		for (int i = 0; i<results_s.length; i++){
			for (int j = 0; j<results_s[i].length; j++){
				string += results_s[i][j];
				System.out.println(string);
			} System.out.println(string);

		}

		//System.out.println("Number of rows = " + rows);
		//System.out.println("Number of cols = " + cols);





				//System.out.println("Number of rows = " + matrix.length);
				//System.out.println("Number of columns = " + matrix[0].length);








		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_9.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_9.gridx = 1;
		gbc_btnNewButton_9.gridy = 3;
		getContentPane().add(btnNewButton_9, gbc_btnNewButton_9);
	}

}