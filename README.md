# proyecto-bdd

## Paquetes Utilizados

Este proyecto utiliza varios paquetes de Maven para facilitar las pruebas BDD (Behavior-Driven Development) y la automatización del navegador. A continuación se describe cada uno de los paquetes principales:

- **Cucumber:**
  - `cucumber-java`: Es la implementación principal de Cucumber para Java. Permite escribir los pasos de las pruebas en archivos `.feature` y luego implementarlos en código Java.
  - `cucumber-junit`: Facilita la ejecución de las pruebas de Cucumber utilizando el framework JUnit. Actúa como un puente entre Cucumber y JUnit, permitiendo que los tests se ejecuten como si fueran pruebas de JUnit estándar.

- **JUnit:**
  - `junit`: Es un framework de pruebas unitarias para Java. Se utiliza aquí para correr las pruebas de Cucumber y para realizar aserciones dentro de los pasos de prueba.

- **WebDriverManager:**
  - `webdrivermanager`: Simplifica la gestión de los drivers de los navegadores (como ChromeDriver, GeckoDriver, etc.). Automáticamente descarga y configura el driver necesario para la versión del navegador instalada en la máquina, evitando la necesidad de gestionarlos manualmente.

- **Selenium:**
  - `selenium-java`: Es la biblioteca principal para la automatización de navegadores. Proporciona una API para controlar el comportamiento de los navegadores web, permitiendo simular interacciones del usuario como hacer clic en botones, llenar formularios y navegar entre páginas.