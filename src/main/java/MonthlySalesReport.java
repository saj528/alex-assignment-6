import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class MonthlySalesReport {
    private YearMonth date;
    private Integer monthlySales;

    public MonthlySalesReport(String date, String monthlySales) {
        this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy"));;
        this.monthlySales = Integer.parseInt(monthlySales);

    }

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth timeOfSales) {
        this.date = date;
    }

    public Integer getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(int monthlySales) {
        this.monthlySales = monthlySales;
    }

    @Override
    public String toString() {
        return "Monthly Sales Report [date=" + date + ", sales=" + monthlySales + "]";
    }
}
