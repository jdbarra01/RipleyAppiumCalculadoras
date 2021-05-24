package testClases;


import page.HomeCalculadora;

public class PA04_Division {

    public static String resultado = "2";

    public void p04_division() throws Exception {
        HomeCalculadora homeCalculadora = new HomeCalculadora();
        homeCalculadora.division();
        homeCalculadora.resultado(resultado);

    }


}
