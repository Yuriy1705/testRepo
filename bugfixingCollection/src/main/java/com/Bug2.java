package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bug2 {
    public static void main(String[] args) {
        List list = new ArrayList(Arrays.asList(1, 2, 3, 45, 67));// Arrays.asList?? он же не расширяется автоматом, поэтому и валимся
        for (int i = 0; i < list.size(); i++) {// Его нужно кинуть в обвертку ArrayList, и все как в лучших домах Лондона
            list.add(i);
        }
    }
}
