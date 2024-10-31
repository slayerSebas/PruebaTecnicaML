package pruebaTecnica.service;

import pruebaTecnica.domain.Product;
import pruebaTecnica.repository.ProductRepository;
import java.util.List;

/**
 * Servicio que maneja la logíca de negocio empleada para la gestion de un
 * producto.
 * 
 */
public class ProductService {
	/**
	 * Objecto de tipo ProductRepository que se emplea para acceder y modificar
	 * la información de un producto.
	 */
    private ProductRepository productRepository;

	/**
	 * Constructor de la clase ProductService. Inicializa el Objeto
	 * ProductRepository.
	 */
    public ProductService() {
        this.productRepository = new ProductRepository();
    }
    
    /**
	 * Metodo que permite obtener todos los productos.
	 * 
	 * @return Lista completa de los productos actuales.
	 */
    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    /**
 	 * Metodo que permite agregar productos.
 	 * 
 	 * @param product producto que se agregará a los productos actuales.
 	 */
    public void addProducts(Product product) {
    	productRepository.addProducts(product);
    }
    
    /**
  	 * Metodo que permite actualizar un producto.
  	 * 
  	 * @param productId Id del producto a actualizar.
  	 * @param updatedProduct Objeto que contiene la información del producto  a actualizar.
  	 * 
  	 * @return El producto actualizado.
  	 */
    public Product updateProduct(String productId, Product updatedProduct) {
        return productRepository.updateProduct(productId,updatedProduct );
    }
    
    /**
  	 * Metodo que permite eliminar un producto.
  	 * 
  	 * @param productId Id del producto a eliminar.
  	 * 
  	 * @return El producto eliminado.
  	 */
    public Product deleteProduct(String productId) {
        return productRepository.deleteProduct(productId);
    }
}