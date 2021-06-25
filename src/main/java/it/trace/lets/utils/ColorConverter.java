package it.trace.lets.utils;

import java.awt.*;

public class ColorConverter {
    public static String getRGB(String color) {
        Color tmp = new Color(0,0,0).decode(color);
        return tmp.getRed() + "," + tmp.getGreen() + "," + tmp.getBlue();
    }
}
