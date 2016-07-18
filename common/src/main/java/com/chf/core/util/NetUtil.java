package com.chf.core.util;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public final class NetUtil {

    public static final String LOCALHOST_IP = "127.0.0.1";

    public static boolean isLocalPortUsed(int port) {
        try {
            return isPortUsed(LOCALHOST_IP, port);
        } catch (UnknownHostException e) {
        }
        return false;
    }

    public static boolean isPortUsed(String host, int port)
            throws UnknownHostException {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
        }
        return false;
    }
}
