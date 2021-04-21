public class Check {

    public boolean sprawdz(int tab[][], int sum2) {
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
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[j][i] == sum2 / 5)
                    sum = sum + tab[j][i];
                else
                    sum = 0;
                if (sum == sum2)
                    return true;
            }
        }

        sum = 0;
        for (int i = 0; i < tab.length; i++) {  //przekatna
            if (tab[i][i] == sum2 / 5)
                sum = sum + tab[i][i];
            else
                sum = 0;
            if (sum == sum2)
                return true;
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

        int[][] tabl = new int[tab.length][tab.length];
        for (int i = 0; i <tab.length; i++){
            for(int j = 0; j <tab.length; j++){
                tabl[j][tabl.length-1-i] = tab[i][j];
            }
        }

        sum = 0;
        int x = tabl.length - 1;
        for (int i = 1; i < tabl.length; i++) {
            for (int j = 0; j < x; j++) {
                if (tabl[j][i + j] == sum2 / 5)
                    sum = sum + tabl[j][i + j];
                else
                    sum = 0;
                if (sum == sum2)
                    return true;
            }
            x--;
        }

        sum = 0;
        int y = tabl.length - 1;
        for (int i = 1; i < tabl.length; i++) {
            for (int j = 0; j < y; j++) {
                if (tabl[i + j][j] == sum2 / 5)
                    sum = sum + tabl[i + j][j];
                else
                    sum = 0;
                if (sum == sum2)
                    return true;
            }
            y--;
        }

        sum = 0;
        for (int i = 0; i < tabl.length; i++) {  //przekatna
            if (tabl[i][i] == sum2 / 5)
                sum = sum + tabl[i][i];
            else
                sum = 0;
            if (sum == sum2)
                return true;
        }

        return false;
    }

}
