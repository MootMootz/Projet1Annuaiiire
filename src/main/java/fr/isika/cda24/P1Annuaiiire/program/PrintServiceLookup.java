package fr.isika.cda24.P1Annuaiiire.program;

import javax.print.DocFlavor;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.OrientationRequested;

public abstract class PrintServiceLookup {

//	// Méthode impression, si on a qu'une seule imprimante par défaut ---------------------------------
//	public static PrintService lookupDefaultPrintService() {
//
//		PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
//		
//		System.out.println(printService.getName());
//		
//		return printService;
//	}
// 
	
	// Méthode impression, pour pouvoir trouver toutes les imprimantes dispos
	public static final PrintService[] lookupPrintServices(DocFlavor flavor, AttributeSet attributes) {

		/* Attributs 
		 * DocFlavor >> pour détarminer le format (comme par exemple MIME)
		 * AttributeSet >>  pour spécifier des éléments relatifs à l'impression : 
		 * couleur / orientation / double sense...
		 */
		DocFlavor df = DocFlavor.URL.JPEG; 
		AttributeSet attribute = new HashAttributeSet();
		attribute.add(OrientationRequested.PORTRAIT);
		attribute.add(ColorSupported.SUPPORTED);
		PrintService[] services = PrintServiceLookup.lookupPrintServices(df, attribute);
		for (int i = 0; i < services.length; i++) {
			if (services[i].isDocFlavorSupported(df))
				System.out.println(services[i].getName());
		}
		return services;
	}

	// Méthode pour déterminer le type MIME, le type et sous type de fichier par l'imprimante par défaut 
	protected static PrintService lookupDefaultPrintService() {

		PrintService ps0 = PrintServiceLookup.lookupDefaultPrintService();
		DocFlavor f[] = ps0.getSupportedDocFlavors();
		for (int i = 0; i < f.length; i++) {
			System.out.println("MIME Type:" + f[i].getMimeType());
			System.out.println("Media Subtype:" + f[i].getMediaSubtype());
			System.out.println("Media Type:" + f[i].getMediaType());
			System.out.println("--------------------------------------");
		}
		return ps0;
	}
}
