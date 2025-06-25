package art.lapov.project2dev;

import art.lapov.project2dev.repository.DataBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("*".repeat(100));
        System.out.println("Welcome to Project2Dev!");
        System.out.println("*".repeat(100));
        DataBase.getManager();
        System.out.println("DataBase is ready!");

    }
}