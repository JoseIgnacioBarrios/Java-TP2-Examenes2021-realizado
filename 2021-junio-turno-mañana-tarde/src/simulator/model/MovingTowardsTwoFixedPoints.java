package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsTwoFixedPoints implements ForceLaws{

	Vector2D c1,c2;
	double g1, g2; 
	public MovingTowardsTwoFixedPoints(Vector2D c1 ,Vector2D c2, double g1, double g2) {
		// TODO Auto-generated constructor stub
		this.c1=c1;
		this.c2=c2;
		this.g1=g1;
		this.g2=g2;
		
	}
	
	
	
	@Override
	public void apply(List<Body> bs) {
		// TODO Auto-generated method stub
		for (int i = 0; i < bs.size(); i++) {
			Vector2D d1=c1.minus(bs.get(i).getPosition());
			Vector2D d2=c2.minus(bs.get(i).getPosition());
			d1=d1.scale(g1);
			d2=d2.scale(g2);
			Vector2D d3=d1.plus(d2);
			Vector2D Fi= d3.scale(bs.get(i).getMass());
			
			bs.get(i).addForce(Fi);
		}
	}

}
