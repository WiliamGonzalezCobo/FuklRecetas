package co.com.general.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class BackingUI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7777402473976538148L;
	
	public void error(String idcampo, String msjError) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msjError, msjError);
        FacesContext.getCurrentInstance().addMessage(idcampo, message);
	}
	
	public void warning(String idcampo, String msjAdvertencia) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msjAdvertencia, msjAdvertencia);
        FacesContext.getCurrentInstance().addMessage(idcampo, message);
	}
	
	public void info(String idcampo, String msjInfo) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msjInfo, msjInfo);
        FacesContext.getCurrentInstance().addMessage(idcampo, message);
	}
	
	public void dialogInfo(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	public void dialogError(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	public void dialogWarn(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends BackingUI> T getBean(Class<T> clase) {
		String nombreBean = clase.getSimpleName();
		nombreBean = nombreBean.substring(0, 1).toLowerCase() + nombreBean.substring(1);
		return (T) FacesUtils.getBean(nombreBean);
	}
	
	

}
