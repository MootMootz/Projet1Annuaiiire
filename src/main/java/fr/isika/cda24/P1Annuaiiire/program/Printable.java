package fr.isika.cda24.P1Annuaiiire.program;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public interface Printable {

	public static final int PAGE_EXISTS = 0;
	public static final int NO_SUCH_PAGE = 0;

	PrinterJob job = PrinterJob.getPrinterJob();
	
	/* On donne le contenu à imprimer au job */
	job.setPrintable();

	/* Affichage de la boite de dialogue d'impression */
	boolean doPrint = job.printDialog();
	if(doPrint)
	{
		try {
			/* Lancement de l'impression */
			job.print();
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}

	}
}
