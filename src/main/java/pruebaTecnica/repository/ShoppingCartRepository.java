package pruebaTecnica.repository;

import pruebaTecnica.domain.Coupon;
import pruebaTecnica.domain.ShoppingCart;


/**
 * Clase responsable de gestionar el acceso y manipulación del carrito de compras.
 * 
 * Esta clase funciona como un repositorio que permite la obtención y modificación 
 * de la información de un carrito de compras, incluyendo la posiblidad de actualizar 
 * descuentos que pueda tener el carrito de compras ya sea de descuento porcentual por 
 * cada producto o un descuento al total general del carrito a partir de un cupón.
 */
public class ShoppingCartRepository {
	private ShoppingCart shoppingCart;
	
	/**
     * Consutructor de la clase ShoppingCartRepository que permite la  Creación
     * de una nueva instancia de ShoppingCartRepository con un carrito de compras vacío.
     */
	public ShoppingCartRepository() {
		this.shoppingCart = new ShoppingCart();
	}
	
	 /**
     * Metodo que permite Obtener el carrito de compras actual.
     *
     * @return El carrito de compras.
     */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
    /**
     * Metodo que actualiza el descuento aplicado al carrito de compras si el shoppingCartId coincide.
     *
     * @param shoppingCartId El ID del carrito de compras.
     * @param discount El valor del descuento a aplicar al carrito de compras.
     * @return El carrito de compras actualizado con la nueva información, en caso que el carrito de compras no se encuentre retorna  null.
     */
	public ShoppingCart updateShoppingCartDiscount(String shoppingCartId, double discount) {
		if(shoppingCart.getShoppingCartId().equals(shoppingCartId)) {			
			shoppingCart.setDiscount(discount);
			return shoppingCart;		
		}
		return null;
	}
	
    /**
     * Metodo que actualiza el cupón que se aplico al total del carrito de compras.
     *
     * @param shoppingCartId El ID del carrito de compras.
     * @param coupon El cupon que se aplica al carrito de compras.
     * @return El carrito de compras actualizado con la nueva información, en caso que el carrito de compras no se encuentre retorna null.
     */
	public ShoppingCart updateShoppingCartCoupon(String shoppingCartId, Coupon coupon) {
		if(shoppingCart.getShoppingCartId().equals(shoppingCartId)) {			
			shoppingCart.setCoupon(coupon);
			return shoppingCart;		
		}
		return null;
	}
			
}
