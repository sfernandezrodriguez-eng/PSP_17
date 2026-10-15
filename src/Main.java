
public static void main(String[] args) throws InterruptedException, FileNotFoundException {

    Scanner teclado = new Scanner(System.in);
    Scanner fichero = new Scanner(new File("src/Lorem_Ipsum.txt"));
    String texto = "";

    while (fichero.hasNextLine()) {

        texto += fichero.nextLine() + "\n";
    }

    fichero.close();

    texto = texto.repeat(2000);

    ContadorCaracteres.Contador[] hilos = new ContadorCaracteres.Contador[5];

    char[] consonantes = new char[5];

    for (int i = 0; i < 5; i++) {
        System.out.print("Introduce la consonante " + (i + 1) + ": ");
        String letra = teclado.next();

        if (letra.length() == 1 && Character.isLetter(letra.charAt(0)) && !"aAeEiIoOuU".contains(letra)) {
            consonantes[i] = letra.charAt(0);

        } else {
            System.out.println("Caracter incorrecto, porfavor escribe una consonante.");
            i--;
        }
    }



    for (int i = 0; i < 5; i++) {

        hilos[i] = new ContadorCaracteres.Contador(texto, consonantes[i]);

        hilos[i].start();
    }

    for (int i = 0; i < 5; i++) {
        hilos[i].join();
    }

    System.out.println("Total de apariciones: " + ContadorCaracteres.total);


    teclado.close();
}



