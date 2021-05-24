package util;

import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccionesGenericas {



    public static boolean existeElemento(MobileElement objeto, int segundos) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), (long) segundos);
            wait.until(ExpectedConditions.visibilityOf(objeto));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }


    public static void validarElemento(MobileElement elemento, String textoAValidar, int segundos) {
        try {
            boolean existe = existeElemento(elemento, segundos);
            if (existe) {
                System.out.println("Se encuentra el elemnto" + elemento);
                if (elemento.getText().trim().equals(textoAValidar.trim())) {
                    Assert.assertTrue(true ,"Se visualiza el resultado esperado: "+ elemento.getText());
                } else {
                    Assert.fail("NO se visualiza el resultado esperado" + textoAValidar );
                }
            } else {
                System.out.println("No se encuentra el elemento" + elemento);
                throw new Error("No se encuentra el elemento" + elemento);
            }
        } catch (Exception var3) {
        }
    }


    public static boolean visualizarObjeto(MobileElement objeto, int segundos) {
        try {
            System.out.println("Buscamos el objeto:" + objeto + ", esperamos " + segundos + " segundos, hasta que aparezca.");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(objeto));
            System.out.println("Se encontró objeto:" + objeto + ", se retorna true.");
            return true;
        } catch (Exception e) {
            System.out.println("No se encontró objeto:" + objeto + ", se retorna false.");
            return false;
        }
    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public static byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
