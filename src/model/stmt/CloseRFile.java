package model.stmt;

import model.exception.MyException;
import model.exception.MyExceptionTypesDontMatch;
import model.exception.MyNotDefinedDictionaryException;
import model.expression.Exp;
import model.program_state.ProgramState;
import model.type.StringType;
import model.utilis.MyIDictionary;
import model.value.StringValue;
import model.value.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class CloseRFile implements IStmt{
    Exp expression;
    public CloseRFile(Exp e)
    {
        expression = e;
    }
    @Override
    public ProgramState execute(ProgramState state) throws MyException, IOException {
        MyIDictionary<String,Value> sym_table = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> file_table = state.getFileTable();
        Value value_of_expression = expression.eval(sym_table);
        if(!Objects.equals(value_of_expression.getType(), new StringType()))
        {
            throw new MyExceptionTypesDontMatch("type of expression needs to be a file!");
        }
        else
        {
            if(file_table.isDefined((StringValue) value_of_expression))
            {
                BufferedReader buff = file_table.lookUp((StringValue) value_of_expression);
                buff.close();
                file_table.remove((StringValue) value_of_expression);
            }
            else
                throw new MyNotDefinedDictionaryException("key not defined!");


        }
        return state;
    }
}
