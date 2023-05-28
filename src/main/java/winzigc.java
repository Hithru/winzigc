

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class winzigc {

    private static final List<SyntaxToken> tokenStream = new ArrayList<>();

    public static void main(String[] args) {
        String operationFlag = args[0];
        switch (operationFlag) {
            case  "-ast":
                executeAstGeneration(args[1]);
                break;
            case "-test":
                executeTests();
                break;
            case  "-h":
                printHelp();
                break;
            default:
                printIncompatibleArgsError();
        }
    }

    private static void executeAstGeneration(String pathToWinzigProgram) {
        try {
            String programAsString = readWinzigProgram(pathToWinzigProgram);
            Lexer lexer = new Lexer(programAsString);
            generateTokenStream(lexer);
            List<SyntaxToken> screenedTokenStream = screenTokenStream();
            ParserBottomUpTree parser = new ParserBottomUpTree(screenedTokenStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeTests() {
        for(int i = 1; i <= 15; i++){
            String path =  String.format("winzig_test_programs/winzig_%02d" , i);
            System.out.println("================================= "+ path+" ===========================================");
            try {
                String programString = readWinzigProgram(path);
                Lexer lexer = new Lexer(programString);
                generateTokenStream(lexer);
                ParserBottomUpTree parser = new ParserBottomUpTree(screenTokenStream());
                tokenStream.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateTokenStream(Lexer lexer) {
        SyntaxKind kind;
        do {
            SyntaxToken token = lexer.findNextToken();
            tokenStream.add(token);
            kind = token.kind;
        } while(kind != SyntaxKind.EndOfProgramToken);
    }

    private static void printHelp() {
        System.out.println("run command: java WinzigCompiler [stage] [path]");
        System.out.println("    [stage]: specifies where to stop in the steps of WinzigCompiler compiler");
        System.out.println("            -ast: generate 'Abstract Syntax Tree' from the winzig program found using file path given by [path]");
        System.out.println("     [path]: relative path to the winzig program");
    }

    private static void printIncompatibleArgsError() {
        System.out.println("Provided args are incompatible. Run with flag -h for help");
        System.out.println("java WinzigCompiler -h");
    }

    private static String readWinzigProgram(String path) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString() + "   ";
        }
    }

    private static List<SyntaxToken> screenTokenStream(){
        List<SyntaxToken> screenedToken = new ArrayList<>();
        for(SyntaxToken token : tokenStream){
            if(token.kind != SyntaxKind.CommentToken && token.kind != SyntaxKind.WhiteSpaceToken &&
                    token.kind != SyntaxKind.NewlineToken && token.kind != SyntaxKind.EndOfProgramToken){
                screenedToken.add(token);
            }
        }
        return screenedToken;
    }
}
