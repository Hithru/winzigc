package org.example;

import java.io.*;

public class Winzigc {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("java Winzigc -h");
            return;
        }

        String flag = args[0];
        String pathToWinzigProgram = args[1];

        switch (flag) {
            case "-ast":
                System.out.println("Generating AST for " + pathToWinzigProgram);
                // Call lexer and parser
                String programAsAString = readWinzigProgram(pathToWinzigProgram);
                if (programAsAString == null) {
                    return;
                }
                Lexer lexer = new Lexer(programAsAString);
                // Implement lexer logic here
                break;
            case "-codegen":
                // Implement code generation logic here
                break;
            default:
                System.out.println("java Winzigc -h");
        }
    }

    private static String readWinzigProgram(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder  stringBuilder = new StringBuilder();
            String         ls = System.getProperty("line.separator");
            String         line;

            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            reader.close();

            return stringBuilder.toString();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the Winzig program file: " + e.getMessage());
            return null;
        }
    }
}

// Add implementation of SyntaxKind, SyntaxToken, Lexer classes
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