public class Check {

    public boolean sprawdz(int tab[][], int sum2) {
        int[][] tabl = new int[tab.length][tab.length];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tabl[j][tabl.length - 1 - i] = tab[i][j];
            }
        }

        if (checkLine(tab, sum2) || checkLine(tabl, sum2))
            return true;

        return false;
    }

    public boolean checkLine(int tab[][], int sum2) {
        int sum = 0;

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] == sum2 / 5)
                    sum = sum + tab[i][j];
                else
                    sum = 0;
                if (sum == sum2)
                    return true;
            }
        }

        sum = 0;
        int l = tab.length - 1;
        for (int i = 1; i < tab.length; i++) {
            for (int j = 0; j < l; j++) {
                if (tab[j][i + j] == sum2 / 5)
                    sum = sum + tab[j][i + j];
                else
                    sum = 0;
                if (sum == sum2)
                    return true;
            }
            l--;
        }

        sum = 0;
        int m = tab.length - 1;
        for (int i = 1; i < tab.length; i++) {
            for (int j = 0; j < m; j++) {
                if (tab[i + j][j] == sum2 / 5)
                    sum = sum + tab[i + j][j];
                else
                    sum = 0;
                if (sum == sum2)
                    return true;
            }
            m--;
        }

        sum = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i][i] == sum2 / 5)
                sum = sum + tab[i][i];
            else
                sum = 0;
            if (sum == sum2)
                return true;
        }

        return false;
    }


}
