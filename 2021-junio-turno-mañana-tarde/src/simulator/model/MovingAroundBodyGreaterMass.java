package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingAroundBodyGreaterMass implements ForceLaws{

	protected double g,c;
	private double mmasa;
	private int idbodi;
	private Vector2D posmaymasa;
	public MovingAroundBodyGreaterMass(double g,double c) {
		// TODO Auto-generated constructor stub
		this.g=g;
		this.c=c;
		this.mmasa=0.0;
		this.idbodi=0;
	}
	
	@Override
	public void apply(List<Body> bs) {
		// TODO Auto-generated method stub
		
		mayormasa(bs);
		for (int i = 0; i < bs.size(); i++) {
			Body bi=bs.get(i);
			if(idbodi!=i) {
				bi.addForce(fmi(bs.get(idbodi),bs.get(i)));
				
			}
			else  bi.addForce(new Vector2D());
		}
	}
	public void mayormasa(List<Body> bs) {
		
		for (int i = 0; i < bs.size(); i++) {
			if(bs.get(i).getMass()>mmasa) {
				mmasa=bs.get(i).getMass();
				idbodi=i;
				posmaymasa=bs.get(i).getPosition();
			}
		}	
	}
	public Vector2D fmi(Body m,Body i ) {
		Vector2D fmires=new Vector2D();
			
			Vector2D den=posmaymasa.minus(i.getPosition());
			double denres=den.magnitude();
	
			Vector2D dmi=den.perpendicular().direction();
			double Fmiaplicada=  (this.g*this.mmasa*i.getMass()*(1-this.c))/(denres*denres);
			fmires=dmi.scale(Fmiaplicada);
		return fmires;
	}
	
	public String toString() {
		return "Moving de nueva fueraza " + c + " with constant acceleration -" + g;
	}
	

}
