package co.com.modulo5.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
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
public class ListadoRecetasBean extends BackingUI implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6057702269202974886L;

	private List<Receta> listadoRecetas;
	private boolean verReceta;
	private DataTable tabla;
	
	@PostConstruct
	public void init() {
		try {
			listadoRecetas = Persistir.lecturaJson();
			Collections.sort(listadoRecetas, new Comparator<Receta>() {
				@Override
				public int compare(Receta r1, Receta r2) {
					return r1.getNombre().compareTo(r2.getNombre());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verReceta() {
		try {
			Receta receta = (Receta) tabla.getRowData();
			getBean(DatosRecetaBean.class).cargarReceta(receta);
			verReceta = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isVerReceta() {
		return verReceta;
	}

	public List<Receta> getListadoRecetas() {
		return listadoRecetas;
	}

	public void setListadoRecetas(List<Receta> listadoRecetas) {
		this.listadoRecetas = listadoRecetas;
	}

	public DataTable getTabla() {
		return tabla;
	}

	public void setTabla(DataTable tabla) {
		this.tabla = tabla;
	}

}
