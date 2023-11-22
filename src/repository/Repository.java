package repository;

import model.exception.MyException;
import model.program_state.ProgramState;
import model.stmt.IStmt;
import model.utilis.MyIDictionary;
import model.utilis.MyIList;
import model.utilis.MyIStack;
import model.utilis.MyStack;
import model.value.Value;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Repository implements IRepository{

    String logFilePath;
    public Repository(String l) {
        programStateList = new ArrayList<>();
        logFilePath = l;
    }
    List<ProgramState> programStateList;
    @Override
    public ProgramState getCurrentProgramState() {
        try {
            return programStateList.get(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Repository{" +
                "programStateList=" + programStateList +
                '}';
    }

    @Override
    public void add(ProgramState programState) {
        programStateList.add(programState);
    }

    @Override
    public void savePrgStateinLOG() throws MyException, IOException {
        PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        logFile.println(" -- NEW PROGRAM STATE -- ");
        logFile.println("exe stack: ");
        ProgramState prg = getCurrentProgramState();
        MyIStack<IStmt> stack_copy = prg.getExeStack().copy();
        while(!stack_copy.isEmpty())
        {
            logFile.println(stack_copy.pop().toString());
        }
        logFile.println("sym table: ");
        MyIDictionary<String, Value> copy_sym = prg.getSymTable();
        List<String> sym_table_content = copy_sym.iterateDictionary();
        for(String item: sym_table_content)
        {
            logFile.println(item);
        }
        logFile.println("out: ");
        MyIList<Value> out_copy = prg.getOut();
        List<Value> out_content = out_copy.iterate_list();
        for(Value item : out_content)
        {
            logFile.println(item.toString());
        }
        logFile.flush();
        logFile.close();
    }
}
