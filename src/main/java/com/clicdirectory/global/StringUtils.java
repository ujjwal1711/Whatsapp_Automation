package com.clicdirectory.global;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hackme on 14/8/17.
 */
public class StringUtils {

    public static ArrayList<String> getEmails(String s) {
        ArrayList<String> emails = new ArrayList<String>();
        Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(s);
        while (m.find()) {
            emails.add(m.group());
        }
        return emails;
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("^\\d+$");
    }

    public static boolean isValidIndianWhatsApp(String contact) {
        if(contact==null||contact.length()!=10||!isNumeric(contact)) return false;
        return true;
    }

    public static String getTitleUrlForString(String title) {
        String result = title.replaceAll(" ", "-").toLowerCase().replaceAll("[^a-zA-Z0-9-]", "").replaceAll("[-]+", "-");
        try{
            if (result.endsWith("-"))
                return result.substring(0, result.length() - 2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String getTitleCampaignForString(String title) {
        String result = "";
        if (title.indexOf("//") > -1) {
            result = title.split("//")[1];
        }
        result = result.substring(result.indexOf("/") + 1);
        String[] arr = result.split("[-\\/]");
        result = "";
        try {
            for (String r : arr) {
                result += r.charAt(0);
            }
        } catch (Exception e) {
            return getTitleUrlForString(title);
        }
        return result;
    }

    public static String getJoinedString(ArrayList<String> curText, String separator) {
        return org.apache.commons.lang.StringUtils.join(curText.toArray(), separator);
    }

    public static String getImageExtension(String filepath) {
        return isImage(filepath);
    }

    public static String isImage(String filepath) {
        String[] extensions = {".jpg", ".png", ".jpeg", ".gif", ".bmp", ".ico", ".webp"};
        for (String extension : extensions) {
            if (filepath.endsWith(extension)) {
                return extension;
            }
        }
        return null;
    }

    public static String getImageFormat(String filepath) {
        String[] extensions = {"jpg", "png", "jpeg", "gif", "bmp", "ico", "webp"};
        for (String extension : extensions) {
            if (filepath.endsWith(extension)) {
                String ext = isImage(filepath);
                if (ext.endsWith(extension)) {
                    if (extension.startsWith("jp"))
                        return "jpeg";
                    return extension;
                }
            }
        }
        return null;

    }

    public static String toCamelCase(final String init) {
        if (init==null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(word.substring(0, 1).toUpperCase());
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length()==init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

    public static String getTodayDate() {
        String[] date = new Date().toString().split(" ");
        return  date[1] + " " + date[2] + "," + date[date.length - 1];
    }

    public static String getMetaKeywordsFromString(String title) {
        if(title!=null){
            try{
                String arr [] = title.split("[ \\.,]+");
                String result = "";
                for(int i = 0 ;i<arr.length-1;i++){
                    result += arr[i]+",";
                }
                result += arr[arr.length-1];
                return result;
            }catch (Exception e){
            }
        }
        return "";
    }

    public static String getFormatedName(String str) {
        if(str==null)return "";
        return str.toLowerCase().substring(0, 1).toUpperCase() + str.toLowerCase().substring(1);
    }
}
