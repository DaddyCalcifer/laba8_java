import java.awt.Graphics;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JPanel {
    List<Square> squareList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.print("Введите уровень рекурсии и порядок отрисвоки (0 - сверху меньшие, 1 - большие): ");
        JFrame f = new JFrame();
        f.add(new Main());
        f.setSize(1000, 1000);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    Scanner scan = new Scanner(System.in);
    int size = 300, n = scan.nextInt(), flag = scan.nextInt();
    @Override
    protected void paintComponent(Graphics g) {
        createSquare(g, 500, 500, size, n, 0);
        if(flag == 1) drawSquare(g, 500, 500, size, true);
        else drawSquare(g, 500, 500, size, false);

    }



    private void createSquare(Graphics g, int x, int y, int size, int n, int angle) {
        squareList.add(new Square(x - size / 2, y - size / 2, size, size));
        if(n != 0)
        {
            if(angle != 4) createSquare(g, x - size / 2, y - size / 2, size * 9 / 20, n - 1,1);
            if(angle != 3) createSquare(g, x + size / 2, y - size / 2, size * 9 / 20, n - 1,2);
            if(angle != 2) createSquare(g, x - size / 2, y + size / 2, size * 9 / 20, n - 1,3);
            if(angle != 1) createSquare(g, x + size / 2 ,y + size / 2, size * 9 / 20, n - 1,4);
        }
    }
    private void drawSquare(Graphics g, int x, int y, int size, boolean reverse)
    {
        if(reverse) {
            for (int i = 1; i <= squareList.size(); i++) {
                g.drawRect(squareList.get(squareList.size() - i).x, squareList.get(squareList.size() - i).y, squareList.get(squareList.size() - i).width, squareList.get(squareList.size() - i).height);
                g.clearRect(squareList.get(squareList.size() - i).x + 1, squareList.get(squareList.size() - i).y + 1, squareList.get(squareList.size() - i).width - 1, squareList.get(squareList.size() - i).height - 1);
            }
        }
        else {
            for (int i = 0; i < squareList.size(); i++) {
                g.drawRect(squareList.get(i).x, squareList.get(i).y, squareList.get(i).width, squareList.get(i).height);
                g.clearRect(squareList.get(i).x + 1, squareList.get(i).y + 1, squareList.get(i).width - 1, squareList.get(i).height - 1);
            }
        }
    }



}