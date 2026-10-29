package Clase11;

public class Tema1_Ej1 {

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
    }

    public static void main(String[] args) {
        ListaEstatica l1 = new ListaEstatica(5);

        l1.insertar(10);
        l1.insertar(20);
        l1.insertar(50);
        l1.insertar(100);
        l1.insertar(80);

        System.out.print("Lista: ");
        l1.mostrar();

        System.out.println("Buscar 50 (existe): " + l1.buscar(50));
        System.out.println("Buscar 30 (no existe): " + l1.buscar(30));

        System.out.println("Insertar 52 con la lista llena:");
        try {
            l1.insertar(52);
        } catch (IllegalStateException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }
}
