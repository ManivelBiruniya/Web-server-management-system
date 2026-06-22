
public class User {

    private String username;
    private String password;
    private boolean loggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    // Getter / Setter (Encapsulation)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    
    public boolean login(String inputUsername, String inputPassword) {
        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
            loggedIn = true;
            System.out.println("[LOGIN] Success. Welcome, " + username + "!");
        } else {
            loggedIn = false;
            System.out.println("[LOGIN] Failed. Invalid username or password.");
        }
        return loggedIn;
    }

    public void logout() {
        if (loggedIn) {
            loggedIn = false;
            System.out.println("[LOGOUT] " + username + " has logged out.");
        } else {
            System.out.println("[LOGOUT] No active session for " + username + ".");
        }
    }
}
