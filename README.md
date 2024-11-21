# Proyecto Taller 4

Este proyecto es una aplicación de Android desarrollada en Kotlin que simula el movimiento de un sensor de acelerómetro y actualiza el color de fondo de la aplicación en función de los valores del sensor. La aplicación también permite agregar y mostrar productos.

## Clases

### `MainActivity.kt`
La clase `MainActivity` es la actividad principal de la aplicación. Configura el `Toolbar` y el `NavHostFragment` para la navegación entre fragmentos. Observa el `SharedViewModel` para actualizar el color de fondo del `Toolbar`.

### `SharedViewModel.kt`
La clase `SharedViewModel` es un `ViewModel` compartido que mantiene el color de fondo de la aplicación. Proporciona un `LiveData` para observar el color de fondo y un método para actualizarlo.

### `ItemListFragment.kt`
El `ItemListFragment` muestra una lista de elementos y simula el movimiento del sensor de acelerómetro. Actualiza el color de fondo de la aplicación cuando los valores del sensor cambian significativamente. También muestra la hora actual y un saludo basado en la hora del día.

### `DataSummaryFragment.kt`
El `DataSummaryFragment` muestra un resumen de los productos en un `RecyclerView`. Observa el `ProductViewModel` para actualizar la lista de productos y el `SharedViewModel` para actualizar el color de fondo.

### `AddProductFragment.kt`
El `AddProductFragment` permite agregar nuevos productos. Obtiene los datos de los campos de texto y los agrega al `ProductViewModel`. Observa el `SharedViewModel` para actualizar el color de fondo.

### `ItemDetailFragment.kt`
El `ItemDetailFragment` muestra los detalles de un elemento seleccionado. Observa el `SharedViewModel` para actualizar el color de fondo.

### `ProductViewModel.kt`
El `ProductViewModel` es un `ViewModel` que mantiene una lista de productos. Proporciona métodos para agregar productos y observar la lista de productos.

### `Product.kt`
La clase `Product` es un modelo de datos que representa un producto con un número de serie, nombre, precio y cantidad.

### `ProductAdapter.kt`
El `ProductAdapter` es un adaptador para el `RecyclerView` en `DataSummaryFragment`. Vincula los datos de los productos a las vistas del `RecyclerView`.

### `ItemAdapter.kt`
El `ItemAdapter` es un adaptador para el `RecyclerView` en `ItemListFragment`. Vincula los datos de los elementos a las vistas del `RecyclerView`.

### `AccelerometerHandler.kt`
El `AccelerometerHandler` maneja los eventos del sensor de acelerómetro. Proporciona métodos para comenzar y detener la escucha de los eventos del sensor.

### `CustomReloj.kt`
El `CustomReloj` es una vista personalizada que dibuja un reloj analógico. Actualiza la hora cada segundo.

## Archivos XML

### `activity_main.xml`
Define el diseño principal de la actividad, incluyendo el `Toolbar` y el `NavHostFragment`.

### `fragment_item_list.xml`
Define el diseño del `ItemListFragment`, incluyendo un reloj personalizado, textos para la hora y el saludo, y un botón de navegación.

### `fragment_data_summary.xml`
Define el diseño del `DataSummaryFragment`, incluyendo un `RecyclerView` para mostrar los productos y botones para agregar y actualizar productos.

### `fragment_add_product.xml`
Define el diseño del `AddProductFragment`, incluyendo campos de texto para ingresar los detalles del producto y un botón para guardar.

### `fragment_item_detail.xml`
Define el diseño del `ItemDetailFragment`, incluyendo un texto para mostrar los detalles del elemento.

### `item_list_content.xml`
Define el diseño de un elemento en la lista de `ItemListFragment`.

### `item_product.xml`
Define el diseño de un elemento en la lista de productos de `DataSummaryFragment`.

### `nav_graph.xml`
Define la navegación entre los fragmentos de la aplicación.

## Permisos

### `AndroidManifest.xml`
Incluye el permiso `android.permission.BODY_SENSORS` para acceder a los sensores del dispositivo.

## Conclusión

Este proyecto demuestra cómo utilizar `ViewModel` y `LiveData` para compartir datos entre fragmentos, cómo manejar eventos de sensores y cómo personalizar vistas en Android. La aplicación es modular y fácil de mantener, con una clara separación de responsabilidades entre las diferentes clases y fragmentos.
