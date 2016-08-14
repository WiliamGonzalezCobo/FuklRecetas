package co.com.commons.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.com.general.bean.BackingUI;
import co.com.recettear.pojo.Receta;

@ManagedBean
@ViewScoped
public class DatosRecetaBean extends BackingUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1265325121489056701L;
	private Receta receta;

	@PostConstruct
	public void init() {
	
	}
	
	public void cargarReceta(Receta receta){
		this.receta = receta;
	}

	public Receta getReceta() {
		return receta;
	}
		
}
