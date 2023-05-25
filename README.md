# Implementación juego de triqui - Santiago Barragan Paipilla 

# Triqui (Tres en línea) en Java

Este es un juego de Triqui (Tres en línea) implementado en Java. Permite a dos jugadores competir entre sí para lograr alinear tres de sus símbolos en línea ya sea horizontalmente, verticalmente o en diagonal.

El juego está diseñado con tres clases principales: `Tablero`, `Jugador` y `Triqui`.

## Tablero

La clase `Tablero` se encarga de gestionar el estado del tablero de juego y las operaciones relacionadas con él. Algunas de las funcionalidades de esta clase incluyen:

- Inicializar el tablero con casillas vacías.
- Mostrar el tablero en la consola.
- Verificar si un movimiento es válido.
- Realizar un movimiento en una casilla específica.
- Verificar si hay un ganador.
- Verificar si hay un empate.

## Jugador

La clase `Jugador` representa a un jugador en el juego de Triqui. Cada jugador tiene un nombre y un símbolo asociado ('X' o 'O'). Esta clase proporciona métodos para obtener el nombre y el símbolo del jugador.

## Triqui

La clase `Triqui` es la clase principal que coordina el juego. En ella se crea un objeto de la clase `Tablero` y dos objetos de la clase `Jugador`, uno para cada jugador. La clase `Triqui` también contiene el método `jugar()`, que maneja la lógica del juego:

- Muestra el estado actual del tablero.
- Solicita las coordenadas del movimiento al jugador actual.
- Verifica si el movimiento es válido.
- Realiza el movimiento en el tablero.
- Verifica si hay un ganador.
- Verifica si hay un empate.
- Cambia al siguiente jugador.

## Cómo jugar

1. Ejecuta la aplicación Java.
2. Aparecerá el tablero vacío en la consola.
3. Se solicitará al jugador 1 que ingrese la fila y la columna para realizar su movimiento.
4. Luego, se solicitará al jugador 2 que haga lo mismo.
5. El juego continuará alternando entre los jugadores hasta que se cumpla una de las siguientes condiciones:
   - Uno de los jugadores logra alinear tres de sus símbolos en línea (horizontal, vertical o diagonal), y se muestra un mensaje indicando al ganador.
   - Todas las casillas del tablero se llenan sin que haya un ganador, y se muestra un mensaje de empate.

## Requisitos del sistema
- Compilador Java.

## Ejecutar el juego

1.  Descarga este repositorio en archivos.
2. Abre una terminal o línea de comandos en la carpeta del proyecto.
3. Compila los archivos Java utilizando el comando.
4. Ejecuta la aplicación Java con el comando.

## Personalización

Si deseas personalizar los nombres de los jugadores, puedes modificar el archivo `Main.java` y cambiar los nombres pasados al crear el objeto `Triqui`. Reemplaza "Jugador 1" en este caso natalia y "Jugador 2" en este caso Santiago por los nombres que desees.

¡Diviértete jugando al Triqui!

