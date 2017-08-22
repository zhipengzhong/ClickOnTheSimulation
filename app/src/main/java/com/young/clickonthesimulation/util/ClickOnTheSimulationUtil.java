package com.young.clickonthesimulation.util;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by 钟志鹏 on 2017/8/22.
 */

public class ClickOnTheSimulationUtil {
    private static final String TAG = "ClickOnTheSimulationUti";

    public static void executeCmd(String cmd){
        DataOutputStream dos = null;
        try {
            //申请root权限
            Process process = Runtime.getRuntime().exec("su");
            dos = new DataOutputStream(process.getOutputStream());
            dos.writeBytes(cmd);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
