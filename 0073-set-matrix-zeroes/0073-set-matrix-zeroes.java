class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col = matrix[0].length;
       
       int rowmatrix[]=new int[row];
       int colmatrix[]=new int[col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowmatrix[i]=1;
                    colmatrix[j]=1;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowmatrix[i]==1 || colmatrix[j]==1)
                    matrix[i][j]=0;
            }
        }
    }
}