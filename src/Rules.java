import acm.program.DialogProgram;
import acm.program.Program;

import java.util.Random;


public class Rules extends DialogProgram {

    boolean player;

    public void run() {
        Random random = new Random();

        player = random.nextBoolean();

        println("Player 1 plays with crosses \n Player 2 plays with zeros");
        println("Player " + (player ? "1" : "2") + " goes first");
    }

    private void winner(boolean a) {
        println((a ? "Player 1" : "Player 2") + " has won!");

    }

    public boolean rerun() {
        String s = readLine("Leave an empty string to play again");
        return s.isEmpty();
    }

    boolean check(Cell[][] c) {

        int leftd = 0;
        int rightd = 0;

        for (int i = 0; i < 3; i++) {
            int ver = c[0][i].score() + c[1][i].score() + c[2][i].score();
            int hor = c[i][0].score() + c[i][1].score() + c[i][2].score();

            leftd += c[i][i].score();
            rightd += c[i][2 - i].score();

            if (ver == 3) {
                for (int j = 0; j < 3; j++) {
                    c[j][i].isCombo = true;
                }
                winner(c[0][i].elem);
                return true;
            } else if (hor == 3) {
                for (int j = 0; j < 3; j++) {
                    c[i][j].isCombo = true;
                }
                winner(c[0][i].elem);
                return true;
            }
            if (ver == 6) {
                for (int j = 0; j < 3; j++) {
                    c[j][i].isCombo = true;
                }
                winner(c[i][0].elem);
                return true;
            } else if (hor == 6) {
                for (int j = 0; j < 3; j++) {
                    c[i][j].isCombo = true;
                }
                winner(c[i][0].elem);
                return true;
            }
        }

        if (leftd == 3 || leftd == 6) {
            c[0][0].isCombo = c[1][1].isCombo = c[2][2].isCombo = true;
            winner(c[1][1].elem);
            return true;
        } else if (rightd == 3 || rightd == 6) {
            c[0][2].isCombo = c[1][1].isCombo = c[2][0].isCombo = true;
            winner(c[1][1].elem);
            return true;
        }

        boolean allHas = false;

        for (Cell[] i : c) {
            for (Cell j : i) {
                if (!j.hasElem) {
                    allHas = true;
                }
            }
        }

        if (!allHas) {
            println("Draw!");
            return true;
        }

        return false;
    }

}
