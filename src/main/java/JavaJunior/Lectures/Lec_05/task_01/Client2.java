package JavaJunior.Lectures.Lec_03.task_01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address, 1300);

            System.out.println(client.getInetAddress());
            System.out.println(client.getLocalPort());

            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            PrintStream printStream = new PrintStream(outputStream);

            printStream.println("Hello!");
            System.out.println(dataInputStream.readLine());
            client.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
