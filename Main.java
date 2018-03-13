import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        final Random rand = new Random();
        boolean finish, fail = false, search;
        int k = 1, s = 0, checks = 1, checksTrue = 0;
        ArrayList<String> visited_tops = new ArrayList();
        Balls currentMap = new Balls();
        currentMap.addBalls();
        finish = currentMap.finish();
        visited_tops.add(0, "" + currentMap.goToString());
        currentMap.show(currentMap.array, currentMap.ROW, currentMap.COLUMN);
        while(finish == false && fail == false){
            s++;
            if(s >= 7) {
                s = s - 7;
            }
            search = false;
            if(visited_tops.contains(currentMap.goToString())){
                search = true;
                checksTrue++;
            }
            if (search == false){
                visited_tops.add(k, "" + currentMap.goToString());
                k++;
                checks++;
                finish = currentMap.finish();
            }
            if(finish != true){
                if(s < currentMap.ROW){
                    currentMap.moveLeft(rand.nextInt(currentMap.ROW));
                }else{
                    currentMap.moveUp(rand.nextInt(currentMap.COLUMN));
                }
            }
            /*if (rand.nextBoolean() == true){
                currentMap.moveLeft(rand.nextInt(currentMap.ROW));
            }else {
                currentMap.moveUp(rand.nextInt(currentMap.COLUMN));
            }*/
            if(checks == 100000 || checksTrue == 5000){
                fail = true;
            }
        }
        if(finish == true) {
            System.out.print("\nЧисло проверок:" + checks);
            System.out.print("\nЧисло отброшенных проверок:" + checksTrue);
            currentMap.show(currentMap.array, currentMap.ROW, currentMap.COLUMN);
        }
        if(fail == true) {
            System.out.print("\nЧисло проверок достигло максимума:" + checks);
            System.out.print("\nЧисло отброшенных проверок:" + checksTrue);
            System.out.print("\nРешение не найдено!");
        }
    }
}
