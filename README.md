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
    



La implementación del sistema de descuentos se basa en el patrón de diseño Strategy, lo que permite definir diferentes estrategias de descuento y aplicarlas de forma intercambiable sin necesidad de modificar la lógica del carrito de compras.
