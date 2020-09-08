package ru.geegbrains.java02.lesson04;
/*
* 1. Отправлять сообщения в лог по нажатию кнопки или по нажатию клавиши Enter.
* 2. Создать лог в файле (показать комментарием, где и как Вы планируете писать сообщение в файловый журнал).
* 3. Прочитать методичку к следующему уроку*/

public class ChatServer {
    public void start(int port) {
        System.out.println("Server started at port: " + port);
    }

    public void stop() {
        System.out.println("Server stopped");
    }
}

