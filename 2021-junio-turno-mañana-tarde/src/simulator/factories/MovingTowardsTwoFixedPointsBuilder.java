package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsTwoFixedPoints;

public class MovingTowardsTwoFixedPointsBuilder extends Builder<ForceLaws>{

	
	
	public MovingTowardsTwoFixedPointsBuilder() {
		// TODO Auto-generated constructor stub
		this.typeTag="mt2fp";
		this.desc="Moving towards two fixedpoints";
	}
	
	@Override
	protected ForceLaws createTheInstance(JSONObject info) {
		// TODO Auto-generated method stub
		Vector2D c1,c2;
		double g1=info.has("g1") ? info.getDouble("g1"): 9.81;
		double g2=info.has("g2") ? info.getDouble("g2"):9.81;
		if(info.has("c1")) {
			JSONArray jc1=info.getJSONArray("c1");
			c1=new Vector2D(jc1.getDouble(0),jc1.getDouble(1));
		}
		else c1=new Vector2D();
		if(info.has("c2")) {
			JSONArray jc2=info.getJSONArray("c2");
			c2=new Vector2D(jc2.getDouble(0),jc2.getDouble(1));
		}
		else c2=new Vector2D();
		
		return new MovingTowardsTwoFixedPoints(c1, c2, g1, g2);
	}
	
	protected JSONObject createData() {
		JSONObject info = new JSONObject();
		info.put("c1", "the first point towards bodies move (a json list of 2 numbers, e.g., [100.0,50.0])");
		info.put("c2", "the second point towards bodies move (a json list of 2 numbers, e.g., [100.0,50.0])");
		info.put("g1", "the length of the first acceleration vector	(a number)");
		info.put("g2",  "the length of the second acceleration vector( a number)");
		return info;
	}

}
