# CS4542 Compiler Design - WinZigC Parser

This project involves implementing a lexical analyzer and parser (recursive descent) for the language WinZigC. This parser is part of the course work for CS4542 Compiler Design.

## Project Description

This parser is implemented without the use of 'lex', 'yacc', or any similar tools and is built using Java. The lexical rules and grammar details can be found in the [`WinzigC_Lex.pdf`](./WinzigC_Lex.pdf) and [`WinzigC_Grammar.pdf`](./WinzigC_Grammar.pdf) files respectively.

## Installation

This project is submitted as a tar file and can be set up by following these steps:

```bash
> tar xvf project1180114D.tar
> make
```

## Usage

After setting up the project, you can run the program on a test program like this:

```bash
java winzigc -ast winzig_test_programs/winzig_01 > tree.01
diff tree.01 winzig_test_programs/winzig_01.tree
```