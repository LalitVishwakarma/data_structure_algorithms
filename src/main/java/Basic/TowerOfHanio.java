package Basic;

public class TowerOfHanio {
    public void move(int n, String from, String using, String to) {
        if(n <= 0)
            return;
        move(n - 1, from, to, using);
        System.out.println("Move " + from + " to " + to);
        move(n - 1, using, from, to);
    }

    public static void main(String[] args) {
        TowerOfHanio towerOfHanio = new TowerOfHanio();
        towerOfHanio.move(4, "A", "B", "C");
    }
}
