class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++) {
            int[] temp=matrix[i];
            reverse(temp);
        }
        return;
    }
    public void reverse(int[] arr) {
        int st=0;
        int end=arr.length-1;

        while(st<end) {
            int k=arr[st];
            arr[st]=arr[end];
            arr[end]=k;
            st++;
            end--;
        }
        return;
    }
}