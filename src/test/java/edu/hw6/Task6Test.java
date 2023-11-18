package edu.hw6;

import edu.hw6.Task6.PortScanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

public class Task6Test {
    @Test
    @DisplayName("Получение списка занятых портов")
    public void getBusyPortsTest() throws IOException {
        ServerSocket socket = new ServerSocket(111); // MyPortCheck

        PortScanner portScanner = new PortScanner();
        List<PortScanner.Port> ports = portScanner.getBusyPorts();
        portScanner.printPortsInfo(ports);

        socket.close();
    }
}
