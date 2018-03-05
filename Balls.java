
import java.util.Random;

public class Balls {
    int row = 3;
    int column = 4;
    int oper = column + row;
    int Depth = 5;
    int scetchik = 0;
    int depthArraySearching[][][][] = new int [Depth][oper][row][column];

    int maxBallsArray[] = new int[column];
    int array[][] = new int[row][column];
    final int cloneArray[][] = new int[row][column];

    boolean finish = false;
    boolean failed = false;
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
                        cloneArray[i][j] = k;
                        ok = true;
                    }
                }
            }
        }
    }

    public void moveUp(int col, boolean flagHardMode, int level, int operation){
        if(flagHardMode == false){
            int k = array[0][col];
            for(int i = 0; i < row - 1; i++){
                array[i][col] = array[i+1][col];
            }
            array[row-1][col] = k;
        }else {
            moveUp(col, false, 0, 0);
            depthArraySearching[level][operation] = array.clone();
        }
    }
    public void moveLeft(int row, boolean flagHardMode, int level, int operation){
        if(flagHardMode == false) {
            int k = array[row][0];
            for (int i = 0; i < column - 1; i++) {
                array[row][i] = array[row][i + 1];
            }
            array[row][column - 1] = k;
        }else {
            moveLeft(row, false, 0, 0);
            depthArraySearching[level][operation] = array.clone();
        }
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
    public void showClone(){
        System.out.println();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(cloneArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void search(){
        while (finish == false){
            //easyMode();
            hardMode();
        }
        if(finish == true && failed == true){
            System.out.println("Решение не найдено!");
        }
        else{
            System.out.println("------------------------------------------");
            show();
            System.out.println("\nОперация: " + scetchik);
            System.out.println("------------------------------------------");
        }
    }
    public void easyMode(){
        int k = rand.nextInt(2);
        if(k == 0){
            moveUp(rand.nextInt(column), false, 0, 0);
        }else {
            moveLeft(rand.nextInt(row), false, 0, 0);
        }
        finish = finish();
    }

    public void hardMode(){
        for(int lvl = 0; lvl < Depth; lvl++){
            for(int operation = 0; operation < oper; operation++){
                if(lvl == 0){
                    Clone();
                    if(operation < column){
                        moveUp(operation, true, lvl, operation);
                    }else if(operation < oper){
                        moveLeft(operation - column, true, lvl, operation);
                    }
                }else if(lvl > 0){
                    //array = (depthArraySearching[lvl-1][operation]).clone();
                    bigClone(lvl-1, operation);
                    if(operation < column){
                        moveUp(operation, true, lvl, operation);
                    }else if(operation < oper){
                        moveLeft(operation - column, true, lvl, operation);
                    }
                }
            }
        }
        for (int lvl = Depth-1; lvl >= 0; lvl--){
            for (int operation = 0; operation < oper; operation++){
                array = depthArraySearching[lvl][operation].clone();
                finish = finish();
                if(lvl == 0 && operation == oper - 1 && finish == false){
                    /*for(int t = 0; t < Depth; t++){
                        array = depthArraySearching[t][0].clone();
                        show();
                        System.out.println("----"+ t + "----");
                    }*/

                }finish = true;
                failed = true;
            }
        }
    }

    public void Clone(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                array[i][j] = cloneArray[i][j];
            }
        }
    }
    public void bigClone(int level, int operation){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                array[i][j] = depthArraySearching[level][operation][i][j];
            }
        }
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
