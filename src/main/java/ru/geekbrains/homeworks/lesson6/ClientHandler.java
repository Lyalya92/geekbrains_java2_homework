package ru.geekbrains.homeworks.lesson6;

import ru.geekbrains.homeworks.lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8189;

    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private static int clients_count = 0;
    private int clientNumber = 0;

    // Конструктор
    public ClientHandler(Socket socket, Server server) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            clients_count++;
            this.clientNumber = clients_count;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String inMessage = in.readUTF();  // читаем сообщение клиента
                if (inMessage.equalsIgnoreCase("/quit")) {
                    break;
                }
                String outMessage = "Client " + this.clientNumber + ": " + inMessage;
                System.out.println(outMessage);
                server.sendMessageToAll(outMessage); //сервер отправляет сообщение всем
                Thread.sleep(100);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            this.clientDisconnect();
        }
    }

    // Метод, отправляющий сообщение
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Клиент отключается
    public void clientDisconnect() {
        server.removeClient(this);
    }
}
