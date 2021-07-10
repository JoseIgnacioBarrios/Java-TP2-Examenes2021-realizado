package simulator.view;

import simulator.misc.Vector2D;

public class info {
	
	private String bodi;
	private double x;
	private Vector2D vector;
	info(String bodi , double x,Vector2D vector){
		this.bodi=bodi;
		this.x=x;
		this.vector=vector;
	}
	public String getBodi() {
		return bodi;
	}
	public double getX() {
		return x;
	}
	
	public Vector2D getVector() {
		return vector;
	}
	public void update(double x,Vector2D vector) {
		this.x=x;
		this.vector=vector;
	}
	
	
}
