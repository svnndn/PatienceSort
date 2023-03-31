import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            InputStream stream = new FileInputStream("data/Test.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers_1 = line.split(" ");
                List<Integer> numbers = new ArrayList<Integer>();
                for (int i = 0; i < numbers_1.length; i++) {
                    numbers.add(Integer.parseInt(numbers_1[i]));
                }
                PatienceSort a = new PatienceSort(numbers);
                a.patienceSorting(numbers);
                OutputStream res = new FileOutputStream("data/Results.txt", true);
                PrintStream printStream = new PrintStream(res);
                printStream.print(numbers.size());
                printStream.print(";");
                printStream.print(a.getTime());
                printStream.print(";");
                printStream.print(a.getIterations());
                printStream.println();
                printStream.close();
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
