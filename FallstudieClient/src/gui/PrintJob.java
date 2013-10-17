package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.Utilities;

import java.awt.print.*;

public class PrintJob implements Printable {

	int[] pageBreaks; // array of page break line positions.
	static JTextArea ausgabe;

	// /* Synthesise some sample lines of text */
	String[] textLines;

	// TODO

	private void initTextLines() {
		String strHelpAusgabe = ausgabe.getText();
		String[] textSplitLines = strHelpAusgabe.split("\n");
		if (textLines == null) {
			int numLines = textSplitLines.length;
			textLines = new String[numLines];

			for (int i = 0; i < numLines; i++) {
				textLines[i] = textSplitLines[i];
			}

		}

	}

	public int print(Graphics g, PageFormat pf, int pageIndex)
			throws PrinterException {

		Font font = new Font("Lucida Grande", Font.PLAIN, 13);
		FontMetrics metrics = g.getFontMetrics(font);
		int lineHeight = metrics.getHeight();

		if (pageBreaks == null) {
			initTextLines();

			int linesPerPage = (int) (pf.getImageableHeight() / lineHeight);
			int numBreaks = (textLines.length - 1) / linesPerPage;
			pageBreaks = new int[numBreaks];
			for (int b = 0; b < numBreaks; b++) {
				pageBreaks[b] = (b + 1) * linesPerPage;
			}
		}

		if (pageIndex > pageBreaks.length) {
			return NO_SUCH_PAGE;
		}

		/*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
		 * Since we are drawing text we
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		/*
		 * Draw each line that is on this page. Increment 'y' position by
		 * lineHeight for each line.
		 */
		int y = 0;
		int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
		int end = (pageIndex == pageBreaks.length) ? textLines.length
				: pageBreaks[pageIndex];

		 String leerZeileNeben = "", leerZeileAusgabe= "", zeilenBeginn = "---", h003;
		 String[] textSplitArray;
		 int laengeGesamt = 15, aktuell = 0, fuellung = 0;

		
		 for (int line = start; line < end; line++) {
		 y += lineHeight;
		
		 if (textLines[line].contains("\t")) {
		 textSplitArray = textLines[line].split("\t");
		 aktuell = textSplitArray[1].length();
		 fuellung = laengeGesamt - aktuell;
		 for (int i = 0; i < fuellung; i++) {
		 leerZeileAusgabe = leerZeileNeben + "-";
		 leerZeileNeben = leerZeileAusgabe;
		 }
		 h003 = zeilenBeginn + textSplitArray[1] + leerZeileAusgabe + "--" + textSplitArray[2];
		 g.drawString(h003, 0, y);
		 leerZeileNeben = "";
		 leerZeileAusgabe = "";
		 h003 = "";
		 } else {
		 g.drawString(textLines[line], 0, y);
		 }
		
		 }

		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	public void drucken(JTextArea druckString) {
		ausgabe = druckString;
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(this);

		if (pj.printDialog()) {
			try {
				pj.print();
			} catch (PrinterException e) {
				System.out.println("PrintJob did not successfully complete");
			}
		}
	}

}