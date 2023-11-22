package model.stmt;

import model.exception.MyException;
import model.program_state.ProgramState;
import model.utilis.MyIList;
import model.value.Value;
import model.expression.*;

public class PrintStmt implements IStmt {
    Exp expression;

    public PrintStmt(Exp e)
    {
        expression = e;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException
    {
        MyIList<Value> out_list = state.getOut();
        out_list.add(expression.eval(state.getSymTable()));
        return state;
    }

    @Override
    public String toString() {
        return "Print( " + expression + ")";
    }
}
