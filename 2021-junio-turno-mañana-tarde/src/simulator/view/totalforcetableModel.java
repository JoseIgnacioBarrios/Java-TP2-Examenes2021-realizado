package simulator.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import simulator.control.Controller;
import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class totalforcetableModel extends AbstractTableModel implements SimulatorObserver{

	//private Controller crtl;
	private List<infoforcetotal> listinfoforcetotal;
	private String [] columnas = {"Bodi", "Total Force"};
	public totalforcetableModel(Controller crtl) {
		// TODO Auto-generated constructor stub
		listinfoforcetotal=new ArrayList<>();
		crtl.addObserver(this);
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listinfoforcetotal.isEmpty()?0: listinfoforcetotal.size(); 
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}
	@Override
	public String getColumnName(int columna) {
		return columnas[columna];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String o=null;
		switch (columnIndex) {
		case 0:
			o= listinfoforcetotal.get(rowIndex).getBodi();
			break;

		case 1:
			o=listinfoforcetotal.get(rowIndex).getlsumaf();
			break;
		}
		return o;
	}

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String fLawsDesc) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		
				for (int i = 0; i < bodies.size(); i++) {
					listinfoforcetotal.add(new infoforcetotal(bodies.get(i).getId(), new Vector2D()));
				}
				fireTableStructureChanged();
			}
		});
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String fLawsDesc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if(bodies!=null) {
					for (int i = 0; i < bodies.size(); i++) {
						if(bodies.size()>listinfoforcetotal.size()) {
						listinfoforcetotal.add(new infoforcetotal(bodies.get(i).getId(), new Vector2D()));
						
						
						}
					}
					
					}
				fireTableStructureChanged();
				}
		});
	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Vector2D resmul=new Vector2D();
				for (int i = 0; i < bodies.size(); i++) {
					resmul =listinfoforcetotal.get(i).getSumaForce().plus(bodies.get(i).getForce());
					listinfoforcetotal.get(i).update(resmul);
				}
				fireTableStructureChanged();
			}
		});
	}

	@Override
	public void onDeltaTimeChanged(double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onForceLawsChanged(String fLawsDesc) {
		// TODO Auto-generated method stub
		
	}

}
