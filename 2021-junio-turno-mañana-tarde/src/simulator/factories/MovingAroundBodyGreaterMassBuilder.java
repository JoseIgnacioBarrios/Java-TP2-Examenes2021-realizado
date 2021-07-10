package simulator.factories;

import javax.xml.crypto.Data;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.MovingAroundBodyGreaterMass;

public class MovingAroundBodyGreaterMassBuilder extends Builder<ForceLaws>{

	
	public MovingAroundBodyGreaterMassBuilder() {
		this.typeTag="nabgm";
		this.desc="Moving around the body with greater mass";
	}
	@Override
	protected ForceLaws createTheInstance(JSONObject info) {
		// TODO Auto-generated method stub
		
		double c=info.has("C") ? info.getDouble("C"):0.25;
		double g=info.has("G") ? info.getDouble("G"):6.67E-11;
		
		return new MovingAroundBodyGreaterMass(g, c);
	}
	protected JSONObject createData() {
		JSONObject info = new JSONObject();
		info.put("G", "The gravitation constant (a number)");
		info.put("C","the rotation factor (a number)");
		return info;
	}

}
