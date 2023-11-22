package model.expression;

import model.exception.MyException;
import model.utilis.MyIDictionary;
import model.value.Value;
import model.stmt.*;

public class ValueExp implements Exp{
    Value e;
    public ValueExp(Value v)
    {
        e = v;
    }
    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        return e;
    }

    @Override
    public String toString() {
        return "ValueExp{" +
                 e +
                '}';
    }
}
