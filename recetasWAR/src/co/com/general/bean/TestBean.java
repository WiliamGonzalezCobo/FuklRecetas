package co.com.general.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TestBean implements Serializable{
	
	private static final long serialVersionUID = 3532743137803743602L;
	
	private String str;

	@PostConstruct
	public void init(){
		this.str = "Hola Mundo";
	}	

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
