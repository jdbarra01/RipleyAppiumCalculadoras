# RipleyAppiumCalculadoras
Prueba Appium calculadoras samsung android y calculadora iOS

Proyecto realizado en appium, con TestNG, libreria de reporte utilizada Allure report, gestor de dependencias gradle

Características 
Las pruebas para la aplicación móvil Native Android Calculator están escritas en Java usando Appium.


Cómo configurar el entorno para ejecutar pruebas
Herramientas y SDK de Android 
Node.js 
Servidor de Appium

Todas las rutas de las bibliotecas deben agregarse a PATHla variable de entorno del sistema y a ~/.bash_profile(para sistemas Unix):

ANDROID_HOME
APPIUM_HOME
NODE_HOME

Archivo de congiguracion de dispositivos en appium server:

{
  "deviceName": "iPhone de Qa",
  "platformName": "iOS",
  "automationName": "XCUITest",
  "platformVersion": "14.4",
  "udid": "a0b766ff1960610ca57681b54c769b96a3ea2d15",
  "bundleId": "com.apple.calculator"
}


{
  "deviceName": "Galaxy S9+",
  "udid": "4845374d4b363098",
  "platformName": "Android",
  "appPackage": "uno.platform.calculator",
  "appActivity": "crc6475c7b1887409e297.MainActivity"
}
