package co.com.modulo2.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.datatable.DataTable;

import co.com.commons.bean.DatosRecetaBean;
import co.com.general.bean.BackingUI;
import co.com.general.bean.Persistir;
import co.com.recettear.pojo.Receta;

@ManagedBean
@ViewScoped
public class BusquedaNombreTiempoBean extends BackingUI implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6057702269202974886L;

	private Receta receta;
	private List<Receta> listadoRecetas;
	private DataTable table;
	private boolean verReceta;

	@PostConstruct
	public void init() {
		try {
			listadoRecetas = Persistir.lecturaJson();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void detalleReceta() {
		try {
			receta = (Receta) table.getRowData();
			getBean(DatosRecetaBean.class).cargarReceta(receta);
			verReceta = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Receta> getListadoRecetas() {
		return listadoRecetas;
	}

	public void setListadoRecetas(List<Receta> listadoRecetas) {
		this.listadoRecetas = listadoRecetas;
	}

	public boolean isVerReceta() {
		return verReceta;
	}

	public DataTable getTable() {
		return table;
	}

	public void setTable(DataTable table) {
		this.table = table;
	}
}
