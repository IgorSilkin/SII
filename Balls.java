
import java.util.Random;

public class Balls {
    int row = 3;
    int column = 3;

    int maxBallsArray[] = new int[column];
    int array[][] = new int[row][column];

    public void addBalls(){
        final Random rand = new Random();

        int k;
        boolean ok;

        for(int i = 0; i < column; i++) {
            maxBallsArray[i] = row;
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                ok = false;
                while (ok == false){
                    k = rand.nextInt(column);
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
        col--;
        int k = array[0][col];

        for(int i = 0; i < row - 1; i++){
            array[i][col] = array[i+1][col];
        }
        array[row-1][col] = k;
    }
    public void moveLeft(int row){
        row--;
        int k = array[row][0];
        for(int i = 0; i < column - 1; i++){
            array[row][i] = array[row][i+1];
        }
        array[row][column-1] = k;
    }

    public void show(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
