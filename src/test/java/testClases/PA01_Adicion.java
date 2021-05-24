package testClases;


import page.HomeCalculadora;

public class PA01_Adicion {

    public static String resultado = "40";

    public void pa01_adicion() throws Exception {
        HomeCalculadora homeCalculadora = new HomeCalculadora();
        homeCalculadora.suma();
        homeCalculadora.resultado(resultado);

    }


}
