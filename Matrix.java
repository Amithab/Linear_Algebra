public class Matrix {

  private static final int DEFAULT_SIZE = 10;
  private static final double DOUBLE_TOLERANCE = 0.0000001;
  private int rowInterchanges;
  private int size;
  private int dim;
  private int maxDim;
  private double [] arr;
  private Matrix [] multArr = null;

  /* 1xDEFAULT_SIZE Matrix generator all set to 0 */
  public Matrix() {
    arr = new double[DEFAULT_SIZE];
    size = DEFAULT_SIZE;
    this.dim = 1;
    this.maxDim = 1;
  }

  /* 1xs Matrix generator all set to 0 */
  public Matrix(int size) {
    arr = new double[size];
    this.size = size;
    this.dim = 1;
    this.maxDim = 1;
  }

  /* s1xs2x...xsn Matrix generator all set to 0 */
  public Matrix(int [] sizes, int maxDim) {
    this.maxDim = maxDim;
    if(sizes.length == 1) {
      arr = new double[sizes[0]];
      this.size = sizes[0];
      this.dim = 1;
    }
    else {
      multArr = new Matrix[sizes[0]];
      this.size = sizes[0];
      this.dim = sizes.length;

      for(int i = 0; i < sizes[0]; i++) {
        int [] sizes2 = new int[sizes.length-1];
        for(int j = 0; j < sizes2.length; j++) {
          sizes2[j] = sizes[j+1];
        }

        multArr[i] = new Matrix(sizes2, maxDim);
      }
    }

  }

  /* NxNxN...xN Matrix generator all set to 0 */
  public Matrix(int size, int dim, int maxDim) {
    this.maxDim = maxDim;
    if(dim == 1) {
      arr = new double[size];
      this.size = size;
      this.dim = 1;
    }
    else {
      multArr = new Matrix[size];
      this.size = size;
      this.dim = dim;

      for(int i = 0; i < size; i++) {
        multArr[i] = new Matrix(size, dim-1, maxDim);
      }
    }
  }

  /* Deep copy constructor */
  public Matrix(Matrix copy) {
    this.maxDim = copy.maxDim;
    if(copy.dim == 1) {
      this.arr = new double[copy.size];
      this.size = copy.size;
      this.dim = 1;

      for(int i = 0; i < copy.size; i++) {
        this.arr[i] = copy.arr[i];
      }
    }
    else {
      multArr = new Matrix[copy.size];
      this.size = copy.size;
      this.dim = copy.dim;

      for(int i = 0; i < size; i++) {
        multArr[i] = new Matrix(copy.multArr[i]);
      }
    }
  }

  public void printArr() {
    System.out.print("[\t");
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "\t");
    }
    System.out.print("]");
  }

  public void printMatrix() {
    if(dim == 1 ) {
      printArr();
      System.out.println();
    }
    else {
      for(int j = 2; j < dim; j++) {
        System.out.print("----");
      }
      if(dim > 2) {
        System.out.println();
        //System.out.println("2D Matrix at dimension: "+ dim + " Index: 0");

      }
      
      for(int i = 0; i < multArr.length; i++) {
        if(dim > 2) {
          for(int j = 0; j < maxDim - dim; j++) {
            System.out.print("\t");
          }
          System.out.println((dim-1) + "D Matrix at Dim: "+ dim + " Ind: "+ i);
        }
        multArr[i].printMatrix();
        //System.out.println();
        for(int j = 2; j < dim; j++) {
          System.out.print("----");
        }
        if(dim > 2) {
          System.out.println();
        }
      }
    }

/*
    System.out.print("_");
    for(int i = 0; i < col-2; i++) {
      System.out.print(" "
    }
    for(int i = 0; i < row; i++) {
      
      for(int j = 0; j < col; j++) {
          
      }
    }*/
  }

  public Matrix matrixMultiply(Matrix b) {
    
    if(this.dim > 2 || b.dim > 2) {
      System.out.printf("Dimensions for matrices are too high");
      return null;
    }

    if(this.dim == 1) {

      /* 1xN matrix times NxM matrix */
      if(b.dim == 1) {
        if(this.size != 1 || b.size != 1) {
          System.out.printf("Incompatible dimensions between matrices");
          return null;
        }
        /* 1x1 matrix multiplied by a 1x1 matrix */
        Matrix result = new Matrix(1);
        result.setValue(new int[]{0}, this.arr[0]*b.arr[0]);
        return result;
      }
      
      if(this.size != b.size) {
        System.out.println("Incompatible dimensions between matrices 1d" + 
                            " and 2d");
        return null;
      }

      // M = b.cols

      int m = b.multArr[0].size;

      Matrix result = new Matrix(m);

      for(int col = 0; col < b.multArr[0].size; col++) {
        double sum = 0.0;
        for(int row = 0; row < b.size; row++) {
          sum += this.arr[row] * b.multArr[col].arr[row];
        }
        result.setValue(new int[]{col}, sum);

      }

      return result;


        // continue code on this line

      
    }

    


  }

  public double getDeterminant() {
    if(dim == 1) {
      if(size == 1) {
        return arr[0];
      }
      System.out.println("Can't find determinant of a 1xn "+ 
                                "matrix where n is not 1");
      return 0;
    }

    if(dim != 2) {
      System.out.println("Can't find determinant of matrices beyond 2 " +
                            "dimensions");
      return 0;
    }

    if(size != multArr[0].size) {
      System.out.println("Can't find determinant of non nxn matrices");
      return 0;
    }

    int rowInterchange = 0;



    return 1;
  }

  public void reducedEchelonForm() {
    Matrix echMatrix = echelonForm();

    int rowPosition = 0;

    for(int col = 0; col < echMatrix.multArr[0].size; col++) {
      double pivot = echMatrix.multArr[rowPosition].arr[col];
      if(compareDoubs(pivot, 1.0)) {
        rowPosition++;
      }
      else if(!compareDoubs(pivot, 0)) {
        reducedEchelonOps(echMatrix, rowPosition, col);
        rowPosition++;
      }
    }
  }

  /* zeroes out values above and below current pivot in column*/
  private void reducedEchelonOps(Matrix mat, int row, int col) {
    double pivot = mat.multArr[row].arr[col];
    for(int i = 0; i < mat.size; i++) {
      if(i != row) {
        double next = mat.multArr[i].arr[col];
        double mult = -1 * next / pivot;

        rowSum(mat, i, rowMultiple(mat, row, mult));
      }
    }
  }

  public boolean compareDoubs(double a, double b) {
    if(Math.abs(a-b) < DOUBLE_TOLERANCE) {
      return true;
    }
    return false;
  }

  public Matrix echelonForm() {
    if( dim > 2 ) {
      System.out.println("Can't find (row reduced)echelon form");
      return null;
    }

    Matrix echMatrix = new Matrix( this );

    if(dim == 1) {
      return echMatrix;
    }

    int rowPosition = 0;

    for(int col = 0; col < echMatrix.multArr[0].size; col++) {
      double [] column = new double[echMatrix.size-rowPosition];
      for(int row = rowPosition; row < echMatrix.size; row++) {
        column[row-rowPosition] = echMatrix.multArr[row].arr[col];
      }

      double max = column[0];
      int maxInd = 0;
      int minInd = 0;
      double min = column[0];
      for(int i = 1; i < column.length; i++) {
        if(column[i] > max) {
          max = column[i];
          maxInd = i;
        }
        else if(column[i] < min) {
          min = column[i];
          minInd = i;
        }
      }
      System.out.println("max, ind, min, ind " + max + " " + maxInd + " " + min + " " + minInd);
      echMatrix.printMatrix();

      if(minInd == maxInd && max != 0.0) {
        echelonOps(echMatrix, rowPosition, col);
        rowPosition++;
        //return echMatrix;
      }
      else if(minInd != maxInd/* && maxInd > 0*/) {
        if(maxInd > 0) {
          System.out.println("vefore inter");
          echMatrix.printMatrix();
          System.out.println("after");
          rowInterchange(echMatrix, rowPosition, maxInd);
          echMatrix.printMatrix();
          echMatrix.rowInterchanges++;
        }
        echelonOps(echMatrix, rowPosition, col);
        rowPosition++;
        //return echMatrix;
      }

      if(rowPosition >= echMatrix.size) {
        return echMatrix;
      }
    }

    return echMatrix;
  }

  /* R1 = R1 + R2 */
  private void rowSum(Matrix mat, int row, double [] rowVals) {
    for(int i = 0; i < mat.multArr[row].size; i++) {
      mat.multArr[row].arr[i]+=rowVals[i];
    }
  }

  /* R1 = R2 */
  private void rowReplacement(Matrix mat, int row, double [] rowVals) {
    for(int i = 0; i < mat.multArr[row].size; i++) {
      mat.multArr[row].arr[i]=rowVals[i];
    }
  }

  /* n*R1 */
  private double[] rowMultiple(Matrix mat, int row, double mult) {
    double [] rowVals = new double[mat.multArr[row].size];
    for(int i = 0; i < mat.multArr[row].size; i++) {
      rowVals[i] = mult*mat.multArr[row].arr[i];
    }
    return rowVals;
  }
  
  /* zeroes out values below current position in column */
  private void echelonOps(Matrix mat, int row, int col) {
    double pivot = mat.multArr[row].arr[col];
    for(int i = row + 1; i < mat.size; i++) {
      double next = mat.multArr[i].arr[col];
      double mult = -1 * next / pivot;

      rowSum(mat, i, rowMultiple(mat, row, mult));
    }
  }

    
    

  /* Switch 2 rows in a 2D matrix */
  public void rowInterchange(Matrix mat, int row1, int row2) {
    for(int i = 0; i < mat.multArr[row1].size; i++) {
      double temp = mat.multArr[row1].arr[i];
      mat.multArr[row1].arr[i] = mat.multArr[row2].arr[i];
      mat.multArr[row2].arr[i] = temp;
    }
  }

  public void inverseMatrix() {

  }


  public double getValue(int [] coor) {
    if(coor.length == 1) {
      return arr[coor[0]];
    }

    int [] coor2 = new int[coor.length-1];
    for(int i = 0; i < coor2.length; i++) {
      coor2[i] = coor[i+1];
    }
    
    return multArr[coor[0]].getValue(coor2);
  }

  public void setValue(int [] coor, double value) {
    if(coor.length == 1) {
      arr[coor[0]] = value;
    }
    else {
      
      int [] coor2 = new int[coor.length-1];
      for(int i = 0; i < coor2.length; i++) {
        coor2[i] = coor[i+1];
      }

      multArr[coor[0]].setValue(coor2, value);
    }
  }

  public double findMax() {
    // add check for empty array
    if(size == 0) {
      System.err.println("Empty Matrix");
      return 0;
    }
      
    if(dim == 1) {
      return findArrMax();
    }

    double max = multArr[0].findMax();

    for(int i = 1; i < size; i++) {
      double temp = multArr[i].findMax();
      if(temp > max) {
        max = temp;
      }
    }

    return max;
  }

  public double findArrMax() {
    double max = arr[0];
    for(int i = 0; i < size; i++) {
      if(arr[i] > max) {
        max = arr[i];
      }
    }

    return max;
  }

  public double findMin() {
    // add check for empty array
    if(size == 0) {
      System.err.println("Empty Matrix");
      return 0;
    }
      
    if(dim == 1) {
      return findArrMin();
    }

    double min = multArr[0].findMin();

    for(int i = 1; i < size; i++) {
      double temp = multArr[i].findMin();
      if(temp < min) {
        min = temp;
      }
    }

    return min;
  }

  public double findArrMin() {
    double min = arr[0];
    for(int i = 0; i < size; i++) {
      if(arr[i] < min) {
        min = arr[i];
      }
    }

    return min;
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
