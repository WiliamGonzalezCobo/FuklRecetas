package co.com.modulo1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.com.general.bean.BackingUI;
import co.com.general.bean.Persistir;
import co.com.recettear.pojo.Ingrediente;
import co.com.recettear.pojo.Receta;

@ManagedBean
@ViewScoped
public class RecetaBean extends BackingUI implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5499623838190415633L;

	private Receta receta;
	private Ingrediente ingrediente;
	private List<Receta> listadoRecetas; 
	
	@PostConstruct
	public void init(){
		receta = new Receta();
		ingrediente = new Ingrediente();
		receta.setListaIngredientes(new ArrayList<Ingrediente>());
		try {
			listadoRecetas = Persistir.lecturaJson();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean validarIngrediente(){
		boolean validador = true;
		if(ingrediente.getNombre()==null || ingrediente.getNombre().isEmpty()){
			error("form_receta:ingredientes:nombreIngrediente", "Campo Requerido");
			validador = false;
		}
		if(ingrediente.getCantidad()==null || ingrediente.getCantidad().isEmpty()){
			error("form_receta:ingredientes:cantidadIngrediente", "Campo Requerido");
			validador = false;
		}
		return validador;
	}
	
	public void guardarIngrediente(){
		try {
			if(validarIngrediente()){
				receta.getListaIngredientes().add(ingrediente);
				ingrediente = new Ingrediente();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean validarReceta(){
		boolean validador = true;
		if(receta.getNombre()==null || receta.getNombre().isEmpty()){
			error("form_receta:nombreReceta", "Campo Requerido");
			validador = false;
		}
		if(receta.getTiempoCoccion()<=0){
			error("form_receta:tiempoCoccion", "No puede ser inferior o igual a 0");
			validador = false;
		}
		
		if(receta.getPreparacion()==null || receta.getPreparacion().isEmpty()){
			error("form_receta:preparacion", "Campo Requerido");
			validador = false;
		}
		if(receta.getListaIngredientes().isEmpty()){
			error("form_receta:ingredientes", "Listado Requerido");
			validador = false;
		}
		
		return validador;
	}
	
	public void guardarReceta() {
		try {
			if (validarReceta()) {
				if (!listadoRecetas.contains(receta)) {
					listadoRecetas.add(receta);
				}
				receta = new Receta();
				Persistir.escrituraJson(listadoRecetas);
				dialogInfo("Registro guardado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarReceta() {
		try {
			listadoRecetas.remove(receta);
			Persistir.escrituraJson(listadoRecetas);
			receta = new Receta();
			dialogInfo("Se elimino el registro");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verReceta(){
		try {
			System.out.println(receta.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	public List<Receta> getListadoRecetas() {
		return listadoRecetas;
	}

	public void setListadoRecetas(List<Receta> listadoRecetas) {
		this.listadoRecetas = listadoRecetas;
	}

	public boolean isVerEliminar() {
		return listadoRecetas.contains(receta);
	}
}
