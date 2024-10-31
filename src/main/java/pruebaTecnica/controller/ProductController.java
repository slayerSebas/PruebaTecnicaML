package pruebaTecnica.controller;
import static spark.Spark.*;
import com.google.gson.Gson;

import pruebaTecnica.domain.Product;
import pruebaTecnica.service.ProductService;

/**
 * Controlador de la API que permite gestionar las operaciones relacionadas con
 * un listado de productos. Este controlador define los siguientes endpoints para:
 * <ul>
 * 	<li>Agregar, eliminar, actualizar o leer un listado de productos</li>
 * </ul>
 * Se emplea la biblioteca Spark para manejar las rutas HTTP y Gson para
 * procesar JSON.
 */
public class ProductController {
    private ProductService productService = new ProductService();
    private Gson gson;

    /**
	 * Constructor del controlador ProductController.
	 * 
	 * @param productService Servicio que contiene la lógica de negocio para
	 * admnistrar un listado de productos.
	 */
    public ProductController(ProductService productService) {
    	this.productService = productService;
    	this.gson = new Gson();
    }
    
    /**
	 * Inicializa los endpoints de la API para administrar un carrito de compras.
	 */
    public void init() { 
		/**
		 * Endpoint que permite obtener el carrito de compras completo. 
		 * Método: GET 
		 * URL:/products 
		 * Respuesta: Objeto JSON con la información de los productos.
		 */
        get("/products", (req, res) -> {
            res.type("application/json");
            return gson.toJson(productService.getAllProducts());
        });
        
        /**
		 * Endpoint que permite adicionar un producto nuevo. 
		 * Método: POST 
		 * URL:/products 
		 * Request Body: Objeto JSON que representa el producto nuevo.
         * Respuesta: Mensaje de confirmación de la adición del producto.
		 */
        post("/product", (req, res) -> {
            String jsonBody = req.body();
            Product product = gson.fromJson(jsonBody, Product.class);
            productService.addProducts(product);
            res.status(201);
            return "Producto agregado";
        });
        
        /**
         * Endpoint que permite actualizar un producto existente.
         * Método: PUT
         * URL: /product/:id
         * Request Body: Objeto JSON con los nuevos datos del producto.
         * Respuesta: JSON con la información del producto actualizado o mensaje de error.
         */
        put("/product/:id", (req, res) -> {
            String productId = req.params(":id");
            String jsonBody = req.body();
            Product updatedProduct = gson.fromJson(jsonBody, Product.class);

            Product product = productService.updateProduct(productId, updatedProduct);
            if (product != null) {
                res.status(200);
                return gson.toJson(product); 
            } else {
                res.status(404);
                return "producto no encontrado";
            }
        });
        
        /**
         * Endpoint que permite eliminar un producto por su ID.
         * Método: DELETE
         * URL: /product/:id
         * Respuesta: JSON con la información del producto eliminado o mensaje de error.
         */
        delete("/product/:id", (req, res) -> {
            String productId = req.params(":id");
            Product product = productService.deleteProduct(productId);
            
            if (product != null) {
                res.status(200);
                return gson.toJson(product); 
            } else {
                res.status(201);
                return "producto eliminado";
            }
        });   
    }
    
    /**
     * Método principal para iniciar el controlador de productos.
     * 
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
    	 ProductService productService = new ProductService(); 
         ProductController productController = new ProductController(productService); 
         productController.init(); 
    }
}
