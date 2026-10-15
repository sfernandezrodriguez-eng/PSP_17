public class ContadorCaracteres {
    static int total = 0;

    static class Contador extends Thread {
        private String texto;
        private char consonante;
        private int contador = 0;

        public Contador(String texto, char consonante) {
            this.texto = texto;
            this.consonante = consonante;
        }

        @Override
        public void run() {

            for (int i = 0; i < texto.length(); i++) {
                if (Character.toLowerCase(texto.charAt(i)) == Character.toLowerCase(consonante)) {
                    contador++;
                }
            }

            synchronized (ContadorCaracteres.class) {
                total += contador;
            }

            System.out.println("Total de apariciones de " + consonante + ": " + contador + " veces");
        }
    }

    }

