import java.util.*;

class MergeSort{
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		int[] array = new int[] {101, 98, 13, 15, 26, 78, 64, 23, 109, 12};
		ms.sort(0, array.length - 1, array);
		ms.printArray(array);

	}

	private void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

	private void sort(int start, int end, int[] array){
		if (start == end){
			return;
		}

		int index = (end + start - 1) / 2;
		sort(start, index, array);
		sort(index + 1, end, array);
		merge(start, end, array, index);
	}

	private void merge(int start, int end, int[] array, int index){
		//index is included when calculate len1
		int len1 = index - start + 1;
		int len2 = end - index;

		int[] a1 = new int[len1];
		int[] a2 = new int[len2];

		for(int i = 0; i < len1; i++){
			a1[i] = array[start + i];
		}

		for(int i = 0; i < len2; i++){
			a2[i] = array[index + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = start;

		while (i < len1 && j < len2){
			if (a1[i] < a2[j]){
				array[k] = a1[i];
				k++;
				i++;
			}
			else{
				array[k] = a2[j];
				k++;
				j++;
			}

		}

		while(i < len1){
			array[k] = a1[i];
			k++;
			i++;
		}

		while(j < len2){
			array[k] = a2[j];
			k++;
			j++;
		}
	}
}