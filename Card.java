import javax.swing.*;
import java.util.Objects;

public class Card extends JButton {

    public Card(String name) {
        setName(name);
        setText(name);
        this.name = name;
    }


    boolean isFlipped = false;


    private String name;


    public void flip() {
        if(!isFlipped) {
             setText("");
            isFlipped = true;
        } else {
            setText(name);
            isFlipped = false;
        }
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }




}
