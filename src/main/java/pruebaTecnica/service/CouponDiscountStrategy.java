package pruebaTecnica.service;

import pruebaTecnica.domain.Coupon;
import pruebaTecnica.domain.ShoppingCart;

/**
 * Estrategia de descuento que aplica un descuento a un carrito de compras
 * utilizando un cupón.
 * 
 * Implementa la interfaz DiscountStrategy para proporcionar la lógica
 * específica de aplicación.
 */
public class CouponDiscountStrategy implements DiscountStrategy {

	
    /**
     * Constructor por defecto de la clase CouponDiscountStrategy.
     * Este constructor inicializa la estrategia de descuento de tipo Cupon.
     */
    public CouponDiscountStrategy() {
    }
	/**
	 * Aplica un descuento en el carrito de compras utilizando un cupón.
	 *
	 * @param shoppingCart El carrito de compras al que se le aplicará el descuento.
	 * @param coupon El cupón que se utilizará para aplicar el descuento al
	 *               carrito de compras.
	 * @throws IllegalArgumentException Si el cupón es nulo, no es válido, o si el
	 *                                  valor del cupón supera el total del carrito.
	 */
	@Override
	public void applyCouponDiscount(ShoppingCart shoppingCart, Coupon coupon) {
		if (coupon != null && coupon.isValid()) {

			double totalShoppingCart = shoppingCart.calculateTotalShoppingCart();
			double discountCoupon = totalShoppingCart * (coupon.getValue() / 100);
			double totalAux = totalShoppingCart - discountCoupon;

			if (totalAux < 0) {
				throw new IllegalArgumentException("El valor del cupón supera el total del carrito.");
			}

			shoppingCart.setCoupon(coupon);
			shoppingCart.setTotal(totalAux);
			shoppingCart.setDiscount(discountCoupon);
		} else {
			throw new IllegalArgumentException("Cupón no válido.");
		}
	}

	/**
	 * Método no soportado para aplicar un descuento porcentual.
	 *
	 * @param shoppingCart El carrito de compras al cual se le aplicaria el
	 *                     descuento. (no se utiliza en este método).
	 * @param percentage   El porcentaje de descuento que se aplicaría al carrito de
	 *                     compras.(no se utiliza en este método).
	 * @throws UnsupportedOperationException Siempre se lanza esta excepción, ya que
	 *                                       esta estrategia no admite descuentos
	 *                                       porcentuales.
	 */

	@Override
	public void applyPercentageDiscount(ShoppingCart shoppingCart, double percentage) {
		throw new UnsupportedOperationException("Este método no está soportado para descuentos por cupones");
	}
}
