package simulator.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class massLossingtableModel  extends AbstractTableModel implements SimulatorObserver{

	private List<info> infoL,infoamostrar;
	private List<Body> bodiesm;
	private String [] columnas = {"Body", "MassPerdida"};
	private double resmass,ressmassbotton;
	public massLossingtableModel(Controller ctrl) {
		// TODO Auto-generated constructor stub
		infoL=new ArrayList<>();
		infoamostrar= new ArrayList<>();
		ctrl.addObserver(this);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return infoL.isEmpty()?0:infoL.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String o =null;
		switch (columnIndex) {
		case 0:
			o=infoL.get(rowIndex).getBodi();
			break;

		case 1:
			o= infoamostrar.get(rowIndex).restamass();
			break;
		}
				
		return o;
	}
	@Override
	public String getColumnName(int columna) {
		return columnas[columna];
	}
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String fLawsDesc) {
		// TODO Auto-generated method stub
		
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
				double ini=0.0;
				for (int i = 0; i < bodies.size(); i++) {
					if(bodies.size()>infoL.size())
						infoL.add(new info(bodies.get(i).getId(),bodies.get(i).getMass()));
						infoamostrar.add(new info(bodies.get(i).getId(),0.0));
						
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
				bodiesm=bodies;
				for (int i = 0; i < bodies.size(); i++) {
					resmass= bodies.get(i).getMass()-infoL.get(i).getMass();
					infoL.get(i).update(bodies.get(i).getId(), resmass);
					
				}
				
				fireTableStructureChanged();
			}
		});
	}
	public void mostrar() {
		for (int i = 0; i < infoL.size(); i++) {
			infoamostrar.get(i).update(infoL.get(i).getBodi(),infoL.get(i).getMass());
		}
		fireTableStructureChanged();
	}
	public void reset() {
		for (int i = 0; i < infoL.size(); i++) {
			
			infoamostrar.get(i).update(infoL.get(i).getBodi(),0.0);
		}
		fireTableStructureChanged();
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
