package pruebaTecnica.service;

import pruebaTecnica.domain.Coupon;
import pruebaTecnica.domain.ShoppingCart;

/**
 * Interfaz que define la estrategia para aplicar descuentos a un carrito de
 * compras.
 * 
 * Esta interfaz proporciona métodos para aplicar descuentos de tipo porcentual
 * o de tipo cupones. La implementacion de esta interfaz debe proporcionar la
 * lógica requerida para cada tipo de descuento que se aplicará aun carrito de
 * compras.
 */
public interface DiscountStrategy {
	/**
	 * Aplica un descuento de tipo porcentual al carrito de compras.
	 *
	 * @param shoppingCart El carrito de compras al que se aplicará el descuento.
	 * @param percentage   El porcentaje de descuento a aplicar.
	 * @throws IllegalArgumentException Si el porcentaje es inválido (por ejemplo,
	 *                                  negativo oque sea superior al 100%).
	 */
	void applyPercentageDiscount(ShoppingCart shoppingCart, double percentage);

	/**
	 * Aplica un descuento al carrito de compras a partir de un cupón valido .
	 *
	 * @param shoppingCart El carrito de compras al que se le aplicará el descuento
	 *                     definido por el cupo valido.
	 * @param coupon El cupón valido que se utilizará para aplicar el
	 *               descuento al carrito de compras.
	 * @throws IllegalArgumentException Si el cupón es nulo o no es válido.
	 */
	void applyCouponDiscount(ShoppingCart shoppingCart, Coupon coupon);
}
