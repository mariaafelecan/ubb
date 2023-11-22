package model.stmt;

import model.exception.MyException;
import model.program_state.ProgramState;
import model.utilis.MyIStack;

public class NopStmt implements IStmt{
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIStack<IStmt> stk = state.getExeStack();
        return state;
    }
}
