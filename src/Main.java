import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    static boolean kolejka = true, ktoGra = true;
    int size = 15;
    int[][] tab = new int[size][size];
    Check x = new Check();
    int licznik = 0;
    static int liczX = 0, liczO = 0;
    static String kto = "X";

    public Main() {
        setSize(760, 760);
        setVisible(true);
        setTitle("Gomoku");
        setLocation(getToolkit().getScreenSize().width / 2 - this.getWidth() / 2, getToolkit().getScreenSize().height / 2 - this.getHeight() / 2);
        setLayout(new GridLayout(size, size));
        if (ktoGra)
            kto = "X";
        else
            kto = "O";
        JOptionPane.showMessageDialog(null, "Zaczyna   " + kto);
        for (int i = 0; i < size * size; i++) {
            JButton przycisk = new JButton("");
            add(przycisk);
            przycisk.setName("" + i);
            przycisk.setFont(new Font("SansSerif", Font.BOLD, 20));
            przycisk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (przycisk.getText() == "") {
                        if (kolejka == true) {
                            przycisk.setText("X");
                            tab[Integer.parseInt(przycisk.getName()) % 15][Integer.parseInt(przycisk.getName()) / size] = 1;
                            kolejka = false;
                            if (x.sprawdz(tab, 5)) {
                                liczX++;
                                JOptionPane.showMessageDialog(null, "WYGRAL GRACZ  X \n\n Liczba zwycięstw gracza X:   " + liczX + "\n Liczba zwycięstw gracza O:   " + liczO);
                                ktoGra = !ktoGra;
                                int odp = JOptionPane.showConfirmDialog(null, "NOWA GRA", "Czy chcesz zagrać ponownie ?", JOptionPane.YES_NO_OPTION);
                                if (odp == JOptionPane.YES_OPTION) {
                                    setVisible(false);
                                    new Main();
                                } else if (odp == JOptionPane.NO_OPTION)
                                    dispose();
                            }
                        } else {
                            przycisk.setText("O");
                            tab[Integer.parseInt(przycisk.getName()) % 15][Integer.parseInt(przycisk.getName()) / size] = 2;
                            if (x.sprawdz(tab, 10)) {
                                liczO++;
                                JOptionPane.showMessageDialog(null, "WYGRAL GRACZ  O\n\n Liczba Zwycięstw gracza O:   " + liczO + "\n Liczba zwycięstw gracza X:   " + liczX);
                                ktoGra = !ktoGra;
                                int odp = JOptionPane.showConfirmDialog(null, "NOWA GRA", "pytanie", JOptionPane.YES_NO_OPTION);
                                if (odp == JOptionPane.YES_OPTION) {
                                    setVisible(false);
                                    new Main();
                                } else if (odp == JOptionPane.NO_OPTION)
                                    dispose();
                            }
                            kolejka = true;
                        }
                        licznik++;
                        if (licznik == size * size && !x.sprawdz(tab, 5)) {
                            ktoGra = !ktoGra;
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }
}
