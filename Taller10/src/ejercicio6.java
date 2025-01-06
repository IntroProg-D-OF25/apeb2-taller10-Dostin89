
import java.util.Scanner;

/***
 * Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3. 
 * Permita a dos jugadores marcar sus movimientos alternativamente. 
 * El juego debe verificar si alguno de los jugadores ha ganado o si hay un empate.
 */
public class ejercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char[][] tablero = new char[3][3];

        // Inicializar tablero vacío
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                tablero[fila][col] = '-';
            }
        }

        System.out.println("--- Tres en Raya ---");
        System.out.println("Jugador 1: X");
        System.out.println("Jugador 2: O");

        boolean ganador = false;
        boolean empate = false;
        char turno = 'X';

        while (!ganador && !empate) {
            // Mostrar tablero
            System.out.println("\nTablero actual:");
            for (int fila = 0; fila < 3; fila++) {
                for (int col = 0; col < 3; col++) {
                    System.out.print(tablero[fila][col] + " ");
                }
                System.out.println();
            }

            System.out.println("Turno del jugador " + (turno == 'X' ? "1 (X)" : "2 (O)"));
            System.out.print("Ingresa la fila (0, 1, 2): ");
            int fila = entrada.nextInt();
            System.out.print("Ingresa la columna (0, 1, 2): ");
            int col = entrada.nextInt();

            // Validar movimiento
            if (fila >= 0 && fila < 3 && col >= 0 && col < 3 && tablero[fila][col] == '-') {
                tablero[fila][col] = turno;

                // Verificar si hay un ganador
                for (int i = 0; i < 3; i++) {
                    if ((tablero[i][0] == turno && tablero[i][1] == turno && tablero[i][2] == turno) ||
                        (tablero[0][i] == turno && tablero[1][i] == turno && tablero[2][i] == turno)) {
                        ganador = true;
                        break;
                    }
                }
                if ((tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) ||
                    (tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno)) {
                    ganador = true;
                }

                // Verificar empate
                empate = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (tablero[i][j] == '-') {
                            empate = false;
                            break;
                        }
                    }
                    if (!empate) break;
                }

                // Cambiar turno si no hay ganador
                if (!ganador) {
                    turno = (turno == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }

        // Mostrar tablero final
        System.out.println("\nTablero final:");
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(tablero[fila][col] + " ");
            }
            System.out.println();
        }

        // Anunciar el resultado
        if (ganador) {
            System.out.println("¡El jugador " + (turno == 'X' ? "1 (X)" : "2 (O)") + " ha ganado!");
        } else if (empate) {
            System.out.println("¡Es un empate!");
        }
    }
}

/***
 * --- Tres en Raya ---
Jugador 1: X
Jugador 2: O

Tablero actual:
- - - 
- - - 
- - - 
Turno del jugador 1 (X)
Ingresa la fila (0, 1, 2): 0
Ingresa la columna (0, 1, 2): 1

Tablero actual:
- X - 
- - - 
- - - 
Turno del jugador 2 (O)
Ingresa la fila (0, 1, 2): 0
Ingresa la columna (0, 1, 2): 2

Tablero actual:
- X O 
- - - 
- - - 
Turno del jugador 1 (X)
Ingresa la fila (0, 1, 2): 0
Ingresa la columna (0, 1, 2): 0

Tablero actual:
X X O 
- - - 
- - - 
Turno del jugador 2 (O)
Ingresa la fila (0, 1, 2): 1
Ingresa la columna (0, 1, 2): 1

Tablero actual:
X X O 
- O - 
- - - 
Turno del jugador 1 (X)
Ingresa la fila (0, 1, 2): 1
Ingresa la columna (0, 1, 2): 2

Tablero actual:
X X O 
- O X 
- - - 
Turno del jugador 2 (O)
Ingresa la fila (0, 1, 2): 2
Ingresa la columna (0, 1, 2): 1

Tablero actual:
X X O 
- O X 
- O - 
Turno del jugador 1 (X)
Ingresa la fila (0, 1, 2): 2
Ingresa la columna (0, 1, 2): 2

Tablero actual:
X X O 
- O X 
- O X 
Turno del jugador 2 (O)
Ingresa la fila (0, 1, 2): 1
Ingresa la columna (0, 1, 2): 0

Tablero actual:
X X O 
O O X 
- O X 
Turno del jugador 1 (X)
Ingresa la fila (0, 1, 2): 2
Ingresa la columna (0, 1, 2): 0

Tablero final:
X X O 
O O X 
X O X 
�Es un empate!
 */



