package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile)); InputStream is = Files.newInputStream(source)) {
            zos.putNextEntry(zipEntry);
            while (is.available() != 0) {
                zos.write(is.read());
            }
        }
     }

}
