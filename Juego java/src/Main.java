/*
 * Autor: Santiago Barragan Paipilla 
 * Tema: Implementacion de Juego en java con md
 * fecha: 23/05/2023 
*/

//Libreris a utilizar 
import java.util.Scanner;

//Clase Tablero
class Tablero {
	//Atributos 
    private char[][] casillas;
    //Constructor 
    public Tablero() {
        casillas = new char[3][3];
        inicializarCasillas();
    }
    //Metodos de clase 
    public void inicializarCasillas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j] = '-';
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean movimientoValido(int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && casillas[fila][columna] == '-';
    }

    public void realizarMovimiento(int fila, int columna, char jugador) {
        casillas[fila][columna] = jugador;
    }

    public boolean hayGanador(char jugador) {
        for (int i = 0; i < 3; i++) {
            if (casillas[i][0] == jugador && casillas[i][1] == jugador && casillas[i][2] == jugador) {
            	// Verificar filas
                return true; 
            }
        }

        for (int j = 0; j < 3; j++) {
            if (casillas[0][j] == jugador && casillas[1][j] == jugador && casillas[2][j] == jugador) {
            	// Verificar columnas
                return true; 
            }
        }

        if ((casillas[0][0] == jugador && casillas[1][1] == jugador && casillas[2][2] == jugador) ||
                (casillas[0][2] == jugador && casillas[1][1] == jugador && casillas[2][0] == jugador)) {
        	// Verificar diagonales
            return true; 
        }

        return false;
    }

    public boolean hayEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][j] == '-') {
                	// Todavía hay casillas vacías, no hay empate
                    return false; 
                }
            }
        }
     // No quedan casillas vacías, hay empate
        return true; 
    }
}

//Clase jugador 
class Jugador {
	//Atributos
    private String nombre;
    private char simbolo;
    //Metodo constructor 
    public Jugador(String nombre, char simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }
    //Getters y setters 
    public String getNombre() {
        return nombre;
    }

    public char getSimbolo() {
        return simbolo;
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
    
}

//Clase triqui 
class Triqui {
	//Atributos
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    //Metodo Constructor
    public Triqui(String nombreJugador1, String nombreJugador2) {
        tablero = new Tablero();
        jugador1 = new Jugador(nombreJugador1, 'X');
        jugador2 = new Jugador(nombreJugador2, 'O');
        jugadorActual = jugador1;
    }
    //Metodo de jugar 
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;

        while (true) {
            // Mostrar el tablero
            tablero.mostrarTablero();

            // Obtener las coordenadas del movimiento del jugador
            System.out.print("Jugador " + jugadorActual.getNombre() + ", ingrese la fila (0-2): ");
            fila = scanner.nextInt();
            System.out.print("Jugador " + jugadorActual.getNombre() + ", ingrese la columna (0-2): ");
            columna = scanner.nextInt();

            // Realizar el movimiento
            if (tablero.movimientoValido(fila, columna)) {
                tablero.realizarMovimiento(fila, columna, jugadorActual.getSimbolo());

                // Verificar si hay un ganador
                if (tablero.hayGanador(jugadorActual.getSimbolo())) {
                    tablero.mostrarTablero();
                    System.out.println("¡El jugador " + jugadorActual.getNombre() + " ha ganado!");
                    break;
                }

                // Verificar si hay empate
                if (tablero.hayEmpate()) {
                    tablero.mostrarTablero();
                    System.out.println("¡Es un empate!");
                    break;
                }

                // Cambiar de jugador
                cambiarJugador();
            } else {
                System.out.println("Movimiento inválido. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    private void cambiarJugador() {
        if (jugadorActual == jugador1) {
            jugadorActual = jugador2;
        } else {
            jugadorActual = jugador1;
        }
    }
}

//Clase main donde se desarrolla todo el programa 
public class Main {
    public static void main(String[] args) {
    	//creacion de objetos 
        Triqui triqui = new Triqui("Natalia", "Santiago");
        triqui.jugar();
    }
}
