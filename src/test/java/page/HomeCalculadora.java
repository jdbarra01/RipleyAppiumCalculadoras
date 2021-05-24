package page;

import constants.Constants;
import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import static util.AccionesGenericas.*;

public class HomeCalculadora {
    public AppiumDriver driver;
    public int tiempo = 1;
    public int tiempoResultado = 3;


    public HomeCalculadora() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }


    @iOSXCUITFindBy(accessibility = "borrar")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Borrar']")
    private MobileElement btnClear;

    @iOSXCUITFindBy(accessibility = "Resultado")
    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/calc_edt_formula")
    private MobileElement textDisplay;

    @iOSXCUITFindBy(accessibility = "0")
    @AndroidFindBy(accessibility = "0")
    private MobileElement inputCero;

    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(accessibility = "1")
    private MobileElement inputUno;

    @iOSXCUITFindBy(accessibility = "2")
    @AndroidFindBy(accessibility = "2")
    private MobileElement inputDos;

    @iOSXCUITFindBy(accessibility = "3")
    @AndroidFindBy(accessibility = "3")
    private MobileElement inputTres;

    @iOSXCUITFindBy(accessibility = "4")
    @AndroidFindBy(accessibility = "4")
    private MobileElement inputCuatro;

    @iOSXCUITFindBy(accessibility = "5")
    @AndroidFindBy(accessibility = "5")
    private MobileElement inputCinco;

    @iOSXCUITFindBy(accessibility = "6")
    @AndroidFindBy(accessibility = "6")
    private MobileElement inputSeis;

    @iOSXCUITFindBy(accessibility = "7")
    @AndroidFindBy(accessibility = "7")
    private MobileElement inputSiete;

    @iOSXCUITFindBy(accessibility = "8")
    @AndroidFindBy(accessibility = "8")
    private MobileElement inputOcho;

    @iOSXCUITFindBy(accessibility = "9")
    @AndroidFindBy(accessibility = "9")
    private MobileElement inputNueve;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='sumar']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Más']")
    private MobileElement inputSuma;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='restar']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Menos']")
    private MobileElement inputRecta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='dividir']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='División']")
    private MobileElement inputDivide;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='multiplicar']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Multiplicación']")
    private MobileElement inputMultiplica;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='es igual a']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Igual']")
    private MobileElement inputIgual;


    @Step("Page Teclado: Operaciones basicas aritmética suma")
    public void suma() {
        System.out.println("Page Teclado: Inicio metodo suma");
        validaElementos();
        inputDos.click();
        inputCero.click();
        inputSuma.click();
        inputDos.click();
        inputCero.click();
        inputIgual.click();

        saveScreenshot("Page Teclado: Operaciones basicas aritmética suma", driver);

    }


    @Step("Page Teclado: Operaciones basicas aritmética recta")
    public void recta() {
        System.out.println("Page Teclado: Inicio metodo recta");
        validaElementos();
        inputUno.click();
        inputCero.click();
        inputCero.click();
        inputRecta.click();
        inputCinco.click();
        inputCero.click();
        inputIgual.click();
        saveScreenshot("Page Teclado: Operaciones basicas aritmética recta", driver);

    }

    @Step("Page Teclado: Operaciones basicas aritmética multiplicacion")
    public void multiplicacion() {
        System.out.println("Page Teclado: Inicio metodo multiplicacion");
        validaElementos();
        inputUno.click();
        inputCero.click();
        inputCero.click();
        inputMultiplica.click();
        inputCinco.click();
        inputCero.click();
        inputIgual.click();
        saveScreenshot("Page Teclado: Operaciones basicas aritmética multiplicacion", driver);

    }


    @Step("Page Teclado: Operaciones basicas aritmética division")
    public void division() {
        System.out.println("Page Teclado: Inicio metodo division");
        validaElementos();
        inputUno.click();
        inputCero.click();
        inputCero.click();
        inputCero.click();
        inputDivide.click();
        inputCinco.click();
        inputCero.click();
        inputCero.click();
        inputIgual.click();
        saveScreenshot("Page Teclado: Operaciones basicas aritmética division", driver);

    }
    @Step("Page Teclado: Operaciones no valida")
    public void divicionNoValida() {
        int nro;
        System.out.println("Page Teclado: Inicio metodo divicionNoValida");
        validaElementos();
        inputUno.click();
        for (nro = 1; nro < 5; nro++) {
            inputCero.click();
        }
        inputDivide.click();
        inputCero.click();
        inputIgual.click();
        saveScreenshot("Page Teclado: Operaciones no valida", driver);
    }

    @Step("Page Teclado: Operaciones no valida")
    public void calculoFueraDeRango() {
        int nro;
        System.out.println("Page Teclado: Inicio metodo calculoFueraDeRango");
        if (DriverContext.getDriver() instanceof AndroidDriver) {
            validaElementos();

            for (nro = 1; nro < 16; nro++) {
                inputNueve.click();
            }
            inputMultiplica.click();
            for (nro = 1; nro < 16; nro++) {
                inputNueve.click();
            }
            for (nro = 1; nro < 21; nro++) {
                inputIgual.click();
            }

        } else {

            validaElementos();
            for (nro = 1; nro < 9; nro++) {
                inputNueve.click();
            }
            inputMultiplica.click();
            for (nro = 1; nro < 9; nro++) {
                inputNueve.click();
            }
            for (nro = 1; nro < 18; nro++) {
                inputIgual.click();
            }
        }
        saveScreenshot("Page Teclado: Operaciones no valida", driver);
    }


    @Step("Page Teclado: Resultado esperados")
    public void resultado(String valor) {
        System.out.println("Page Teclado: Inicio metodo Valida elementos resultados");
        validarElemento(textDisplay, valor, tiempoResultado);
        saveScreenshot("Page Teclado: Resultado esperados", driver);
    }

    @Step("Page Teclado: Resultado esperados")
    public void resultadoDivision(String valor) {
        System.out.println("Page Teclado: Inicio metodo Valida elementos resultados");
        validarElemento(textDisplay, valor, tiempoResultado);
        saveScreenshot("Page Teclado: Resultado esperados", driver);
    }


    public void validaElementos() {
        System.out.println("Page Teclado: Inicio metodo Valida elementos");
        visualizarObjeto(inputCero, tiempo);
        visualizarObjeto(inputDos, tiempo);
        visualizarObjeto(inputTres, tiempo);
        visualizarObjeto(inputCuatro, tiempo);
        visualizarObjeto(inputCinco, tiempo);
        visualizarObjeto(inputSeis, tiempo);
        visualizarObjeto(inputSiete, tiempo);
        visualizarObjeto(inputOcho, tiempo);
        visualizarObjeto(inputNueve, tiempo);
        visualizarObjeto(inputSuma, tiempo);
        visualizarObjeto(inputRecta, tiempo);
        visualizarObjeto(inputMultiplica, tiempo);
        visualizarObjeto(inputDivide, tiempo);
        visualizarObjeto(inputIgual, tiempo);


    }
}