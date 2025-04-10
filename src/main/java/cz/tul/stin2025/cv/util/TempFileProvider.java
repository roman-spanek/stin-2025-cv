package cz.tul.stin2025.cv.util;

import java.io.File;
import java.io.IOException;

public class TempFileProvider {

    public File createTempFile(String prefix, String suffix) throws IOException {
        return File.createTempFile(prefix, suffix);
    }

    public File getTempDirectory() {
        return new File(System.getProperty("java.io.tmpdir"));
    }
}