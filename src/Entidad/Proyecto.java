package Entidad;

import org.json.JSONException;
import org.json.JSONObject;

import Implements.EntityImplementation;

public class Proyecto implements EntityImplementation{
	private Integer id;
	private String nombre;
	public static final String NOMBRE_TABLA = "proyectos";
	
	public Proyecto() {}
	public Proyecto(JSONObject object) {
		toEntity(object);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		
		try {
			jsonObject.put("nombre",nombre);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println("JSON: "+jsonObject.toString());
		
		return jsonObject;
	}

	@Override
	public void toEntity(JSONObject object) {
		try {
			id = object.getInt("id");
			nombre = object.getString("nombre");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public String toString() {
		return "id: "+id+". Nombre: "+nombre;
	}
	
}
