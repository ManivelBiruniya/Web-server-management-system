
public class ResourceMonitor {

    private double cpuUsage;
    private double memoryUsage;
    private double diskUsage;
    private double networkUsage;

    public double monitorCPU() {
        cpuUsage = generateUsage();
        System.out.println("[MONITOR] CPU Usage: " + cpuUsage + "%");
        return cpuUsage;
    }

    public double monitorMemory() {
        memoryUsage = generateUsage();
        System.out.println("[MONITOR] Memory Usage: " + memoryUsage + "%");
        return memoryUsage;
    }

    public double monitorDisk() {
        diskUsage = generateUsage();
        System.out.println("[MONITOR] Disk Usage: " + diskUsage + "%");
        return diskUsage;
    }

    public double monitorNetwork() {
        networkUsage = generateUsage();
        System.out.println("[MONITOR] Network Activity: " + networkUsage + " Mbps");
        return networkUsage;
    }

    
    private double generateUsage() {
        return Math.round((Math.random() * 100) * 100.0) / 100.0;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public double getDiskUsage() {
        return diskUsage;
    }

    public double getNetworkUsage() {
        return networkUsage;
    }
}
