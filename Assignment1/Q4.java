public class Q4 {
    public static void main(String[] args){
        int rows, cols, sumRow, sumCol;

        int arr[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rows = arr.length;
        cols = arr[0].length;

        for(int i=0;i < rows;i++){
            sumRow = 0;
            for(int j=0; j< cols;j++){
                sumRow = sumRow + arr[i][j];
            }
            System.out.println("Row "+(i+1)+" sum: "+sumRow);
        }

        for(int i=0; i< cols;i++){
            sumCol = 0;
            for(int j=0; j<cols; j++){
                sumCol = sumCol + arr[j][i];
            }
            System.out.println("Col "+(i+1)+" sum: "+sumCol);
        }


    }
}
