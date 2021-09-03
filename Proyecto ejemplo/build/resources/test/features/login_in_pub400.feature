#Author: guseche@devco.com.co

  Feature: login in terminal pub400

    Scenario: succesfull login in server as400 pub400
      When make the process login in the terminal pub400
      Then the login process was successful
