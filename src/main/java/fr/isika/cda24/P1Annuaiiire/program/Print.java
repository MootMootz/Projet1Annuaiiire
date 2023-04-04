package fr.isika.cda24.P1Annuaiiire.program;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
import fr.isika.cda24.P1Annuaiiire.program.Printable;

public class Print implements Printable {

  public int print(Graphics g, PageFormat pf, int page) throws PrinterAbortException {

	  /* On récupère les coordonnées des bords de la page */
    int x = (int)pf.getImageableX();
    int y = (int)pf.getImageableY();
    int w = (int)pf.getImageableWidth();
    int h = (int)pf.getImageableHeight();
    
    // User (0,0) is typically outside the
    // imageable area, so we must translate
    // by the X and Y values in the PageFormat
    // to avoid clipping.
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    // Now we perform our rendering
    g.drawString("Hello world!", 100, 100);

    // tell the caller that this page is part
    // of the printed document
    return PAGE_EXISTS;
  }
}