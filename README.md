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

**Tecnologias Utilizadas**

  - **Java**: El lenguaje principal para el desarrollo de la aplicación.
  - **Spark**: Framework utilizado para simplificar la creación y configuración de servicios HTTP.
  - **Maven**: Herramienta de gestión de proyectos y dependencias.

**Estructura del proyecto**

El proyecto está organizado en varios paquetes(capas), donde cada uno tiene un propósito específico:

  - **Domain**: Contiene las clases de modelo que representan los objetos del dominio, como *Product*, *ShoppingCart*, *Coupon* y *ShoppingCartResponse*.
  - **Service**: Implementa la lógica de negocio, gestionando las interacciones entre el *controlador* y el *repositorio*.
  - **Repository**: Se encarga de la persistencia de datos, proporcionando métodos para interactuar los datos existentes.
  - **Controller**: Maneja las solicitudes HTTP y delega las operaciones a los servicios correspondientes.

*los controladores se integran en una solo controlador llamado **MainController** donde tambien se define el Puerto por el cual la aplicación escuchará las peticiones HTTP.*

**Patrón de Diseño**

La aplicación implementa el Patrón de **strategy** para gestionar los dos tipos de descuentos implementados en la aplicación. Este patrón permite definir una familia de algoritmos de descuento, encapsular cada uno y hacerlos intercambiables. Así, se pueden aplicar diferentes estrategias de descuento sin modificar el código ya implementado.

Adicionalmente, la aplicación está construida siguiendo principios de programación orientada a objetos (POO), lo que permite una mayor modularidad y reutilización del código. Se han aplicado principios como la abstracción, la encapsulación para crear clases que representan entidades como productos, carritos de compras y cupones, promoviendo así un diseño limpio.
