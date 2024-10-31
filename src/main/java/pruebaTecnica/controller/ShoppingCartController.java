package pruebaTecnica.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pruebaTecnica.domain.Coupon;
import pruebaTecnica.domain.Product;
import pruebaTecnica.domain.ShoppingCartResponse;
import pruebaTecnica.service.ShoppingCartService;

/**
 * Controlador de la API que permite gestionar las operaciones relacionadas con
 * un carrito de compras. Este controlador define los siguientes endpoints para:
 * <ul>
 * <li>Agregar, eliminar y vaciar productos del carrito de compras</li>
 * <li>Obtener el total del carrito y la lista de productos</li>
 * <li>Aplicar descuentos de tipo porcentaje a cada producto del carrito y de
 * tipo cupon que se aplica al total del carrito.</li>
 * </ul>
 * Se emplea la biblioteca Spark para manejar las rutas HTTP y Gson para
 * procesar JSON.
 */
public class ShoppingCartController {
	private ShoppingCartService shoppingCartService = new ShoppingCartService();
	private Gson gson;

	/**
	 * Constructor del controlador ShoppingCartController.
	 * 
	 * @param shoppingCartService Servicio que contiene la lógica de negocio para
	 *                            admnistrar el carrito de compras.
	 */
	public ShoppingCartController(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
		this.gson = new Gson();
	}

	/**
	 * Inicializa los endpoints de la API para administrar un carrito de compras.
	 */
	public void init() {
		/**
		 * Endpoint que permite obtener el carrito de compras completo. Método: GET URL:
		 * /shoppingCart Respuesta: Objeto JSON con la información actual del carrito de
		 * compras.
		 */
		get("/shoppingCart", (req, res) -> {
			res.type("application/json");
			return gson.toJson(shoppingCartService.getShoppingCart());
		});

		/**
		 * Endpoint que permite obtener el total del carrito de compras junto con el
		 * listado de productos. Método: GET URL: /shoppingCart/total Respuesta: JSON
		 * con el total y los productos en el carrito de compras.
		 */
		get("/shoppingCart/total", (req, res) -> {
			res.type("application/json");
			double total = shoppingCartService.calculateShoppingCartTotal();
			List<Product> products = shoppingCartService.getShoppingCart().getProducts();
			ShoppingCartResponse shoppingCartresponse = new ShoppingCartResponse(total, products);
			return gson.toJson(shoppingCartresponse);
		});

		/**
		 * Endpoint que permite agregar un producto al carrito de compras. Método: POST
		 * URL: /shoppingCart/product Request Body: Objeto JSON con los datos del
		 * producto (id, nombre, precio, categoría). Respuesta: Mensaje confirmando la
		 * adición del producto.
		 */
		post("/shoppingCart/product", (req, res) -> {
			res.type("application/json");
			String jsonBody = req.body();
			Product product = gson.fromJson(jsonBody, Product.class);

			shoppingCartService.addProductToShoppingCart(product);
			res.status(201);
			return "Producto añadido al carrito";
		});

		/**
		 * Endpoint que permite aplicar un descuento porcentual a los productos del
		 * carrito de compras. Método: POST URL:
		 * /shoppingCart/:shoppingCartId/applyPercentageDiscount Request Body: JSON con
		 * el valor del descuento (double). Respuesta: Mensaje de confirmación o de
		 * error si el descuento es inválido.
		 */
		post("/shoppingCart/:shoppingCartId/applyPercentageDiscount", (req, res) -> {
			res.type("application/json");
			String shoppingCartId = req.params(":shoppingCartId");
			String jsonBody = req.body();
			JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);
			double discount = jsonObject.get("discount").getAsDouble();
			try {
				shoppingCartService.applyPercentageDiscount(shoppingCartId, discount);
				res.status(200);
				return "Descuento en porcentaje aplicado correctamente.";
			} catch (IllegalArgumentException e) {
				res.status(400);
				return e.getMessage();
			} catch (Exception e) {
				res.status(500);
				return "Error interno del servidor: " + e.getMessage();
			}
		});

		/**
		 * Endpoint que permite aplicar un descuento de tipo cupón al total del carrito
		 * de compras. Método: POST URL:
		 * /shoppingCart/:shoppingCartId/applyCouponDiscount Request Body: JSON con los
		 * datos del cupón (nombre y valor). Respuesta: Mensaje de confirmación o error
		 * si el cupón es inválido.
		 */
		post("/shoppingCart/:shoppingCartId/applyCouponDiscount", (req, res) -> {
			res.type("application/json");
			String shoppingCartId = req.params("shoppingCartId");
			String jsonBody = req.body();
			Coupon coupon = gson.fromJson(jsonBody, Coupon.class);
			try {
				shoppingCartService.applyCouponDiscount(shoppingCartId, coupon);
				res.status(200);
				return "Descuento por cupón aplicado correctamente." + shoppingCartId;
			} catch (IllegalArgumentException e) {
				res.status(400);
				return e.getMessage();
			} catch (Exception e) {
				res.status(500);
				return "Error interno del servidor: " + e.getMessage();
			}

		});

		/**
		 * Endpoint que permite eliminar un producto del carrito de compras. Método:
		 * DELETE URL: /shoppingCart/product/:id Parámetro URL: id del producto.
		 * Respuesta: Mensaje de confirmación de la eliminación.
		 */
		delete("/shoppingCart/product/:id", (req, res) -> {
			res.type("application/json");
			String productId = req.params(":id");
			shoppingCartService.removeProductFromShoppingCart(productId);
			res.status(201); // No content
			return "producto con " + productId + "ha sido eliminado de su carrito de compras.";
		});

		/**
		 * Endpoint que permite vaciar un carrito de compras. Método: DELETE URL:
		 * /shoppingCart/clear Respuesta: Mensaje de confirmación si el carrito de
		 * compras fue vaciado.
		 */
		delete("/shoppingCart/clear", (req, res) -> {
			res.type("application/json");
			shoppingCartService.clearShoppingCart();
			res.status(201); // No content
			return "Carrito de compras vaciado";
		});

	}

	/**
	 * Método principal para iniciar el controlador del carrito de compras.
	 * 
	 * @param args argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		ShoppingCartService shoppingCartService = new ShoppingCartService();
		ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartService);
		shoppingCartController.init();
	}
}
