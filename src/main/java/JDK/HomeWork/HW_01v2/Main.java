package JDK.HomeWork.HW_01v2;

public class Main {
    //TODO надо доработать чтобы диалог выводился в клиенте, а не только в окне сервера
    public static void main(String[] args) {
        // Запускаем сервер
        ServerInterface server = new ServerInterface();

        // Создаем клиентов и передаем им ссылку на сервер
        ClientInterface client1 = new ClientInterface(server);
        ClientInterface client2 = new ClientInterface(server);

        // Открываем окна клиентов
        client1.setVisible(true);
        client2.setVisible(true);
    }
}

