package pruebaTecnica.domain;

import java.util.UUID;

/**
 * Clase que representa un producto en el sistema, con propiedades básicas como
 * ID, nombre, precio y categoría.
 */
public class Product {
	private String id;
	private String name;
	private Double price;
	private String category;

	/**
	 * Constructor de la clase Product que permite la creación de un producto con
	 * todos sus atributos.
	 *
	 * @param id       El identificador único del producto.
	 * @param name     El nombre del producto.
	 * @param price    El precio del producto.
	 * @param category La categoría del producto.
	 */
	public Product(String id, String name, Double price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	/**
	 * Constructor de la clase Product sin parámetros que genera un ID único para el
	 * producto nuevo.
	 */
	public Product() {
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Metodo que permite obtener el nombre de un producto.
	 * 
	 * @return El nombre de un producto.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite actualizar el nombre de un producto.
	 * 
	 * @param name El nombre del producto a actualizar.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que permite obtener el precio de un producto.
	 * 
	 * @return El precio del producto.
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Metodo que permite actualizar el precio de un producto.
	 * 
	 * @param price El precio del producto.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Metodo que permite obtener la categoria de un producto.
	 * 
	 * @return la categoria de un producto.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Metodo que permite actualizar la categoria de un producto.
	 * 
	 * @param category la categoria del producto.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Metodo que permite obtener el Id de un producto.
	 * 
	 * @return El Id del producto.
	 */
	public String getId() {
		return id;
	}
}
