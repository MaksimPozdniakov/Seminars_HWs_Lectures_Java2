package JDK.HomeWork.HW_02;

import JDK.HomeWork.HW_02.client.ClientView;
import JDK.HomeWork.HW_02.server.ClassRepository;
import JDK.HomeWork.HW_02.server.Server;
import JDK.HomeWork.HW_02.server.ServerRepositoryInterface;

public class Main {
    public static void main(String[] args) {
        ServerRepositoryInterface repository =
                new ClassRepository("src/main/java/JDK/HomeWork/HW_02/server/dialogsBase.txt");
        Server server = new Server(repository);
        new ClientView(server);
        new ClientView(server);
    }
}


