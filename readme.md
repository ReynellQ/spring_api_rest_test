Market API

Una API REST para ver los recursos de un market


- V1:
  - Entry Points:
    ```
      GET /api/compras/ : Ver todas las compras
      GET /api/compras/{id} : Ver la compra con un ID especificado
      GET /api/clientes/ : Ver todos los clientes
      GET /api/clientes/{id} : Ver un cliente con el ID especificado
      GET /api/productos/ : Ver todos los productos
      GET /api/productos/{id} : Ver un producto con el id especificado
      GET /api/categorias/ : Ver todas las categorias
      GET /api/categorias/{id} : Ver una categoria con el ID especificado
    ```
- V2:
  - Entry Points:
    ```
      POST /api/clientes/ : Añadir un cliente
      POST /api/categoria/ : Añadir una categoria
      POST /api/productos/ : Añadir un producto
      GET /api/compras/{id}/list : Ver compra con productos
      POST /api/compras/ : Añadir una compra (con productos)
      
    ```
