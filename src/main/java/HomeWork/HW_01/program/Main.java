package HomeWork.HW_01.program;

import HomeWork.HW_01.model.Decorator;
import HomeWork.HW_01.model.Model;

public class Main {
    public static void main(String[] args) {
        int string1 = Model.sumWords("Привет");
        System.out.println(Decorator.print(string1));
    }
}
