package de.fraas.prepregdatatracker.threads;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.data.repo.VersuchRepository;
import de.fraas.prepregdatatracker.services.ExportService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcel Fraas on 24.03.16.
 */

@Component
public class ExportThread extends Thread {

    @Autowired
    private Versuchsreihe versuchsreihe;

    @Autowired
    private ExportService exportService;

    private Anlagenparameter anlagenparameter;
    private Aufwickler aufwickler;
    private Kalander kalander;
    private Materialien materialien = new Materialien();
    private Prepregeigenschaften prepregeigenschaften;
    private Temperaturen temperaturen;
    private Zugspannungen zugspannungen;
    private Zugstation zugstation;

    public Anlagenparameter getAnlagenparameter() {
        return anlagenparameter;
    }

    public void setAnlagenparameter(Anlagenparameter anlagenparameter) {
        this.anlagenparameter = anlagenparameter;
    }

    public Aufwickler getAufwickler() {
        return aufwickler;
    }

    public void setAufwickler(Aufwickler aufwickler) {
        this.aufwickler = aufwickler;
    }

    public Kalander getKalander() {
        return kalander;
    }

    public void setKalander(Kalander kalander) {
        this.kalander = kalander;
    }

    public Materialien getMaterialien() {
        return materialien;
    }

    public void setMaterialien(Materialien materialien) {
        this.materialien = materialien;
    }

    public Prepregeigenschaften getPrepregeigenschaften() {
        return prepregeigenschaften;
    }

    public void setPrepregeigenschaften(Prepregeigenschaften prepregeigenschaften) {
        this.prepregeigenschaften = prepregeigenschaften;
    }

    public Temperaturen getTemperaturen() {
        return temperaturen;
    }

    public void setTemperaturen(Temperaturen temperaturen) {
        this.temperaturen = temperaturen;
    }

    public Zugspannungen getZugspannungen() {
        return zugspannungen;
    }

    public void setZugspannungen(Zugspannungen zugspannungen) {
        this.zugspannungen = zugspannungen;
    }

    public Zugstation getZugstation() {
        return zugstation;
    }

    public void setZugstation(Zugstation zugstation) {
        this.zugstation = zugstation;
    }



    public void test() throws IOException {
        List<ExportService.Tabledata> tabledata = exportService.generateData();
        InputStream source = getClass().getResourceAsStream("/poi/template.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(source);
        XSSFSheet sheet = wb.getSheetAt(0);
        //if(sheet.getRow(2).getCell(1) == null) sheet.getRow(2).createCell(1);
        //if(sheet.getRow(3).getCell(1) == null) sheet.getRow(3).createCell(1);
        //if(sheet.getRow(4).getCell(1) == null) sheet.getRow(4).createCell(1);

        sheet.getRow(2).getCell(1).setCellValue(versuchsreihe.getVersuchsanlage());         // Versuchsanlage
        sheet.getRow(3).getCell(1).setCellValue(versuchsreihe.getDatum());                  // Versuchsdatum
        sheet.getRow(4).getCell(1).setCellValue(versuchsreihe.getPerson().toString());      // Protokollführung

        sheet.getRow(10).getCell(3).setCellValue(this.materialien.getFaserhalbzeug());    // Faserhalbzeug
        sheet.getRow(11).getCell(3).setCellValue(this.materialien.getHarzsystem());       // Harzsystem
        sheet.getRow(12).getCell(3).setCellValue(this.materialien.getTrägermaterial());   // Trägermaterial
        sheet.getRow(13).getCell(3).setCellValue(this.materialien.getKaschiermaterial()); // Kaschiermaterial

        int i = 0;
        for (ExportService.Tabledata d : tabledata) {
            System.out.println(d.getChecked());
            if (d.getChecked()) {
                sheet.getRow(9).getCell(3 + i).setCellValue(d.getVnr());

                sheet.getRow(14).getCell(3 + i).setCellValue(this.anlagenparameter.getSpalthöhe());   // Spalthöhe
                sheet.getRow(15).getCell(3 + i).setCellValue(d.getAnlagengeschwindigkeit());          // Anlagengeschwindigkeit
                sheet.getRow(16).getCell(3 + i).setCellValue(this.anlagenparameter.getVerfahren());   // Verfahren
                sheet.getRow(17).getCell(3 + i).setCellValue(this.anlagenparameter.getBahnverlauf()); // Bahnverlauf

                sheet.getRow(18).getCell(3 + i).setCellValue(d.getTAuftrag());    // Temperatur Auftrag
                sheet.getRow(19).getCell(3 + i).setCellValue(d.getTKalander());   // Temperatur Kalander
                sheet.getRow(20).getCell(3 + i).setCellValue(d.getTTisch1());     // Temperatur Tisch 1
                sheet.getRow(21).getCell(3 + i).setCellValue(d.getTTisch2());     // Temperatur Tisch 2
                sheet.getRow(22).getCell(3 + i).setCellValue(d.getTKühlplatte()); // Temperatur Kühlplatte
                sheet.getRow(23).getCell(3 + i).setCellValue(d.getIrStatus());    // IR Status

                sheet.getRow(24).getCell(3 + i).setCellValue(this.zugspannungen.getBeschichtung());       // Zug Beschichtung
                sheet.getRow(25).getCell(3 + i).setCellValue(this.zugspannungen.getZugwalze());           // Zug Zugwalze
                sheet.getRow(26).getCell(3 + i).setCellValue(this.zugspannungen.getGewebeOben());         // Zug Gewebe Oben
                sheet.getRow(27).getCell(3 + i).setCellValue(this.zugspannungen.getDeckpapierOben());     // Zug Deckpapier Oben
                sheet.getRow(28).getCell(3 + i).setCellValue(this.zugspannungen.getDeckpapierUnten());    // Zug Deckpapier Unten
                sheet.getRow(29).getCell(3 + i).setCellValue(d.getAufwicklerDeckpapier());                // Zug Aufwickler Deckpapier
                sheet.getRow(30).getCell(3 + i).setCellValue(d.getAufwicklerPrepreg());                   // Zug Aufwickler Prepreg
                sheet.getRow(31).getCell(3 + i).setCellValue(d.getFadenspannung());                       // Zug Fadenspannung

                sheet.getRow(32).getCell(3 + i).setCellValue(this.kalander.getDrehmoment());      // Kalander Drehmoment
                sheet.getRow(33).getCell(3 + i).setCellValue(this.kalander.getDrehzahl());        // Kalander Drehzahl
                sheet.getRow(34).getCell(3 + i).setCellValue(d.getPKalander());                   // Druck Kalander
                sheet.getRow(35).getCell(3 + i).setCellValue(this.kalander.getSpaltA());          // Spalt Kalander A
                sheet.getRow(36).getCell(3 + i).setCellValue(this.kalander.getSpaltB());          // Spalt Kalander B

                sheet.getRow(37).getCell(3 + i).setCellValue(d.getPZugstation());                     // Druck Zugstation
                sheet.getRow(38).getCell(3 + i).setCellValue(this.zugstation.getSpaltZugstationA());  // Spalt Zugstation A
                sheet.getRow(39).getCell(3 + i).setCellValue(this.zugstation.getSpaltZugstationB());  // Spalt Zugstation B

                sheet.getRow(40).getCell(3 + i).setCellValue(this.aufwickler.getTaperDeckpapier());   // Taper Deckpapier
                sheet.getRow(41).getCell(3 + i).setCellValue(this.aufwickler.getTaperPrepreg());      // Taper Prepreg

                sheet.getRow(42).getCell(3 + i).setCellValue(this.prepregeigenschaften.getFlächengewicht());  // Flächengewicht
                sheet.getRow(43).getCell(3 + i).setCellValue(this.prepregeigenschaften.getHarzgehalt());      // Harzgehalt
                sheet.getRow(44).getCell(3 + i).setCellValue(this.prepregeigenschaften.getPrepregbreite());   // Prepregbreite
                sheet.getRow(45).getCell(3 + i).setCellValue(d.getLaufmeter());                               // Laufmeter

                i++;
            }
        }
        String excelFileName = "Data Export.xlsx";
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }


    public void run() {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}