package co.com.general.bean;

import java.io.File;
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
	private static final String rutaJson = "D:\\temp\\"+"datos.json";
	
	public static void escrituraJson(List<Receta> listaRecetas)throws Exception {
		FileWriter datosJson = null;
		try {
			limpiarDatosJson();
			String json = new Gson().toJson(listaRecetas);
			datosJson = new FileWriter(rutaJson, true);
			datosJson.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			datosJson.close();
		}
	}
	
	private static void limpiarDatosJson(){
		File f = new File(rutaJson);
		try {
			if(f.exists()){
				f.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Receta> lecturaJson() throws Exception{
		File f = new File(rutaJson);
		List<Receta> recetas = null;
		FileReader datosJson = null;
		if(f.exists()){
			try {
				datosJson = new FileReader(rutaJson);
				Type type = new TypeToken<ArrayList<Receta>>(){}.getType();
				recetas = new Gson().fromJson(datosJson, type);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				datosJson.close();
			}
		}
        if(recetas==null){
        	recetas = new ArrayList<Receta>();
        }
        return recetas;
	}
}
