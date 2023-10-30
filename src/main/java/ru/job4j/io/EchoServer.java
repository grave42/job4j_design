package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                    Pattern pattern = Pattern.compile("msg=[^ ]+");
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        List<String> params = List.of(matcher.group().split("="));
                        if ("msg".contains(params.get(0)) && "Bye".contains(params.get(1))) {
                            server.close();
                        }
                    } else {
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}