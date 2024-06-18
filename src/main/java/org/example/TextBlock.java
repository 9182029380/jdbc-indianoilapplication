package org.example;

public class TextBlock {
    public static void main(String[] args) {

        // This is a text block annotation that provides a multi-line comment or string literal
        // to be used as a description or example in the documentation.
        /* This is a
           multi-line comment */
        String dqName = "Pat Q. Smith";
        String tbName = """
                Pat Q. Smith""";
        System.out.println(dqName==tbName);
    }

}
