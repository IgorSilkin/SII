import java.util.ArrayList;
import java.util.Random;

public class Main {
    int level = 0;
    public static void main(String [] args){
        boolean finish, search, fail = false;
        int k = 0, s = 0, checks = 1, checksTrue = 0;
        int lvl = 0;
        final Random rand = new Random();
        Balls map = new Balls();
        ArrayList<String> maps_list = new ArrayList<>();
        map.show(map.array, map.ROW, map.COLUMN);
        finish = map.finish();
        maps_list.add(0, map.goToString());
        while(finish == false && fail == false){
            if (lvl == 0){
                for(int id = 0; id < 7; id++){
                    map.goToArray(maps_list.get(0));
                    search = false;
                    map.search_operation_by_id(id);
                    if(maps_list.contains(map.goToString())){
                        search = true;
                        checksTrue++;
                    }
                    if (search == false){
                        maps_list.add(k, "" + map.goToString());
                        k++;
                        checks++;
                        finish = map.finish();
                        if(finish == true){
                            id = 999;
                        }
                    }
                }
                lvl++;
            }else if (lvl > 0){
                for (int i = (int)Math.pow(7, (lvl-1)); i <= (int)Math.pow(7, lvl); i++){
                    if(checks > 50000){
                        outAnswer(false, checks, checksTrue, map);
                        return;
                    }
                    for(int id = 0; id < 7; id++){
                        map.goToArray(maps_list.get(i));
                        search = false;
                        map.search_operation_by_id(id);
                        if(maps_list.contains(map.goToString())){
                            search = true;
                            checksTrue++;
                        }
                        if (search == false){
                            maps_list.add(k, "" + map.goToString());
                            k++;
                            checks++;
                            finish = map.finish();
                            if(finish == true){
                                outAnswer(true, checks, checksTrue, map);
                                return;
                            }
                        }
                    }
                }
                lvl++;
            }
        }
//        if(finish == true) {
//            System.out.print("\nЧисло проверок:" + checks);
//            System.out.print("\nЧисло отброшенных проверок:" + checksTrue);
//            map.show(map.array, map.ROW, map.COLUMN);
//        }
//        if(fail == true) {
//            System.out.print("\nЧисло проверок достигло максимума:" + checks);
//            System.out.print("\nЧисло отброшенных проверок:" + checksTrue);
//            System.out.print("\nРешение не найдено!");
//        }
//        map.moveUp(0);
//        map.show(map.array, map.ROW, map.COLUMN);
//        map.goToArray(maps_list.get(0));
//        map.show(map.array, map.ROW, map.COLUMN);
    }
    public static void outAnswer(boolean flag, int checks, int checksTrue, Balls map){
        if(flag == true) {
            System.out.print("\nЧисло проверок:" + checks);
            System.out.print("\nЧисло отброшенных проверок:" + checksTrue);
            map.show(map.array, map.ROW, map.COLUMN);
        }
        if(flag == false) {
            System.out.print("\nЧисло проверок достигло максимума:" + checks);
            System.out.print("\nЧисло отброшенных проверок:" + checksTrue);
            System.out.print("\nРешение не найдено!");
            System.out.print("\nПодходящие ответы:\t" + map.d);
        }
    }
}
