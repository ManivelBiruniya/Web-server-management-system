import java.util.HashMap;
import java.util.Map;

/**
 * Configuration - manages server settings such as port, max connections,
 * timeout, and security options.
 * Demonstrates ENCAPSULATION: settings map is private,
 * modified only through updateConfig().
 */
public class Configuration {

    private Map<String, String> settings;

    public Configuration() {
        settings = new HashMap<>();
        settings.put("port", "8080");
        settings.put("maxConnections", "100");
        settings.put("timeout", "30");
        settings.put("security", "enabled");
    }

    public void updateConfig(String key, String value) {
        settings.put(key, value);
        System.out.println("[CONFIG] Updated -> " + key + " = " + value);
    }

    public void saveConfig() {
        System.out.println("[CONFIG] Saving configuration...");
        for (Map.Entry<String, String> entry : settings.entrySet()) {
            System.out.println("   " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("[CONFIG] Configuration saved successfully.");
    }

    public String getSetting(String key) {
        return settings.get(key);
    }
}
