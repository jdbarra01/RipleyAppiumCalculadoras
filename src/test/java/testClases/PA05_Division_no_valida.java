package testClases;


import driver.DriverContext;
import io.appium.java_client.android.AndroidDriver;
import page.HomeCalculadora;

public class PA05_Division_no_valida {

    public static String resultadoiOS = "Error";
    public static String resultadoAndroid = "";

    public void pa05_division_no_valida() throws Exception {
        HomeCalculadora homeCalculadora = new HomeCalculadora();
        homeCalculadora.divicionNoValida();
        if (DriverContext.getDriver() instanceof AndroidDriver) {
            homeCalculadora.resultadoDivision(resultadoAndroid);
        }else{
            homeCalculadora.resultadoDivision(resultadoiOS);
        }
    }


}
