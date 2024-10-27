public class SortingDemo {

    // Bubble Sort Implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Recursively sort elements before partition
            quickSort(arr, pi + 1, high); // Recursively sort elements after partition
        }
    }

    // Partition function for Quick Sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the rightmost element as pivot
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample dataset
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        // Measuring time for Bubble Sort
        int[] bubbleSortData = data.clone(); // Clone the array to preserve original data
        long startTime = System.nanoTime();
        bubbleSort(bubbleSortData);
        long endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        // Measuring time for Quick Sort
        int[] quickSortData = data.clone(); // Clone the array to preserve original data
        startTime = System.nanoTime();
        quickSort(quickSortData, 0, quickSortData.length - 1);
        endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;

        // Output results
        System.out.println("Bubble Sort Result:");
        printArray(bubbleSortData);
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " nanoseconds");

        System.out.println("Quick Sort Result:");
        printArray(quickSortData);
        System.out.println("Quick Sort Time: " + quickSortTime + " nanoseconds");
    }
}
