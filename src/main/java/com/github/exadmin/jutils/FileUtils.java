package com.github.exadmin.jutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileUtils {
    public interface FileAcceptor {
        boolean testFileByName(String shortFileName);
    }

    /**
     * Scans whole directory with sub-folder recursively and returns list of found files
     * which corresponds to the implementation of {@link FileAcceptor} interface.
     * @param rootDirName String directory name to do scanning in
     * @param fileAcceptor filter of found files by name
     * @return List of Strings, each name is a full path name of the file
     */
    public static List<String> findAllFilesRecursively(String rootDirName, FileAcceptor fileAcceptor) {
        List<String> result = new ArrayList<>();

        _findAllFilesRecursively(result, new File(rootDirName), fileAcceptor);

        return result;
    }

    private static void _findAllFilesRecursively(List<String> collectedFiles, File dirToScan, FileAcceptor fileAcceptor) {
        File[] items = dirToScan.listFiles();
        if (items == null) return;

        for (File item : items) {
            if (item.isDirectory() && item.exists()) {
                _findAllFilesRecursively(collectedFiles, item, fileAcceptor);
            } else {
                String longFileName = item.toString();
                String shortFileName = item.getName();
                if (fileAcceptor.testFileByName(shortFileName)) collectedFiles.add(longFileName);
            }
        }
    }

    /**
     * Stores string to the file in override mode.
     * @param content String to store
     * @param fileToWriteInto String file name to the file to create/override
     * @throws IOException
     */
    public static void saveToFile(String content, String fileToWriteInto) throws IOException {
        Path path = Paths.get(fileToWriteInto);
        Files.write(path, content.getBytes());
    }

    /**
     * Reads file into string
     * @param filePath String file name to read
     * @return String content of the file
     * @throws IOException
     */
    public static String readFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes);
    }

    /**
     * Returns list of files found in the scpeified diretory.
     * No recursive approach is used - only one level scan.
     * @param dir directory to scan files in
     * @return List of File
     */
    public static List<File> getFilesInDir(File dir) {
        File[] filesOnly = dir.listFiles(File::isFile);
        if (filesOnly == null) return Collections.emptyList();

        return Arrays.stream(filesOnly).toList();
    }
}
