package com.clicdirectory.global;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class FileUtility {
    private static final Logger logger = Logger.getLogger(FileUtility.class);

    public static List<String> readListFromFile(File file) {
        List<String> result = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.add(line);
            }
            scanner.close();
        } catch (
                IOException e)

        {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public static String getTitleUrlForString(String title) {
        String result= title.replaceAll(" ", "-").toLowerCase().replaceAll("[^a-zA-Z0-9-]", "").replaceAll("[-]+", "-");
        if(result.endsWith("-"))
            return result.substring(0,result.length()-2);
        return result;
    }

    public static String readFile(String fname) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line + "\n");
            }
            if (br != null)
                br.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return stringBuffer.toString();
    }

    public static List<String> readListFromFile(String fname) {
        BufferedReader br;
        List<String> result = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            if (br != null)
                br.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public static void writeFile(String fname, String content) {
        try {
            File file = new File(fname);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();
            bw.close();
        } catch (IOException e) {
        }
    }

    public static void writeSetToFileLineByLine(String fname, Collection<String> set) {
        try {
            File file = new File(fname);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : set)
                bw.write(s + "\n");
            bw.flush();
            bw.close();
        } catch (IOException e) {
        }
    }

    public static void deleteFile(String fname) {
        try {
            File file = new File(fname);
            file.delete();
        } catch (Exception e) {
        }
    }

    public static void appendToFile(String fname, String content) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fname, true)));
            out.println(content);
            out.close();
        } catch (IOException e) {
        }
    }

    public static void copy(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    public static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(target);
        byte[] buf = new byte[1024];
        int length;
        while ((length = in.read(buf)) > 0) {
            out.write(buf, 0, length);
        }
    }

    public static ArrayList<String> listFilesAndFilesSubDirectories(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        ArrayList<String> result = new ArrayList();
        if (fList != null && fList.length > 0) {
            for (File file : fList) {
                if (file.isFile()) {
                    result.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    ArrayList<String> resultFiles = listFilesAndFilesSubDirectories(file.getAbsolutePath());
                    if (resultFiles != null)
                        result.addAll(resultFiles);
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getFilesInDirectoryStartingWithAndNotEndingWith(String directoryName, String prefix, String suffix) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        ArrayList<String> result = new ArrayList();
        if (fList != null && fList.length > 0) {
            for (File file : fList) {
                if (file.isFile()) {
                    if (file.getName().startsWith(prefix) && !file.getName().endsWith(suffix))
                        result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getFilesInDirectoryStartingWithAndEndingWith(String directoryName, String prefix, String suffix) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        ArrayList<String> result = new ArrayList();
        if (fList != null && fList.length > 0) {
            for (File file : fList) {
                if (file.isFile()) {
                    if (file.getName().startsWith(prefix) && file.getName().endsWith(suffix))
                        result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static ArrayList<String> replaceJsFileContentWithAddedSaltAndShowChanges(File log, HashMap<String, String> map) throws FileNotFoundException {
        ArrayList<String> changes = new ArrayList<String>();
        FileReader fr = new FileReader(log);
        String s;
        String content = "";
        int lineNo = 1;
        boolean saltAdded = false;
        if (log.getName().endsWith(".json")) {
            System.out.println("dsdsds");
        }

        try {
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {

                if (saltAdded == false) {
                    if (s.contains(";")) {
                        changes.add((log.getAbsolutePath() + ": Line-" + lineNo + "" + s));
                        s = s.replaceFirst(";", ";\r\nvar " + Randomizer.getRandomString(10) + "= " + Math.random() + ";");
                        saltAdded = true;
                    }
                }

                for (Map.Entry x : map.entrySet()) {
                    if (s.contains((String) (x.getKey()))) {
                        changes.add((log.getAbsolutePath() + ": Line-" + lineNo + "" + s));
                        s = s.replace((String) (x.getKey()), (String) (x.getValue()));
                    }
                }
                content += s + "\r\n";
                lineNo++;
            }
        } catch (Exception e) {

        }
        writeFile(log.getAbsolutePath(), content);
        return changes;
    }

    public static ArrayList<String> replaceFileContent(File log, HashMap<String, String> map) throws FileNotFoundException {
        ArrayList<String> changes = new ArrayList<String>();
        FileReader fr = new FileReader(log);
        String s;
        String content = "";
        int lineNo = 1;
        try {
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                for (Map.Entry x : map.entrySet()) {
                    if (s.contains((String) (x.getKey()))) {
                        changes.add((log.getAbsolutePath() + ": Line-" + lineNo + "" + s));
                        s = s.replace((String) (x.getKey()), (String) (x.getValue()));
                    }
                }
                content += s + "\r\n";
                lineNo++;
            }
        } catch (Exception e) {

        }
        writeFile(log.getAbsolutePath(), content);
        return changes;
    }

    public static boolean createDirectory(String dirPath) {

        File file = new File(dirPath);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
                return true;
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        return false;
    }

    public static List<String> listFilesForDirectory(final File folder) {
        List<String> data = new ArrayList<String>();
        int count = 0;
        int size = folder.listFiles().length;
        for (final File fileEntry : folder.listFiles()) {
            ++count;
            //System.out.println(fileEntry.length());
            if (count < size / 10) {
                if (fileEntry.isDirectory()) {
                } else {
                    if (!fileEntry.getName().contains("gz") && fileEntry.getName().contains("xml") && !fileEntry.getName().contains(" 2")) {
                        data.add(FileUtility.readFile(fileEntry.getAbsolutePath()));
                        data.add("\n");
                    }
                }
            }
        }
        return data;
    }

    public static String htmlLinksFromXml(final File xmlFile) {

        if (xmlFile.isDirectory()) {
            // listFilesForFolder(fileEntry);
        } else {
            if (!xmlFile.getName().contains("gz") && xmlFile.getName().contains("xml") && !xmlFile.getName().contains(" 2")) {
                return FileUtility.readFile(xmlFile.getAbsolutePath());
            }
        }
        return "";
    }


    public static List<File> listHtmlLinksFromXml(final File folder) {
        List<File> data = new ArrayList<File>();
        int size = folder.listFiles().length;
        System.out.println("file count " + size);
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
            }
            if (!fileEntry.getName().contains("gz") && fileEntry.getName().contains("xml") && !fileEntry.getName().contains(" 2"))
                data.add(fileEntry);

        }
        return data;
    }

    public static ArrayList<String> getAllFilesInDirectory(String directoryName, String prefix) {
        File directory = new File(directoryName);
        int c=0;

        File[] fList = directory.listFiles();
        ArrayList<String> result = new ArrayList();
        if (fList != null && fList.length > 0) {
            for (File file : fList) {
                if (file.isFile()) {
                    if (file.getName().startsWith(prefix))
                        result.add(file.getAbsolutePath());
                    c++;
                }
            }
        }
        return result;
    }

    public static List<File> listSongListFromArtist(File file) {
        List<File> data = new ArrayList<File>();
        int size = file.listFiles().length;
        System.out.println("file count " + size);
        for (final File fileEntry : file.listFiles()) {
            if (fileEntry.isDirectory()) {
            }
            if (!fileEntry.getName().contains("gz") && fileEntry.getName().contains("xml") && !fileEntry.getName().contains(" 2"))
                data.add(fileEntry);

        }
        return data;
    }


}
