package pruebaTecnica.controller;
import static spark.Spark.*;

/**
 * Autor: Johan Sebastian Contreras Bello
 * Email: server_sebas93@hotmail.com
 * Fecha de creación: 31 de octubre 2024
 * 
 * Aplicación Backend que permite administrar un listado de productos (CRUD) y gestionar un carrito de compras.
 * 
 * Dentro de la gestión del carrito de compras se exponen metodos que permiten aplicar dos tipos de descuento:
 * <ul>
 * 	<li>Descuento por porcentaje: descuento aplicado a cada producto del carrito de compras. </li>
 * 	<li>Descuento a partir de un cupon: descuento a partir de un cupon valido que se aplica al total del carrito de compras. </li>
 * </ul>
 * 
 * La clase MainController unifica los dos flujos desarrollados y permite especificar el puerto por el cual la App escuchará todo 
 * tipo de peticiones HTTP.
 */

public class MainController {
	 public static void main(String[] args) {
		 // Configura el puerto en el que el servidor escuchará las peticiones HTTP
		 	port(8000); 
		 	
		 // Inicia el controlador de productos
		 	ProductController.main(args); 
		 	
		 // Inicia el controlador de carrito de compras
	        ShoppingCartController.main(args); 
	      
	    }
}
