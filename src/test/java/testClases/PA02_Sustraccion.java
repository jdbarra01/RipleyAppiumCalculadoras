package testClases;


import page.HomeCalculadora;

public class PA02_Sustraccion {

    public static String resultado = "50";

    public void pa02_sustraccion() throws Exception {
        HomeCalculadora homeCalculadora = new HomeCalculadora();
        homeCalculadora.recta();
        homeCalculadora.resultado(resultado);

    }


}
