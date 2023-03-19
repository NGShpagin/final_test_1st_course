package UI;

import Core.MVP.Model;
import Core.MVP.Presenter;

import java.util.Scanner;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");
        ConsoleView view = new ConsoleView();
        Presenter presenter = new Presenter(view);
        Menu menu = new Menu();



        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                menu.mainMenu(menu);
//                System.out.println("1 - Домашние животные\n2 - Вьючные животные\n3 - Выход");
//                String key1 = in.next();
//                System.out.print("\033[H\033[J");
//                switch (key1) {
//                    case "1" -> {
//                        System.out.println("1 - Кошки\n2 - Собаки\n3 - Хомяки\n4 - Назад");
//                        String key2 = in.next();
//                        System.out.print("\033[H\033[J");
//                        switch (key2) {
//                            case "1":
//                                presenter.setCurrentIndex(1);
//                                presenter.printAnimal("cats");
//                                System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад");
//                                String key4 = in.next();
//                                System.out.print("\033[H\033[J");
//                                switch (key4) {
//                                    case "1" -> presenter.prev("cats");
//                                    case "2" -> presenter.next("cats");
//                                    case "3" -> presenter.addAnimal(AnimalTypes.CAT);
//                                    default -> System.out.println("Такой команды нет");
//                                }
//                                break;
//                            case "2":
//                                System.out.println("Собаки");
//                                break;
//                            case "3":
//                                System.out.println("Хомяки");
//                                break;
//                            case "4":
//                                break;
//                            default:
//                                System.out.println("Такой команды нет");
//                                break;
//                        }
//                    }
//                    case "2" -> {
//                        System.out.println("1 - Лошади\n2 - Верблюды\n3 - Ослы\n2-4 - Назад");
//                        String key3 = in.next();
////                        System.out.print("\033[H\033[J");
//                        switch (key3) {
//                            case "1" -> System.out.println("Лошади");
//                            case "2" -> System.out.println("Верблюды");
//                            case "3" -> System.out.println("Ослы");
//                            case "4" -> System.out.print("\033[H\033[J");
//                            default -> System.out.println("Такой команды нет");
//                        }
//                    }
//                    case "3" -> {
//                        return;
//                    }
//                    default -> System.out.println("Такой команды нет");
//                }
            }
        }
    }
}
