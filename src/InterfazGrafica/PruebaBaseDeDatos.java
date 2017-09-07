package InterfazGrafica;

import Control.ProyectoJSON;
import Entidad.Proyecto;

public class PruebaBaseDeDatos {
	
	
	public static void main(String[] arg) {
		ProyectoJSON controlProyecto = new ProyectoJSON();
		for(int i=5;i<20;i++) {
			Proyecto proyecto1 = new Proyecto();
			proyecto1.setNombre("Proyecto "+i);
			controlProyecto.crear(proyecto1);
		}
		
		for(Proyecto i: controlProyecto.listarEnLista())
			System.out.println("Proyecto "+i.getId()+": "+i.getNombre());
		
		
		
	}
	
	
}
