import java.util.ArrayList;
public class Main {
    private static int MAX_COUNT_SEARCHING = 500000;
    public static void main(String [] args){
        boolean finish;//флаг окончания игры
        int k = 0;//счетчик добавленных состояний
        int lvl = 1;//глубина поиска
        long startTime = System.currentTimeMillis();//Start timer

        Balls map = new Balls();
        ArrayList<String> maps_list = new ArrayList<>();//массив пройденных состояний
        map.show(map.array, map.ROW, map.COLUMN);
        finish = map.finish();//проверка условий окончания игры
        maps_list.add(0, map.goToString());
        for(int id = 0; id < 7; id++){
            map.goToArray(maps_list.get(0));
            map.search_operation_by_id(id);
            if(maps_list.contains(map.goToString())){
                map.checksTrue++;
            }
            else{
                maps_list.add(k, "" + map.goToString());
                k++;
                finish = map.finish();
                if(finish == true){
                    outAnswer(true, map, startTime);
                    return;
                }
            }//генерируем все ходы первого уровня
        }
        while(finish == false){
            for (int i = (int)Math.pow(7, (lvl-1)); i <= (int)Math.pow(7, lvl); i++){
                if(map.checks > MAX_COUNT_SEARCHING){
                    outAnswer(false, map, startTime);
                    return;
                }
                for(int id = 0; id < 7; id++){
                    map.goToArray(maps_list.get(i));
                    map.search_operation_by_id(id);
                    if(maps_list.contains(map.goToString())){
                        map.checksTrue++;
                    }
                    else{
                        maps_list.add(k, "" + map.goToString());
                        k++;
                        finish = map.finish();
                        if(finish == true){
                            outAnswer(true, map, startTime);
                            return;
                        }
                    }
                }
            }
            lvl++;
        }
    }
    public static void outAnswer(boolean flag, Balls map, long startTime){
        long finishTime = System.currentTimeMillis();
        long seconds = (finishTime - startTime) / 1000;
        int minutes = 0;
        if(seconds >= 60){
            minutes = (int)seconds / 60;
            seconds = seconds % 60;
        }
        if(flag == true) {
            System.out.print("\nЧисло проверок: " + map.checks);
            System.out.print("\nЧисло отброшенных проверок: " + map.checksTrue);
            System.out.print("\nВремя выполнения программы:\t" + minutes + " минут(ы) " + seconds + " секунд(ы)");
            map.show(map.array, map.ROW, map.COLUMN);
        }
        if(flag == false) {
            System.out.print("\nЧисло проверок достигло максимума:" + map.checks);
            System.out.print("\nЧисло отброшенных проверок:" + map.checksTrue);
            System.out.print("\nРешение не найдено!");
            System.out.print("\nВремя выполнения программы:\t" + minutes + " минут(ы) " + seconds + " секунд(ы)");
        }
    }//Вывод ответа на экран.
    // Принимает экземпляр текущей карты, флаг окончания и время начала выполнения функции
}
