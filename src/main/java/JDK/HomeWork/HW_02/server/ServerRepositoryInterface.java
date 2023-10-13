package JDK.HomeWork.HW_02.server;

import java.util.ArrayList;

public interface ServerRepositoryInterface {
    ArrayList<String> readFromFile(ArrayList<String> log);
    void writeToFile(ArrayList<String> log);
}
