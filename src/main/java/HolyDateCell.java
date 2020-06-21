import javafx.scene.control.DateCell;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolyDateCell extends DateCell {
    private final static String[] s = {"Nowy Rok", "Trzech Króli", "Święto Pracy",
            "Święto Narodowe 3 Maja", "Wniebowzięcie Najświętszej Marii Panny",
            "Dzień Wszystkich Świętych", "Narodowe Święto Niepodległości",
            "Boże Narodzenie - dzień 1", "Boże Narodzenie - dzień 2"};
    private final static int[] d = {1, 6, 1, 3, 15, 1, 11, 25, 26};
    private final static int[] m = {1, 1, 5, 5, 8, 11, 11, 12, 12};

    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            this.setTextFill(Color.BLACK);
            DayOfWeek day = DayOfWeek.from(item);
            if (day == DayOfWeek.SUNDAY) {
                this.setTextFill(Color.RED);
            }
            int year = item.getYear();
            int[] w = wielkanoc(year);
            LocalDate wielkanoc = LocalDate.of(year, w[1], w[0]);
            int[] b = boze(year);
            LocalDate boze = LocalDate.of(year, b[1], b[0]);
            int[] l = lany(year);
            LocalDate lany = LocalDate.of(year, l[1], l[0]);
            if (item.equals(wielkanoc)) {
                this.setTextFill(Color.RED);
                this.setTooltip(new Tooltip("Wielkanoc"));
            }
            if (item.equals(boze)) {
                this.setTextFill(Color.RED);
                this.setTooltip(new Tooltip("Boże Ciało"));
            }
            if (item.equals(lany)) {
                this.setTextFill(Color.RED);
                this.setTooltip(new Tooltip("Lany Poniedziałek"));
            }
            for (int i = 0; i < s.length; i++) {
                if (item.equals(LocalDate.of(year, m[i], d[i]))) {
                    this.setTextFill(Color.RED);
                    this.setTooltip(new Tooltip(s[i]));
                }
            }
        }
    }

    private static int[] wielkanoc(int rok) {
        int dzien;
        int miesiac;
        int wskA = 0;
        int wskB = 0;
        if (rok <= 1582) {
            wskA = 15;
            wskB = 6;
        } else if (rok <= 1699) {
            wskA = 22;
            wskB = 2;
        } else if (rok <= 1799) {
            wskA = 23;
            wskB = 3;
        } else if (rok <= 1899) {
            wskA = 23;
            wskB = 4;
        } else if (rok <= 2099) {
            wskA = 24;
            wskB = 5;
        } else if (rok <= 2199) {
            wskA = 24;
            wskB = 6;
        } else if (rok <= 2299) {
            wskA = 25;
            wskB = 0;
        } else if (rok <= 2399) {
            wskA = 26;
            wskB = 1;
        } else if (rok <= 2499) {
            wskA = 25;
            wskB = 1;
        }
        int a = rok % 19;
        int b = rok % 4;
        int c = rok % 7;
        int d = (a * 19 + wskA) % 30;
        int e = (2 * b + 4 * c + 6 * d + wskB) % 7;
        int liczbaDni = 22 + d + e;
        if ((d == 29) && (e == 6)) {
            dzien = 19;
            miesiac = 4;
        } else if ((d == 28) & (e == 6)) {
            dzien = 18;
            miesiac = 4;
        } else {
            if (liczbaDni <= 31) {
                dzien = liczbaDni;
                miesiac = 3;
            } else {
                dzien = liczbaDni - 31;
                miesiac = 4;
            }
        }
        return new int[]{dzien, miesiac};
    }

    private static int[] boze(int rok) {
        int[] wielkanoc = wielkanoc(rok);
        int dzienBoze;
        int miesiacBoze;
        int temp;
        if (wielkanoc[1] == 3) {
            temp = 60 - (31 - wielkanoc[0]) - 30;
        } else {
            temp = 60 - (30 - wielkanoc[0]);
        }
        if (temp <= 31) {
            dzienBoze = temp;
            miesiacBoze = 5;
        } else {
            dzienBoze = temp - 31;
            miesiacBoze = 6;
        }
        return new int[]{dzienBoze, miesiacBoze};
    }

    private static int[] lany(int rok) {
        int[] wielkanoc = wielkanoc(rok);
        if ((wielkanoc[0] == 31) && (wielkanoc[1] == 3)) {
            return new int[]{1, wielkanoc[1] + 1};
        } else {
            return new int[]{wielkanoc[0] + 1, wielkanoc[1]};
        }
    }
}
