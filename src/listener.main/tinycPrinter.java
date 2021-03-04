package listener.main;

import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import generated.*;

public class tinycPrinter {
    public static void main(String[] args) throws IOException {
        tinycLexer lexer = new tinycLexer(CharStreams.fromFileName("test.c"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tinycParser parser = new tinycParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new tinycPrintListener(), tree);
    }
}
