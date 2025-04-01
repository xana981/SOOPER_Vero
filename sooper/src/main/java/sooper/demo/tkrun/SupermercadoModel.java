package sooper.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

import sooper.demo.util.Database;

public class SupermercadoModel {
	
	Database db = new Database();

	public List<Object[]> AniadirArticulosPedido(int i) {
		// TODO Auto-generated method stub
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql = "SELECT * FROM ARTICULOPEDIDO WHERE IDPEDIDO = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql, i);
		
		return lista;
		
	}

	public void embolsaArticulo(int idArticulo) {
		
		String sql = ("UPDATE articuloPedido SET embolsado = ?  WHERE idArticulo = ?"); //Modificar la tabla articuloPedido el campo embolsado cuando el idArticulo sea lo seleccionado en la tabla
		
		db.executeUpdate(sql,1,idArticulo); //La primera ? cambiamos embolsado por un 1 y la segunda depende del valor idArticulo 
	}
	
}
