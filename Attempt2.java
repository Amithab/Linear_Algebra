public class MultMatrix {

  private static final int DEFAULT_SIZE = 1;
  private static final int DEFAULT_DIM = 1;
  private int dim;
  private Matrix [] arr;

  public MultMatrix() {
    dim = DEFAULT_DIM;
    arr = new Matrix[DEFAULT_SIZE];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = new Matrix();
    }
  }

  public MultMatrix(int size) {
    dim = DEFAULT_DIM;
    arr = new Matrix[DEFAULT_SIZE];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = new Matrix(size);
    }
  }
//popup
