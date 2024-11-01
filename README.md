# PruebaTecnicaML
Este repositorio contiene el código fuente de una aplicación backend desarrollada como parte de una evaluación técnica para Mercado Libre. El objetivo de esta aplicación es demostrar mis habilidades en el desarrollo de App Backend, gestión de datos y arquitectura de software(Aplicación).

# Descripción del Proyecto

Este proyecto es una aplicación de backend que permite la gestión de un carrito de compras. La aplicación no solo facilita la adición y eliminación de productos, sino también ofrece la posiblidad de aplicar dos tipos de descuento como:

- **Descuentos por porcentaje**: Permite aplicar un porcentaje de descuento sobre el los productos del carrito de compras
- **Descuentos por cupon**: Permite aplicar un descuento fijo al total del carrito de compras siempre y cuando el cupón sea valido. (*Se considera un cupón valido cuando tiene atributos de nombre y valor*)

Tambien, permite la eliminación y adición de productos al carrito de compras y el calculo del valor total del carrito de compras. 

Adicionalmente, se implemento un CRUD basico para la gestión de productos. esta gestión permite:

  - **Crear Producto**: Permite adicionar nuevos productos al listado de productos actual.
  - **Actualizar Producto**: Permite actualizar productos existente a partir de un **productID**.
  - **Eliminar Producto**: Permite eliminar productos existente a partir de un **productID**.
  - **Ver Producto**: Permite visualizar información de productos existente a partir de un **productID**.
    
# Infrastructura

### Tecnologias empleadas

  - **Java**: El lenguaje principal para el desarrollo de la aplicación.
  - **Spark**: Framework utilizado para simplificar la creación y configuración de servicios HTTP.
  - **Maven (3.9.9)**: Herramienta de gestión de proyectos y dependencias.

### Estructura del proyecto

El proyecto está organizado en varios paquetes(capas), donde cada uno tiene un propósito específico:

  - **Domain**: Contiene las clases de modelo que representan los objetos del dominio, como *Product*, *ShoppingCart*, *Coupon* y *ShoppingCartResponse*.
  - **Service**: Implementa la lógica de negocio, gestionando las interacciones entre el *controlador* y el *repositorio*.
  - **Repository**: Se encarga de la persistencia de datos, proporcionando métodos para interactuar los datos existentes.
  - **Controller**: Maneja las solicitudes HTTP y delega las operaciones a los servicios correspondientes.

*los controladores se integran en una solo controlador llamado **MainController** donde tambien se define el Puerto por el cual la aplicación escuchará las peticiones HTTP.*

### Patrón de diseño

La aplicación implementa el Patrón de **strategy** para gestionar los dos tipos de descuentos implementados en la aplicación. Este patrón permite definir una familia de algoritmos de descuento, encapsular cada uno y hacerlos intercambiables. Así, se pueden aplicar diferentes estrategias de descuento sin modificar el código ya implementado.

Adicionalmente, la aplicación está construida siguiendo principios de programación orientada a objetos (POO), lo que permite una mayor modularidad y reutilización del código. Se han aplicado principios como la abstracción, la encapsulación para crear clases que representan entidades como productos, carritos de compras y cupones, promoviendo así un diseño limpio.

# Generalidades del Desarrollo de la aplicación

En esta sección, se describen actividades de vital importancia para mi que me permitieron estructurar y definir como abordaria los desafíos presentados en la prueba.

### Actividades Desarrolladas

**Investigación sobre Patrones de Diseño:**
  Se Realizo un estudio detallado sobre varios patrones de diseño, centrándome en el patrón Strategy, ya que este permite una gran flexibilidad y permite la separación de responsablidades lo cual permitio implementar la lógica de los dos tipos de descuento solicitados.
  
**Generación de Recurso Grafico:**
  Antes de iniciar la solución requerida, se tomo el tiempo para estructurar mis entidades y el comportamiento que estas tendrian en mi aplicacion. para ello desarrollo un pequeño esquema de diagrama de clase UML que me permitio definir a la hora de la aplicacion las propiedades, metodos y      caracteristicas que tendrian mis entidades dentro de mi aplicacion.
  
![Diagrama en blanco](https://github.com/user-attachments/assets/5d769f73-c15d-40c6-a30b-88d163afc4f1)



# Instrucciones para Ejecutar la Aplicación

1. **Prerequisitos**:
   - Asegúrate de tener instalados los siguientes programas:
     - **Java (JDK 22 o superior)**.
     - **Maven**: Gestor de paquetes.
     - **eclipse**:(Opcional) Este es el compilador raiz con el cual se desarrollo la aplicación. si esta disponible, solo es importar el proyecto y correr ***MainController*** para levantar la aplicacion.
       
2. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/slayerSebas/PruebaTecnicaML.git
   cd PruebaTecnicaML

3. **Compilar el proyecto**:
   Abre una terminal en el directorio del proyecto y ejecuta el siguiente comando para compilar el proyecto:
     ```bash
   mvn clean install
4. **Ejecutar la aplicación**:
  Una vez que la compilación se haya completado sin errores, puedes ejecutar la aplicación con el siguiente comando:
    ```bash
   mvn exec:java -Dexec.mainClass="pruebaTecnica.controller.MainController"
5. **Acceder a la aplicación**:

   - La aplicación se ejecutará en el puerto **8000** por defecto. para acceder a los endPoints de la aplicación se recomienda el uso de herramientas como Postman.
   - adicionalmente, en el repositorio encontraran los endPoint ya configurados para pruebas.
     
6. **Insumo para pruebas**

   Si se emplea la herramienta **Postman**,En la carpeta de utils encontraran dos archivos .json con las configuraciones necesarias para probar la aplicacion. solo es importarlos directamente en la herramienta.

   **EndPoints de pruebas configurados**
   
      6.1 **EndPoints Carrito de compras**
    ```bash
      http://localhost:8000/shoppingCart // GET -> listar el carrito de compras.
      http://localhost:8000/shoppingCart/product // POST -> agrega un producto al carrito de compras -- el objeto se recibe por el body() - Raw.
      http://localhost:8000/shoppingCart/clear // DELETE -> vacia el carrito de compras
      http://localhost:8000/shoppingCart/product/{productId} // DELETE -> elimina un producto del carrito de compras a partir de su Id.
      http://localhost:8000/shoppingCart/{shoppingCartId}/applyPercentageDiscount // POST -> aplica un descuento de tipo porcentaje a todos los productos del carrito de compras -> se valida un Id para poder realizar la operación.
      http://localhost:8000/shoppingCart/{shoppingCartId}/applyCouponDiscount // POST -> aplica un descuento de tipo cupon al total del carrito de compras -> se valida un Id para poder realizar la operación
    ```
    6.2 **EndPoints Producto**
    ```bash
      http://localhost:8000/product // GET -> listar todos los productos disponibles.
      http://localhost:8000/product // POST -> crear un producto nuevo -- el objeto se recibe por el body() - Raw.
      http://localhost:8000/product/{productId} // PUT -> Actualizar un producto -- el objeto se recibe por el body() - Raw. -- consultar o crear un producto para tener un Id valido y poder probar este endPoint
      http://localhost:8000/product/{productId} // DELETE -> eiminar un producto -- consultar o crear un producto para tener un Id valido y poder probar este endPoint 
    ```
La anterior estructura de pruebas podra encontrarse en la carpeta ***utils*** del proyecto. podra ser descarga e importar en postman.

## Agradecimientos

Agradezco la oportunidad de presentar esta prueba. Este proceso me ha permitido afrontar nuevos desafios y poder demostrar mis habilidades, oportunidades de mejora y conocimientos en el desarrollo de la aplicación.





