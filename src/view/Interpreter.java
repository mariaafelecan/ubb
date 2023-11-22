package view;

import controller.Controller;
import model.exception.MyException;
import model.expression.ArithExp;
import model.expression.ValueExp;
import model.expression.VarExp;
import model.stmt.*;
import model.program_state.ProgramState;
import model.type.BoolType;
import model.type.IntType;
import model.utilis.*;
import model.value.BoolValue;
import model.value.IntValue;
import model.value.StringValue;
import model.value.Value;
import repository.IRepository;
import repository.Repository;
import view.commands.ExitCommand;
import view.commands.RunExample;

import java.io.BufferedReader;
import java.io.IOException;

class Interpreter {
    public static void main() throws MyException, IOException {
        ///ex1
        IStmt ex1= new CompStmt(new VarDeclarationStmt("v",new IntType()),
                new CompStmt(new AssigmentStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new
                        VarExp("v"))));
        MyIStack<IStmt> stk1 = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl1 =
                new MyDictionary<String,Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable1 = new MyDictionary<>();
        MyIList<Value> out1 = new MyList<Value>();
        ProgramState crtPrgState1= new ProgramState(stk1, symtbl1, out1, ex1, fileTable1);

        IRepository repo1 = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo1.add(crtPrgState1);
        Controller controller1 = new Controller(repo1);


        ///ex2
        IStmt ex2 = new CompStmt( new VarDeclarationStmt("a",new IntType()),
                new CompStmt(new VarDeclarationStmt("b",new IntType()),
                        new CompStmt(new AssigmentStmt("a", new ArithExp(1,new ValueExp(new IntValue(2)),new
                                ArithExp(3, new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))) )),
                                new CompStmt(new AssigmentStmt("b",new ArithExp(1,new VarExp("a"), new ValueExp(new
                                        IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        MyIStack<IStmt> stk2 = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl2 =
                new MyDictionary<String,Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable2 = new MyDictionary<>();
        MyIList<Value> out2 = new MyList<Value>();
        ProgramState crtPrgState2= new ProgramState(stk2, symtbl2, out2, ex2, fileTable2);

        IRepository repo2 = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo2.add(crtPrgState2);
        Controller controller2 = new Controller(repo2);


        ///ex3
        IStmt ex3 = new CompStmt(new VarDeclarationStmt("a",new BoolType()),
                new CompStmt(new VarDeclarationStmt("v", new IntType()),
                        new CompStmt(new AssigmentStmt("a", new ValueExp(new BoolValue(false))),
                                new CompStmt(new IfStmt(new VarExp("a"),new AssigmentStmt("v",new ValueExp(new
                                        IntValue(2))), new AssigmentStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
        MyIStack<IStmt> stk3 = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl3 =
                new MyDictionary<String,Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable3 = new MyDictionary<>();
        MyIList<Value> out3 = new MyList<Value>();
        ProgramState crtPrgState3= new ProgramState(stk3, symtbl3, out3, ex3, fileTable3);

        IRepository repo3 = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo3.add(crtPrgState3);
        Controller controller3 = new Controller(repo3);


        ///testing the file operations

        String varf;
        varf="C:\\Users\\Maria\\Desktop\\ubb\\MAP\\A2\\test.in.txt";
        ValueExp e = new ValueExp(new StringValue(varf));
        IStmt combinedStmt = new CompStmt(new CompStmt(new CompStmt(new CompStmt(                 new CompStmt(
        new OpenRFile(e),
        new VarDeclarationStmt("varc", new IntType())
        ),
        new ReadFile(e, "varc")
        ),
        new ReadFile(e, "varc")  // Include the ReadFile statement again
        ),
        new PrintStmt(new VarExp("varc"))
        ),
        new CloseRFile(e)
        );
        MyIStack<IStmt> stk4 = new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl4 =
                new MyDictionary<String,Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable4 = new MyDictionary<>();
        MyIList<Value> out4 = new MyList<Value>();
        ProgramState crtPrgState4= new ProgramState(stk4, symtbl4, out4, combinedStmt, fileTable4);

        IRepository repo4 = new Repository("C:\\Users\\Maria\\Desktop\\ubb\\MAP\\log_file.txt");
        repo4.add(crtPrgState4);
        Controller controller4 = new Controller(repo4);



        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),controller1));
        menu.addCommand(new RunExample("2",ex2.toString(),controller2));
        menu.addCommand(new RunExample("3",ex3.toString(),controller3));
        menu.addCommand(new RunExample("4", combinedStmt.toString(), controller4));
        menu.show();
    }
}
