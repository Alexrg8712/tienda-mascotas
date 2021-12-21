package co.com.tienda.mascotas;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProveedoresJSON {

	private static URL url;
	private static String place = "http://localhost:5000/";
	
	public static ArrayList<Proveedores> parsingProveedores(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		Iterator i = proveedores.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Proveedores provee = new Proveedores();
			provee.setNitproveedor(Long.parseLong(innerObj.get("nitproveedor").toString()));
			provee.setNombre_proveedor(innerObj.get("nombre_proveedor").toString());
			provee.setDireccion_proveedor(innerObj.get("direccion_proveedor").toString());
			provee.setTelefono_proveedor(innerObj.get("telefono_proveedor").toString());
			provee.setCiudad_proveedor(innerObj.get("ciudad_proveedor").toString());
			lista.add(provee);
		}
		return lista;
	}

	public static ArrayList<Proveedores> getJSON() throws IOException, ParseException{

		url = new URL(place + "proveedores/listar");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
	}

	public static int postJSON(Proveedores provee) throws IOException {

		url = new URL(place + "proveedores/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"nitproveedor\":\"" + String.valueOf(provee.getNitproveedor())
				+ "\",\"nombre_proveedor\": \"" + provee.getNombre_proveedor() + "\",\"direccion_proveedor\": \""
				+ provee.getDireccion_proveedor() + "\",\"telefono_proveedor\":\"" + provee.getTelefono_proveedor() + "\",\"ciudad_proveedor\":\""
				+ provee.getCiudad_proveedor() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;

	}
	public static int putJSON(Proveedores provee, Long id) throws IOException {
		
		
		url = new URL(place+"proveedores/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"nitproveedor\":\""+ id
				+"\",\"nombre_proveedor\": \""+provee.getNombre_proveedor()
				+"\",\"direccion_proveedor\": \""+provee.getDireccion_proveedor()
				+"\",\"telefono_proveedor\":\""+provee.getTelefono_proveedor()
				+"\",\"ciudad_proveedor\":\""+provee.getCiudad_proveedor()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


	public static int deleteJSON (Long id) throws IOException {


	url = new URL(place+"proveedores/eliminar/" + id);
	HttpURLConnection http;
	http = (HttpURLConnection)url.openConnection();

	try {
	  http.setRequestMethod("DELETE");
	} catch (ProtocolException e) {
	  e.printStackTrace();
	}

	http.setDoOutput(true);
	http.setRequestProperty("Accept", "application/json");
	http.setRequestProperty("Content-Type", "application/json");


	int respuesta = http.getResponseCode();
	http.disconnect();
	return respuesta;
	}
	
}
