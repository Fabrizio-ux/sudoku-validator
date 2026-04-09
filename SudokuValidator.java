public class SudokuValidator {

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        imprimirMatriz(sudoku);

        boolean filasValidas = validarFilas(sudoku);
        boolean columnasValidas = validarColumnas(sudoku);
        boolean bloquesValidos = validarBloques(sudoku);

        if (filasValidas && columnasValidas && bloquesValidos) {
            System.out.println("\nEl tablero de Sudoku es válido.");
        } else {
            System.out.println("\nEl tablero de Sudoku NO es válido.");
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("Tablero Sudoku:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean validarFilas(int[][] matriz) {
        boolean valido = true;

        for (int i = 0; i < 9; i++) {
            boolean[] vistos = new boolean[10];

            for (int j = 0; j < 9; j++) {
                int valor = matriz[i][j];

                if (valor < 1 || valor > 9) {
                    System.out.println("Error en fila " + (i + 1) + ": valor fuera de rango -> " + valor);
                    valido = false;
                } else if (vistos[valor]) {
                    System.out.println("Error en fila " + (i + 1) + ": número repetido -> " + valor);
                    valido = false;
                } else {
                    vistos[valor] = true;
                }
            }
        }

        return valido;
    }

    public static boolean validarColumnas(int[][] matriz) {
        boolean valido = true;

        for (int j = 0; j < 9; j++) {
            boolean[] vistos = new boolean[10];

            for (int i = 0; i < 9; i++) {
                int valor = matriz[i][j];

                if (valor < 1 || valor > 9) {
                    System.out.println("Error en columna " + (j + 1) + ": valor fuera de rango -> " + valor);
                    valido = false;
                } else if (vistos[valor]) {
                    System.out.println("Error en columna " + (j + 1) + ": número repetido -> " + valor);
                    valido = false;
                } else {
                    vistos[valor] = true;
                }
            }
        }

        return valido;
    }

    public static boolean validarBloques(int[][] matriz) {
        boolean valido = true;

        for (int filaInicio = 0; filaInicio < 9; filaInicio += 3) {
            for (int colInicio = 0; colInicio < 9; colInicio += 3) {
                boolean[] vistos = new boolean[10];

                for (int i = filaInicio; i < filaInicio + 3; i++) {
                    for (int j = colInicio; j < colInicio + 3; j++) {
                        int valor = matriz[i][j];

                        if (valor < 1 || valor > 9) {
                            System.out.println("Error en bloque (" + filaInicio + "," + colInicio + "): valor fuera de rango -> " + valor);
                            valido = false;
                        } else if (vistos[valor]) {
                            System.out.println("Error en bloque 3x3 que inicia en [" + filaInicio + "," + colInicio + "]: número repetido -> " + valor);
                            valido = false;
                        } else {
                            vistos[valor] = true;
                        }
                    }
                }
            }
        }

        return valido;
    }
}
