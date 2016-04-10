package de.fraas.prepregdatatracker.ui.utils;

import de.fraas.prepregdatatracker.services.ExportService;
import de.fraas.prepregdatatracker.ui.controller.ExportController;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

/**
 * Created by Marcel Fraas on 16.03.16.
 */
public class CheckBoxCellFactory implements Callback {

    @Override
    public TableCell call(Object param) {
        CheckBoxTableCell<ExportService.Tabledata,Boolean> checkBoxCell = new CheckBoxTableCell<ExportService.Tabledata, Boolean>();
        return checkBoxCell;
    }
}
