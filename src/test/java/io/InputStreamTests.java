package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputStreamTests {

    private static Path path;
    private File file;

    @BeforeAll
    static void setPath() {
        path = Paths.get("test.txt");
    }

    @BeforeEach
    void setUp() throws IOException {
        file = Files.createFile(path).toFile();
    }

    @Test
    void testCreateFileInputStreamResultInSuccess() {
        Assertions.assertThatCode(() -> new FileInputStream(file))
            .doesNotThrowAnyException();
    }

    @Test
    void testCreateFileInputStreamResultInFail() {
        Assertions.assertThatThrownBy(() -> new FileInputStream((File) null))
            .isInstanceOf(NullPointerException.class);

    }

    @AfterEach
    void removeFile() throws IOException {
        Files.deleteIfExists(path);
    }
}
