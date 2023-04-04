package fr.isika.cda24.P1Annuaiiire.program;

import javax.print.PrintService;
import javax.print.attribute.HashAttributeSet;

public class ServiceUI {

	public void printDialog() {
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
		PrintService selectedPrintService = ServiceUI.printDialog(null, 150, 150, printServices, defaultPrintService, null, attrib);
		if (selectedPrintService != null)
			System.out.println("selected printer:" + selectedPrintService.getName());
		else
			System.out.println("selection cancelled");
	}
}
