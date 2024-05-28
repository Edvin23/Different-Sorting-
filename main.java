import java.util.Random;

public class main{


    public static void main(String[]args){

        long start = System.currentTimeMillis();
        int[] array = new int[10];
        bubbleSort(array);
        System.out.println("\nBubble sorted Array:");
        printArray(array);
        long end = System.currentTimeMillis();

        System.out.println("Milliseconds: " + (end - start));

        long startMerge = System.currentTimeMillis();
        int[] arrayMerge = new int[100];
        mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        System.out.println("\nMerge sorted Array:");
        printArray(arrayMerge);
        long endMerge = System.currentTimeMillis();
        System.out.println("\nMilliseconds: " + (endMerge - startMerge));


        long startQuick = System.currentTimeMillis();
        int[] arrayQuick = new int[500];
        quickSort(arrayQuick, 0, arrayQuick.length - 1);
        System.out.println("\nQuick sorted Array:");
        printArray(arrayQuick);
        long endQuick = System.currentTimeMillis();
        System.out.println("\nMilliseconds: " + (endQuick - startQuick));

        long startInsertion = System.currentTimeMillis();
        int[] arrayInsertion = new int[1000];
        insertionSort(arrayInsertion);
        System.out.println("\nInsertion sorted Array:");
        printArray(arrayInsertion);
        long endInsertion = System.currentTimeMillis();
        System.out.println("\nMilliseconds: " + (endInsertion - startInsertion));

        long startSelection = System.currentTimeMillis();
        int[] arraySelection = new int[10000];
        selectionSort(arraySelection);
        System.out.println("\nSelection sorted Array:");
        printArray(arraySelection);
        long endSelection = System.currentTimeMillis();
        System.out.println("\nMilliseconds: " + (endSelection - startSelection));


        long start_Quick = System.currentTimeMillis();
        int[] array_Quick = new int[800000];
        quickSort_(array_Quick, 0, array_Quick.length - 1);
        System.out.println("\nQuick Again sorted Array:");
        printArray(array_Quick);
        long end_Quick = System.currentTimeMillis();
        System.out.println("\nMilliseconds: " + (end_Quick - start_Quick));





    }
    public static void bubbleSort(int[] array) {
        Random rand = new Random();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            array[i] = rand.nextInt(200001);
            for (int j = 0; j < n - i - 1; j++) {
// Swap if the element found is greater than the next element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
// Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
// Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        Random rand = new Random();
        int n1 = mid - left + 1;
        int n2 = right - mid;
// Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
// Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[mid + 1 + j];
// Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
// Copy remaining elements of leftArray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
// Copy remaining elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
// Find pivot such that elements smaller than pivot are on the left,
          //  and greater on the right
            int pivotIndex = partition(arr, low, high);
// Recursively sort the sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            arr[j] = rand.nextInt(200001);
            if (arr[j] < pivot) {
// Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
// Swap pivot (arr[low]) with arr[i-1]
        int temp = arr[i - 1];
        arr[i - 1] = arr[low];
        arr[low] = temp;
        return i - 1;
    }

    public static void insertionSort(int[] arrayInsertion) {
        Random rand = new Random();
        int n = arrayInsertion.length;
        for (int i = 1; i < n; ++i) {
            arrayInsertion[i] = rand.nextInt(200001);
            int key = arrayInsertion[i];
            int j = i - 1;
            arrayInsertion[j] = rand.nextInt(200001);
// Move elements of arr[0..i-1] that are greater than key to one
            //position ahead of their current position
            while (j >= 0 && arrayInsertion[j] > key) {
                arrayInsertion[j + 1] = arrayInsertion[j];
                j = j - 1;
            }
            arrayInsertion[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arraySelection) {
        Random rand = new Random();
        int n = arraySelection.length;
        for (int i = 0; i < n-1; i++) {
            arraySelection[i] = rand.nextInt(200001);
// Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                arraySelection[j] = rand.nextInt(200001);
                if (arraySelection[j] < arraySelection[minIndex]) {
                    minIndex = j;
                }
            }
// Swap the found minimum element with the first element
            int temp = arraySelection[minIndex];
            arraySelection[minIndex] = arraySelection[i];
            arraySelection[i] = temp;
        }
    }

    public static void quickSort_(int[] arr, int low, int high) {
        if (low < high) {
// Find pivot such that elements smaller than pivot are on the left,
            //  and greater on the right
            int pivotIndex = partition_(arr, low, high);
// Recursively sort the sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition_(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            arr[j] = rand.nextInt(200001);
            if (arr[j] < pivot) {
// Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
// Swap pivot (arr[low]) with arr[i-1]
        int temp = arr[i - 1];
        arr[i - 1] = arr[low];
        arr[low] = temp;
        return i - 1;

    }
    long end = System.currentTimeMillis();

    public static void printArray(int[] arr) {

        for (int value : arr) {
            System.out.print(value + " ");

        }
        System.out.println();
    }
}

