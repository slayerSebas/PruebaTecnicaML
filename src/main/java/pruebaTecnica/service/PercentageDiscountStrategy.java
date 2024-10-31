package pruebaTecnica.service;

import pruebaTecnica.domain.Coupon;
import pruebaTecnica.domain.Product;
import pruebaTecnica.domain.ShoppingCart;


/**
 * Estrategia de descuento que aplica un descuento en porcentaje a los productos
 * de un carrito de compras.
 * 
 * Implementa la interfaz DiscountStrategy para proporcionar la lógica
 * específica de la aplicación.
 */
public class PercentageDiscountStrategy implements DiscountStrategy{

	

    /**
     * Constructor por defecto de la clase PercentageDiscountStrategy.
     * Este constructor inicializa la estrategia de descuento de tipo porcentual por producto.
     */
	 public PercentageDiscountStrategy() {
	}

	/**
     * Aplica un descuento en procentaje a todos los productos del carrito de compras.
     *
     * @param shoppingCart El carrito de compras al cual se aplicará el descuento.
     * @param discountPercentage El porcentaje de descuento que se aplicará a cada producto del carrito
     * 		  de compras.
     */
	@Override
	public void applyPercentageDiscount(ShoppingCart shoppingCart, double discountPercentage) {
		
	        for(int i =0; i< shoppingCart.getProducts().size(); i++) {
	        	Product productAux = shoppingCart.getProducts().get(i);
	        	double priceAux = productAux.getPrice();
	            double discountAmount = priceAux * (discountPercentage / 100);
	            double discountedPrice = priceAux - discountAmount;
	            productAux.setPrice(discountedPrice);
	        }
	        shoppingCart.setDiscount(discountPercentage);
	}

	 /**
     * Método no soportado para aplicar descuentos mediante cupones al carrito de compras.
     *
     * @param shoppingCart El carrito de compras (no se emplea en este metodo).
     * @param coupon El cupón que se intentaría aplicar (no se utiliza en este método) al carrito de compras.
     * @throws UnsupportedOperationException Siempre se ejecuta la excepción, ya que esta estrategia no admite 
     * 			descuentos de tipo cupon.
     */
	@Override
	public void applyCouponDiscount(ShoppingCart shoppingCart, Coupon coupon) {
		 throw new UnsupportedOperationException("Este método no está soportado para descuentos por cupones");
		
	}
}
