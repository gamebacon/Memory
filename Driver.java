import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    JFrame frame;
    JPanel panel;
    int gridSize = 4;
    ArrayList<JButton> cards = new ArrayList<JButton>();
    Scanner scanner;

    private ArrayList<JButton> flippedCards;


    public static void main(String[] args) {
        Driver game = new Driver();

        game.init();

        game.SetUpGui();

        //game loop
        game.Start();

    }

    public void init() {
        scanner = new Scanner(System.in);
        do {
            System.out.print("Enter grid size: ");
            gridSize = scanner.nextInt();
            if(Math.pow(gridSize,2) % 2 == 0 && gridSize < 50)
                break;
            else
                System.out.println("Invalid gridsize, the input^2 must be even and less than 50");
        } while (true);
        System.out.println("Grid size: " + gridSize + " * " + gridSize + "\nGame starting....");


        cards = new ArrayList<JButton>();
        flippedCards = new ArrayList<JButton>();
    }

    public void Start() {
        while(true) {

        }
    }



    private void SetUpGui() {
        frame = new JFrame("Number memory");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel(new GridLayout(gridSize,gridSize,2,2));

        cards.

        for (int i = 0; i < (gridSize * gridSize)/2; i++) {
            cards.add(new JButton(String.valueOf(i)));
            cards.add(new JButton(String.valueOf(i)));
        }

        for(JButton card : cards) {
            card.addActionListener(new CardActionListener());
            panel.add(card);
        }




        for(int i = 0; i-1 < (gridSize*gridSize)/2; i++) {
            cards[i] = new Card(String.valueOf(i));
            cards[i + 1] = new Card(String.valueOf(i));
            cards[i].addActionListener(new CardActionListener());
            //cards[i].setEnabled(false);
            panel.add(cards[i]);
        }



        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }


    private boolean isMatch() {
        if(flippedCards.size() == 2 && flippedCards.get(0).equals(flippedCards.get(1)))
            return true;
        return false;
    }

    private void onMatch() {
        for(Card card : flippedCards) {
            card.setEnabled(false);
            flippedCards.remove(card);
        }
    }

    public class CardActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Card card = (Card) ev.getSource();

                if(flippedCards.size() < 2 || card.isFlipped)
                  card.flip();
               if(card.isFlipped)
                flippedCards.add(card);
               else if(flippedCards.contains(card))
                flippedCards.remove(card);


             if(flippedCards.size() == 2)
               System.out.println(flippedCards.get(0).getName() + ", " + flippedCards.get(1).getName());
        }
    }

}

