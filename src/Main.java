import java.util.Scanner;

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

        boolean running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.println("Menu:");
                System.out.println("1. Dodaj nowy zbiór danych");
                System.out.println("2. Usuń istniejący zbiór danych");
                System.out.println("3. Oblicz średnią arytmetyczną");
                System.out.println("4. Oblicz medianę");
                System.out.println("5. Oblicz odchylenie standardowe");
                System.out.println("6. Wyjście");
                System.out.print("Wybierz opcję: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        DataSet newDataSet = new DataSet();
                        System.out.print("Ile liczb chcesz dodać? ");
                        int count = scanner.nextInt();
                        for (int i = 0; i < count; i++) {
                            System.out.print("Podaj liczbę: ");
                            double value = scanner.nextDouble();
                            newDataSet.addData(value);
                        }
                        manager.addDataSet(newDataSet);
                    }
                    case 2 -> {
                        System.out.print("Podaj indeks zbioru do usunięcia: ");
                        int indexToRemove = scanner.nextInt();
                        if (indexToRemove >= 0 && indexToRemove < manager.getDataSets().size()) {
                            manager.removeDataSet(manager.getDataSets().get(indexToRemove));
                        } else {
                            System.out.println("Nieprawidłowy indeks.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Podaj indeks zbioru: ");
                        int meanIndex = scanner.nextInt();
                        if (meanIndex >= 0 && meanIndex < manager.getDataSets().size()) {
                            System.out.println("Średnia: " + StatisticsOperations.calculateMean(manager.getDataSets().get(meanIndex)));
                        } else {
                            System.out.println("Nieprawidłowy indeks.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Podaj indeks zbioru: ");
                        int medianIndex = scanner.nextInt();
                        if (medianIndex >= 0 && medianIndex < manager.getDataSets().size()) {
                            System.out.println("Mediana: " + StatisticsOperations.calculateMedian(manager.getDataSets().get(medianIndex)));
                        } else {
                            System.out.println("Nieprawidłowy indeks.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Podaj indeks zbioru: ");
                        int stdDevIndex = scanner.nextInt();
                        if (stdDevIndex >= 0 && stdDevIndex < manager.getDataSets().size()) {
                            System.out.println("Odchylenie standardowe: " + StatisticsOperations.calculateStandardDeviation(manager.getDataSets().get(stdDevIndex)));
                        } else {
                            System.out.println("Nieprawidłowy indeks.");
                        }
                    }
                    case 6 -> running = false;
                    default -> System.out.println("Nieprawidłowa opcja.");
                }
            }
        }
    }
}
