import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.*;

// QuickSort Class
public class QuickSort {

    // Define
    String names[];
    int length;
    int counter = 0; // Define the counter and set it 0

    // To handle exceptions include throws
    public static void main(String[] args)
            throws IOException  {

        // List that holds strings of a file
        List<String> listOfStrings
                = new ArrayList<String>();

        // Load data from file
        BufferedReader bf = new BufferedReader(
                new FileReader("src/TextList.txt"));

        // Read entire line as string
        String line = bf.readLine();

        // Checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();

        }
        // Closing buffer reader object
        bf.close();

        // Storing the data in arraylist to array
        String[] array
                = listOfStrings.toArray(new String[0]);

        // Define the sorter
        QuickSort sorter = new QuickSort();
        sorter.sort(array);  // Sort the array using the sort function

        // Write to a file
        FileWriter writer = new FileWriter("src/QuickSortedList.txt");
        int len = array.length;
        for (int i = 0; i < len; i++) {
            writer.write(array[i] + "\n"+ "");
        }

        // Close the input file
        writer.close();

        // Calculate execution time
        Calendar calendar = Calendar.getInstance();
        Date start = calendar.getTime(); //count start time
        calendar = Calendar.getInstance();
        Date end = calendar.getTime(); //count end time
        long sum = end.getTime() - start.getTime(); //get execution time
        System.out.println("Execution time: "+sum+" ms"); //print execution time
    }

    // The sort function
    void sort(String array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        this.names = array;
        this.length = array.length;
        partition(0, length - 1);

        // Print each string in array
        for (String eachString : array) {
            System.out.println(eachString);
        }
        
    }

    // The partition function
    void partition(int lowerIndex, int higherIndex) {

        // Define lower index and higher index
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names[lowerIndex + (higherIndex - lowerIndex) / 2];

        // Pivot comparison
        while (i <= j) {
            while (this.names[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.names[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }

        // Call partition recursively
        if (lowerIndex < j) {
            partition(lowerIndex, j);
        }
        if (i < higherIndex) {
            partition(i, higherIndex);
        }
    }

    // Exchange name function
    void exchangeNames(int i, int j) {
        String temp = this.names[i];
        this.names[i] = this.names[j];
        this.names[j] = temp;
    }
}