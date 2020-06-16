package main.java;

public class Leetcode658 {

        public List<Integer> findClosestElements(int[] input, int k, int x) {
            int[] arr = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                arr[i] = x - input[i];
            }

            quickSort(arr, 0, arr.length - 1);
            Integer[] ret = new Integer[k];
            for (int j = 0; j < k; j++) {
                int diff = arr[j], original = 0;

                if (original < 0) original = Math.abs(arr[j]) + x;
                else original = x - arr[j];

                ret[j] = original;
            }

            return Arrays.stream(ret).sorted().collect(Collectors.toList());
        }

        private void quickSort(int[] arr, int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);

                quickSort(arr, begin, partitionIndex-1);
                quickSort(arr, partitionIndex+1, end);
            }
        }

        private int partition(int[] arr, int begin, int end) {
            int pivot = Math.abs(arr[end]);
            int i = (begin-1);

            for (int j = begin; j < end; j++) {
                if (Math.abs(arr[j]) <= pivot) {
                    i++;

                    int swapTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                }
            }

            int swapTemp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = swapTemp;

            return i+1;
        }
    
}
