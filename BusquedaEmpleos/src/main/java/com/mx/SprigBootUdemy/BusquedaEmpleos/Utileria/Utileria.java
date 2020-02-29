package com.mx.SprigBootUdemy.BusquedaEmpleos.Utileria;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename().replace(" ", "_");
		nombreOriginal=Utileria.obtenerNombreUnico()+"_"+nombreOriginal;
		System.out.println(Utileria.obtenerNombreUnico());
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreOriginal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			// Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreOriginal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	public static String obtenerNombreUnico() {
		Calendar fecha=Calendar.getInstance();
		return fecha.get(Calendar.YEAR)+""+
			   (fecha.get(Calendar.MONTH)+1)+""+
			   fecha.get(Calendar.DAY_OF_MONTH)+""+
			   fecha.get(Calendar.HOUR_OF_DAY)+""+
			   fecha.get(Calendar.MINUTE)+""+
			   fecha.get(Calendar.SECOND)+""+
			   fecha.get(Calendar.MILLISECOND);
	}
}
