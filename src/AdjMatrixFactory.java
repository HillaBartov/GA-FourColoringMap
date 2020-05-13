//Created by
//Hilla Bartov
//Ofir Cohen

public class AdjMatrixFactory {

    public static boolean[][] buildMatrix() {
        boolean[][] matrix = new boolean[12][12];
        //initialize all with zeros
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matrix[i][j] = false;
            }
        }
        //Set ones
        matrix[0][1]=true; matrix[0][5]=true; matrix[0][10]=true;
        matrix[1][0]=true; matrix[1][2]=true; matrix[1][6]=true; matrix[1][8]=true; matrix[1][10]=true;
        matrix[2][1]=true; matrix[2][3]=true; matrix[2][4]=true; matrix[2][8]=true; matrix[2][10]=true;
        matrix[3][2]=true; matrix[3][4]=true; matrix[3][10]=true;
        matrix[4][2]=true; matrix[4][3]=true; matrix[4][8]=true; matrix[4][10]=true; matrix[4][11]=true;
        matrix[5][0]=true; matrix[5][6]=true; matrix[5][7]=true; matrix[5][9]=true; matrix[5][10]=true; matrix[5][11]=true;
        matrix[6][1]=true; matrix[6][7]=true; matrix[6][5]=true;
        matrix[7][5]=true; matrix[7][6]=true; matrix[7][1]=true; matrix[7][8]=true; matrix[7][9]=true;
        matrix[8][1]=true; matrix[8][2]=true; matrix[8][4]=true; matrix[8][7]=true; matrix[8][9]=true; matrix[8][11]=true;
        matrix[9][5]=true; matrix[9][7]=true; matrix[9][8]=true; matrix[9][11]=true;
        matrix[10][0]=true; matrix[10][1]=true; matrix[10][2]=true; matrix[10][3]=true; matrix[10][4]=true; matrix[10][5]=true; matrix[10][11] = true;
        matrix[11][4]=true; matrix[11][5]=true; matrix[11][8]=true; matrix[11][9]=true; matrix[11][10]= true;

        return matrix;
    }
}
