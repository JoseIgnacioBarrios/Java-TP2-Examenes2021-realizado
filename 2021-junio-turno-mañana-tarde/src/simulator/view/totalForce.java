package simulator.view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import simulator.control.Controller;

public class totalForce extends JDialog{
	private Controller crtl;
	private JButton aceptar;
	private int _status;
	public totalForce(Frame mainWindos,Controller crtl ) {
		// TODO Auto-generated constructor stub
		super(mainWindos,true);
		this.crtl=crtl;
		initGui();
	}
	private void initGui() {
		// TODO Auto-generated method stub
		setTitle("Total Force of Bodies");
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		mainPanel.add(new totalForceTable(crtl));
		aceptar= new JButton();
		aceptar.setText("OK....");
		aceptar.setToolTipText("aceptar");
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_status = 1;
				dispose();
			}
		});
		mainPanel.add(aceptar);
		setVisible(false);
		setResizable(false);
		pack();
	}
	public int open() {
		setLocation(getParent().getLocation().x + 50, getParent().getLocation().y + 50);
		pack();
		setVisible(true);
		return _status;
	}

}
