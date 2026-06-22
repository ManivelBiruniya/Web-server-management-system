import java.util.Scanner;

public class CMSConnector {

    private String cmsLink;
    private String cmsUsername;
    private boolean connected;

    public CMSConnector() {
        this.cmsLink     = "";
        this.cmsUsername = "";
        this.connected   = false;
    }

    
     
    public void inputDetails(Scanner scanner) {
        System.out.println("\n===== CMS CONNECTION SETUP =====");

        // --- CMS Link ---
        System.out.print("Enter CMS System Link (URL): ");
        String link = scanner.nextLine().trim();

        if (link.isEmpty()) {
            System.out.println("[CMS] Error: CMS link cannot be empty.");
            return;
        }

        
        if (!link.startsWith("http://") && !link.startsWith("https://")) {
            System.out.println("[CMS] Warning: URL should start with http:// or https://");
            System.out.print("Continue anyway? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();
            if (!confirm.equals("yes") && !confirm.equals("y")) {
                System.out.println("[CMS] Connection setup cancelled.");
                return;
            }
        }

       
        System.out.print("Enter CMS Username       : ");
        String uname = scanner.nextLine().trim();

        if (uname.isEmpty()) {
            System.out.println("[CMS] Error: Username cannot be empty.");
            return;
        }

        this.cmsLink     = link;
        this.cmsUsername = uname;

        System.out.println("[CMS] Details captured successfully.");
    }

    
    public void connect() {
        if (cmsLink.isEmpty() || cmsUsername.isEmpty()) {
            System.out.println("[CMS] Cannot connect: link or username not set.");
            return;
        }

        System.out.println("\n[CMS] Attempting connection...");
        System.out.println("      URL      : " + cmsLink);
        System.out.println("      Username : " + cmsUsername);

        
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        
        connected = true;
        System.out.println("[CMS] Connected successfully to " + cmsLink);
    }

    
    public void disconnect() {
        if (connected) {
            connected = false;
            System.out.println("[CMS] Disconnected from " + cmsLink);
        } else {
            System.out.println("[CMS] No active CMS connection to close.");
        }
    }

    public void displayStatus() {
        System.out.println("\n---- CMS Connection Status ----");
        System.out.println("  Link      : " + (cmsLink.isEmpty()     ? "Not set" : cmsLink));
        System.out.println("  Username  : " + (cmsUsername.isEmpty() ? "Not set" : cmsUsername));
        System.out.println("  Connected : " + (connected ? "YES" : "NO"));
    }

    

    public String getCmsLink() {
        return cmsLink;
    }

    public void setCmsLink(String cmsLink) {
        this.cmsLink = cmsLink;
    }

    public String getCmsUsername() {
        return cmsUsername;
    }

    public void setCmsUsername(String cmsUsername) {
        this.cmsUsername = cmsUsername;
    }

    public boolean isConnected() {
        return connected;
    }
}
