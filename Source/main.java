import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;
import java.io.File;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] SortArray = null;

        System.out.println("Do you want a random array(0) or enter your specific array(1)?");
        System.out.println("enter 'quit' to discontinue.");
        String user_input = sc.next();

        while (!user_input.equalsIgnoreCase("quit")) {

            if (user_input.equals("0")) {
                System.out.println("Enter the size of the random array(n)");
                int n = sc.nextInt();

                // storing the generated array in variable randomArray
                SortArray = GenerateRandomArray(n);

                /*
                 * In order to display the random generated array, we use
                 * the function Array.toString() that will convert it into string format
                 */
                System.out.println("The generated random array:" + Arrays.toString(SortArray));
            }

            else if (user_input.equals("1")) {
                System.out.println("Enter the size of your specific array(n)");
                int size = sc.nextInt();

                SortArray = new int[size];
                System.out.println("Enter " + size + " elements");
                for (int i = 0; i < size; i++) {
                    SortArray[i] = sc.nextInt();
                }
                System.out.println("Your specific array:" + Arrays.toString(SortArray));
            }

            else {
                System.out.println("Please enter 0 or 1 or quit!! ");
                user_input = sc.next();
                continue;
            }

            System.out.println("Please enter the sorting algorithm:");
            System.out.println(
                    "Enter the appropriate number:\nBubbleSort=1\nInsertion=2\nMergeSort=3\nQuickSort=4\nSelectionSort=5");

            int SortingAlgorithm = sc.nextInt();

            // switch case for the different sorting algorithm
            switch (SortingAlgorithm) {

                case 1: {
                    System.out.println("You have selected Bubble sort");

                    int[] copyArray = Arrays.copyOf(SortArray, SortArray.length);

                    long startTime = System.nanoTime();
                    // invoking the BubbleSort
                    int num_comparisons = BubbleSort.bubbleSort(copyArray);
                    long endTime = System.nanoTime();

                    System.out.println("The sorted array:" + Arrays.toString(copyArray));
                    System.out.println("This sorting algorithm took:" + (endTime - startTime) + " ns");
                    System.out.println("The number of comparisons:" + num_comparisons);

                    String record = "SortingAlgorithm: BubbleSort | Size: " + copyArray.length + "\n" +
                            "Time taken: " + (endTime - startTime) + " ns\n" +
                            "Number of Comparisons: " + num_comparisons + "\n" +
                            "-------------------------";

                    if (!Exists("BubbleSort", copyArray.length)) {
                        writeToFile(record);
                    } else {
                        System.out.println("Already exists in file.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("You have selected Insertion Sort");

                    int[] copyArray = Arrays.copyOf(SortArray, SortArray.length);

                    long startTime = System.nanoTime();
                    int num_comparisons = InsertionSort.insertionSort(copyArray);
                    long endTime = System.nanoTime();

                    System.out.println("The sorted array:" + Arrays.toString(copyArray));
                    System.out.println("This sorting algorithm took:" + (endTime - startTime) + " ns");
                    System.out.println("The number of comparisons:" + num_comparisons);

                    String record = "SortingAlgorithm: InsertionSort | Size: " + copyArray.length + "\n" +
                            "Time taken: " + (endTime - startTime) + " ns\n" +
                            "Number of Comparisons: " + num_comparisons + "\n" +
                            "-------------------------";

                    if (!Exists("InsertionSort", copyArray.length)) {
                        writeToFile(record);
                    } else {
                        System.out.println("Already exists in file.");
                    }
                    break;
                }

                case 3: {
                    System.out.println("You have selected Merge Sort");

                    int[] copyArray = Arrays.copyOf(SortArray, SortArray.length);

                    long startTime = System.nanoTime();
                    int num_comparisons = MergeSort.mergeSort(copyArray);
                    long endTime = System.nanoTime();

                    System.out.println("The sorted array:" + Arrays.toString(copyArray));
                    System.out.println("This sorting algorithm took:" + (endTime - startTime) + " ns");
                    System.out.println("The number of comparisons:" + num_comparisons);

                    String record = "SortingAlgorithm: MergeSort | Size: " + copyArray.length + "\n" +
                            "Time taken: " + (endTime - startTime) + " ns\n" +
                            "Number of Comparisons: " + num_comparisons + "\n" +
                            "-------------------------";

                    if (!Exists("MergeSort", copyArray.length)) {
                        writeToFile(record);
                    } else {
                        System.out.println("Already exists in file.");
                    }
                    break;
                }

                case 4: {
                    System.out.println("You have selected Quick Sort");

                    int[] copyArray = Arrays.copyOf(SortArray, SortArray.length);

                    long startTime = System.nanoTime();
                    int num_comparisons = QuickSort.quickSort(copyArray, 0, copyArray.length - 1);
                    long endTime = System.nanoTime();

                    System.out.println("The sorted array:" + Arrays.toString(copyArray));
                    System.out.println("This sorting algorithm took:" + (endTime - startTime) + " ns");
                    System.out.println("The number of comparisons:" + num_comparisons);

                    String record = "SortingAlgorithm: QuickSort | Size: " + copyArray.length + "\n" +
                            "Time taken: " + (endTime - startTime) + " ns\n" +
                            "Number of Comparisons: " + num_comparisons + "\n" +
                            "-------------------------";

                    if (!Exists("QuickSort", copyArray.length)) {
                        writeToFile(record);
                    } else {
                        System.out.println("Already exists in file.");
                    }
                    break;
                }

                case 5: {
                    System.out.println("You have selected Selection Sort");

                    int[] copyArray = Arrays.copyOf(SortArray, SortArray.length);

                    long startTime = System.nanoTime();
                    int num_comparisons = SelectionSort.selectionSort(copyArray);
                    long endTime = System.nanoTime();

                    System.out.println("The sorted array:" + Arrays.toString(copyArray));
                    System.out.println("This sorting algorithm took:" + (endTime - startTime) + " ns");
                    System.out.println("The number of comparisons:" + num_comparisons);

                    String record = "SortingAlgorithm: SelectionSort | Size: " + copyArray.length + "\n" +
                            "Time taken: " + (endTime - startTime) + " ns\n" +
                            "Number of Comparisons: " + num_comparisons + "\n" +
                            "-------------------------";

                    if (!Exists("SelectionSort", copyArray.length)) {
                        writeToFile(record);
                    } else {
                        System.out.println("Already exists in file.");
                    }
                    break;
                }

                default:
                    System.out.println("Invalid choice!");
            }

            // ask to open file (after operation)
            System.out.println("\nOpen record.txt? (1=yes / 0=no)");
            int open = sc.nextInt();
            if (open == 1) {
                openFile();
            }

            System.out.println("\nContinue? (0/1 or type quit)");
            user_input = sc.next();
        }

        System.out.println("Program ended.");
        sc.close();
    }

    // GenerateRandomArray() function
    public static int[] GenerateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }

    // appending to record.txt file
    public static void writeToFile(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("record.txt", true))) {
            bw.write(text);
            bw.newLine();
            System.out.println("Saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openFile() {
        try {
            File file = new File("record.txt");
            if (file.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("File not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // check if record already exists
    public static boolean Exists(String SortingAlgorithm, int size) {
        File file = new File("record.txt");

        if (!file.exists()) {
            return false;
        }

        try {
            Scanner reader = new Scanner(file);

            String condition = "SortingAlgorithm: " + SortingAlgorithm + " | Size: " + size;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains(condition)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}