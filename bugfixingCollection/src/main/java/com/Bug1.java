package com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bug1 {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

//        for (Object o : queue) { Не знаю, почему валимся после первой же итерации, поэтому написал другой аналогичный метод
//            queue.remove(0);
//        }
        while ((!queue.isEmpty())){
            queue.poll();
        }

        System.out.println(queue);

    }
}
