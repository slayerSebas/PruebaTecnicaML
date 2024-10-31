package pruebaTecnica.domain;

import java.util.List;

/**
 * Clase que permite representar la respuesta de un carrito de compras. Contiene
 * las propiedades y atributos de un carrito de compras.
 */
public class ShoppingCartResponse {

	private double total;
	private List<Product> products;

	/**
	 * Constructor que permite inicializar la respuesta de un carrito de compras.
	 *
	 * @param total    Valor total del carrito de compras.
	 * @param products Lista de productos en el carrito de compras.
	 */
	public ShoppingCartResponse(double total, List<Product> products) {
		this.total = total;
		this.products = products;
	}

	/**
	 * Metodo que obtiene el valor total de un carrito de compras.
	 *
	 * @return El valor total del carrito de compras.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Metodo que obtiene el listado de propuctos de un carrito de compras.
	 *
	 * @return El listado de productos de un carrito de compras.
	 */
	public List<Product> getProducts() {
		return products;
	}

}
