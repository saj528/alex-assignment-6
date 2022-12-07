import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public List<MonthlySalesReport> readData (String fileName) throws IOException {
		List<MonthlySalesReport> sales = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				sales.add(new MonthlySalesReport(values[0], values[1]));
			}
			return sales;
		} finally {
			if (reader != null)
				reader.close();
		}
	}
}
