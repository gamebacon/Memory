import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class PictureMemory extends JFrame {


    HashMap<Card, Card> pairs;
    int gridSize = 4;


    public static void main(String[] args) {
        PictureMemory game = new PictureMemory();
        game.init();
    }



    private void init() {
        if(false)
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter gridsize: ");
            gridSize = scanner.nextInt();
            if((gridSize*gridSize) % 2 == 0)
                break;
            else
                System.out.println("Invalid gridsize.");
        } while (true);


        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Deck gridPanel = new Deck(gridSize);

        for (int i = 0; i < (gridSize * gridSize)/2; i++) {
            gridPanel.add(new Card(String.valueOf(i)));
            gridPanel.add(new Card(String.valueOf(i)));
        }




        getContentPane().add(BorderLayout.CENTER, gridPanel);
        setVisible(true);
    }

    private void GameLoop() {

    }



}
