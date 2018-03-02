public class Main {
    public static void main(String[] args) {
        Balls game = new Balls();
        game.addBalls();
        game.show();
        game.moveUp(2);
        System.out.println();
        game.show();
        game.moveUp(2);
        System.out.println();
        game.show();
        game.moveLeft(2);
        System.out.println();
        game.show();
    }
}
