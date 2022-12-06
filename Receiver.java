package br.com.carv.simple.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author joao
 */
public class Receiver {

    public Receiver() throws Exception {

        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("Receiver is running!");
        Scanner scan = new Scanner(System.in);

        while (true) {
            byte[] buffer = new byte[1500];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String message = new String(buffer).trim();
            System.out.println("Received: " + message);

            InetAddress senders = packet.getAddress();
            int sendersPort = packet.getPort();

            System.out.print("Send: ");
            message = scan.nextLine();

            buffer = message.getBytes();

            packet = new DatagramPacket(buffer, buffer.length, senders, sendersPort);
            socket.send(packet);

            //System.out.println("Sent: " + message);
        }

    }
    
    public static void main(String[] args) throws Exception {
        Receiver receiver = new Receiver();
    }
}
