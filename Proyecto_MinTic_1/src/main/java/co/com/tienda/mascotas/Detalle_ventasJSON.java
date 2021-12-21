package co.com.tienda.mascotas;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Detalle_ventasJSON {
	private static URL url;
	private static String place = "http://localhost:5000/";
	public static int postJSON(Detalle_ventas detalle) throws IOException {

		url = new URL(place + "detalle_ventas/guardar");
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

		String data = "{" + "\"codigo_detalle_venta\":\"" + String.valueOf(detalle.getCodigo_detalle_venta())
				          + "\",\"cantidad_producto\": \"" + String.valueOf(detalle.getCantidad_producto()) 
				          + "\",\"codigo_producto\": \""+ String.valueOf(detalle.getCodigo_producto())
				          + "\",\"codigo_venta\":\"" + String.valueOf(detalle.getCodigo_venta())
				          + "\",\"valor_total\":\""	+  String.valueOf(detalle.getValor_total())
				          + "\",\"valor_venta\":\""+  String.valueOf(detalle.getValor_venta())
				          + "\",\"valoriva\":\""+  String.valueOf(detalle.getValoriva())+ "\"}";
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;

	}
}


