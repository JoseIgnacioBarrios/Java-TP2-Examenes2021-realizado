package simulator.view;

public class info {
	private String bodi;
	private double mass;
	public info(String bodi,double massini) {
		// TODO Auto-generated constructor stub
	this.bodi=bodi;
	this.mass=mass;
	}
	public String getBodi() {
		return bodi;
	}
	public double getMass() {
		return mass;
	}
	public String restamass() {
		return ""+this.mass;
	}
	public void update(String bodi,double mass) {
		this.bodi=bodi;
		this.mass=mass;
	}

}
