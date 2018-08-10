import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CheckMatrix {
  // fake comment commit git config check

  @Test
  public void firstTest() {
    // Testing: [ [1, 2], [3, 4] ]
    Matrix mat = new Matrix(2, 2, 2);
    mat.printMatrix();

    mat.setValue(new int[]{0, 0}, 1);
    mat.setValue(new int[]{0, 1}, 2);
    mat.setValue(new int[]{1, 0}, 3);
    mat.setValue(new int[]{1, 1}, 4);
    mat.printMatrix();

    assertEquals(1, (int)mat.getValue(new int[]{0, 0}));
    assertEquals(2, (int)mat.getValue(new int[]{0, 1}));
    assertEquals(3, (int)mat.getValue(new int[]{1, 0}));
    assertEquals(4, (int)mat.getValue(new int[]{1, 1}));
  }








  /*public static void main(String [] args) {
    int a = 0;
    System.out.println("hello " + a + " hi\n");

    Matrix mat = new Matrix(3, 4, 4);
    Matrix echMat = mat.echelonForm();
    if(echMat != null) {
      echMat.printMatrix();
    }

    Matrix mat2 = new Matrix(2, 2, 2);
    int [] coor = {0, 0};
    for(int i = 0; i < mat2.getSize(); i ++) {
      for(int j = 0; j < 2; j++) {
        mat2.setValue(coor, i + j+1);
        coor[1]++;
      }
      coor[1] = 0;
      coor[0]++;
    }
    mat2.printMatrix();
    echMat = mat2.echelonForm();
    if(echMat != null) {
      echMat.printMatrix();
    }

    System.out.println("Done!");
    coor[0] = 0;
    coor[1] = 0;
    Matrix mat3 = new Matrix(new int[]{3, 5} , 2);
    for(int i = 0; i < 3; i ++) {
      for(int j = 0; j < 5; j++) {
        mat3.setValue(coor, i + j+1);
        coor[1]++;
      }
      coor[1] = 0;
      coor[0]++;
    }
    mat3.printMatrix();
    echMat = mat3.echelonForm();
    if(echMat != null) {
      echMat.printMatrix();
    }

    System.out.println("Done!");
    coor[0] = 0;
    coor[1] = 0;
    Matrix mat4 = new Matrix(2, 2, 2);
    for(int i = 0; i < 2; i ++) {
      for(int j = 0; j < 2; j++) {
        mat4.setValue(coor, 2*i + j+1);
        coor[1]++;
      }
      coor[1] = 0;
      coor[0]++;
    }
    mat4.printMatrix();
    echMat = mat4.echelonForm();
    if(echMat != null) {
      echMat.printMatrix();
    }

    System.out.println("Done!");
    coor[0] = 0;
    coor[1] = 0;
    Matrix mat5 = new Matrix(3, 2, 2);
    for(int i = 0; i < 3; i ++) {
      for(int j = 0; j < 3; j++) {
        mat5.setValue(coor, 2*i - 10*j+1);
        coor[1]++;
      }
      coor[1] = 0;
      coor[0]++;
    }
    mat5.printMatrix();
    echMat = mat5.echelonForm();
    if(echMat != null) {
      echMat.printMatrix();
    }
  }*/

}
  
