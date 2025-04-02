package sooper.demo.tkrun;

import java.util.List;



public class SupermercadoController {

	private SupermercadoModel model;
	private SupermercadoView view;
	
		
	public void setVistaModel( SupermercadoView v , SupermercadoModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.view.getFrame().setVisible(true);
	}
	
	//a partir de aqui, implementamos los metodos de las funcionalidades correspondientes
	
	public void AniadirArticulosPedido(int i) {
		//metodo para rellenar la tabla de articulos y pedidos
		int j;
		List<Object[]> lista=model.AniadirArticulosPedido(i);
		//una vez que me devuelva el modelo el resultado de la consulta, analizo la lista devuelta:
		
		for (j=0; j<lista.size();j++) {
			view.rellenaListaArticulos(lista.get(j));
		}
		
	};
	
	public SupermercadoView getView() {
		return view;
	}

	public void setView(SupermercadoView view) {
		this.view = view;
	}

	public SupermercadoModel getModel() {
		return model;
	}

	public void setModel(SupermercadoModel model) {
		this.model = model;
	}

	public void embolsarArticulos() {
		
		String idArticulo; //creo la variable																
																											  //setValueAt,se le infica la fila, la columna y el valor que le queremos meter
		idArticulo = this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(),0).toString();     //inicializo la variable y le saco el valor a la tabla, lo seleccionado
																											  //(getSelectedRow) Me devuelve el numero de fila que esta seleccionada, devuelve un entero
		this.model.embolsaArticulo(Integer.parseInt(idArticulo)); 
		
		this.view.getmodeloArticulo().removeRow(this.view.getTable().getSelectedRow());       //Eliminamos (removeRow) la fila que tenemos seleccionada (getSelectedRow) de la tabla de arriba
		
		Object[] fila = null;
		
		this.view.getmodeloListaEmbolsados().addRow(fila);
		
		//Para sacar la fila
		
		int numeroFila = this.view.getmodeloListaEmbolsados().getRowCount();
		
		this.view.getmodeloListaEmbolsados().setValueAt(idArticulo,numeroFila-1,0);
		
		this.view.getmodeloListaEmbolsados().setValueAt("999",numeroFila-1,1);
		
	}

}

