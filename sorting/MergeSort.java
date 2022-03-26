package sorting;

public class MergeSort {
    static int[] sorted;

    void merge(int arr[], int m, int n){
        int mid = (m+n)/2;
        int i = m, j = mid + 1, k = m;

        while(i<=mid && j<=n){
            if(arr[i] >= arr[j]){
                sorted[k] = arr[j];
                j++;
            }else{
                sorted[k] = arr[i];
                i++;
            }
            k++;
        }

        // 남은 데이터도 삽입
        if(i > mid){
            while(j <= n){
                sorted[k++] = arr[j];
                j++;
            }
        }else{
            while(i <= mid){
                sorted[k++] = arr[i];
                i++;
            }
        }

        for(int t = m; t<=n;t++){
            arr[t] = sorted[t];
        }
    }

    void mergeSort(int arr[], int m, int n){
        if(m<n){
            int middle = (m+n)/2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr,m , n);
        }
    }

    public static void main(String[] args) {
        int arr[] = {7,6,5,8,3,5,9,1};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr,0,7);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

