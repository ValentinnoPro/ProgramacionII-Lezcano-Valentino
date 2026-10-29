package Clase11;

public class Tema1_Ej2 {

    static class ListaEstatica {

        private int[] datos;
        private int cantidad;

        public ListaEstatica(int capacidad) {
            this.cantidad = 0;
            this.datos = new int[capacidad];
        }

        public void insertar(int valor) {
            if (this.datos.length == this.cantidad) {
                throw new IllegalStateException("La lista esta llena");
            }

            this.datos[this.cantidad] = valor;
            this.cantidad += 1;
        }

        public int buscar(int valor) {
            for (int i = 0; i < this.cantidad; i++) {
                if (this.datos[i] == valor) {
                    return i;
                }
            }

            return -1;
        }

        public void mostrar() {
            System.out.print("[");

            for (int i = 0; i < this.cantidad; i++) {
                System.out.print(this.datos[i]);

                if (i < this.cantidad - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }

        // Inserta desplazando hacia la derecha desde indice (se recorre de derecha a izquierda).
        public void insertarEnPosicion(int indice, int valor) {
            if (datos.length == cantidad) {
                throw new IllegalStateException("Lista llena.");
            } else if (indice < 0 || indice > cantidad) {
                throw new IndexOutOfBoundsException("La lista debe ser contigua.");
            }

            for (int i = cantidad; i > indice; i--) {
                datos[i] = datos[i - 1];
            }
            datos[indice] = valor;
            cantidad += 1;
        }

        // Elimina desplazando hacia la izquierda (se recorre de izquierda a derecha).
        public void eliminarEnPosicion(int indice) {
            if (indice < 0 || indice >= cantidad) {
                throw new IndexOutOfBoundsException("Indice incorrecto. Intenta nuevamente.");
            }

            for (int i = indice; i < cantidad - 1; i++) {
                datos[i] = datos[i + 1];
            }
            cantidad -= 1;
        }
    }

    public static void main(String[] args) {
        ListaEstatica l1 = new ListaEstatica(6);

        l1.insertar(20);
        l1.insertar(40);
        System.out.print("Lista inicial: ");
        l1.mostrar();

        l1.insertarEnPosicion(0, 10);
        System.out.print("Insertar 10 al principio (0): ");
        l1.mostrar();

        l1.insertarEnPosicion(2, 30);
        System.out.print("Insertar 30 en el medio (2): ");
        l1.mostrar();

        l1.insertarEnPosicion(4, 50);
        System.out.print("Insertar 50 al final (4): ");
        l1.mostrar();

        System.out.println("Insertar en indice 9:");
        try {
            l1.insertarEnPosicion(9, 99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        l1.eliminarEnPosicion(0);
        System.out.print("Eliminar el primero (0): ");
        l1.mostrar();

        l1.eliminarEnPosicion(1);
        System.out.print("Eliminar del medio (1): ");
        l1.mostrar();

        l1.eliminarEnPosicion(2);
        System.out.print("Eliminar el ultimo (2): ");
        l1.mostrar();

        System.out.println("Eliminar en indice 2 (ya no existe):");
        try {
            l1.eliminarEnPosicion(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println("Eliminar en indice -1:");
        try {
            l1.eliminarEnPosicion(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }
}
