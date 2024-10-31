package pruebaTecnica.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Clase que representa un carrito de compras, permitiendo agregar, eliminar, y
 * gestionar productos, así como aplicar descuentos a los productos de un
 * carrito de compras o al total del carrito de compras usando un cupon valido.
 */
public class ShoppingCart {
	private List<Product> productShoppingCart;
	private double discount;
	private Coupon coupon;
	private String shoppingCartId;
	private double total;

	/**
	 * Constructor que permite inicializar un carrito de compras vacío con un ID
	 * único.
	 */
	public ShoppingCart() {
		this.shoppingCartId = UUID.randomUUID().toString();
		this.productShoppingCart = new ArrayList<>();
		this.discount = 0;
		this.coupon = null;
		this.total = 0;

	}

	/**
	 * Metodo que permite obtener el valor total de un carrito de compras.
	 * 
	 * @return El valor total de un carrito de compras.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Metodo que permite actualizar el valor total de un carrito de compras.
	 * 
	 * @param total EL valor total de un carrito de compras.
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Metodo que permite obtener el cupon valido que se aplico al carrito de
	 * compras.
	 * 
	 * @return El cupon que se aplico al carrito de compras.
	 */
	public Coupon getCoupon() {
		return coupon;
	}

	/**
	 * Metodo que permite asignar un cupon valido que se aplicará al carrito de
	 * compras.
	 * 
	 * @param coupon El cupon valido que se aplicará al carrito de compras.
	 */
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	/**
	 * Metodo que permite obtener el Id de un carrito de compras.
	 * 
	 * @return El Id del carrito de compras.
	 */
	public String getShoppingCartId() {
		return shoppingCartId;
	}

	/**
	 * Metodo que permite obtener el listao de productos de un carrito de compras.
	 * 
	 * @return El listado de productos de un carrito de compras.
	 */
	public List<Product> getProducts() {
		return productShoppingCart;
	}

	/**
	 * Metodo que permite vaciar un carrito de compras.
	 * 
	 */
	public void clearShoppingCart() {
		productShoppingCart.clear();
	}

	/**
	 * Metodo que permite agregar productos a un carrito de compras.
	 * 
	 * @param product El producto a agregar al carrito de compras.
	 * 
	 */
	public void addProductShoppingCart(Product product) {
		productShoppingCart.add(product);
	}

	/**
	 * Metodo que permite obtener el valor del descuento que se aplicará a un
	 * carrito de compras.
	 * 
	 * @return El valor del descuento del carrito de compras.
	 * 
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * Metodo que permite actualizar el valor del descuento que se aplicará a un
	 * carrito de compras. como el carrito de compras puede tener mas de un tipo de
	 * descuento se genera un acumulador para el descuento.
	 * 
	 * @param discount El valor del descuento del carrito de compras.
	 * 
	 */
	public void setDiscount(double discount) {
		this.discount += discount;
	}

	/**
	 * Metodo que permite eliminar productos de un carrito de compras.
	 * 
	 * 
	 * @param productId El Id del producto que se eliminará del carrito de compras.
	 * 
	 */
	public void deleteProductShoppingCart(String productId) {
		if (productId != null) {
			for (int i = 0; i < productShoppingCart.size(); i++) {
				Product product = productShoppingCart.get(i);

				if (product.getId().equals(productId)) {
					productShoppingCart.remove(i);
				}
			}
		}
	}

	/**
	 * Metodo que permite calcular el monto total de un carrito de compras.
	 * 
	 * @return El total del carrito de compras.
	 * 
	 */
	public double calculateTotalShoppingCart() {
		double total = 0;
		for (int i = 0; i < productShoppingCart.size(); i++) {
			total = total + productShoppingCart.get(i).getPrice();
		}
		setTotal(total);
		return total;
	}

}
