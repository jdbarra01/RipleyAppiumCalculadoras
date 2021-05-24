package testSuites.ios;

import constants.OS;
import driver.DriverContext;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.*;


public class Test_iOS {

    @BeforeMethod
    public void setUp() {
        DriverContext.setUp(OS.IOS, "a0b766ff1960610ca57681b54c769b96a3ea2d15", "iPhone de Qa", false, "");
    }

    @AfterMethod
    public void tearDown() {
        DriverContext.quitDriver();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida operaciones aritmética adición")
    public void PA01_IOS() throws Exception {
        PA01_Adicion pa01_adicion = new PA01_Adicion();
        pa01_adicion.pa01_adicion();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida operaciones aritmética sustracción")
    public void PA02_IOS() throws Exception {
        PA02_Sustraccion pa02_sustraccion = new PA02_Sustraccion();
        pa02_sustraccion.pa02_sustraccion();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida operaciones aritmética multiplicacion")
    public void PA03_IOS() throws Exception {
        PA03_Multiplicacion pa03_multiplicacion = new PA03_Multiplicacion();
        pa03_multiplicacion.p03_multiplicacion();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida operaciones aritmética division")
    public void PA04_IOS() throws Exception {
        PA04_Division pa04_division = new PA04_Division();
        pa04_division.p04_division();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Operacion no valida")
    public void PA05_IOS() throws Exception {
        PA05_Division_no_valida pa05_division_no_valida = new PA05_Division_no_valida();
        pa05_division_no_valida.pa05_division_no_valida();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Multiplicacion fuera de rango")
    public void PA06_IOS() throws Exception {
        PA06_Multiplicacion_fuera_de_rango pa06_multiplicacion_fuera_de_rango = new PA06_Multiplicacion_fuera_de_rango();
        pa06_multiplicacion_fuera_de_rango.pa06_multiplicacion_fuera_de_rango();
    }


}