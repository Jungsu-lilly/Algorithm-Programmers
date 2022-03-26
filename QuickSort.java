public class QuickSort {
    public void quickSort(int start, int end, int[] arr){
        if(start >= end) return;

        int i = start + 1;
        int j = end;
        int key =start;

        while(i<=j){
            while(i<=end && arr[i] <= arr[key]){ // arr[key] 보다 더 큰값 발견
                i++;
            }
            while(j>start && arr[j] >= arr[key]){ // arr[key] 보다 더 작은값 발견
                j--;
            }
            if(i > j){
                int temp = arr[j];
                arr[j] = arr[key];
                arr[key] = temp;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        quickSort(start, j-1, arr);
        quickSort(j+1, end, arr);
    }

    public static void main(String[] args) {

        QuickSort t = new QuickSort();
        int[] arr1 = {1,10,5,8,7,6,4,3,2,9};
        int[] arr2 = {2,4,6,8,10,5,7,9,1,3};

        t.quickSort(0,9,arr1);
        t.quickSort(0,9,arr2);

        for (int i : arr1) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i : arr2) {
            System.out.print(i+"  ");
        }
    }
}
