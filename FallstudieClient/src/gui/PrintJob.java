package gui;

/*
 * TableReportDemo.java
 * This demo shows you how to customize the JTable print function.
 * As an example, we print a report header with two rows and a border.
 */
import java.awt.*;
import java.awt.print.*;
import java.util.logging.*;
import javax.swing.*;

public class PrintJob extends JFrame {
	private static final long serialVersionUID = -7181253957779790330L;
	private JTable table;
	private String title;

	public PrintJob(JTable druckTable, String title) {
		table=druckTable;
		this.title=title;
		try {
			printJTable();
		} catch (PrinterException ex) {
			Logger.getLogger(PrintJob.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	private void printJTable() throws PrinterException {
		// possibly prepare the table for printing here first
		// wrap in a try/finally so table can be restored even if something
		// fails
		try {
			// fetch the printable
			Printable printable = new TableReport(table, title);
			PrinterJob job = PrinterJob.getPrinterJob();// fetch a PrinterJob
			job.setPrintable(printable);// set the Printable on the PrinterJob
			// create an attribute set to store attributes from the print dialog
//			PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
			// display a print dialog and record whether or not the user cancels
			// it
			if (job.printDialog()) {
				try {
					job.print();
				} catch (PrinterException e) {
					// TODO: handle exception
				}
			}
		} finally {
			// possibly restore the original table state here
		}
	}

}

class TableReport implements Printable {
	private Printable tablePrintable;
	private PageFormat pageFormatJTable;
	private String title;

	public TableReport(final JTable table, String title) {
		tablePrintable = table.getPrintable(JTable.PrintMode.FIT_WIDTH, null,
				null);
		this.title = title;
	}

	public int print(final Graphics graphics, final PageFormat pageFormat,
			final int pageIndex) throws PrinterException {
		Graphics2D g = (Graphics2D) graphics;
		int x1 = (int) pageFormat.getImageableX();
		int y1 = (int) pageFormat.getImageableY();
		int w1 = (int) pageFormat.getImageableWidth();
		int h1 = (int) pageFormat.getImageableHeight();
		if (pageFormatJTable == null) {
			pageFormatJTable = (PageFormat) pageFormat.clone();
			Paper paperJTable = pageFormatJTable.getPaper();
			if (pageFormatJTable.getOrientation() == PageFormat.PORTRAIT) {
				paperJTable.setImageableArea(x1, y1 + 60,// skip header area
						w1, h1 - 90);// reserve space for header and footer
			} else {
				paperJTable.setImageableArea(y1 + 60, x1,// skip header area
						h1 - 90, w1);// reserve space for header and footer
			}
			pageFormatJTable.setPaper(paperJTable);
		}
		Font f = g.getFont();
		g.setFont(g.getFont().deriveFont(15f));
		FontMetrics fm = g.getFontMetrics();
		g.drawString(title, x1 + (w1 - fm.stringWidth(title)) / 2, y1 + 15);
		g.setFont(f);
		fm = g.getFontMetrics();
		g.drawRect(x1, y1, w1, 40);
		String footer = "Page " + (pageIndex + 1);
		g.drawString(footer, x1 + (w1 - fm.stringWidth(footer)) / 2, y1 + h1
				- 10);
		// print the table:
		Graphics gCopy = g.create();
		int retVal = tablePrintable.print(gCopy, pageFormatJTable, pageIndex);
		gCopy.dispose();
		//
		return retVal;
	}
}