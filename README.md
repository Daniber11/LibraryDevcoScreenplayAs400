  <p align='center'>
    <img src='https://user-images.githubusercontent.com/77740619/131050720-d5d4dcce-5f45-4616-812f-63b24bc02bfe.png'>
    <h3 align='center'>Devco</h3>
    <h3 align='center'>Libreria Screenplay AS400</h3>
  <p>

  ___

  > Esta libreria nos permitira interactuar con sistemas AS400 implementando serenity bdd con java.

  Nos proporciona un conjunto de interacciones las cuales, permitirán generar artefactos de pruebas automáticas de manera sencilla con un sistema AS400.

  Como librería nos permitirá eliminar la dependencia de un sistema de emulación de sesiones AS400 dado que la misma realizará la conexión e interacción mediante telnet.

  ### Construido con 🔨

  * librerías serenityBDD java
  * librería xtn5250 Versión: 2.2
  * librería dm3270-lib Versión: 0.9.1

  ## Empezando 🚀

  Mediante los siguientes pasos podremos hacer uso de esta librería en nuestros proyectos de automatización para sistemas AS400.

  ### Prerrequisitos 📋

   * Java JDK 11

  ### Instalación 🔧

  <br>

  ## Como se usa ⚙️

  Dado que existen dos tipos de terminales AS400 3270 y 5250. dentro de la librería tendremos la siguiente estructura de paquetes que nos separan las funcionalidades para cada uno de estas terminales.

 ```
  Terminal 5250 > co.com.devco.automation.screenplay.as400.screen5250

  Terminal 3270 > co.com.devco.automation.screenplay.as400.screen3270
 ```

 ### Interactions

  Dentro de estos paquetes tendremos deferentes interacciones que nos permitirás de manera sencilla interactuar con nuestra terminal AS400 ya sea 5250 o 3270
  
  <br>
  
  1. Inicio de conexión con terminal
  
  * OpenScreen5250
  ```
  OpenScreen5250.session(Session)
  ```
  
  * OpenScreen3270
  
  ```
  OpenScreen3270.session(Session)
  ```
  
  >Nota: tanto para la sesión con la terminal 5250 y la 3270. El método session utiliza como variable de entrada un objeto tipo Session dicho objeto podrá ser creado de la       siguiente manera 
  
  ```
  Session.withHost(String).andPort(Integer)  
  ```
  
  <br>

  2. Ingresar valor en campo editable
  
  En este caso tanto para ambas terminales la interacción se invoca de la misma manera solo que cada uno se encuentra ubicada en el paquete correspondiente a la terminal que se esté trabajando
  
 ```
  Enter.theValue(String).into(Target)
 ```
  
  >Nota: ver creación de objeto tipo Target
  
  <br>
  
  3. Oprimir Tecla o envió de caracteres
  
  Al igual que el Enter para esta interacción para las dos terminales se maneja de la misma manera, pero cada uno se encuentra en su respectivo paquete de la terminal que se esté usando
  
  * Terminar 5250
  
  ```
  Hit.the(KeysScreen5250)
  Hit.the(String)
  ```
  
  * Terminal 3270
  
  ```
  Hit.the(KeysScreen3270)
  Hit.the(String)
  ```
  
  >Nota: ver las teclas existentes para la terminal 5250 o 3270.
  
  <br>
  
  ### Questions
  
  Dentro de los respectivos paquetes de cada terminal tendremos una forma de obtener texto al momento de realizar la prueba e interactuar con el sistema
  
  ```
   Text.of(Target)
  ```

  > :warning: El target es necesario que al momento de declarar la forma en la que será ubicado este debe ser mediante **coordenadas** mas no por etiqueta.
  
  <br>
  
  ### Target
  
  Al igual que en las automatizaciones para páginas web o aplicaciones móviles al momento de querer interactuar con nuestra terminal tendremos que indicarle a nuestra prueba     con que elemento queremos interactuar para esto tenemos nuestro propio modo de generar nuestros Target donde podremos indicar si queremos usarlos mediante etiqueta o         coordenadas.
  
> Nota:  :warning: Se debe tener precaución de que el Target utilizado sea el correspondiente a la librería y no a serenityBDD.
  
  
  Este target lo podremos crear de la siguiente manera
 
  * Etiqueta
  
  ```
    Targetelemento = Target.the(String).locatedByTag(String)
  ```
  
  * Coordenadas
  
  ```
    Target elemento = Target.the(String).locatedByCoordinate(Coordinate)
  ```
    
> Nota: Este modo de creación de target es el usado cuando es necesario obtener un texto de la terminal dado que este nos permite indicar la posición de la final y columna inicial además de la longitud del campo o texto a tomar.
  
  ```
    Coordinate.withRow(Integer).withInitialColumn(Integer).andLenght(Integer)
  ```
  
    
  
