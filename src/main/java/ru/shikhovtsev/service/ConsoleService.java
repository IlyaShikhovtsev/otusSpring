package ru.shikhovtsev.service;

import ru.shikhovtsev.exception.StreamInputOutputServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConsoleService implements StreamInputOutputService {
    private final PrintStream outputStream;
    private final BufferedReader reader;

    public ConsoleService() {
        this.outputStream = System.out;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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
