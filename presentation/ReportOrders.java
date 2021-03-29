package presentation;

/*import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import connection.ConnectorToDB;
import dao.OrderDAO;
import model.Orders;
import model.Product;

public class ReportOrders {
/*
    private static Font font = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static Font bigFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD, BaseColor.RED);
    private static Connection con = ConnectorToDB.getConnection();

    public void createOrdersReport(String pdfName)  {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfName));
            document.open();
            addContent(document);
            createTable(document);
            document.close();
        }
        catch (Exception e)
        {
            System.out.println("ERROR AT PRINTING ORDER REPORT");
        }
    }

    public void createBill(String pdfName, Orders ord) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfName));
            document.open();
            Paragraph firstPage = new Paragraph();
            addEmptyLine(firstPage, 1);
            firstPage.add(new Paragraph("BILL FOR ORDER#" + ord.getId(), font)); // Header
            addEmptyLine(firstPage, 1);
            firstPage.add(new Paragraph("Bill generated: " + new Date(), font)); // time when bill was generated

            PdfPTable table = new PdfPTable(5);
            PdfPCell c1 = new PdfPCell(new Phrase("ID")); // ID collumn
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Customer Name")); // CUSTOMER collumn
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Product")); // PRODUCT collumn
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Quantity")); // QUANTITY collumn
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Price")); // PRICE collumn
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            table.addCell(Integer.toString(ord.getId())); // display id
            table.addCell(ord.getCustomer()); // display customer
            table.addCell(ord.getProduct()); // display product
            table.addCell(Integer.toString(ord.getQuantity())); // display address
            table.addCell(Double.toString(ord.getQuantity()*ord.getPrice())); // display price of the order

            document.add(firstPage);
            Paragraph empty = new Paragraph();
            addEmptyLine(empty, 3); // make some space between the header and the table
            document.add(empty);
            document.add(table);
            document.close();
        } catch(Exception e){ System.out.println("ERROR AT PRINTING THE BILL!");}
    }

    public void createUnderStock(String pdfName, String name, String product, int quantity) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfName));
            document.open();

            Paragraph firstPage = new Paragraph();
            addEmptyLine(firstPage, 1);
            firstPage.add(new Paragraph("ORDER EXECUTION PROCESS COULD NOT BE PERFORMED", bigFont));
            firstPage.add(new Paragraph("\n\nWe apologize for the inconvenience, but the requested product is not in stock.\n\nThe order to "+name+" of "+quantity+" "+product+"s couldn't be processed."));
            document.add(firstPage);
            document.close();
        }
        catch (Exception e) {
            System.out.println("eroare la understock");
        }
    }

    private static void addContent(Document document) throws DocumentException {
        Paragraph firstPage = new Paragraph();

        addEmptyLine(firstPage, 1);
        firstPage.add(new Paragraph("REPORT ORDERS", font)); // Header

        addEmptyLine(firstPage, 1);
        firstPage.add(new Paragraph("Report generated: " + new Date(), font)); // time when report generated

        document.add(firstPage);
    }

    private static void createTable(Document document) throws SQLException, DocumentException {
        PdfPTable table = new PdfPTable(4);

        PdfPCell c1 = new PdfPCell(new Phrase("ID")); // ID collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Customer Name")); // CUSTOMER collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Product")); // PRODUCT collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Quantity")); // QUANTITY collumn
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        OrderDAO dao = new OrderDAO(con);
        ArrayList<Orders> listOfOrd = dao.getOrdersList(); // get the list of clients and display them into the table
        for(Orders o : listOfOrd) {
            table.addCell(Integer.toString(o.getId())); // display id
            table.addCell(o.getCustomer()); // display customer
            table.addCell(o.getProduct()); // display product
            table.addCell(Integer.toString(o.getQuantity())); // display address
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



