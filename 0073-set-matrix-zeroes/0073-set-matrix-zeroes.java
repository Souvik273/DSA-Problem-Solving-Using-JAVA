class Solution {
    public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        int row_arr[] = new int [row];
        int col_arr[] = new int [col];

        for(int i =0 ; i<row ; i++){
            for(int j = 0 ; j< col; j++){
                if(matrix[i][j]==0){
                    row_arr[i]=1;
                    col_arr[j]=1;
                }
            }
        }
        for(int i = 0 ; i< row ; i++){
            for(int j =0 ; j< col; j++){
                if(row_arr[i]==1 || col_arr[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}