package testClases;


import page.HomeCalculadora;

public class PA03_Multiplicacion {

    public static String resultado = "500";

    public void p03_multiplicacion() throws Exception {
        HomeCalculadora homeCalculadora = new HomeCalculadora();
        homeCalculadora.multiplicacion();
        homeCalculadora.resultado(resultado);

    }


}
