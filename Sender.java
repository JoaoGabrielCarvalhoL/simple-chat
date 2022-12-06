package br.com.carv.simple.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author joao
 */
public class Sender {

    public Sender() throws Exception {

        DatagramSocket socket = new DatagramSocket();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Send: ");
            String message = scan.nextLine();

            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 2020);

            socket.send(packet);
            //System.out.println("Sent: " + message);

            buffer = new byte[1500];

            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            message = new String(buffer).trim();
            System.out.println("Received: " + message);

        }

    }
    
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
    }

}
