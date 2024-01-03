package main.java.JavaJunior.Lectures.Lec_05.task_02;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            broadCastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    // region Personal message

    private void handlePersonalMessage(String message) {
        String[] parts = message.split(" ", 2); // Разделяем сообщение на две части по первому пробелу
        if (parts.length > 1) {
            String recipient = parts[0].substring(1); // Извлекаем имя получателя без символа '@'
            String personalMessage = parts[1]; // Сообщение без имени получателя

            // Ищем получателя среди клиентов
            for (ClientManager client : clients) {
                if (client.name.equals(recipient)) {
                    try {
                        // Отправляем личное сообщение только выбранному получателю
                        client.bufferedWriter.write(name + ": " + personalMessage);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                        break;
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }
    }

    // Данный метод нужен, чтобы убрать начало сообщения, до @
    private String messageWithoutName(String messageFromClient) {
        String[] message = messageFromClient.split(":");
        return message[1];
    }

    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                // System.out.println(messageWithoutName(messageFromClient));

                if (messageWithoutName(messageFromClient).startsWith("@")) {

                    handlePersonalMessage(messageWithoutName(messageFromClient)); // Обработка личного сообщения
                    // System.out.println("Знак имеется!");

                } else {

                    broadCastMessage(messageFromClient); // Рассылка обычного сообщения всем клиентам
                    // System.out.println("Знак отсутствует!");

                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    // end region

    private void broadCastMessage(String messageToSend) {
        for (ClientManager client: clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(messageToSend);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        broadCastMessage("SERVER: " + name + " покинул чат.");
    }

}
