import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LogManager - stores and manages activity / error / audit logs.
 * Demonstrates ENCAPSULATION: the internal log list is private,
 * only accessible through addLog(), displayLogs(), searchLogs().
 */
public class LogManager {

    private List<String> logs;
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogManager() {
        logs = new ArrayList<>();
    }

    public void addLog(String message) {
        String timestamp = LocalDateTime.now().format(FORMAT);
        logs.add("[" + timestamp + "] " + message);
    }

    public void displayLogs() {
        System.out.println("---- Activity Logs ----");
        if (logs.isEmpty()) {
            System.out.println("No logs available.");
            return;
        }
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public List<String> searchLogs(String keyword) {
        List<String> results = new ArrayList<>();
        for (String log : logs) {
            if (log.toLowerCase().contains(keyword.toLowerCase())) {
                results.add(log);
            }
        }
        return results;
    }

    public List<String> getLogs() {
        return logs;
    }
}
