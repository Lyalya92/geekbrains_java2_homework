package ru.geekbrains.homeworks.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int PORT = 8189;   //Порт, который будет слушать сервер

    private List<ClientHandler> clients = new ArrayList<ClientHandler>(); // Список клиентов, которые будут подключаться к серверу

    private Socket socket;
    private ServerSocket serverSocket;

    // Конструктор:
    public Server() {

        try { //Пробуем запустить сервер
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = serverSocket.accept();  // ждем подключения
                ClientHandler client = new ClientHandler(socket, this);  // создаем обработчик клиента
                addClient(client); //добавляем его в список клиентов
                new Thread(client).start(); // запускаем в новом потоке
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
                System.out.println("Server stopped");
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Сервер отправляет сообщение всем клиентам
    public void sendMessageToAll(String message) {
        for(ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    // Добавление клиента в список
    public void addClient(ClientHandler client) {
        clients.add(client);
    }

    // Удаление клиента из списка
    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }


}
