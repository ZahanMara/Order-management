package presentation;
/*

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
*/

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import connection.ConnectorToDB;
import dao.CustomerDAO;
import model.Customer;

public class ReportCustomer {

    /*private static Font font = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static Connection con = ConnectorToDB.getConnection();

    public void createCustomerReport(String pdfName) {
        try{
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(pdfName));
            document.open();
            addContent(document);
            createTable(document);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addContent(Document document) throws DocumentException {
        Paragraph firstPage = new Paragraph();

        addEmptyLine(firstPage, 1);
        firstPage.add(new Paragraph("REPORT CLIENTS", font)); // Header

        addEmptyLine(firstPage, 1);
        firstPage.add(new Paragraph("Report generated: " + new Date(), font)); // time when report generated

        document.add(firstPage);
    }

    private static void createTable(Document document) throws SQLException, DocumentException {
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("ID")); // ID collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Name")); // NAME collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Address")); // ADDRESS collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        CustomerDAO dao = new CustomerDAO(con);
        ArrayList<Customer> listOfCust = dao.getCustomersList(); // get the list of clients and display them into the table
        for(Customer c : listOfCust) {
            table.addCell(Integer.toString(c.getId())); // display id
            table.addCell(c.getName()); // display name
            table.addCell(c.getAddress()); // display address
        }

        Paragraph empty = new Paragraph();
        addEmptyLine(empty, 3); // make some space between the header and the table
        document.add(empty);
        document.add(table);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }*/
}



