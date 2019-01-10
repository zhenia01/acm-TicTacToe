import acm.graphics.GCompound;
import acm.graphics.GOval;
import java.awt.Color;

class Circle extends GCompound {

    Circle() {
        GOval black = new GOval(295, 295);
        black.setFilled(true);
        black.setColor(Color.BLACK);
        add(black, 1, 1);

        GOval white = new GOval(282, 282);
        white.setFilled(true);
        white.setColor(Color.WHITE);
        add(white, 8, 8);

//        markAsComplete();
    }
}
