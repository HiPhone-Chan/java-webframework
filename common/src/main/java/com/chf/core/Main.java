package com.chf.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import gnu.io.NRSerialPort;

public class Main {

	public static void main(String[] args) {

		for (String s : NRSerialPort.getAvailableSerialPorts()) {
			System.out.println("Availible port: " + s);
		}
		String port = "COM4";
		int baudRate = 115200;
		NRSerialPort serial = new NRSerialPort(port, baudRate);
		serial.connect();

		DataInputStream ins = new DataInputStream(serial.getInputStream());
		DataOutputStream outs = new DataOutputStream(serial.getOutputStream());

		while (true) {
			try {
				byte b = (byte)ins.read();
				System.out.println(b);
				outs.write(b);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		serial.disconnect();
	
	}

}
