import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    static boolean turn = true, whoPlay = true;
    int size = 15;
    int[][] tab = new int[size][size];
    Check x = new Check();
    int counter = 0;
    static int counterX = 0, counterO = 0;
    static String who = "X";

    public Main() {
        setSize(760, 760);
        setVisible(true);
        setTitle("Gomoku");
        setLocation(getToolkit().getScreenSize().width / 2 - this.getWidth() / 2, getToolkit().getScreenSize().height / 2 - this.getHeight() / 2);
        setLayout(new GridLayout(size, size));
        if (whoPlay)
            who = "X";
        else
            who = "O";
        JOptionPane.showMessageDialog(null, "Zaczyna   " + who);
        for (int i = 0; i < size * size; i++) {
            JButton button = new JButton("");
            add(button);
            button.setName("" + i);
            button.setFont(new Font("SansSerif", Font.BOLD, 20));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (button.getText() == "") {
                        if (turn == true) {
                            button.setText("X");
                            tab[Integer.parseInt(button.getName()) % 15][Integer.parseInt(button.getName()) / size] = 1;
                            checkWin(5);
                            turn = false;
                        } else {
                            button.setText("O");
                            tab[Integer.parseInt(button.getName()) % 15][Integer.parseInt(button.getName()) / size] = 2;
                            checkWin(10);
                            turn = true;
                        }
                        counter++;
                        if (counter == size * size && !x.check(tab, 5)) {
                            whoPlay = !whoPlay;
                            JOptionPane.showMessageDialog(null, "REMIS");
                            int odp = JOptionPane.showConfirmDialog(null, "NOWA GRA", "pytanie", JOptionPane.YES_NO_OPTION);
                            if (odp == JOptionPane.YES_OPTION) {
                                setVisible(false);
                                new Main();
                            } else if (odp == JOptionPane.NO_OPTION)
                                dispose();
                        }
                    }
                }
            });
        }
    }

    public void checkWin(int sum2) {
        if (x.check(tab, sum2)) {
            if (sum2 == 10) {
                counterO++;
                JOptionPane.showMessageDialog(null, "WYGRAL GRACZ  O\n\n Liczba Zwycięstw gracza O:   " + counterO + "\n Liczba zwycięstw gracza X:   " + counterX);
            } else {
                counterX++;
                JOptionPane.showMessageDialog(null, "WYGRAL GRACZ  X\n\n Liczba Zwycięstw gracza X:   " + counterX + "\n Liczba zwycięstw gracza O:   " + counterO);
            }
            whoPlay = !whoPlay;
            int odp = JOptionPane.showConfirmDialog(null, "NOWA GRA", "pytanie", JOptionPane.YES_NO_OPTION);
            if (odp == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Main();
            } else if (odp == JOptionPane.NO_OPTION)
                dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
