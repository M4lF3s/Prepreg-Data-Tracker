package de.fraas.prepregdatatracker.services;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import de.fraas.prepregdatatracker.driver.utils.PropertyChangeObserver;
import de.fraas.prepregdatatracker.ui.controller.ParameterController;
import javafx.application.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Marcel Fraas on 08.03.16.
 */

@Service
public class UIUpdateService implements PropertyChangeObserver{

    @Autowired
    private ParameterController parameterController;

    private String spalthöhe;
    private String anlagengeschwindigkeit;
    private String verfahren;
    private String bahnverlauf;
    private String drehmoment;
    private String drehzahl;
    private String druckKalander;
    private String spaltA;
    private String spaltB;
    private String flächengewicht;
    private String harzgehalt;
    private String prepregbreite;
    private String laufmeter;
    private String auftrag;
    private String kalander;
    private String tisch1;
    private String tisch2;
    private String kühlplatte;
    private String irStatus;
    private String beschichtung;
    private String zugwalze;
    private String gewebeOben;
    private String deckpapierOben;
    private String deckpapierUnten;
    private String aufwicklerDeckpapier;
    private String aufwicklerPrepreg;
    private String fadenspannung;
    private String pZugstation;
    private String spaltZugstationA;
    private String spaltZugstationB;
    private String taperDeckpapier;
    private String taperPrepreg;
    private String faserhalbzeug;
    private String harzsystem;
    private String trägermaterial;
    private String kaschiermaterial;



    @PostConstruct
    private void init(){
        ObserverManager.register(this);
    }

    public void updateAll(){
        parameterController.setTfSpalthöheText(spalthöhe);
        parameterController.setTfAnlagengeschwindigkeitText(anlagengeschwindigkeit);
        parameterController.setTfVerfahrenText(verfahren);
        parameterController.setTfBahnverlaufText(bahnverlauf);
        parameterController.setTfDrehmomentText(drehmoment);
        parameterController.setTfDrehzahlText(drehzahl);
        parameterController.setTfDruckKalenderText(druckKalander);
        parameterController.setTfSpaltAText(spaltA);
        parameterController.setTfSpaltBText(spaltB);
        parameterController.setTfFlächengewichtText(flächengewicht);
        parameterController.setTfHarzgehaltText(harzgehalt);
        parameterController.setTfPrepregbreiteText(prepregbreite);
        parameterController.setTfLaufmeterText(laufmeter);
        parameterController.setTfAuftragText(auftrag);
        parameterController.setTfKalanderText(kalander);
        parameterController.setTfTisch1Text(tisch1);
        parameterController.setTfTisch2Text(tisch2);
        parameterController.setTfKühlplatteText(kühlplatte);
        parameterController.setTfIrStatusText(irStatus);
        parameterController.setTfBeschichtungText(beschichtung);
        parameterController.setTfZugwalzeText(zugwalze);
        parameterController.setTfGewebeObenText(gewebeOben);
        parameterController.setTfDeckpapierObenText(deckpapierOben);
        parameterController.setTfDeckpapierUntenText(deckpapierUnten);
        parameterController.setTfAufwicklerDText(aufwicklerDeckpapier);
        parameterController.setTfAufwicklerPText(aufwicklerPrepreg);
        parameterController.setTfFadenspannungText(fadenspannung);
        parameterController.setTfDruckZugstationText(pZugstation);
        parameterController.setTfSpaltZugAText(spaltZugstationA);
        parameterController.setTfSpaltZugBText(spaltZugstationB);
        parameterController.setTfTaperDeckpapierText(taperDeckpapier);
        parameterController.setTfTaperPrepregText(taperPrepreg);
        parameterController.setTfFaserhalbzeugText(faserhalbzeug);
        parameterController.setTfHarzsystemText(harzsystem);
        parameterController.setTfTrägermaterialText(trägermaterial);
        parameterController.setTfKaschiermaterialText(kaschiermaterial);
    }

    @Override
    public void update(Anlagenparameter anlagenparameter) {
        this.spalthöhe = String.valueOf(anlagenparameter.getSpalthöhe());
        this.anlagengeschwindigkeit = String.valueOf(anlagenparameter.getAnlagengeschwindigkeit());
        this.verfahren = String.valueOf(anlagenparameter.getVerfahren());
        this.bahnverlauf = String.valueOf(anlagenparameter.getBahnverlauf());
        parameterController.setTfSpalthöheText(spalthöhe);
        parameterController.setTfAnlagengeschwindigkeitText(anlagengeschwindigkeit);
        parameterController.setTfVerfahrenText(verfahren);
        parameterController.setTfBahnverlaufText(bahnverlauf);
    }

    @Override
    public void update(Kalander kalander) {
        this.drehmoment = String.valueOf(kalander.getDrehmoment());
        this.drehzahl = String.valueOf(kalander.getDrehzahl());
        this.druckKalander = String.valueOf(kalander.getpKalander());
        this.spaltA = String.valueOf(kalander.getSpaltA());
        this.spaltB = String.valueOf(kalander.getSpaltB());
        parameterController.setTfDrehmomentText(drehmoment);
        parameterController.setTfDrehzahlText(drehzahl);
        parameterController.setTfSpaltAText(spaltA);
        parameterController.setTfSpaltBText(spaltB);
    }

    @Override
    public void update(Prepregeigenschaften prepregeigenschaften) {
        this.flächengewicht = String.valueOf(prepregeigenschaften.getFlächengewicht());
        this.harzgehalt = String.valueOf(prepregeigenschaften.getHarzgehalt());
        this.prepregbreite = String.valueOf(prepregeigenschaften.getPrepregbreite());
        this.laufmeter = String.valueOf(prepregeigenschaften.getLaufmeter());
        parameterController.setTfFlächengewichtText(flächengewicht);
        parameterController.setTfHarzgehaltText(harzgehalt);
        parameterController.setTfPrepregbreiteText(prepregbreite);
        parameterController.setTfLaufmeterText(laufmeter);
    }

    @Override
    public void update(Temperaturen temperaturen) {
        this.auftrag = String.valueOf(temperaturen.gettAuftrag());
        this.kalander = String.valueOf(temperaturen.gettKalander());
        this.tisch1 = String.valueOf(temperaturen.gettTisch1());
        this.tisch2 = String.valueOf(temperaturen.gettTisch2());
        this.kühlplatte = String.valueOf(temperaturen.gettKühlplatte());
        this.irStatus = String.valueOf(temperaturen.isIrStatus());
        parameterController.setTfAuftragText(auftrag);
        parameterController.setTfKalanderText(kalander);
        parameterController.setTfTisch1Text(tisch1);
        parameterController.setTfTisch2Text(tisch2);
        parameterController.setTfKühlplatteText(kühlplatte);
        parameterController.setTfIrStatusText(irStatus);
    }

    @Override
    public void update(Zugspannungen zugspannungen) {
        this.beschichtung = String.valueOf(zugspannungen.getBeschichtung());
        this.zugwalze = String.valueOf(zugspannungen.getZugwalze());
        this.gewebeOben = String.valueOf(zugspannungen.getGewebeOben());
        this.deckpapierOben = String.valueOf(zugspannungen.getDeckpapierOben());
        this.deckpapierUnten = String.valueOf(zugspannungen.getDeckpapierUnten());
        this.aufwicklerDeckpapier = String.valueOf(zugspannungen.getAufwicklerDeckpapier());
        this.aufwicklerPrepreg = String.valueOf(zugspannungen.getAufwicklerPrepreg());
        this.fadenspannung = String.valueOf(zugspannungen.getFadenspannung());
        parameterController.setTfBeschichtungText(beschichtung);
        parameterController.setTfZugwalzeText(zugwalze);
        parameterController.setTfGewebeObenText(gewebeOben);
        parameterController.setTfDeckpapierObenText(deckpapierOben);
        parameterController.setTfDeckpapierUntenText(deckpapierUnten);
        parameterController.setTfAufwicklerDText(aufwicklerDeckpapier);
        parameterController.setTfAufwicklerPText(aufwicklerPrepreg);
        parameterController.setTfFadenspannungText(fadenspannung);
    }

    @Override
    public void update(Zugstation zugstation) {
        this.pZugstation = String.valueOf(zugstation.getpZugstation());
        this.spaltZugstationA = String.valueOf(zugstation.getSpaltZugstationA());
        this.spaltZugstationB = String.valueOf(zugstation.getSpaltZugstationB());
        parameterController.setTfDruckZugstationText(pZugstation);
        parameterController.setTfSpaltZugAText(spaltZugstationA);
        parameterController.setTfSpaltZugBText(spaltZugstationB);
    }

    @Override
    public void update(Aufwickler aufwickler) {
        this.taperDeckpapier = String.valueOf(aufwickler.getTaperDeckpapier());
        this.taperPrepreg = String.valueOf(aufwickler.getTaperPrepreg());
        parameterController.setTfTaperDeckpapierText(taperDeckpapier);
        parameterController.setTfTaperPrepregText(taperPrepreg);
    }

    @Override
    public void update(Materialien materialien) {
        this.faserhalbzeug = String.valueOf(materialien.getFaserhalbzeug());
        this.harzsystem = String.valueOf(materialien.getHarzsystem());
        this.trägermaterial = String.valueOf(materialien.getTrägermaterial());
        this.kaschiermaterial = String.valueOf(materialien.getKaschiermaterial());
        parameterController.setTfFaserhalbzeugText(faserhalbzeug);
        parameterController.setTfHarzsystemText(harzsystem);
        parameterController.setTfTrägermaterialText(trägermaterial);
        parameterController.setTfKaschiermaterialText(kaschiermaterial);
    }

    @Override
    public void update(Versuch versuch) {

    }

    @Override
    public void update(Versuchsreihe versuchsreihe) {

    }
}
