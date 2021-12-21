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

public class VentasJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Ventas> parsingVentas(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		JSONArray venta = (JSONArray) jsonParser.parse(json);
		Iterator i = venta.iterator();
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
		Ventas ventas = new Ventas();
			ventas.setCodigo_venta(Long.parseLong(innerObj.get("codigo_venta").toString()));
			ventas.setCedula_cliente(Long.parseLong(innerObj.get("cedula_cliente").toString()));
			ventas.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
			ventas.setIvaventa(Double.parseDouble(innerObj.get("ivaventa").toString()));
			ventas.setTotal_venta(Double.parseDouble(innerObj.get("total_venta").toString()));
			ventas.setValor_venta(Double.parseDouble(innerObj.get("valor_venta").toString()));
			lista.add(ventas);
		}
		return lista;
	}
	public static ArrayList<Ventas> getJSON() throws IOException, ParseException{
		
		url = new URL( sitio +"ventas/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		
		for (int i = 0; i<inp.length ; i++) {
		   json += (char)inp[i];
		}
		
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
	}
	public static int postJSON(Ventas ventas) throws IOException {

		url = new URL(sitio + "ventas/guardar");
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

		String data = "{" + "\"codigo_venta\":\"" +String.valueOf(ventas.getCodigo_venta())
				+ "\",\"cedula_cliente\": \"" + String.valueOf(ventas.getCedula_cliente()) 
				+ "\",\"cedula_usuario\": \""+ String.valueOf(ventas.getCedula_usuario()) 
				+ "\",\"ivaventa\":\"" + String.valueOf(ventas.getIvaventa()) 
				+ "\",\"total_venta\":\""+  String.valueOf(ventas.getTotal_venta()) 
				+ "\",\"valor_venta\":\""+  String.valueOf(ventas.getValor_venta())+ "\"}";
		
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;

	}

public static int putJSON(Ventas ventas, Long id) throws IOException { //Metodo para actualizar, recibe dos parametros
	
	
	url = new URL(sitio+"ventas/actualizar"); //Conectamos con el back y utilizamos la api de actualizar 
	HttpURLConnection http;
	http = (HttpURLConnection)url.openConnection();
	
	try {
	  http.setRequestMethod("PUT"); //Expresion put estrictamente es para actualizar, palabra predeterminada
	} catch (ProtocolException e) {
	  e.printStackTrace();
	}
	
	http.setDoOutput(true);
	http.setRequestProperty("Accept", "application/json");
	http.setRequestProperty("Content-Type", "application/json");
	
	String data = "{" + "\"codigo_venta\":\"" +String.valueOf(ventas.getCodigo_venta())
	+ "\",\"cedula_cliente\": \"" + String.valueOf(ventas.getCedula_cliente()) 
	+ "\",\"cedula_usuario\": \""+ String.valueOf(ventas.getCedula_usuario()) 
	+ "\",\"ivaventa\":\"" + String.valueOf(ventas.getIvaventa()) 
	+ "\",\"total_venta\":\""+  String.valueOf(ventas.getTotal_venta()) 
	+ "\",\"valor_venta\":\""+  String.valueOf(ventas.getValor_venta())+ "\"}";
	
	byte[] out = data.getBytes(StandardCharsets.UTF_8); //Informacion se convierte en formato UTF-8
	OutputStream stream = http.getOutputStream();
	stream.write(out);
	
	int respuesta = http.getResponseCode(); //Retorna el valor de respuesta, el valor determinado es 200 para saber si se actualizo correctamente
	http.disconnect();
	return respuesta;
}
public static Long parsingConsecutivo(String json) throws IOException, ParseException {
	Long cod=null;
	JSONParser jsonParser = new JSONParser();
	JSONObject innerObj = (JSONObject) jsonParser.parse(json);
		 
	if (innerObj!=null && !innerObj.isEmpty()) {
	    cod=Long.parseLong(innerObj.get("id").toString());
	}
	return cod;
}
public static Long getConsecutivo() throws IOException, ParseException {
	Long cod=null;
	
	url = new URL(sitio+"ventas/consecutivo");
	HttpURLConnection http;
	http = (HttpURLConnection)url.openConnection();
	
	http.setRequestMethod("GET");
	http.setRequestProperty("Accept", "application/json");
	
	InputStream respuesta = http.getInputStream();
	byte[] inp = respuesta.readAllBytes();
	String json = "";
	
	for (int i = 0; i<inp.length ; i++) {
		   json += (char)inp[i];
	}
		
	cod = parsingConsecutivo(json);
	http.disconnect();
	return cod;
	
}

}