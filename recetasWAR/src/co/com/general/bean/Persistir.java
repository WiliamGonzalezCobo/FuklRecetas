package co.com.general.bean;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import co.com.recettear.pojo.Receta;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Persistir implements Serializable{
	
	private static final long serialVersionUID = 8362882110331231649L;
	private static final String rutaJson = "/home/desarrollo-06/Juan/"+"datos.json";
	
	public static void escrituraJson(List<Receta> listaRecetas) throws java.io.IOException {
		String json = new Gson().toJson(listaRecetas);
		FileWriter datosJson = new FileWriter(rutaJson, true);
		datosJson.write(json);
		datosJson.close();		
	}

	public static List<Receta> lecturaJson() throws java.io.IOException {
        FileReader datosJson = new FileReader(rutaJson);
        Type type = new TypeToken<ArrayList<Receta>>(){}.getType();
        List<Receta> recetas = new Gson().fromJson(datosJson, type); 
        datosJson.close();
        return recetas;
	}
}
