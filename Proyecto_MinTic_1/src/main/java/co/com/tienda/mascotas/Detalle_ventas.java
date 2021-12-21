package co.com.tienda.mascotas;

public class Detalle_ventas {
	private int codigo_detalle_venta;
	private  int cantidad_producto;
	private String descripcion_producto;
	private  long codigo_producto;
	private String codigo_venta;
	private double valor_total;
	private double valor_venta;
	private double valoriva;
	private double precio_producto;
	
	public Integer getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public String getDescripcion_producto() {
		return descripcion_producto;
	}
	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public String getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(String codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public double getValoriva() {
		return valoriva;
	}
	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	public double getPrecio_producto() {
		return precio_producto;
	}
	public void setPrecio_producto(double precio_producto) {
		this.precio_producto = precio_producto;
	}
	
}
