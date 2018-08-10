public class Matrix2 {

  private static int final DEFAULT_DIM = 10;
  private int [][] mat;
  private int row;
  private int col;


  public Matrix2() {
    mat = new int[DEFAULT_DIM][DEFAULT_DIM];
    row = DEFAULT_DIM;
    col = DEFAULT_DIM;
  }

  public Matrix2(int row, int col) {
    /*for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        mat[i][j] = 0;
      }
    }*/
    this.row = row;
    this.col = col;

    mat = new int[row][col];
    //int [] testArr = mat[0];
    //System.out.println(testArr[0]);
  }

  public void printMatrix2() {
    System.out.print("_");
    for(int i = 0; i < col-2; i++) {
      System.out.print(" "
    }
    for(int i = 0; i < row; i++) {
      
      for(int j = 0; j < col; j++) {
          
      }
    }
  }

  public int getDeterminant() {
    return 1;
  }

  public int findMax() {
    // add check for empty array
    int max = mat[0][0];
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(mat[i][j] > max) {
          max = mat[i][j];
        }
      }
    }
    return max;
  }

  public int findMin() {
    // add check for empty array
    int min = mat[0][0];
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(mat[i][j] < min) {
          min = mat[i][j];
        }
      }
    }

    return min;
  }
        

}
