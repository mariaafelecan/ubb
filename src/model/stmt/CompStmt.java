package model.stmt;

import model.exception.MyException;
import model.program_state.ProgramState;
import model.utilis.MyIStack;

public class CompStmt implements IStmt {
    IStmt first;
    IStmt second;
    public CompStmt(IStmt f, IStmt s)
    {
        first = f;
        second = s;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException
    {
        MyIStack<IStmt> stk = state.getExeStack();
        stk.push(second);
        stk.push(first);
        return state;
    }

    @Override
    public String toString() {
        return "CompStmt( " +
                "first argument = [" + first +
                "] , second argument = [" + second+"] )";
    }
}
