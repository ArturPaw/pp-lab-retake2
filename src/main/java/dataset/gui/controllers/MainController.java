package dataset.gui.controllers;

import java.util.function.Function;

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
        TextInputDialog dialog = new TextInputDialog("Wprowadź wartości oddzielone przecinkami");
        dialog.setTitle("Dodaj Zbiór Danych");
        dialog.setHeaderText("Dodaj nowy zbiór danych");
        dialog.setContentText("Dane:");

        dialog.showAndWait().ifPresent(data -> {
            String[] values = data.split(",");
            DataSet newDataSet = new DataSet();
            for (String value : values) {
                newDataSet.addData(Double.parseDouble(value.trim()));
            }
            manager.addDataSet(newDataSet);
        });
    }

    @FXML
    private void removeDataSet() {
        TextInputDialog dialog = new TextInputDialog("Podaj indeks");
        dialog.setTitle("Usuń Zbiór Danych");
        dialog.setHeaderText("Usuń istniejący zbiór danych");
        dialog.setContentText("Indeks:");

        dialog.showAndWait().ifPresent(index -> {
            int idx = Integer.parseInt(index.trim());
            if (idx >= 0 && idx < manager.getDataSets().size()) {
                manager.removeDataSet(manager.getDataSets().get(idx));
            } else {
                showAlert("Nieprawidłowy Indeks", "Proszę podać prawidłowy indeks.");
            }
        });
    }

    @FXML
    private void calculateMean() {
        calculateStatistic("Oblicz Średnią", StatisticsOperations::calculateMean);
    }

    @FXML
    private void calculateMedian() {
        calculateStatistic("Oblicz Medianę", StatisticsOperations::calculateMedian);
    }

    @FXML
    private void calculateStandardDeviation() {
        calculateStatistic("Oblicz Odchylenie Standardowe", StatisticsOperations::calculateStandardDeviation);
    }

    private void calculateStatistic(String title, Function<DataSet, Double> statisticFunction) {
        TextInputDialog dialog = new TextInputDialog("Podaj indeks");
        dialog.setTitle(title);
        dialog.setHeaderText(title);
        dialog.setContentText("Indeks:");

        dialog.showAndWait().ifPresent(index -> {
            int idx = Integer.parseInt(index.trim());
            if (idx >= 0 && idx < manager.getDataSets().size()) {
                double result = statisticFunction.apply(manager.getDataSets().get(idx));
                showAlert(title, "Wynik: " + result);
            } else {
                showAlert("Nieprawidłowy Indeks", "Proszę podać prawidłowy indeks.");
            }
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
