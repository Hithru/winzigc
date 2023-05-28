package org.example;

import java.io.*;

/**
 * Winzigc
 * compile : javac winzigc.java
 * run : java Program
 * compile and run : javac winzigc.java; java Winzigc –ast winzig_test_programs/winzig_01
 */
public class winzigc {
    public static void main(String[] args) {
        if (args.length == 0) {
            displayHelp();
            return;
        }

        String flag = args[0];

        switch (flag) {
            case "-ast":
                processAstCommand(args);
                break;
            case "-codegen":
                processCodeGenCommand();
                break;
            case "-h":
                displayHelp();
                break;
            default:
                System.out.println("Provided args are incompatible. Run with flag -h for help");
        }
    }

    private static void processAstCommand(String[] args) {
        if (args.length < 2) {
            System.out.println("Path to Winzig program is missing");
            return;
        }

        String pathToWinzigProgram = args[1];
        System.out.println("Generate AST for " + pathToWinzigProgram);

        try {
            String programAsString = readWinzigProgram(pathToWinzigProgram);
            Lexer lexer = new Lexer(programAsString);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the Winzig program: " + e.getMessage());
        }
    }

    private static void processCodeGenCommand() {
        // Implement code generation logic here
    }

    private static void displayHelp() {
        System.out.println("Run command: java winzigc [stage] [path]");
        System.out.println("    [stage]: Specifies where to stop in the steps of Winzigc compiler");
        System.out.println("            -ast: Generate 'Abstract Syntax Tree' from the Winzig program found using file path given by [path]");
        System.out.println("     [path]: Relative path to the Winzig program");
    }

    private static String readWinzigProgram(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder stringBuilder = new StringBuilder();
            String lineSeparator = System.getProperty("line.separator");
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(lineSeparator);
            }

            return stringBuilder.toString();
        }
    }
}

enum SyntaxKind {
    //     for the lexer
    IdentifierToken(),
    IntegerToken,
    WhiteSpaceToken,
    CharToken,
    StringToken,
    CommentToken,
    NewlineToken,               //  \n
    ProgramToken,               //  program
    VarToken,                   //  var
    ConstToken,                 //  const
    TypeToken,                  //  type
    FunctionToken,              //  function
    ReturnToken,                //  return
    BeginToken,                 //  begin
    EndToken,                   //  end
    SwapToken,                  //  :=:
    AssignToken,                //  :=
    OutputToken,                //  output
    IfToken,                    //  if
    ThenToken,                  //  then
    ElseToken,                  //  else
    WhileToken,                 //  while
    DoToken,                    //  do
    CaseToken,                  //  case
    OfToken,                    //  of
    CaseExpToken,               //  ..
    OtherwiseToken,             //  otherwise
    RepeatToken,                //  repeat
    ForToken,                   //  for
    UntilToken,                 //  until
    LoopToken,                  //  loop
    PoolToken,                  //  pool
    ExitToken,                  //  exit
    LessOrEqualOprToken,        //  <=
    NotEqualOprToken,           //  <>
    LessThanOprToken,           //  <
    GreaterOrEqualOprToken,     //  >=
    GreaterThanOprToken,        //  >
    EqualToOprToken,            //  =
    ModulusOprToken,            //  mod
    AndOprToken,                //  and
    OrOprToken,                 //  or
    NotOprToken,                //  not
    ReadToken,                  //  read
    SuccessorToken,             //  succ
    PredecessorToken,           //  pred
    CharFuncToken,              //  chr
    OrdinalFuncToken,           //  ord
    EndOfFileToken,             //  eof
    ColonToken,                 //  :
    SemiColonToken,             //  ;
    SingleDotToken,             //  .
    CommaToken,                 //  ,
    OpenBracketToken,           //  (
    CloseBracketToken,          //  )
    PlusToken,                  //  +
    MinusToken,                 //  -
    MultiplyToken,              //  *
    DivideToken                 //  /

}

class SyntaxToken {
    SyntaxKind kind;
    int position;
    String text;
    Object value;
    public SyntaxToken(SyntaxKind kind, int position, String text, Object value){
        this.kind = kind;
        this.position = position;
        this.text = text;
        this.value = value;
    }
}

class Lexer{

    private final String _text;

    public Lexer(String text){
        _text = text;
    }

}



