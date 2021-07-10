package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;

public class distanceTable extends JPanel {
	private JButton reset_Button;
	private distanceTableModel a;
	
	distanceTable(Controller ctrl){
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), 
												   "Accumulated Distances", 
												   TitledBorder.LEFT, 
												   TitledBorder.TOP));
		a=new distanceTableModel(ctrl);
		JTable table = new JTable(a);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		
		
			
		reset_Button =new JButton();
		reset_Button.setText("RESSET DISTANCES");
		reset_Button.setPreferredSize(new Dimension(20,20));
		reset_Button.setMaximumSize(new Dimension(30,30));
		reset_Button.setSize(30, 30);
		//reset_Button.setMinimumSize(new Dimension(20,20));
		reset_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.reset();
			}
		});
		
		
		
		this.add(reset_Button,BorderLayout.NORTH);
		
		this.add(scroll,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(20,300));
	}

}
