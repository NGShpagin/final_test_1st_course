package UI;

import Core.MVP.Presenter;
import Core.Models.AnimalTypes;

import java.util.Scanner;

public class Menu {
    ConsoleView view = new ConsoleView();
    Presenter presenter = new Presenter(view);

    public Menu() { }

    public void mainMenu(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - Домашние животные\n2 - Вьючные животные\n3 - Выход");
        String key1 = in.next();
        switch (key1) {
            case "1" -> menu.secondMenu_1(menu);
            case "2" -> menu.secondMenu_2(menu);
            case "3" -> System.exit(0);
            default -> {
                menu.mainMenu(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void secondMenu_1(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - Кошки\n2 - Собаки\n3 - Хомяки\n4 - Назад\n\n5 - Выход");
        String key = in.next();
        presenter.setCurrentIndex(1);
        switch (key) {
            case "1" -> {
                presenter.printAnimal("cats");
                menu.thirdMenu_1_1(menu);
            }
            case "2" -> {
                presenter.printAnimal("dogs");
                menu.thirdMenu_1_2(menu);
            }
            case "3" -> {
                presenter.printAnimal("hamsters");
                menu.thirdMenu_1_3(menu);
            }
            case "4" -> menu.mainMenu(menu);
            case "5" -> System.exit(0);
            default -> {
                menu.secondMenu_1(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void secondMenu_2(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - Лошади\n2 - Верблюды\n3 - Ослы\n4 - Назад\n\n5 - Выход");
        String key = in.next();
        presenter.setCurrentIndex(1);
        switch (key) {
            case "1" -> {
                presenter.printAnimal("horses");
                menu.thirdMenu_2_1(menu);
            }
            case "2" -> {
                presenter.printAnimal("camels");
                menu.thirdMenu_2_2(menu);
            }
            case "3" -> {
                presenter.printAnimal("donkeys");
                menu.thirdMenu_2_3(menu);
            }
            case "4" -> menu.mainMenu(menu);
            case "5" -> System.exit(0);
            default -> {
                menu.secondMenu_2(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdMenu_1_1(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev("cats");
                menu.thirdMenu_1_1(menu);
            }
            case "2" -> {
                presenter.next("cats");
                menu.thirdMenu_1_1(menu);
            }
            case "4" -> presenter.removeAnimal(AnimalTypes.CAT);
            case "3" -> presenter.addAnimal(AnimalTypes.CAT);
            case "6" -> menu.secondMenu_1(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdMenu_1_1(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdMenu_1_2(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev("dogs");
                menu.thirdMenu_1_2(menu);
            }
            case "2" -> {
                presenter.next("dogs");
                menu.thirdMenu_1_2(menu);
            }
            case "3" -> presenter.addAnimal(AnimalTypes.DOG);
            case "4" -> presenter.removeAnimal(AnimalTypes.DOG);
            case "6" -> menu.secondMenu_1(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdMenu_1_2(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdMenu_1_3(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev("hamsters");
                menu.thirdMenu_1_3(menu);
            }
            case "2" -> {
                presenter.next("hamsters");
                menu.thirdMenu_1_3(menu);
            }
            case "3" -> presenter.addAnimal(AnimalTypes.HAMSTER);
            case "4" -> presenter.removeAnimal(AnimalTypes.HAMSTER);
            case "6" -> menu.secondMenu_1(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdMenu_1_3(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdMenu_2_1(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev("horses");
                menu.thirdMenu_2_1(menu);
            }
            case "2" -> {
                presenter.next("horses");
                menu.thirdMenu_2_1(menu);
            }
            case "3" -> presenter.addAnimal(AnimalTypes.HORSE);
            case "4" -> presenter.removeAnimal(AnimalTypes.HORSE);
            case "6" -> menu.secondMenu_2(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdMenu_2_1(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdMenu_2_2(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev("camels");
                menu.thirdMenu_2_2(menu);
            }
            case "2" -> {
                presenter.next("camels");
                menu.thirdMenu_2_2(menu);
            }
            case "3" -> presenter.addAnimal(AnimalTypes.CAMEL);
            case "4" -> presenter.removeAnimal(AnimalTypes.CAMEL);
            case "6" -> menu.secondMenu_2(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdMenu_2_2(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdMenu_2_3(Menu menu) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Найти\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev("donkeys");
                menu.thirdMenu_2_3(menu);
            }
            case "2" -> {
                presenter.next("donkeys");
                menu.thirdMenu_2_3(menu);
            }
            case "3" -> presenter.addAnimal(AnimalTypes.DONKEY);
            case "4" -> presenter.removeAnimal(AnimalTypes.DONKEY);
            case "6" -> menu.secondMenu_2(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdMenu_2_3(menu);
                System.out.println("Такой команды нет");
            }
        }
    }
}
