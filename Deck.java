import javax.swing.*;
import java.awt.*;

public class Deck extends JPanel {

    public Deck(int gridSize) {

        super(new GridLayout(gridSize, gridSize, 2, 2));
    }

}
