package com.chf.core.util;

import java.io.IOException;

public final class ShellInteractUtil {

    private static final int SHELL_SUCCESS = 0;

    private static final String SHELL_PATH = "/root/manage/";

    public static boolean changePwd(String user, String newPwd) {
        String cmd = String.format("%s/change_pwd.sh %s %s", SHELL_PATH, user,
                newPwd);
        return runCommand(cmd) == SHELL_SUCCESS;
    }

    public static boolean killPort(int port) {
        String cmd = String.format("%s/manage.sh -k %d", SHELL_PATH, port);
        return runCommand(cmd) == SHELL_SUCCESS;
    }

    private static int runCommand(String cmd) {
        Process process;
        try {
            process = Runtime.getRuntime().exec(cmd);
            int value = process.waitFor();
            System.out.println("value is " + value);
            return value;
        } catch (IOException | InterruptedException e) {
        }
        return -1;
    }
}
