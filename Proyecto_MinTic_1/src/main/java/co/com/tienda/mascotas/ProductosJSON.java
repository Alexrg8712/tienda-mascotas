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

public class ProductosJSON {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Productos> parsingProductos(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Productos> lista = new ArrayList<Productos>();
		JSONArray productos = (JSONArray) jsonParser.parse(json);
		Iterator i = productos.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Productos produ = new Productos();
			produ.setCodigo_producto(Long.parseLong(innerObj.get("codigo_producto").toString()));
			produ.setNombre_producto(innerObj.get("nombre_producto").toString());
			produ.setPrecio_compra(Double.parseDouble(innerObj.get("precio_compra").toString()));
			produ.setIvacompra(Double.parseDouble(innerObj.get("ivacompra").toString()));
			produ.setPrecio_venta(Double.parseDouble(innerObj.get("precio_venta").toString()));
			produ.setNitproveedor(Long.parseLong(innerObj.get("nitproveedor").toString()));
			lista.add(produ);
		}
		return lista;
	}

	public static ArrayList<Productos> getJSON() throws IOException, ParseException{

		url = new URL(sitio + "productos/listar");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		http.disconnect();
		return lista;
	}

	public static int postJSON(Productos produ) throws IOException {

		url = new URL(sitio + "productos/guardar");
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

		String data = "{" + "\"codigo_producto\":\"" + String.valueOf(produ.getCodigo_producto())
				+ "\",\"nombre_producto\": \"" + produ.getNombre_producto() + "\",\"precio_compra\": \""
				+ String.valueOf(produ.getPrecio_compra()) + "\",\"ivacompra\":\"" + String.valueOf(produ.getIvacompra()) + "\",\"precio_venta\":\""
				+ String.valueOf(produ.getPrecio_venta()) + "\",\"nitproveedor\":\"" + String.valueOf(produ.getNitproveedor()) + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;

	}
	public static int putJSON(Productos produ, Long id) throws IOException {
		
		
		url = new URL(sitio+"productos/actualizar");
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
				+ "\"codigo_producto\":\""+ id
				+"\",\"nombre_producto\": \""+produ.getNombre_producto()
				+"\",\"precio_compra\": \""+produ.getPrecio_compra()
				+"\",\"ivacompra\":\""+produ.getIvacompra()
				+"\",\"precio_venta\":\""+produ.getPrecio_venta()
				+"\",\"nitproveedor\":\""+produ.getNitproveedor()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


	public static int deleteJSON (Long id) throws IOException {


	url = new URL(sitio+"productos/eliminar/" + id);
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


