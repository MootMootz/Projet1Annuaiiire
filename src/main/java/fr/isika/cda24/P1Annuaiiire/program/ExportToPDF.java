package fr.isika.cda24.P1Annuaiiire.program;

public class ExportToPDF {

	Document document = new Document();
	PdfWriter.getInstance(document, new FileOutputStream("listeStagiaires.pdf"));

	document.open();

	PdfPTable table = new PdfPTable(3);
	addTableHeader(table);
	addRows(table);
	addCustomRows(table);

	document.add(table);
	document.close();
}
