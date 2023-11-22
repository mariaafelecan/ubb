package controller;

import model.expression.ValueExp;
import model.expression.VarExp;
import model.program_state.*;
import model.stmt.*;
import model.type.IntType;
import model.utilis.*;
import model.value.StringValue;
import repository.IRepository;
import model.exception.*;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    private ProgramState oneStep(ProgramState state) throws MyException, IOException {
        MyIStack<IStmt> stk = state.getExeStack();
        if (stk.isEmpty()) throw new MyException("program state: stack is empty");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    public void allStep() throws MyException, IOException {
        ProgramState prg = repo.getCurrentProgramState();
        while (!prg.getExeStack().isEmpty()){
            System.out.println(prg.toString());
            repo.savePrgStateinLOG();
            try {
                this.oneStep(prg);
            }

            catch (MyException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
        System.out.println(prg.toString());
        repo.savePrgStateinLOG();
    }

}
