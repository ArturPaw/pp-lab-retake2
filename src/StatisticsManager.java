import java.util.ArrayList;
import java.util.List;

public class StatisticsManager implements StatisticsOperations {
    private final List<DataSet> dataSets;

    public StatisticsManager() {
        this.dataSets = new ArrayList<>();
    }

    public void addDataSet(DataSet dataSet) {
        dataSets.add(dataSet);
    }

    public void removeDataSet(DataSet dataSet) {
        dataSets.remove(dataSet);
    }

    public List<DataSet> getDataSets() {
        return new ArrayList<>(dataSets);
    }
}
