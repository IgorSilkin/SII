
import java.util.Random;

public class Balls {
    int row = 3;
    int column = 4;
    int depth = 10;
    int scetchik = 0;

    int maxBallsArray[] = new int[column];
    int array[][] = new int[row][column];

    boolean finish = false;
    final Random rand = new Random();

    public void addBalls(){
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
        int k = array[0][col];

        for(int i = 0; i < row - 1; i++){
            array[i][col] = array[i+1][col];
        }
        array[row-1][col] = k;
    }
    public void moveLeft(int row){
        int k = array[row][0];
        for(int i = 0; i < column - 1; i++){
            array[row][i] = array[row][i+1];
        }
        array[row][column-1] = k;
    }

    public void show(){
        System.out.println();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void search(){
        while (finish == false){
            easyLevel();
        }
        System.out.println("------------------------------------------");
        show();
        System.out.println("\nОперация: " + scetchik);
        System.out.println("------------------------------------------");
    }
    public void easyLevel(){
        int k = rand.nextInt(2);
        if(k == 0){
            moveUp(rand.nextInt(column));
        }else {
            moveLeft(rand.nextInt(row));
        }
        finish = finish();
    }

    public boolean finish(){
        scetchik++;
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
