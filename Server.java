
public abstract class Server {

    protected String serverName;
    protected String status;   
    protected long uptimeSeconds;

    public Server(String serverName) {
        this.serverName = serverName;
        this.status = "STOPPED";
        this.uptimeSeconds = 0;
    }

    
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

    
    public void healthCheck() {
        System.out.println("[HEALTH CHECK] " + serverName + " -> Status: " + status
                + " | Uptime: " + uptimeSeconds + "s");
    }
}
