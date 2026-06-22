
public class ApacheServer extends Server {

    public ApacheServer() {
        super("Apache Server");
    }

    @Override
    public void start() {
        status = "RUNNING";
        uptimeSeconds = 0;
        System.out.println("[APACHE] Server started successfully on default port.");
    }

    @Override
    public void stop() {
        status = "STOPPED";
        System.out.println("[APACHE] Server stopped.");
    }

    @Override
    public void restart() {
        System.out.println("[APACHE] Restarting...");
        stop();
        start();
    }
}
