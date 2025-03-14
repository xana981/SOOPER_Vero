package sooper.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SupermercadoView {

	protected JFrame frmSupermercado;
	private JTextField textField;
	private JTable table;
	private JButton btnNewButton_1;


	 public SupermercadoView() {
		// TODO Auto-generated constructor stub
		initialize();
	} 

	private void initialize() {

		frmSupermercado = new JFrame();
		frmSupermercado.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][]"));
		frmSupermercado.setBounds(0,0,500,500);
		
		textField = new JTextField();
		frmSupermercado.getContentPane().add(textField, "cell 0 0,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		frmSupermercado.getContentPane().add(btnNewButton, "cell 0 1");
		
		JScrollPane scrollPane = new JScrollPane();
		frmSupermercado.getContentPane().add(scrollPane, "cell 0 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("New button");
		frmSupermercado.getContentPane().add(btnNewButton_1, "cell 0 3");
		frmSupermercado.setVisible(true);
	}
	
	public JFrame getFrame() {
		return this.frmSupermercado;
	}
}
