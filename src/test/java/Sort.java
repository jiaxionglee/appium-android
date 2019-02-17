/**
 * Created by jiaxiong on 2019-02-15 16:13
 */
public class Sort {

    void quickSort(int arr[],int start,int end){
        if (start>end){
            return;
        }
        int i=start;
        int j=end;
        int baseval=arr[start];
        while (i<j){
            while (arr[j]>=baseval){
                j--;
            }
            if (i<j){
                arr[i]=arr[j];
                i++;
            }

            while (arr[j]<baseval){
                j--;
            }
            if (i<j){
                arr[i]=arr[j];
                i++;
            }
        }
    }

    public static void main(String args[]){
        Sort sortTest = new Sort();

        int arr[]={3,2,38,26,27,46,48,50,47,4};
        sortTest.quickSort(arr,4,9);
    }
}