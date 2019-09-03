package com.precisionmedcare.jkkj.utils;

import org.python.util.PythonInterpreter;

public class pythonTest {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a=[5,2,3,9,4,0]; ");
        interpreter.exec("print(sorted(a));");  //此处python语句是3.x版本的语法
        interpreter.exec("print sorted(a);");   //此处是python语句是2.x版本的语法
    }
}
