package view;

import controller.Controller;
import model.exception.*;
import model.stmt.*;
import model.program_state.*;
import model.type.BoolType;
import model.type.IntType;
import model.value.*;
import repository.IRepository;
import repository.Repository;
import model.utilis.*;
import model.expression.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class View {
    /*
    private IStmt ex1= new CompStmt(new VarDeclarationStmt("v",new IntType()),
            new CompStmt(new AssigmentStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new
                    VarExp("v"))));

    private IStmt ex2 = new CompStmt( new VarDeclarationStmt("a",new IntType()),
            new CompStmt(new VarDeclarationStmt("b",new IntType()),
                    new CompStmt(new AssigmentStmt("a", new ArithExp(1,new ValueExp(new IntValue(2)),new
                            ArithExp(3, new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))) )),
                            new CompStmt(new AssigmentStmt("b",new ArithExp(1,new VarExp("a"), new ValueExp(new
                                    IntValue(1)))), new PrintStmt(new VarExp("b"))))));
    private IStmt ex3 = new CompStmt(new VarDeclarationStmt("a",new BoolType()),
            new CompStmt(new VarDeclarationStmt("v", new IntType()),
            new CompStmt(new AssigmentStmt("a", new ValueExp(new BoolValue(false))),
            new CompStmt(new IfStmt(new VarExp("a"),new AssigmentStmt("v",new ValueExp(new
            IntValue(2))), new AssigmentStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));

    public void printMenu(){
        System.out.println("welcome! please choose your option!");
        System.out.println("0 - >exit");
        System.out.println("1 -> "+ "execute : [ int v; " +" v=2 ; Print(v) ]" );
        System.out.println("2 ->" + "execute : [ int a; a=2+3*5; int b; b=a-4/2 + 7; Print(b) ]");
        System.out.println("3 -> execute: [ bool a; a=false; int v; If a Then v=2 Else v=3; Print(v) ]");
    }

    public void executeEx1(){
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl =
                new MyDictionary<String,Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable = new MyDictionary<>();
        MyIList<Value> out = new MyList<Value>();
        ProgramState crtPrgState= new ProgramState(stk, symtbl, out, ex1, fileTable);

        IRepository repo = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo.add(crtPrgState);
        Controller controller = new Controller(repo);
        try {
            controller.allStep();
        }
        catch (MyException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void executeEx2()
    {
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl =
                new MyDictionary<String,Value>();
        MyIList<Value> out = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable = new MyDictionary<>();
        ProgramState crtPrgState= new ProgramState(stk, symtbl, out, ex2, fileTable);

        IRepository repo = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo.add(crtPrgState);
        Controller controller = new Controller(repo);
        try {
            controller.allStep();
        }
        catch (MyException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void executeEx3()
    {
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl =
                new MyDictionary<String,Value>();
        MyIList<Value> out = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable = new MyDictionary<>();
        ProgramState crtPrgState= new ProgramState(stk, symtbl, out, ex3, fileTable);

        IRepository repo = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo.add(crtPrgState);
        Controller controller = new Controller(repo);
        try {
            controller.allStep();
        }
        catch (MyException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void start()
    {
        boolean stop = false;
        while(!stop)
        {
            printMenu();
            int option;
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if(option ==1)
                executeEx1();
            else if (option == 2) {
                executeEx2();

            } else if (option == 3) {
                executeEx3();

            } else if (option == 0) {
                stop = true;

            }
        }
    }

     */
    public void start() {
        try
        {
            Interpreter.main();
        }
        catch(MyException|IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /*
    public void test_file() {
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl =
                new MyDictionary<String,Value>();
        MyIList<Value> out = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable = new MyDictionary<>();
        ProgramState crtPrgState= new ProgramState(stk, symtbl, out, ex2, fileTable);

        IRepository repo = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo.add(crtPrgState);
        Controller controller = new Controller(repo);
        try
        {
            controller.test_file_operations();
        }
        catch(MyException| IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

     */
}
