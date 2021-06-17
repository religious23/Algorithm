package 每日一题;

/**
 * @author 王文
 * @version : V1.0
 * @className: Lk20210615
 * @description: 巅峰山脉问题  二分法
 * @date 2021-06-17
 */
public class Lk20210615 {
    public static int peakIndexInMountainArray(int[] arr) {
        if(arr==null){
            return -1;
        }
        if(arr.length==1){
            return 0;
        }
        int l=0;
        int r=arr.length-1;
        while(l<r){
           int mid=l+r+1>>1;
            if(arr[mid-1]<arr[mid]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
