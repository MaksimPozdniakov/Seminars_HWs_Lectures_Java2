package JDK.HomeWork.HW_02.client;

import JDK.HomeWork.HW_02.server.Server;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    private HashMap<String, ArrayList<String>> usersBase = new HashMap();
    private Server server;
    private ClientInterface listener;

    public Client(Server server, ClientInterface listener) {
        this.server = server;
        this.listener = listener;
        server.addClient(this); // добавляем клиента в список сервера
    }

    // получаем данные из ClientView и записываем в базу
    public void fillUserData(String login, String ip, String port, String password) {
        ArrayList<String> userData = new ArrayList<>();
        userData.add(ip);
        userData.add(port);
        userData.add(password);
        usersBase.put(login, userData);
    }


    // получаем ответ от сервера о его работе
    public void answerStatusServer() {
        boolean status = server.getStatusValue();
        listener.statusServer(status);
    }


    // получаем сообщение с экрана и отправляем его на сервер
    public void sendMessage(String message) {
        String name = "";
        for (String key : usersBase.keySet()) {
            name = key;
        }

        String messageWithName = name + ": " + message;


        server.fillArrayWithDialogs(messageWithName);
    }


    // получаем историю диалога от сервера и отправляем в ClientView
    public void receiveMessageFromServer(ArrayList<String> allDialogs) {
        listener.print(allDialogs);
    }

    public ArrayList<String> getDialogs() {
        return server.getDialogs();
    }
}