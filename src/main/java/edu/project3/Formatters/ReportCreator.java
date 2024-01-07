package edu.project3.Formatters;

import java.io.IOException;

public interface ReportCreator {
    String createReport();

    String createTable(String[] header, String[][] table);

    void printReport();

    void saveReport(String path) throws IOException;
}
