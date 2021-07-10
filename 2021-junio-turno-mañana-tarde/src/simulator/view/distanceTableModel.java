package simulator.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import simulator.control.Controller;
import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class distanceTableModel extends AbstractTableModel implements SimulatorObserver{

	private List<info> infoL,infoaux;
	private String [] columnas = {"Bodi", "Accumulated Distance"};
	private boolean uoo;
	
	distanceTableModel(Controller ctrl){
		infoL=new ArrayList<>();
		ctrl.addObserver(this);
	}
	
	
	@Override
	public int getRowCount() {
		return infoL.isEmpty()?0:infoL.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String o = null;
		switch(columnIndex) {
		case 0:
			o = infoL.get(rowIndex).getBodi();
			break;
		case 1:
			o = ""+infoL.get(rowIndex).getX();
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
	public void reset() {
		List<info> a=new ArrayList<>();
		for (int i = 0; i < infoL.size(); i++) {
			a.add(new info(infoL.get(i).getBodi(),0.0,infoL.get(i).getVector()));
		}
		infoL.clear();
		for (int i = 0; i < a.size(); i++) {
			infoL.add(new info(a.get(i).getBodi(),a.get(i).getX(),a.get(i).getVector()));
			
		}
		fireTableStructureChanged();
		a.clear();
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String fLawsDesc) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				infoL.clear();
			}
		});
	}


	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Vector2D vectorini=new Vector2D();
				if(bodies!=null) {
					for (int i = 0; i < bodies.size(); i++) {
						if(bodies.size()>infoL.size())
							infoL.add(new info(bodies.get(i).getId(),vectorini.distanceTo(bodies.get(i).getPosition()),bodies.get(i).getPosition()));
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
				if(bodies!=null) {
					for (int i = 0; i < bodies.size(); i++) {
						double auxdis=infoL.get(i).getX();
						double auxto=infoL.get(i).getVector().distanceTo(bodies.get(i).getPosition());
						auxdis=auxdis+auxto;
						//infoL.clear();
						infoL.get(i).update(auxdis,bodies.get(i).getPosition());		
					}
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
