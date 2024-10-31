package pruebaTecnica.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pruebaTecnica.domain.Product;

/**
 * Clase que actúa como repositorio para gestionar los productos de la
 * aplicación. Permite realizar operaciones como crear, leer, actualizar y
 * eliminar productos de una lista .
 */
public class ProductRepository {
	private List<Product> products = new ArrayList<>();

	Product product = new Product(UUID.randomUUID().toString(), "product1", 15.0, "tecnology");

	/**
	 * Constructor de la clase ProductRepository que permite la Creación de una
	 * instancia de ProductRepository e inicializa la lista de productos con un
	 * producto de ejemplo.
	 */
	public ProductRepository() {
		products.add(product);
	}

	/**
	 * Metodo que obtiene la lista completa de productos.
	 *
	 * @return Lista de productos disponibles en el repositorio.
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Metodo que permite agregar un producto a la lista de productos.
	 *
	 * @param product Producto nuevo a agregar a la lista de productos.
	 */
	public void addProducts(Product product) {
		products.add(product);
	}

	/**
	 * Metodo que permite actualizar un producto de la lista de productos.
	 *
	 * @param productId Id de producto a actualizar.
	 * @param updateProduct Producto actualizado.
	 * 
	 * @return Retorna el producto actualizado. si no se actualizo un producto
	 *         retornar Null.
	 */
	public Product updateProduct(String productId, Product updateProduct) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getId().equals(productId)) {
				product.setCategory(updateProduct.getCategory());
				product.setName(updateProduct.getName());
				product.setPrice(updateProduct.getPrice());
				return product;
			}
		}
		return null;
	}

	/**
	 * Metodo que permite eliminar un producto de la lista de productos.
	 *
	 * @param productId Id de producto a eliminar.
	 * 
	 * @return Retorna el producto eliminado, si no se elimino retorna Null.
	 */
	public Product deleteProduct(String productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getId().equals(productId)) {
				products.remove(i);
				return product;
			}
		}
		return null;
	}
}