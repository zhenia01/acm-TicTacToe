import java.awt.*;
import java.awt.event.*;

import acm.graphics.GObject;
import acm.program.*;

public class Main extends GraphicsProgram {

    @Override
    public void init() {
        setSize(900 + 18 - 1, 900 + 70 - 1);// 18 -- 70
    }

    @Override
    public void run() {


        Rules rules = new Rules();
        rules.run();

        Cell[][] cells = new Cell[3][3];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cells[x][y] = new Cell(x * 300, y * 300);

                int finalX = x;
                int finalY = y;

                cells[x][y].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (!cells[finalX][finalY].hasElem) {

                            if (rules.player) {
                                Cross temp = new Cross();
                                add(temp, cells[finalX][finalY].spot);
                            } else {
                                Circle temp = new Circle();
                                add(temp, cells[finalX][finalY].spot);
                            }
                            cells[finalX][finalY].hasElem = true;
                            cells[finalX][finalY].elem = rules.player;
                            rules.player = !rules.player;
                        }

                        if (rules.check(cells)) {

                            for (Cell[] cell : cells) {
                                for (Cell cell1 : cell) {
                                    if (cell1.isCombo) {
                                        cell1.setFilled(true);
                                        cell1.sendToBack();
                                        cell1.setFillColor(Color.YELLOW);
                                    }
                                }
                            }

                            if (rules.rerun()) {
                                removeAll();
                                run();
                            } else {
                                exit();
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        cells[finalX][finalY].sendToFront();
                        cells[finalX][finalY].setColor(cells[finalX][finalY].hasElem ? Color.RED : Color.GREEN);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        cells[finalX][finalY].setColor(Color.BLACK);
                    }
                });

                add(cells[x][y], x * 300 - 1, y * 300 - 1);

            }
        }


    }
}