/**
 * Server class - abstract base class representing a generic web server.
 * Demonstrates ABSTRACTION: complex server operations are hidden behind
 * simple methods like start(), stop(), restart().
 * Subclasses (ApacheServer, NginxServer) provide INHERITANCE and POLYMORPHISM.
 */
public abstract class Server {

    protected String serverName;
    protected String status;   // "RUNNING" or "STOPPED"
    protected long uptimeSeconds;

    public Server(String serverName) {
        this.serverName = serverName;
        this.status = "STOPPED";
        this.uptimeSeconds = 0;
    }

    // Abstract methods -> each subclass implements its own behaviour (Polymorphism)
    public abstract void start();
    public abstract void stop();
    public abstract void restart();

    public String getServerName() {
        return serverName;
    }

    public String getStatus() {
        return status;
    }

    public long getUptime() {
        return uptimeSeconds;
    }

    /**
     * Simple health check shared by all server types.
     */
    public void healthCheck() {
        System.out.println("[HEALTH CHECK] " + serverName + " -> Status: " + status
                + " | Uptime: " + uptimeSeconds + "s");
    }
}
