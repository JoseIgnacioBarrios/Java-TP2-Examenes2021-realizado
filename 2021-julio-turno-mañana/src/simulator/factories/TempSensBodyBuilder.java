package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.TempSensBody;

public class TempSensBodyBuilder extends Builder<Body> {

	public TempSensBodyBuilder() {
		this.typeTag="tempsens";
		this.desc="cuenpo de temperaturas";
	}
	
	
	
	@Override
	protected Body createTheInstance(JSONObject data) {
		String id = data.getString("id");
		Vector2D vel= new Vector2D(data.getJSONArray("v").getDouble(0), data.getJSONArray("v").getDouble(1));
		Vector2D pos = new Vector2D(data.getJSONArray("p").getDouble(0), data.getJSONArray("p").getDouble(1));
	    double mass = data.getDouble("m");
	    double minT= data.has("minT")? data.getDouble("minT"):1E10;
	    double maxT=data.has("maxT")? data.getDouble("maxT"):10E10;
	    double redF=data.has("redF")? data.getDouble("redF"):0.1;
	    double incF=data.has("incF")? data.getDouble("incF"):10E-7;
	    
		return new TempSensBody(id, pos, vel, mass, minT, maxT, redF, incF);
	}
	
	protected JSONObject createData() {
		JSONObject info = new JSONObject();
		info.put("id", "Identificador");
		info.put("v", "Velocidad");
		info.put("p", "Posicion");
		info.put("m", "Masa");
		info.put("minT", "minima tempratura");
		info.put("maxT", "maxima temperatura");
		info.put("redF", "factor de reduccion de temperatura");
		info.put("incF", "factor de aumento de temperatura");
	
		return info;
	}

}
