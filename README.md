![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# Actividad Formativa 4 Llanquihue Tour App - Desarrollo Orientado A Objeto I

## Autor Del Proyecto
- **Nombre:** Hector Eduardo Soto Vasquez
- **Carrera:** Analista Programador Computacional

## Descripcion Del Proyecto
Este es el proyecto Formativa 4 en cual es una actualizacion de la actividad Sumativa 2 en el cual el problema de la empresa llanquihue tour
llanquihue tour Quiere tener una estructura mas flexible en cual tengan herencias para tener mayor flexibildad 

## Estructura General Del Proyecto

```plaintext
📁 Resources
├── Panoramas.txt #Tipo de texto donde estan los panoramas agregados
📁 src/
├── ui/           #Clase Principal Con El Metodo Main
├── model/        #Clase De Dominio (CentroPanoramicos)
├── data/         #Clase para gestionar datos y leer archivos

````

---

## Clases Creadas
En Esta Semana Se creo las clases Madre que es ServicioTuristico la cual Tiene Objetos Nombre y DuracionHoras, estos objetos se transfieren a las clases RutaGastronomica,PaseoLacustre y ExcursionCultural en formato de herencia en cual cada uno de ellos le agrega un objeto dependiendod de su clase y su funcion 

## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio desde Github.

```bash
git clone https://github.com/HectorSotoDuocuc/LlanquihueTour_HectorSoto.git
```

2. abre el proyecto en IntelliJ IDEA.

3. Ejecutar el archivo `Main.java` desde el paquete `ui` buscando el boton verde de play que estara arriba a la derecha.

4. Saldra un menu donde podra agregar panoramas, eliminarlos, buscar por nombre o mostrar todos.
