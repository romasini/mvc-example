package ru.romasini.simple.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleSocketClient {

    private static Socket socket;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8189);
        Response response = sendRequest(socket, "GET", "/mvc/api/v1/products/1", null);
        System.out.println(response);

        StringBuilder body = new StringBuilder();
        body.append("{");
        body.append("\"name\"").append(":").append("\"Banana\"").append(",");
        body.append("\"price\"").append(":").append("150");
        body.append("}");
        socket = new Socket("localhost", 8189);
        Response response1 = sendRequest(socket, "POST", "/mvc/api/v1/products", body.toString());
        System.out.println(response1);

    }

    public static class Response{
        StringBuilder stringBuilder;

        public Response(Socket socket) {
            String line = null;
            stringBuilder = new StringBuilder();

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line).append("\r\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public String toString() {
            return stringBuilder.toString();
        }
    }

    public static Response sendRequest(Socket socket, String method, String query, String body){

        try {
           StringBuilder out = new StringBuilder();
           out.append(method).append(" ").append(query).append(" ").append("HTTP/1.1").append("\r\n");
           out.append("Host: ").append("localhost:8189").append("\r\n");
           out.append("Accept:*/*").append("\r\n");
           out.append("Connection: ").append("close").append("\r\n");
           if(body == null) {
               out.append("Content-type: ").append("text/plain;charset=UTF-8").append("\r\n");
               out.append("\r\n");
           }else {
               out.append("Content-type: ").append("application/json").append("\r\n");
               out.append("Content-length: ").append(body.getBytes(StandardCharsets.UTF_8).length).append("\r\n");
               out.append("\r\n");
               out.append(body);
           }
           socket.getOutputStream().write(out.toString().getBytes(StandardCharsets.UTF_8));
           socket.getOutputStream().flush();

           Response response = new Response(socket);
           return response;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
