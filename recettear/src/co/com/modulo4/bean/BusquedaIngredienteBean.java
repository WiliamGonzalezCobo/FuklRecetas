package co.com.modulo4.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.datatable.DataTable;

import co.com.commons.bean.DatosRecetaBean;
import co.com.general.bean.BackingUI;
import co.com.general.bean.Persistir;
import co.com.recettear.pojo.Ingrediente;
import co.com.recettear.pojo.Receta;

@ManagedBean
@ViewScoped
public class BusquedaIngredienteBean extends BackingUI implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6057702269202974886L;

	private List<Receta> listadoRecetas;
	private List<Receta> listadoRecetasFiltradas;
	private List<Ingrediente> listadoIngredientes;
	private DataTable tablaIngredientes;
	private DataTable tablaRecetas;
	private boolean verTablaReceta;
	private boolean verReceta;
	
	@PostConstruct
	public void init() {
		try {
			listadoRecetas = Persistir.lecturaJson();
			listadoIngredientes = new ArrayList<Ingrediente>();
			for (Receta receta : listadoRecetas) {
				listadoIngredientes.addAll(receta.getListaIngredientes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filtrarRecetas() {
		try {
			Ingrediente ingredienteSeleccionado = (Ingrediente) tablaIngredientes.getRowData();
			listadoRecetasFiltradas = new ArrayList<Receta>();
			for (Receta receta : listadoRecetas) {
				ingrediente:
				for (Ingrediente ingrediente : receta.getListaIngredientes()) {
					if(ingrediente.getNombre().compareTo(ingredienteSeleccionado.getNombre())==0){
						listadoRecetasFiltradas.add(receta);
						break ingrediente;
					}
				}
			}
			verTablaReceta = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verReceta() {
		try {
			Receta receta = (Receta) tablaRecetas.getRowData();
			getBean(DatosRecetaBean.class).cargarReceta(receta);
			verReceta = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isVerReceta() {
		return verReceta;
	}

	public List<Ingrediente> getListadoIngredientes() {
		return listadoIngredientes;
	}

	public void setListadoIngredientes(List<Ingrediente> listadoIngredientes) {
		this.listadoIngredientes = listadoIngredientes;
	}

	public DataTable getTablaIngredientes() {
		return tablaIngredientes;
	}

	public void setTablaIngredientes(DataTable tablaIngredientes) {
		this.tablaIngredientes = tablaIngredientes;
	}

	public List<Receta> getListadoRecetasFiltradas() {
		return listadoRecetasFiltradas;
	}

	public void setListadoRecetasFiltradas(List<Receta> listadoRecetasFiltradas) {
		this.listadoRecetasFiltradas = listadoRecetasFiltradas;
	}

	public DataTable getTablaRecetas() {
		return tablaRecetas;
	}

	public void setTablaRecetas(DataTable tablaRecetas) {
		this.tablaRecetas = tablaRecetas;
	}

	public boolean isVerTablaReceta() {
		return verTablaReceta;
	}
}
