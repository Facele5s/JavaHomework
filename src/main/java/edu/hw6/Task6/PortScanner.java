package edu.hw6.Task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortScanner {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String STR_PROTOCOL = "Протокол";
    private static final String STR_PORT = "Порт";
    private static final String STR_SERVICE = "Сервис";
    private static final String STR_TCP = "TCP";
    private static final String STR_UDP = "UDP";

    private static final String FORMAT = "%10s%7s%20s";
    private static final Pattern PORT_SERVICE_PATTERN = Pattern.compile("^(\\d+):(.+)$");

    private static final int PORT_START = 0;
    private static final int PORT_STOP = 49151;

    private static final String PORTS_SERVICES_FILEPATH = "src/main/java/edu/hw6/Task6/ports_services.txt";

    private static final Map<Integer, String> SERVICES = new HashMap<>();

    public PortScanner() {
        this(PORTS_SERVICES_FILEPATH);
    }

    public PortScanner(String servicesFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(servicesFilePath))) {
            reader.lines().forEach(line -> {
                Matcher matcher = PORT_SERVICE_PATTERN.matcher(line);

                if (matcher.matches()) {
                    SERVICES.put(Integer.parseInt(matcher.group(1)), matcher.group(2));
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Port> getBusyPorts() {
        List<Port> busyPorts = new ArrayList<>();

        for (int port = PORT_START; port <= PORT_STOP; port++) {
            try {
                ServerSocket socket = new ServerSocket(port);
                socket.close();
            } catch (Exception e) {
                busyPorts.add(new Port(port, STR_TCP));
            }

            try {
                DatagramSocket socket = new DatagramSocket(port);
                socket.close();
            } catch (Exception e) {
                busyPorts.add(new Port(port, STR_UDP));
            }
        }

        return busyPorts;
    }

    public void printPortsInfo(List<Port> ports) {
        LOGGER.info(String.format(FORMAT, STR_PROTOCOL, STR_PORT, STR_SERVICE));

        ports.forEach(port -> {
            LOGGER.info(String.format(FORMAT, port.protocol, port.port, port.service));
        });
    }

    public static class Port {
        private final int port;
        private final String protocol;
        private final String service;

        Port(int port, String protocol) {
            this.port = port;
            this.protocol = protocol;

            if (SERVICES.get(port) == null) {
                service = "?";
            } else {
                service = SERVICES.get(port);
            }
        }

        public int getPort() {
            return port;
        }

        public String getProtocol() {
            return protocol;
        }

        public String getService() {
            return service;
        }
    }

}
