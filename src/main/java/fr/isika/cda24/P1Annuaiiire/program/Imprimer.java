package fr.isika.cda24.P1Annuaiiire.program;

import fr.isika.cda24.P1Annuaiiire.entitees.Stagiaire;
import javafx.collections.ObservableList;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class Imprimer {
    private ObservableList<Stagiaire> Annuaire;
    private ObservableList<Stagiaire> items;

    public Imprimer(ObservableList<Stagiaire> annuaire) {
        this.Annuaire = annuaire;
    }

    public void imprimerAnnuaire() {
        Printer printer = Printer.getDefaultPrinter();
        if (printer != null) {
            PrinterJob printerJob = PrinterJob.createPrinterJob(printer);
            if (printerJob != null && printerJob.showPrintDialog(null)) {
                // Créez un Node avec le contenu à imprimer
                TextFlow textFlow = new TextFlow();
                textFlow.getChildren().add(new Text("Annuaire des stagiaires\n\n"));
                for (Stagiaire stagiaire : items) { // Remplacez "stagiaires" par "items"
                    textFlow.getChildren().add(new Text(stagiaire.toString() + "\n"));
                }

                // Imprimez le contenu
                printerJob.printPage(textFlow);
                printerJob.endJob();
            }
        } else {
            System.out.println("Aucune imprimante trouvée.");
        }
    }
}