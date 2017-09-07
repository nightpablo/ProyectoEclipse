package Control;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entidad.Proyecto;
import Implements.ControlImplementation;
import Utils.HTTPConection;

public class ProyectoJSON implements ControlImplementation<Proyecto> {

	@Override
	public void crear(Proyecto entrada) {
		new HTTPConection().gestion(new Object[] {Proyecto.NOMBRE_TABLA,"POST",entrada.toJSON()});
	}

	@Override
	public void modificar(Proyecto entrada) {
		new HTTPConection().gestion(new Object[] {Proyecto.NOMBRE_TABLA,"PUT",entrada.toJSON(),entrada.getId()});		
	}

	@Override
	public void borrar(Proyecto entrada) {
		new HTTPConection().gestion(new Object[] {Proyecto.NOMBRE_TABLA,"DELETE",entrada.getId()});
	}

	@Override
	public Proyecto buscarPorId(Integer id) {
		ArrayList<Proyecto> Entry = listarEnLista();
        for(Proyecto i: Entry)
            if(i.getId()==id)
                return i;
        return null;
	}
	
	@Override
	public ArrayList<Proyecto> listarEnLista(){

        ArrayList<Proyecto> salida = null;
        
		try {
			JSONArray lista = (JSONArray) new HTTPConection().gestion(new Object[] {Proyecto.NOMBRE_TABLA,"GET"});
	        salida = new ArrayList<Proyecto>();
			for(int i=0;i<lista.length();i++)
				salida.add(new Proyecto((JSONObject) lista.get(i)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

        return salida;
	}
	
}
