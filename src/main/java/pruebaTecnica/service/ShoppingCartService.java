package pruebaTecnica.service;

import pruebaTecnica.domain.Coupon;
import pruebaTecnica.domain.Product;
import pruebaTecnica.domain.ShoppingCart;
import pruebaTecnica.repository.ShoppingCartRepository;

/**
 * Servicio que maneja la logíca de negocio empleada para la gestion de un
 * carrito de Compras.
 * 
 */
public class ShoppingCartService {

	/**
	 * Objecto de tipo ShoppingCartRepository que se emplea para acceder y modificar
	 * la información de un carrito de compras.
	 */
	private ShoppingCartRepository shoppingCartRepository;

	/**
	 * Constructor de la clase ShoppingCartService. Inicializa el Objeto
	 * shoppingCartRepositorys.
	 */
	public ShoppingCartService() {
		this.shoppingCartRepository = new ShoppingCartRepository();
	}

	/**
	 * Metodo que permite adicionar un objecto de tipo Product a un carrito de
	 * compras.
	 * 
	 * @param product Producto que se adicionará al carrito de compras.
	 */
	public void addProductToShoppingCart(Product product) {
		shoppingCartRepository.getShoppingCart().addProductShoppingCart(product);
	}

	/**
	 * Metodo que permite eliminar un objecto de tipo Product de un carrito de
	 * compras.
	 * 
	 * @param productId Id del producto que se eliminará del carrito de compras.
	 */
	public void removeProductFromShoppingCart(String productId) {
		shoppingCartRepository.getShoppingCart().deleteProductShoppingCart(productId);
	}

	/**
	 * Metodo que permite calcular el total de un carrito de compras.
	 * 
	 * @return El valor total del carrito de compras.
	 */
	public double calculateShoppingCartTotal() {
		return shoppingCartRepository.getShoppingCart().calculateTotalShoppingCart();
	}

	/**
	 * Metodo que permite obtener el carrito de compras.
	 * 
	 * @return El carrito de compras actual.
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCartRepository.getShoppingCart();
	}

	/**
	 * Metodo que permite eliminar todos los productos del carrito de compras.
	 * 
	 */
	public void clearShoppingCart() {
		shoppingCartRepository.getShoppingCart().clearShoppingCart();
	}

	/**
	 * Metodo que permite aplicar un descuento de tipo porcentual a cada producto del
	 * carrito de compras.
	 * 
	 * @param shoppingCartId Id del carrito de compras al que se le aplicará el
	 *                       descuento.
	 * @param percentage     Valor que se aplicará a cada producto como descuento.
	 * @throws IllegalArgumentException Si el carrito no se encuentra.
	 */
	public void applyPercentageDiscount(String shoppingCartId, double percentage) {
		ShoppingCart shoppingCartAux = shoppingCartRepository.updateShoppingCartDiscount(shoppingCartId, percentage);

		if (shoppingCartAux != null) {
			DiscountStrategy discountStrategy = new PercentageDiscountStrategy();
			discountStrategy.applyPercentageDiscount(shoppingCartAux, percentage);
		} else {
			throw new IllegalArgumentException("Carrito no encontrado.");
		}
	}

	/**
	 * Metodo que permite aplicar un descuento al total del carrito de compras a partir de un cupon.
	 * 
	 * @param shoppingCartId Id del carrito de compras al que se le aplicará el
	 *                       descuento.
	 * @param coupon Cupon que se aplicará al total del carrito de compras como descuento.
	 * @throws IllegalArgumentException Si el carrito no se encuentra.
	 */
	public void applyCouponDiscount(String shoppingCartId, Coupon coupon) {
		ShoppingCart shoppingCartAux = shoppingCartRepository.updateShoppingCartCoupon(shoppingCartId, coupon);

		if (shoppingCartAux != null) {
			DiscountStrategy discountStrategy = new CouponDiscountStrategy();
			discountStrategy.applyCouponDiscount(shoppingCartAux, coupon);
		} else {
			throw new IllegalArgumentException("Carrito no encontrado.");
		}
	}
}
