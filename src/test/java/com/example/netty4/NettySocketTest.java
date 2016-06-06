package com.example.netty4;

import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Biplab Nayak [Created on 6/6/2016].
 */
public class NettySocketTest {

    @Test
    public void testNettyEndpoint() {
        try(final Socket socket = new Socket("localhost", 7000)) {

            sendRequest(socket, "aaaaaabdgfssssssssssg");
            String response = receiveResponse(socket);
            System.out.printf("");

            if (socket!=null){
                socket.close();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(final Socket socket, final String request) throws IOException {

        OutputStream outputStream = null;
        BufferedWriter buffWriter = null;

        outputStream = socket.getOutputStream();
        buffWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        buffWriter.write(request);
        buffWriter.flush();
    }


    private String receiveResponse(final Socket socket) throws IOException {

        InputStream inputStream = null;
        BufferedReader buffReader = null;
        String line = null;

        inputStream = socket.getInputStream();
        buffReader = new BufferedReader(new InputStreamReader(inputStream));

        /*StringBuilder data = new StringBuilder();
        while((line=buffReader.readLine())!=null){
            data.append(line + System.getProperty("line.separator"));
        }
        return data.toString();*/
        return buffReader.readLine();
    }

}
