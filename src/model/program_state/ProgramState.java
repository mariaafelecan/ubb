package model.program_state;

import model.stmt.*;
import model.utilis.MyIStack;
import model.utilis.MyIList;
import model.utilis.MyIDictionary;
import model.value.StringValue;
import model.value.Value;

import java.io.BufferedReader;

public class ProgramState {
    MyIStack<IStmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    MyIDictionary<StringValue, BufferedReader> fileTable;
    IStmt originalProgram; //optional field, but good to have

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }
    public MyIDictionary<StringValue, BufferedReader> getFileTable(){return fileTable;}

    public void setSymTable(MyIDictionary<String, Value> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public void setOut(MyIList<Value> out) {
        this.out = out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(IStmt originalProgram) {
        this.originalProgram = originalProgram;
    }

    public ProgramState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value>
            ot, IStmt prg, MyIDictionary<StringValue, BufferedReader> ft){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        fileTable = ft;
        //originalProgram=deepCopy(prg);//recreate the entire original prg
        stk.push(prg);
    }

    @Override
    public String toString() {
        return "program state: \n" +
                "exeStack = " + exeStack.toString() + '\n' +
                "symTable = " + symTable.toString() + '\n' +
                "out = " + out.toString() +
                '\n';
    }
}