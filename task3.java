import java.util.Arrays;
//Реализовать алгоритм пирамидальной сортировки (HeapSort).

public class task3 {
    public static void main(String[] args){
        int[] array = { 65, -54, 0, 15, 29, -12, 0, 135};
        heapSort(array);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void heapSort(int[] array){
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, i, size);
        }

        for (int i = size - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, i);
        }
    }

    public static void heapify(int[] array, int i, int size){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;

        if (left < size && array[left] > array[max]){
            max = left;
        }
        if (right < size && array[right] > array[max]){
            max = right;
        }
        if(i != max){
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;

            heapify(array, max, size);
        } 

    }
}

