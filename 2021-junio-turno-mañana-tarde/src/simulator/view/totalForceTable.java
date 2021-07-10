package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;

public class totalForceTable extends JPanel {

	
	public totalForceTable(Controller crtl) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2) 
												   ));
		JTable table = new JTable(new totalforcetableModel(crtl));
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		this.add(scroll);
		this.setPreferredSize(new Dimension(800,300));
	}
}
