package InterfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Control.ProyectoJSON;
import Entidad.Proyecto;
import Utils.HTTPConection;

public class ListadoProyectos {

	private JFrame frame;
	private JTable table;
	private ArrayList<Proyecto> listaproyectos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ListadoProyectos a = new ListadoProyectos(new ProyectoJSON().listarEnLista());
		a.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public ListadoProyectos(ArrayList<Proyecto> listaproyectos) {
		this.listaproyectos = listaproyectos;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		
		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Id","Nombre"},0);
		
		for(Proyecto i: listaproyectos)
			tableModel.addRow(new Object[] {i.getId(),i.getNombre()});
		
		table = new JTable(tableModel);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		sorter.setComparator(0, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2)
					return 1;
				else if(o1==o2)
					return 0;
				else
					return -1;
			}
		});
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.toggleSortOrder(0);
		
		frame.getContentPane().add(new JScrollPane(table));
	}

}
