import acm.graphics.GPoint;
import acm.graphics.GRect;

class Cell extends GRect{

    GPoint spot;
    boolean isCombo = false;
    boolean hasElem = false;
    boolean elem; // true - cross, false - circle

    Cell(int x, int y) {
        super(300, 300);
        spot = new GPoint(x, y);
    }

    int score() {
        if (hasElem) {
            return (elem ? 1 : 2);
        } else {
            return -10;
        }
    }
}
