package model.stmt;

import model.exception.MyException;
import model.exception.MyLogicException;
import model.program_state.ProgramState;
import model.expression.*;
import model.type.BoolType;
import model.utilis.MyIDictionary;
import model.utilis.MyIStack;
import model.value.BoolValue;
import model.value.Value;

import java.util.Objects;

public class IfStmt implements IStmt{
    Exp exp;
    IStmt thenS;
    IStmt elseS;
    public IfStmt(Exp e, IStmt t, IStmt el) {exp=e; thenS=t; elseS=el;}

    @Override
    public String toString()
    {
        return "(IF("+ exp.toString()+")THEN(" +thenS.toString()+")ELSE(" + elseS.toString() + "))";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIDictionary<String, Value> my_sym_table = state.getSymTable();
        Value condition = exp.eval(my_sym_table);
        MyIStack<IStmt> exe_stack = state.getExeStack();
        if(!Objects.equals(condition.getType(), new BoolType()))
            throw new MyLogicException("the type of the condition s not boolean!");
        else
        {
            BoolValue cond = (BoolValue) condition;
            if(cond.getValue())
            {
                exe_stack.push(thenS);
            }
            else
                exe_stack.push(elseS);
        }
        return state;
    }
}
