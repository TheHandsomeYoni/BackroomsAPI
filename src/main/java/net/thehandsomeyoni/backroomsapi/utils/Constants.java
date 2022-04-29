package net.thehandsomeyoni.backroomsapi.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public final class Constants {

    public static String color(String text){
        text = ChatColor.translateAlternateColorCodes('&', text);
        return text;
    }

    public static List<String> color(List<String> textList){
        List<String> text = new ArrayList<String>();
        try{
            for (String textEach : textList){
                text.add(color(textEach));
            }
            return text;
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }
}