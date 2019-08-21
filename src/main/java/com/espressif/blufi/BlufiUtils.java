package com.espressif.blufi;

public class BlufiUtils {
    public static final String VERSION = "2.1.0";
    public static final int[] SUPPORT_BLUFI_VERSION = {1, 2};

    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
