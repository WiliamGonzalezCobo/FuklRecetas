package co.com.modulo1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
	
	@PostConstruct
	public void init(){
		receta = new Receta();
		receta.setListaIngredientes(new ArrayList<Ingrediente>());
	}
	
	public void guardarReceta(){
		try {
			
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
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
