  <p align='center'>
    <img src='https://user-images.githubusercontent.com/77740619/131050720-d5d4dcce-5f45-4616-812f-63b24bc02bfe.png'>
    <h3 align='center'>Devco</h3>
    <h3 align='center'>Libreria Screenplay AS400</h3>
  <p>

  ___

  > Esta libreria nos permitira interactuar con sistemas AS400 implementando serenity bdd con java.

  Nos proporciona un conjunto de interacciones las cuales, permitiran generar artefactos de pruebas automaticas de manera sencilla con un sistema AS400.

  Como libreria nos permitira eliminar la dependencia de un sistema de emulasion de sesiones AS400 dado que la misma realizara la conexion e interaccion mediante telnel.

  ### Construido con 🔨

  * Librerias serenityBDD java
  * Libreria xtn5250 Versión: 2.2
  * Libreria dm3270-lib Versión: 0.9.1

  ## Empezando 🚀

  Mediante los siguientes pasos podremos hacer uso de esta libreria en nuestros proyectos de automatizacion para sistemas AS400.

  ### Pre-requisitos 📋

   * Java JDK 11

  ### Instalación 🔧

  <br>

  ## Como se usa ⚙️

  Dado que existen dos tipos de terminales AS400 3270 y 5250. dentro de la libreria tendremos la siguiente estructura de paquetes que nos separan las funcionalidades para cada uno de estas terminales.

 ```
  Terminal 5250 > co.com.devco.automation.screenplay.as400.screen5250

  Terminal 3270 > co.com.devco.automation.screenplay.as400.screen3270
 ```


  Dentro de estos paquetes tendremos deferentes interacciones que nos pemitiras de manera sencilla interactual con nuestra termininal AS400 ya sea 5250 o 3270
  
  1. Inicio de conexion con terminal
  
  * OpenScreen5250
  ```
  OpenScreen5250.session(Session)
  ```
  
  * OpenScreen3270
  
  ```
  OpenScreen3270.session(Session)
  ```
  
  >Nota: tanto para la sesion con la terminal 5250 y la 3270. El metodo session utiliza como variable de entrada un objeto tipo Session dicho objeto podra ser creado de la       siguente manera 
  
  ```
  Session.withHost(String).andPort(Integer)  
  ```
  
  2. Ingresar valor en campo editable
  
  En este caso tanto para ambas terminales la interacción se invoca de la misma manera solo que cada uno se encuentra ubicada en el paquete correspondiente a la terminal que se este trabajando
  
 ```
  Enter.theValue(String).into(Target)
 ```
  
  >Nota: ver creacion de objeto tipo Target
  
