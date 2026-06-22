/**
 * NginxServer - concrete Server implementation.
 * Demonstrates INHERITANCE (extends Server) and POLYMORPHISM
 * (different start/stop/restart behaviour than ApacheServer).
 */
public class NginxServer extends Server {

    public NginxServer() {
        super("Nginx Server");
    }

    @Override
    public void start() {
        status = "RUNNING";
        uptimeSeconds = 0;
        System.out.println("[NGINX] Server started successfully (event-driven mode).");
    }

    @Override
    public void stop() {
        status = "STOPPED";
        System.out.println("[NGINX] Server stopped.");
    }

    @Override
    public void restart() {
        System.out.println("[NGINX] Restarting...");
        stop();
        start();
    }
}
