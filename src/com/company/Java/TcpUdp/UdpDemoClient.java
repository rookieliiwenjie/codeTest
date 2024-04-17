package com.company.Java.TcpUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpDemoClient {
    private DatagramSocket socket;

    private String serverIP;
    private int serverPort;

    public UdpDemoClient(DatagramSocket socket, String serverIP, int serverPort) throws SocketException {
        if (socket == null) {
            synchronized (this) {
                if (socket == null) {
                    this.socket = new DatagramSocket();
                }
            }
        }
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" ---->");
            String request = scanner.next();
            // 2. 把字符串构造成 UDP packet, 并进行发送
//            DatagramPacket datagramPacket = new DatagramPacket();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DatagramSocket socket = new DatagramSocket(7788);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
