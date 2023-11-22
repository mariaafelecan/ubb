package model.expression;
import model.exception.MyException;
import model.utilis.MyIDictionary;
import model.value.*;
public interface Exp {
    Value eval(MyIDictionary<String, Value> tbl) throws MyException;
}
