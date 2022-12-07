import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        CSVReader reader = new CSVReader();

        List<MonthlySalesReport> model3 = reader.readData("model3.csv");
        YearlySalesReport(model3,"Model 3");

        List<MonthlySalesReport> modelS = reader.readData("modelS.csv");
        YearlySalesReport(modelS,"Model S");

        List<MonthlySalesReport> modelX = reader.readData("modelX.csv");
        YearlySalesReport(modelX,"Model X");

        //System.out.println("Debug line");

    }

    private static void YearlySalesReport(List<MonthlySalesReport> salesData, String carModel) {
        System.out.println(carModel + " Yearly Sales Report");
        System.out.println("---------------------------");

        Map<Integer, List<MonthlySalesReport>> groupedByYearData = salesData.stream()
                .collect(Collectors.groupingBy(d -> d.getDate().getYear()));

        String totalYearlySales = groupedByYearData.entrySet()
                .stream()
                .map(d -> d.getKey() + " -> " + d.getValue().stream().mapToInt(s -> s.getMonthlySales()).sum())
                .collect(Collectors.joining("\n"));

        System.out.println(totalYearlySales);
        System.out.println("");

        Optional<MonthlySalesReport> maxSalesData = salesData.stream()
                .max((MonthlySalesReport o1, MonthlySalesReport o2) -> o1.getMonthlySales().compareTo(o2.getMonthlySales()));
        Optional<MonthlySalesReport> minSalesData = salesData.stream()
                .min((MonthlySalesReport o1, MonthlySalesReport o2) -> o1.getMonthlySales().compareTo(o2.getMonthlySales()));

        System.out.println("The best month for " + carModel + " was: " + maxSalesData.get().getDate());
        System.out.println("The worst month for " + carModel + " was: " + minSalesData.get().getDate());
        System.out.println("");
    }


}
