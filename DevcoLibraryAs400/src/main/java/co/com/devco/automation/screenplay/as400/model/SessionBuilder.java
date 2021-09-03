package co.com.devco.automation.screenplay.as400.model;

public class SessionBuilder {

    private String host;

    public SessionBuilder(String host) {
        this.host = host;
    }

    public Session andPort(int port) {
        return new Session(this.host, port);
    }

}
