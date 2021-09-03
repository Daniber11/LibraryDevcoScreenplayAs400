package co.com.devco.automation.screenplay.as400.model;

public class Session {

    private String host;
    private int port;

    public Session(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static SessionBuilder withHost(String host) {
        return new SessionBuilder(host);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

}
