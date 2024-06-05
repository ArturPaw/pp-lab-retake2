package dataset;

import java.util.Collections;
import java.util.List;

public interface StatisticsOperations {
    static double calculateMean(DataSet dataSet) {
        List<Double> data = dataSet.getData();
        double sum = 0.0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    static double calculateMedian(DataSet dataSet) {
        List<Double> data = dataSet.getData();
        Collections.sort(data);
        int size = data.size();
        if (size % 2 == 0) {
            return (data.get(size / 2 - 1) + data.get(size / 2)) / 2.0;
        } else {
            return data.get(size / 2);
        }
    }

    static double calculateStandardDeviation(DataSet dataSet) {
        List<Double> data = dataSet.getData();
        double mean = calculateMean(dataSet);
        double sum = 0.0;
        for (double num : data) {
            sum += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum / data.size());
    }
}
