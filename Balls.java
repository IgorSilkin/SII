
import java.util.Random;

public class Balls {
    int ROW = 3;
    int COLUMN = 4;
    int checks = 0;//кол-во проверок
    int checksTrue = 0;//кол-во совпадений с массивом карт
    int maxBallsArray [] = new int[COLUMN];//максимальное количество объектов каждого вида на карте
    int array [][] = new int[ROW][COLUMN];//карта

    final Random rand = new Random();

    Balls(){
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
    }//Конструктор. Генерирует рандомное поле

    public void search_operation_by_id(int id){
        if (id < COLUMN){
            moveUp(id);
        }else if(id < ROW + COLUMN){
            moveLeft(id - COLUMN);
        }
    }//Функция получает число и вызывает функции изменения поля

    public void moveUp(int col){
        int k = array[0][col];
        for(int i = 0; i < ROW - 1; i++){
            array[i][col] = array[i+1][col];
        }
        array[ROW-1][col] = k;
    }//передвижение столбца вверх
    public void moveLeft(int row){
        int k = array[row][0];
        for (int i = 0; i < COLUMN - 1; i++) {
            array[row][i] = array[row][i + 1];
        }
        array[row][COLUMN - 1] = k;
    }//передвижение строки влево

    public int [][] show(int [][] array, int row, int col){
        System.out.println();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        return array;
    }//отображение поля
    public String goToString(){
        String str = "";
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COLUMN; j++){
                str += array[i][j];
            }
        }
        return str;
    }//перевод массива в строку
    public void goToArray(String str){
        int k = 0;
        for(int i = 0; i < str.length(); i++){
            if (i == 0){
                this.array[k][i % this.COLUMN] =  Integer.parseInt("" + str.charAt(i));
            }
            if(i % this.COLUMN > 0 && i != 0){
                this.array[k][i % this.COLUMN] = Integer.parseInt("" + str.charAt(i));
            }
            if (i % this.COLUMN == 0 && i != 0) {
                k++;
                this.array[k][i % this.COLUMN] = Integer.parseInt("" + str.charAt(i));
            }
        }
    }//перевод строки в массив

    public boolean finish(){
        checks++;
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
    }//проверка условий окончания игры
}
