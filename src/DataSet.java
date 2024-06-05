import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private final List<Double> data;

    public DataSet() {
        this.data = new ArrayList<>();
    }

    public void addData(double value) {
        data.add(value);
    }

    public void removeData(double value) {
        data.remove(value);
    }

    public List<Double> getData() {
        return new ArrayList<>(data);
    }
}
