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
                presenter.printAnimal(AnimalTypes.CAT);
                menu.thirdSubMenu(menu, AnimalTypes.CAT);
            }
            case "2" -> {
                presenter.printAnimal(AnimalTypes.DOG);
                menu.thirdSubMenu(menu, AnimalTypes.DOG);
            }
            case "3" -> {
                presenter.printAnimal(AnimalTypes.HAMSTER);
                menu.thirdSubMenu(menu, AnimalTypes.HAMSTER);
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
                presenter.printAnimal(AnimalTypes.HORSE);
                menu.thirdSubMenu(menu, AnimalTypes.HORSE);
            }
            case "2" -> {
                presenter.printAnimal(AnimalTypes.CAMEL);
                menu.thirdSubMenu(menu, AnimalTypes.CAMEL);
            }
            case "3" -> {
                presenter.printAnimal(AnimalTypes.DONKEY);
                menu.thirdSubMenu(menu, AnimalTypes.DONKEY);
            }
            case "4" -> menu.mainMenu(menu);
            case "5" -> System.exit(0);
            default -> {
                menu.secondMenu_2(menu);
                System.out.println("Такой команды нет");
            }
        }
    }

    public void thirdSubMenu(Menu menu, AnimalTypes type) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - prev (<<<)   2 - next (>>>)\n\n3 - Добавить\n4 - Удалить\n5 - Обучить команде\n6 - Назад\n\n7 - Выход");
        String key = in.next();
        switch (key) {
            case "1" -> {
                presenter.prev(type);
                menu.thirdSubMenu(menu, type);
            }
            case "2" -> {
                presenter.next(type);
                menu.thirdSubMenu(menu, type);
            }
            case "3" -> {
                presenter.addAnimal(type);
                presenter.setCurrentIndex(1);
                presenter.printAnimal(type);
                menu.thirdSubMenu(menu, type);
            }
            case "4" -> {
                presenter.removeAnimal(type);
                presenter.setCurrentIndex(1);
                presenter.printAnimal(type);
                menu.thirdSubMenu(menu, type);
            }
            case "5" -> {
                presenter.learnNewCommand(type);
                presenter.printAnimal(type);
                menu.thirdSubMenu(menu, type);
            }
            case "6" -> menu.secondMenu_1(menu);
            case "7" -> System.exit(0);
            default -> {
                menu.thirdSubMenu(menu, type);
                System.out.println("Такой команды нет");
            }
        }
    }
}
