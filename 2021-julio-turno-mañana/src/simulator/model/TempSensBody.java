package simulator.model;

import simulator.misc.Vector2D;

public class TempSensBody extends Body{
	private Vector2D posAntes;
	private double minT,maxT,redF,incF, res,current;
	private boolean coling=false;
	public TempSensBody(String id, Vector2D pos, Vector2D vel, double mass,double minT ,double maxT ,double redF ,double incF) {
		super(id, pos, vel, mass);
		// TODO Auto-generated constructor stub
		this.posAntes=pos;
		this.minT=minT;
		this.maxT=maxT;
		this.redF=redF;
		this.incF=incF;
		
	}
	public void move(double t) {
		//Hara el move de la clase padre
		
		if(coling=false) {
			super.move(t);
			if(1>= incF &&incF>=0 && maxT>=0) {
				res=incF*pos.distanceTo(posAntes);
				if(res>maxT){
					coling=true;
				}
			}
		}
		else {
			
			if(1>= redF &&redF>=0 && minT>=0) {
				res=res*(1-redF);
				if(res<minT) {
					coling=false;
				}
			}
		}
	}
	

}
