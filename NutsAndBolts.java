import java.util.*;

class NutsAndBolts {
        
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        
        quickSort(nuts, bolts, 0, nuts.length-1);
        printArray(nuts);
        printArray(bolts);
    }
    
    public static int partition(char[] array, int low, int high, char pivot) {
        int i = low, j = high;
        int pivotIndex = -1;
        while (i < j) {
            while (i <= high && array[i] < pivot) {
                i++;
            }
            while (j > low && array[j] > pivot) {
                j--;
            }
            if(i == low) {
                if(array[low] == pivot) {
                    pivotIndex = low;
                }
            } else if(array[i-1] == pivot) {
                pivotIndex = i-1;
            } else if(array[j] == pivot) {
                pivotIndex = j;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        if( pivotIndex != -1 && pivotIndex < j) {
            swap(array, pivotIndex, j);
        }
        return j;
    }

    public static void quickSort(char nuts[], char bolts[], int low, int high) {
        if(low > high) {
            return;
        }
        int pivot = partition(nuts, low, high, bolts[low]);
        partition(bolts, low, high, nuts[pivot]);
        quickSort(nuts, bolts, low, pivot-1);
        quickSort(nuts, bolts, pivot+1, high);
    }
    
    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void printArray(char[] arr) {
        for (char ch : arr){
            System.out.print(ch + " ");
        }
        System.out.print("\n");
    }
}
