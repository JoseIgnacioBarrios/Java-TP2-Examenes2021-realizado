package simulator.view;

import simulator.misc.Vector2D;

public class infoforcetotal {
	private String bodi,lsumaf;
	private Vector2D sumaForce;
	public infoforcetotal(String bodi,Vector2D sumaforce) {
		// TODO Auto-generated constructor stub
		this.bodi=bodi;
		this.sumaForce= sumaforce;
	}
	public String getBodi() {
		return bodi;
	}
	public Vector2D getSumaForce() {
		return sumaForce;
	}
	public String getlsumaf() {
		return "["+sumaForce.getX()+","+sumaForce.getY()+"]";
	}
	public void update(Vector2D res) {
		this.sumaForce=res;
	}
	

}
