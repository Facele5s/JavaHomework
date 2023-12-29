package edu.hw6;

import edu.hw6.Task6.PortScanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Task6Test {
    @Test
    @DisplayName("Получение списка занятых портов")
    public void getBusyPortsTest() {
        PortScanner portScanner = new PortScanner();
        List<PortScanner.Port> ports = portScanner.getBusyPorts();
        portScanner.printPortsInfo(ports);
    }
}
