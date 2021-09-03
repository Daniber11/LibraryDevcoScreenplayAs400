package co.com.devco.example.as400.userinterfaces;

import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;

public class login {

    public static final Target USUARIO =  Target.the("Usuario").locatedByCoordinate(Coordinate.withRow(5).withInitialColumn(25).andLenght(1));
    public static final Target CLAVE =  Target.the("Clave").locatedByTag("Password");
    public static final Target MENSAJE =  Target.the("Mensaje estado de conexion").locatedByCoordinate(Coordinate.withRow(24).withInitialColumn(1).andLenght(38));

}
