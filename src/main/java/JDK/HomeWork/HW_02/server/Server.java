package JDK.HomeWork.HW_02.server;

import JDK.HomeWork.HW_02.client.Client;
import java.util.ArrayList;
import java.util.List;

public class Server implements ServerInterface {

    private boolean statusServerValue;
    private ArrayList<String> allDialogs = new ArrayList<>();

    List<Client> clients;

    private ServerRepositoryInterface repository;

    public Server(ServerRepositoryInterface repository) {
        new ServerView(this);
        clients = new ArrayList<>();
        this.repository = repository;
    }

    public void addClient(Client client) {
        clients.add(client); // добавляем клиента в список
    }


    public void fillArrayWithDialogs(String message) {
        allDialogs.add(message);
        repository.writeToFile(allDialogs);

        for (Client client : clients) {
            client.receiveMessageFromServer(allDialogs); // Отправляем сообщение каждому клиенту
        }
    }


    @Override
    public void statusServer(boolean status) {
        statusServerValue = status;
    }


    public boolean getStatusValue() {
        return statusServerValue;
    }


    public ArrayList<String> getDialogs() {
        allDialogs.clear();
        return new ArrayList<>(repository.readFromFile(allDialogs));
    }


}
