/**
 * Main - entry point that demonstrates the full Web Server Management
 * System workflow: Login -> Dashboard -> Server Control / Monitoring ->
 * Log Management -> Configuration -> Logout.
 *
 * Polymorphism is shown by storing ApacheServer and NginxServer objects
 * in a single Server[] array and calling start()/stop()/restart() on
 * each without knowing the exact subclass.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("===== WEB SERVER MANAGEMENT SYSTEM =====\n");

        LogManager logManager = new LogManager();
        Configuration config = new Configuration();
        ResourceMonitor monitor = new ResourceMonitor();
        User admin = new User("admin", "admin123");

        // ---- LOGIN MODULE ----
        boolean loginSuccess = admin.login("admin", "admin123");
        if (!loginSuccess) {
            return;
        }
        logManager.addLog("Admin logged in.");

        // ---- DASHBOARD -> SERVER CONTROL MODULE (Polymorphism) ----
        Server[] servers = { new ApacheServer(), new NginxServer() };

        System.out.println("\n--- Starting Servers ---");
        for (Server server : servers) {
            server.start();
            logManager.addLog(server.getServerName() + " started.");
        }

        // ---- SERVER MONITORING MODULE ----
        System.out.println("\n--- Resource Monitoring ---");
        monitor.monitorCPU();
        monitor.monitorMemory();
        monitor.monitorDisk();
        monitor.monitorNetwork();

        System.out.println("\n--- Health Checks ---");
        for (Server server : servers) {
            server.healthCheck();
        }

        // ---- CONFIGURATION MODULE ----
        System.out.println("\n--- Configuration ---");
        config.updateConfig("port", "9090");
        config.updateConfig("maxConnections", "200");
        config.saveConfig();

        // ---- SERVER CONTROL: restart one server (Polymorphism demo) ----
        System.out.println("\n--- Restarting Apache Server ---");
        servers[0].restart();
        logManager.addLog(servers[0].getServerName() + " restarted.");

        // ---- STOP ALL SERVERS ----
        System.out.println("\n--- Stopping Servers ---");
        for (Server server : servers) {
            server.stop();
            logManager.addLog(server.getServerName() + " stopped.");
        }

        // ---- LOG MANAGEMENT MODULE ----
        System.out.println();
        logManager.displayLogs();

        System.out.println("\n--- Searching logs for 'Nginx' ---");
        for (String log : logManager.searchLogs("Nginx")) {
            System.out.println(log);
        }

        // ---- LOGOUT ----
        System.out.println();
        admin.logout();
    }
}
