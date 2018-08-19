package com;

        import java.util.LinkedList;
        import java.util.Queue;

public class Bug3 {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.remove();// Что мы удаляем с пустого листа????? size не может уйти в (-1), вот и валимся
    }
}
