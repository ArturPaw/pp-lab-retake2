package dataset.gui.controllers;

import dataset.DataSet;
import dataset.StatisticsManager;
import dataset.StatisticsOperations;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

public class MainController {
    private StatisticsManager manager = new StatisticsManager();

    @FXML
    private void addDataSet() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add DataSet");
        dialog.setHeaderText("Add a new data set");
        dialog.setContentText("Please enter data set values (comma separated):");

        dialog.showAndWait().ifPresent(values -> {
            DataSet dataSet = new DataSet();
            for (String value : values.split(",")) {
                dataSet.addData(Double.parseDouble(value.trim()));
            }
            manager.addDataSet(dataSet);
        });
    }

    @FXML
    private void removeDataSet() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Remove DataSet");
        dialog.setHeaderText("Remove an existing data set");
        dialog.setContentText("Please enter the index of the data set to remove:");

        dialog.showAndWait().ifPresent(index -> {
            try {
                int i = Integer.parseInt(index.trim());
                manager.removeDataSet(i);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Index");
                alert.setContentText("Please enter a valid integer index.");
                alert.showAndWait();
            }
        });
    }

    @FXML
    private void calculateMean() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Calculate Mean");
        alert.setHeaderText("Mean of all data sets");
        alert.setContentText("The mean is: " + StatisticsOperations.calculateMean(manager.getAllData()));

        alert.showAndWait();
    }

    @FXML
    private void calculateMedian() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Calculate Median");
        alert.setHeaderText("Median of all data sets");
        alert.setContentText("The median is: " + StatisticsOperations.calculateMedian(manager.getAllData()));

        alert.showAndWait();
    }

    @FXML
    private void calculateStandardDeviation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Calculate Standard Deviation");
        alert.setHeaderText("Standard Deviation of all data sets");
        alert.setContentText("The standard deviation is: " + StatisticsOperations.calculateStandardDeviation(manager.getAllData()));

        alert.showAndWait();
    }
}
