package crackingthecodinginterview.largestfiles;

import java.io.File;
import java.util.*;

public class Solution {

    private static List<File> getAllFilesRecursively(File filePath) {
        List<File> result = new ArrayList<>();

        if (filePath.isDirectory()) {
            for (File file : filePath.listFiles()) {
                if (file.isDirectory()) {
                    result.addAll(getAllFilesRecursively(file));
                } else {
                    result.add(file);
                }
            }
        } else {
            result.add(filePath);
        }
        return result;
    }

    private static void sortFilesBySizeReversed(List<File> fileList) {
        Collections.sort(fileList, (f1, f2) -> new Long(f2.length()).compareTo(new Long(f1.length())));
    }

    public static void main(String[] args) {

        String pathName = "/media/e/Downloads/";
        File filePath = new File(pathName);

        List<File> files = getAllFilesRecursively(filePath);
        sortFilesBySizeReversed(files);


        for (File file : files) {
            System.out.println("FileName: " + file.getPath() + " - Size: " + file.length());
        }
        System.out.println("Number of files: " + files.size());

    }

}
