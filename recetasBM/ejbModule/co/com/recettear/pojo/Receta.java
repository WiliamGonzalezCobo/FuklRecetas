package co.com.recettear.pojo;

import java.util.List;

public class Receta {
	
	private String nombre;
	private double tiempoCoccion;
	private String preparacion;
	private List<Ingrediente> listaIngredientes;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTiempoCoccion() {
		return tiempoCoccion;
	}
	public void setTiempoCoccion(double tiempoCoccion) {
		this.tiempoCoccion = tiempoCoccion;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}
	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

}
