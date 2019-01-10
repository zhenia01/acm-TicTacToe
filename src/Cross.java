import acm.graphics.GCompound;
import acm.graphics.GLine;

class Cross extends GCompound {

    Cross() {

        GLine line;

        line = new GLine(1, 1, 296, 296);
        add(line);

        line = new GLine(296, 1, 1, 296);
        add(line);

        for (int i = 2; i <= 5; i++) {
            line = new GLine(i, 1, 296, 297 - i);
            add(line);

            line = new GLine(1, i, 297 - i, 296);
            add(line);

            line = new GLine(297 - i, 1, 1, 297 - i);
            add(line);

            line = new GLine(296, i, i, 296);
            add(line);

        }

//        markAsComplete();
    }


}
