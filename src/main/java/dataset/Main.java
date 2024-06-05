package dataset;

public class Main {
    public static void main(String[] args) {
        StatisticsManager manager = new StatisticsManager();

        DataSet dataSet1 = new DataSet();
        dataSet1.addData(1.0);
        dataSet1.addData(2.0);
        dataSet1.addData(3.0);
        manager.addDataSet(dataSet1);

        DataSet dataSet2 = new DataSet();
        dataSet2.addData(4.0);
        dataSet2.addData(5.0);
        dataSet2.addData(6.0);
        manager.addDataSet(dataSet2);

        DataSet dataSet3 = new DataSet();
        dataSet3.addData(7.0);
        dataSet3.addData(8.0);
        dataSet3.addData(9.0);
        manager.addDataSet(dataSet3);

        System.out.println("Zbiory danych:");
        manager.getDataSets().forEach(dataSet -> System.out.println(dataSet.getData()));
    }
}
