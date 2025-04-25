package Lab01;

import java.util.Arrays;
public class AddMatrices {
    public static void main(String[] args) {
    double[][] matrix1 = {{5, 23, 47}, {8, 4, 2}},
    matrix2 = {{6, 11, 2}, {22, 39, 9}};
    double[][] result = new double[2][3];
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
    }
    System.out.println("The sum of matrix 1:");
    System.out.println(Arrays.toString(matrix1[0]));
    System.out.println(Arrays.toString(matrix1[1]));
    System.out.println("and matrix 2:");
    System.out.println(Arrays.toString(matrix2[0]));
    System.out.println(Arrays.toString(matrix2[1]));
    System.out.println("is as follow");
    System.out.println(Arrays.toString(result[0]));
    System.out.println(Arrays.toString(result[1]));
}
}
