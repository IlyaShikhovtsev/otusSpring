package ru.shikhovtsev.service;

import ru.shikhovtsev.exception.StreamInputOutputServiceException;

import java.io.*;

public class ConsoleService implements StreamInputOutputService {
    private final PrintStream outputStream;
    private final BufferedReader reader;

    public ConsoleService(PrintStream outputStream, InputStream inputStream) {
        this.outputStream = outputStream;
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public void println(String message) {
        outputStream.println(message);
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new StreamInputOutputServiceException(e);
        }
    }
}
