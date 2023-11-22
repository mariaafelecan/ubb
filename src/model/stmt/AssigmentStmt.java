package model.stmt;

import model.exception.MyException;
import model.exception.MyExceptionNotDeclared;
import model.exception.MyExceptionTypesDontMatch;
import model.program_state.ProgramState;
import model.expression.*;
import model.utilis.MyIDictionary;
import model.utilis.MyIStack;
import model.value.Value;
import model.type.*;

import java.util.Objects;

public class AssigmentStmt implements IStmt{

    String id;
    Exp expression;

    public AssigmentStmt(String v, Exp expres) {
        id = v;
        expression = expres;
    }

    @Override
    public String toString() {
        return "AssigmentStmt( " + id  +
                " = " + expression + ")";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyIStack<IStmt> exe_stack = state.getExeStack();
        MyIDictionary<String, Value> sym_table = state.getSymTable();
        if(sym_table.isDefined(id))
        {
            Value val = expression.eval(sym_table);
            Type type_id = sym_table.lookUp(id).getType();
            if(Objects.equals(val.getType().toString(), type_id.toString()))
            {
                sym_table.update(id, val);
            }
            else
            {
                throw new MyExceptionTypesDontMatch("the types do not match!");}
        }
        else throw new MyExceptionNotDeclared("this variable was not declared!");
        return state;
    }
}
