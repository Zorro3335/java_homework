package java_homework.calculator;

public interface ICalculableFactory {
    Calculable create(int primaryArg, boolean logFlag);
}
