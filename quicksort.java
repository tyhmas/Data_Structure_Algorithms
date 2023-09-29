import java.util.*;

class QuickSort{
    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] array = new int[]{3, 3, 4, 3};
        qs.quicksort(0, array.length - 1, array);
        System.out.println("After sorted, results are: ");
        qs.printArray(array);

    }

    private void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void swap(int a, int b){
        int c = a;
        a = b;
        b = c;
    }

    private int partition(int start, int end, int[] array){
        if (start == end){
            return end;
        }

        int pivot = start;
        int p = start;
        int q = end;
        int temp;
    
        while (p < q){
            while(p + 1 <= end && array[p] < array[pivot]){
                p++;
            }
            while(q - 1 >= start && array[q] >= array[pivot]){
                q--;
            }
            
            temp = array[p];
            array[p] = array[q];
            array[q] = temp;
        }

        temp = array[pivot];
        array[pivot] = array[q];
        array[q] = temp;
        printArray(array);
        return q;
    }

    private void quicksort(int start, int end, int[] array){
        System.out.println("start: " + start + ", end: " + end);
        int replace = partition(start, end, array);
        System.out.println("replacement place: " + replace);
        if (start <= replace - 1)
            quicksort(start, replace - 1, array);

        if (end >= replace + 1)
            quicksort(replace + 1, end, array);
    }
}
