package de.fraas.prepregdatatracker.services;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.data.repo.VersuchRepository;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcel Fraas on 16.03.16.
 */

@Service
public class ExportService {

    public class Tabledata {
        private SimpleBooleanProperty checked = new SimpleBooleanProperty(false);
        private String vnr;
        private String laufmeter;
        private String anlagengeschwindigkeit;
        private String spalthöhe;
        private String tAuftrag;
        private String tKalander;
        private String tTisch1;
        private String tTisch2;
        private String tKühlplatte;
        private String irStatus;
        private String aufwicklerDeckpapier;
        private String aufwicklerPrepreg;
        private String fadenspannung;
        private String pKalander;
        private String pZugstation;

        public SimpleBooleanProperty checkedProperty() {
            return checked;
        }

        public Boolean getChecked() {
            return this.checkedProperty().get();
        }

        public void setChecked(Boolean checked) {
            this.checkedProperty().set(checked);
        }

        public String getVnr() {
            return vnr;
        }

        public void setVnr(String vnr) {
            this.vnr = vnr;
        }

        public String getLaufmeter() {
            return laufmeter;
        }

        public void setLaufmeter(String laufmeter) {
            this.laufmeter = laufmeter;
        }

        public String getAnlagengeschwindigkeit() {
            return anlagengeschwindigkeit;
        }

        public void setAnlagengeschwindigkeit(String anlagengeschwindigkeit) {
            this.anlagengeschwindigkeit = anlagengeschwindigkeit;
        }

        public String getSpalthöhe() {
            return spalthöhe;
        }

        public void setSpalthöhe(String spalthöhe) {
            this.spalthöhe = spalthöhe;
        }

        public String getTAuftrag() {
            return tAuftrag;
        }

        public void settAuftrag(String tAuftrag) {
            this.tAuftrag = tAuftrag;
        }

        public String getTKalander() {
            return tKalander;
        }

        public void settKalander(String tKalander) {
            this.tKalander = tKalander;
        }

        public String getTTisch1() {
            return tTisch1;
        }

        public void settTisch1(String tTisch1) {
            this.tTisch1 = tTisch1;
        }

        public String getTTisch2() {
            return tTisch2;
        }

        public void settTisch2(String tTisch2) {
            this.tTisch2 = tTisch2;
        }

        public String getTKühlplatte() {
            return tKühlplatte;
        }

        public void settKühlplatte(String tKühlplatte) {
            this.tKühlplatte = tKühlplatte;
        }

        public String getIrStatus() {
            return irStatus;
        }

        public void setIrStatus(String irStatus) {
            this.irStatus = irStatus;
        }

        public String getAufwicklerDeckpapier() {
            return aufwicklerDeckpapier;
        }

        public void setAufwicklerDeckpapier(String aufwicklerDeckpapier) {
            this.aufwicklerDeckpapier = aufwicklerDeckpapier;
        }

        public String getAufwicklerPrepreg() {
            return aufwicklerPrepreg;
        }

        public void setAufwicklerPrepreg(String aufwicklerPrepreg) {
            this.aufwicklerPrepreg = aufwicklerPrepreg;
        }

        public String getFadenspannung() {
            return fadenspannung;
        }

        public void setFadenspannung(String fadenspannung) {
            this.fadenspannung = fadenspannung;
        }

        public String getPKalander() {
            return pKalander;
        }

        public void setpKalander(String pKalander) {
            this.pKalander = pKalander;
        }

        public String getPZugstation() {
            return pZugstation;
        }

        public void setpZugstation(String pZugstation) {
            this.pZugstation = pZugstation;
        }

    }


    @Autowired
    private VersuchRepository versuchRepository;

    @Autowired
    private Versuchsreihe versuchsreihe;

    private Anlagenparameter anlagenparameter;
    private Aufwickler aufwickler;
    private Kalander kalander;
    private Materialien materialien = new Materialien();
    private Prepregeigenschaften prepregeigenschaften;
    private Temperaturen temperaturen;
    private Zugspannungen zugspannungen;
    private Zugstation zugstation;

    private ObservableList<Tabledata> data;

    public ObservableList<Tabledata> generateData(){

        List<Versuch> versuchList = versuchRepository.findByVersuchsreihe(versuchsreihe);
        data = FXCollections.observableArrayList();

        for(Versuch v : versuchList){
            Tabledata row = new Tabledata();
            Set<Parameter> parameterSet = v.getParameter();
            //row.export = "e";
            row.setVnr(String.valueOf(v.getVnr()));
            for(Parameter p : parameterSet){
                if(p instanceof Anlagenparameter){
                    this.anlagenparameter = (Anlagenparameter)p;
                    row.setSpalthöhe(String.valueOf(((Anlagenparameter) p).getSpalthöhe()));
                    row.setAnlagengeschwindigkeit(String.valueOf(((Anlagenparameter) p).getAnlagengeschwindigkeit()));
                }
                if(p instanceof Temperaturen){
                    this.temperaturen = (Temperaturen)p;
                    row.settAuftrag(String.valueOf(((Temperaturen) p).gettAuftrag()));
                    row.settKalander(String.valueOf(((Temperaturen) p).gettKalander()));
                    row.settTisch1(String.valueOf(((Temperaturen) p).gettTisch1()));
                    row.settTisch2(String.valueOf(((Temperaturen) p).gettTisch2()));
                    row.settKühlplatte(String.valueOf(((Temperaturen) p).gettKühlplatte()));
                    row.setIrStatus(String.valueOf(((Temperaturen) p).irStatus));
                }
                if(p instanceof Zugspannungen){
                    this.zugspannungen = (Zugspannungen)p;
                    row.setAufwicklerDeckpapier(String.valueOf(((Zugspannungen) p).getAufwicklerDeckpapier()));
                    row.setAufwicklerPrepreg(String.valueOf(((Zugspannungen) p).getAufwicklerPrepreg()));
                    row.setFadenspannung(String.valueOf(((Zugspannungen) p).getFadenspannung()));
                }
                if(p instanceof Kalander){
                    this.kalander = (Kalander)p;
                    row.setpKalander(String.valueOf(((Kalander) p).getpKalander()));
                }
                if(p instanceof Zugstation){
                    this.zugstation = (Zugstation)p;
                    row.setpZugstation(String.valueOf(((Zugstation) p).getpZugstation()));
                }
                if(p instanceof Aufwickler){
                    this.aufwickler = (Aufwickler)p;
                }
                if(p instanceof Prepregeigenschaften){
                    this.prepregeigenschaften = (Prepregeigenschaften)p;
                    row.setLaufmeter(String.valueOf(((Prepregeigenschaften) p).getLaufmeter()));
                }
                if(p instanceof Materialien){
                    this.materialien = (Materialien) p;
                }

            }
            data.add(row);
        }

        return data;
    }

    public void generateFile() throws IOException {
        XSSFSheet sheet = readXLSXFile();
        sheet = writeAt(sheet, 2, 1, "HelloWorld");
        writeXLSXFile(sheet);
    }

    public XSSFSheet readXLSXFile() throws IOException {
        InputStream ExcelFileToRead = getClass().getResourceAsStream("/poi/template.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        return wb.getSheetAt(0);

    }

    public XSSFSheet writeAt(XSSFSheet sheet, int row, int column, String value) {
        if(sheet.getRow(row) == null){
            sheet.createRow(row);
        }
        XSSFRow r = sheet.getRow(row);
        if(r.getCell(column) == null){
            r.createCell(column);
        }
        XSSFCell c = r.getCell(column);
        c.setCellType(Cell.CELL_TYPE_STRING);
        c.setCellValue(value);
        return sheet;
    }

    public void test() throws IOException {
        List<Tabledata> tabledata = generateData();
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
        for(Tabledata d : tabledata){
            System.out.println(d.getChecked());
            if(d.getChecked()){
                sheet.getRow(9).getCell(3+i).setCellValue(d.getVnr());

                sheet.getRow(14).getCell(3+i).setCellValue(this.anlagenparameter.getSpalthöhe());   // Spalthöhe
                sheet.getRow(15).getCell(3+i).setCellValue(d.getAnlagengeschwindigkeit());          // Anlagengeschwindigkeit
                sheet.getRow(16).getCell(3+i).setCellValue(this.anlagenparameter.getVerfahren());   // Verfahren
                sheet.getRow(17).getCell(3+i).setCellValue(this.anlagenparameter.getBahnverlauf()); // Bahnverlauf

                sheet.getRow(18).getCell(3+i).setCellValue(d.getTAuftrag());    // Temperatur Auftrag
                sheet.getRow(19).getCell(3+i).setCellValue(d.getTKalander());   // Temperatur Kalander
                sheet.getRow(20).getCell(3+i).setCellValue(d.getTTisch1());     // Temperatur Tisch 1
                sheet.getRow(21).getCell(3+i).setCellValue(d.getTTisch2());     // Temperatur Tisch 2
                sheet.getRow(22).getCell(3+i).setCellValue(d.getTKühlplatte()); // Temperatur Kühlplatte
                sheet.getRow(23).getCell(3+i).setCellValue(d.getIrStatus());    // IR Status

                sheet.getRow(24).getCell(3+i).setCellValue(this.zugspannungen.getBeschichtung());       // Zug Beschichtung
                sheet.getRow(25).getCell(3+i).setCellValue(this.zugspannungen.getZugwalze());           // Zug Zugwalze
                sheet.getRow(26).getCell(3+i).setCellValue(this.zugspannungen.getGewebeOben());         // Zug Gewebe Oben
                sheet.getRow(27).getCell(3+i).setCellValue(this.zugspannungen.getDeckpapierOben());     // Zug Deckpapier Oben
                sheet.getRow(28).getCell(3+i).setCellValue(this.zugspannungen.getDeckpapierUnten());    // Zug Deckpapier Unten
                sheet.getRow(29).getCell(3+i).setCellValue(d.getAufwicklerDeckpapier());                // Zug Aufwickler Deckpapier
                sheet.getRow(30).getCell(3+i).setCellValue(d.getAufwicklerPrepreg());                   // Zug Aufwickler Prepreg
                sheet.getRow(31).getCell(3+i).setCellValue(d.getFadenspannung());                       // Zug Fadenspannung

                sheet.getRow(32).getCell(3+i).setCellValue(this.kalander.getDrehmoment());      // Kalander Drehmoment
                sheet.getRow(33).getCell(3+i).setCellValue(this.kalander.getDrehzahl());        // Kalander Drehzahl
                sheet.getRow(34).getCell(3+i).setCellValue(d.getPKalander());                   // Druck Kalander
                sheet.getRow(35).getCell(3+i).setCellValue(this.kalander.getSpaltA());          // Spalt Kalander A
                sheet.getRow(36).getCell(3+i).setCellValue(this.kalander.getSpaltB());          // Spalt Kalander B

                sheet.getRow(37).getCell(3+i).setCellValue(d.getPZugstation());                     // Druck Zugstation
                sheet.getRow(38).getCell(3+i).setCellValue(this.zugstation.getSpaltZugstationA());  // Spalt Zugstation A
                sheet.getRow(39).getCell(3+i).setCellValue(this.zugstation.getSpaltZugstationB());  // Spalt Zugstation B

                sheet.getRow(40).getCell(3+i).setCellValue(this.aufwickler.getTaperDeckpapier());   // Taper Deckpapier
                sheet.getRow(41).getCell(3+i).setCellValue(this.aufwickler.getTaperPrepreg());      // Taper Prepreg

                sheet.getRow(42).getCell(3+i).setCellValue(this.prepregeigenschaften.getFlächengewicht());  // Flächengewicht
                sheet.getRow(43).getCell(3+i).setCellValue(this.prepregeigenschaften.getHarzgehalt());      // Harzgehalt
                sheet.getRow(44).getCell(3+i).setCellValue(this.prepregeigenschaften.getPrepregbreite());   // Prepregbreite
                sheet.getRow(45).getCell(3+i).setCellValue(d.getLaufmeter());                               // Laufmeter

                i++;
            }
        }
        String excelFileName = "Data Export.xlsx";
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }


    public void writeXLSXFile(XSSFSheet sheet) throws IOException {

        String excelFileName = "Test.xlsx";//name of excel file

        XSSFWorkbook wb = sheet.getWorkbook();

        FileOutputStream fileOut = new FileOutputStream(excelFileName);

        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

}
