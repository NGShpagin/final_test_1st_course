package UI;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");
        Menu menu = new Menu();
        menu.mainMenu(menu);
    }
}
