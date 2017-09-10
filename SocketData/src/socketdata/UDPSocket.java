/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketdata;

import socketdata.database.CurdOpertaion;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Sanjoth Shaw
 */
public class UDPSocket
{
    private String module;
    private String temp;
    private String ip;

    public void insertData(String ip,String module,String temp){
			this.module =module;
			this.temp = temp;
                        this.ip = ip;
			 CurdOpertaion cord = new CurdOpertaion();
		        cord.save(ip,module,temp);


	}
    public static void main(String args[]) throws Exception
      {
       UDPSocket udpsocket = new UDPSocket();
          DatagramSocket serverSocket = new DatagramSocket(80); // Port Nimber
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while(true)
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  System.out.println("RECEIVED: " + sentence);
                  String[] tempdata = sentence.split(",");
                  String module = tempdata[0];
                  String[] temprature = tempdata[1].split(":");
                  System.out.println("Module : "+module);
                   // System.out.println("Temprature : "+temprature[1]);

               //   udpsocket.insertData(receivePacket.getAddress()+"",module,""+temprature[1]);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  String capitalizedSentence = sentence.toUpperCase();
                  sendData = capitalizedSentence.getBytes();
                  System.out.println("IPAddress: " + IPAddress +"  Port : "+port+" Module : "+module);
//                  DatagramPacket sendPacket =
//                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
//                  serverSocket.send(sendPacket);
               }
      }

}
