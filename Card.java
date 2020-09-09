import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Card extends JButton implements ActionListener {

    static ArrayList<Card> flippedCards;

    public Card(String name) {
       // setText(name);
        this.name = name;
        addActionListener(this);
        flippedCards = new ArrayList<Card>();
    }

    private String name;
    public boolean isFlipped = false;

    public void flip() {
        if(isFlipped) {
            setText("");
            flippedCards.remove(this);
            isFlipped = false;
        }
        else {
            setText(name);
            flippedCards.add(this);
            isFlipped = true;
            System.out.println(flippedCards.toString());
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", isFlipped=" + isFlipped +
                '}';
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isFlipped || flippedCards.size( ) < 2)
            flip();
    }
}
