package testClases;


import driver.DriverContext;
import io.appium.java_client.android.AndroidDriver;
import page.HomeCalculadora;

public class PA06_Multiplicacion_fuera_de_rango {

    public static String resultadoiOS = "Error";
    public static String resultadoAndroid = "1.00000000E+300";

    public void pa06_multiplicacion_fuera_de_rango() throws Exception {
        HomeCalculadora homeCalculadora = new HomeCalculadora();
        homeCalculadora.calculoFueraDeRango();
        if (DriverContext.getDriver() instanceof AndroidDriver) {
            homeCalculadora.resultadoDivision(resultadoAndroid);
        }else{
            homeCalculadora.resultadoDivision(resultadoiOS);
        }
    }


}
