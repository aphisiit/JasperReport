package com.guy;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import javax.swing.*;
//import org.apache.commons.collections.map.HashedMap;

public class EmployeeReport {

    public static void main(String[] args) throws JRException,
            ClassNotFoundException,SQLException{
        String reportScrFile = "C:\\Users\\aphis\\Documents\\IntelliJ\\JasperEmployee\\src\\employee.jrxml";

        // Compile jrxml file ( We create this file from iReport or Eclipse)
        JasperReport jasperReport = JasperCompileManager.compileReport(reportScrFile);

        // Connect database (this example is connect Oracle database g11)
        Connection conn = OracleConnUtils.getOracleConnection();

        // Parameters for report
        Map<String,Object> parameters = new HashMap<>();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conn);

        //create directory(folder) for save report
        //if you don't want to create directory, skip this step
        File outDir = new File("C:\\Users\\aphis\\Desktop\\EmployeeReport");
        outDir.mkdir();

        //export file
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\aphis\\Desktop\\EmployeeReport\\Employee.pdf");

//
//        JRPdfExporter exporter = new JRPdfExporter();
//
//        ExporterInput exporterInput = new SimleExporterInput(print);
//
//        exporter.setExporterInput(exporterInput);
//
//        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
//             "C:\\Users\\aphis\\Desktop\\EmployeeReport\\Employee.pdf"
//        );
//
//        exporter.setExporterOutput(exporterOutput);
//
//        SimplePdfExportConfiguration configuration = new SimplePdfExporterConfiguration();
//        exporter.setConfiguration(configuration);
//        exporter.exportReport();
        JOptionPane.showMessageDialog(null,"Your report was saved at path : " +
                "C:\\Users\\aphis\\Desktop\\EmployeeReport\\Employee.pdf");
        System.out.print("Done!");

        //open pdf file after export file
        try {
            File myFile = new File("C:\\Users\\aphis\\Desktop\\EmployeeReport\\Employee.pdf");
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            // no application registered for PDFs
        }


    }
}
