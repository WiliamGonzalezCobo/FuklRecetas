package co.com.modulo1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.general.bean.Persistir;
import co.com.recettear.pojo.Ingrediente;
import co.com.recettear.pojo.Receta;

@ManagedBean
@ViewScoped
public class RecetaBean implements Serializable{
	
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
		listadoRecetas = new ArrayList<>();
	}
	
	public void guardarIngrediente(){
		try {
			receta.getListaIngredientes().add(ingrediente);
			ingrediente = new Ingrediente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardarReceta(){
		try {
			listadoRecetas.add(receta);
			receta = new Receta();
			Persistir.escrituraJson(listadoRecetas);
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
	
//	public void addMessage(String idElement, String detail) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
//    	FacesContext context = FacesContext.getCurrentInstance();
//    	context.addMessage(idElement, message);
//    }

}
