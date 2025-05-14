class PeakMountain {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left<right){
            mid = (left + right)/2;
            if(arr[mid]<arr[mid+1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;


        // for(int i=0;i<arr.length-1;i++){
        //     if(arr[i]>arr[i+1]){
        //         return i;
        //     }
        // }
        // return 0;
    }
}