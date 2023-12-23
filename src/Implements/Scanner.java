package Implements;

import Interfaces.IScanner;

public class Scanner implements IScanner {
    java.util.Scanner scanner;

    public Scanner(java.util.Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public String readString() {
        return scanner.next();
    }

    @Override
    public double readDouble() {
        return scanner.nextDouble();
    }

    @Override
    public boolean readBoolean() {
        return scanner.nextBoolean();
    }

    @Override
    public void printString(String text) {
        System.out.print(text);
    }

    @Override
    public void printlnString(String text) {
        System.out.println(text);
    }
}
