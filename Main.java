import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.println("===== WEB SERVER MANAGEMENT SYSTEM =====\n");

        
        Scanner scanner = new Scanner(System.in);

        LogManager    logManager = new LogManager();
        Configuration config     = new Configuration();
        ResourceMonitor monitor  = new ResourceMonitor();
        User          admin      = new User("admin", "admin123");
        CMSConnector  cms        = new CMSConnector();

      
        cms.inputDetails(scanner);   
        cms.connect();               
        cms.displayStatus();         
        logManager.addLog("CMS connected: " + cms.getCmsLink()
                          + " | user: " + cms.getCmsUsername());

        
        System.out.println("\n===== LOGIN =====");
        boolean loginSuccess = admin.login("admin", "admin123");
        if (!loginSuccess) {
            cms.disconnect();
            scanner.close();
            return;
        }
        logManager.addLog("Admin logged in.");

        
        Server[] servers = { new ApacheServer(), new NginxServer() };

        System.out.println("\n--- Starting Servers ---");
        for (Server server : servers) {
            server.start();
            logManager.addLog(server.getServerName() + " started.");
        }

        
        System.out.println("\n--- Resource Monitoring ---");
        monitor.monitorCPU();
        monitor.monitorMemory();
        monitor.monitorDisk();
        monitor.monitorNetwork();

        System.out.println("\n--- Health Checks ---");
        for (Server server : servers) {
            server.healthCheck();
        }

        
        System.out.println("\n--- Configuration ---");
        config.updateConfig("port", "9090");
        config.updateConfig("maxConnections", "200");
        config.saveConfig();

        
        System.out.println("\n--- Restarting Apache Server ---");
        servers[0].restart();
        logManager.addLog(servers[0].getServerName() + " restarted.");

        
        System.out.println("\n--- Stopping Servers ---");
        for (Server server : servers) {
            server.stop();
            logManager.addLog(server.getServerName() + " stopped.");
        }

        
        System.out.println();
        logManager.displayLogs();

        System.out.println("\n--- Searching logs for 'Nginx' ---");
        for (String log : logManager.searchLogs("Nginx")) {
            System.out.println(log);
        }

        
        System.out.println();
        admin.logout();
        cms.disconnect();
        logManager.addLog("CMS disconnected.");

        scanner.close();
    }
}