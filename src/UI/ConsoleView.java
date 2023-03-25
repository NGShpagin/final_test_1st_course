package UI;

import Core.MVP.Presenter;
import Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner sc;

    public ConsoleView() {
        sc = new Scanner(System.in);
    }

    @Override
    public String getName() {
        System.out.print("Name: ");
        return sc.next();
    }

    @Override
    public void setName(String name) {
        System.out.printf("Name: %s\n", name);
    }

    @Override
    public int getAge() {
        System.out.print("Age: ");
        return sc.nextInt();
    }

    @Override
    public void setAge(int age) {
        System.out.printf("Birthday: %d\n", age);
    }

    @Override
    public String getCommand() {
        System.out.print("Command: ");
        return sc.nextLine();
    }

    @Override
    public void learnCommand(String command) {
        System.out.printf("Command: %s\n", command);
    }
}
