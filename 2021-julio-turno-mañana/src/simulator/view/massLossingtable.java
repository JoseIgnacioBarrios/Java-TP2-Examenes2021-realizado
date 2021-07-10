package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;

public class massLossingtable extends JPanel{
	
	
	private JButton showbutton, resetbutton;
	private massLossingtableModel a;
	massLossingtable(Controller ctrl){
		a =new massLossingtableModel(ctrl);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), 
												   "Mass Lossing", 
												   TitledBorder.LEFT, 
												   TitledBorder.TOP));
		JPanel centro = new JPanel();
		centro.setLayout(new BoxLayout(centro, BoxLayout.X_AXIS));
		centro.setPreferredSize(new Dimension(30,30));
		centro.setMaximumSize(new Dimension(30,30));
		showbutton= new JButton();
		showbutton.setText("SHOW");
		showbutton.setEnabled(true);
		showbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.mostrar();
			}
		});
		resetbutton= new JButton();
		resetbutton.setText("RESET");
		resetbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.reset();
			}
		});
		centro.add(showbutton);
		centro.add(resetbutton);
		this.add(centro,BorderLayout.NORTH);
		
		
		JTable table = new JTable(a);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		//this.add(showbutton);
		this.add(scroll,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(900,300));
	}

}
