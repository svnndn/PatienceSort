import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException {
            int[][] arr = new int[100][];

            for (int i = 0; i < 100; i++) {
                int amount = (int) (100 + Math.random() * 9901);
                arr[i] = new int[amount];
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * 10000);
                }
            }
            writeToFile(arr);
    }

    public static void writeToFile(int[][] array) throws IOException {

        File file = new File("Test.txt");
        file.createNewFile();
        FileWriter filewriter = new FileWriter(new File("Test.txt"));

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < array[i].length; j++) {
                filewriter.write(array[i][j] + " ");
            }
            filewriter.write("\r\n");
        }
        filewriter.flush();
    }
}
