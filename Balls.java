
import java.util.Random;

public class Balls {

    int ROW = 3;
    int COLUMN = 4;
    int maxBallsArray [] = new int[COLUMN];
    int array [][] = new int[ROW][COLUMN];

    final Random rand = new Random();

    public void addBalls(){
        int k;
        boolean ok;

        for(int i = 0; i < COLUMN; i++) {
            maxBallsArray[i] = ROW;
        }
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COLUMN; j++){
                ok = false;
                while (ok == false){
                    k = rand.nextInt(COLUMN);
                    if(maxBallsArray[k] > 0){
                        maxBallsArray[k]--;
                        array[i][j] = k;
                        ok = true;
                    }
                }
            }
        }
    }

    public void moveUp(int col){
        int k = array[0][col];
        for(int i = 0; i < ROW - 1; i++){
            array[i][col] = array[i+1][col];
        }
        array[ROW-1][col] = k;
    }
    public void moveLeft(int row){
        int k = array[row][0];
        for (int i = 0; i < COLUMN - 1; i++) {
            array[row][i] = array[row][i + 1];
        }
        array[row][COLUMN - 1] = k;
    }

    public int [][] show(int [][] array, int row, int col){
        System.out.println();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        return array;
    }
    public String goToString(){
        String str = "";
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COLUMN; j++){
                str += array[i][j];
            }
        }
        return str;
    }


    public boolean finish(){
        if(
            array[0][0] == array[1][0] &&
            array[1][0] == array[2][0] &&
            array[0][1] == array[1][1] &&
            array[1][1] == array[2][1] &&
            array[0][2] == array[1][2] &&
            array[1][2] == array[2][2] &&

            array[0][0] != array[0][1] &&
            array[0][0] != array[0][2] &&
            array[0][0] != array[0][3] &&
            array[0][1] != array[0][2] &&
            array[0][1] != array[0][3] &&
            array[0][2] != array[0][3] &&

            array[1][0] != array[1][1] &&
            array[1][0] != array[1][2] &&
            array[1][0] != array[1][3] &&
            array[1][1] != array[1][2] &&
            array[1][1] != array[1][3] &&
            array[1][2] != array[1][3] &&

            array[2][0] != array[2][1] &&
            array[2][0] != array[2][2] &&
            array[2][0] != array[2][3] &&
            array[2][1] != array[2][2] &&
            array[2][1] != array[2][3] &&
            array[2][2] != array[2][3]) {
            return true;
        }
        else return false;
    }
}
