package console;

import console.action.AuthorAction;
import console.action.ReaderAction;

import java.util.Scanner;

public class AuthorSubMenu {
    public static void showAuthorSubMenu(Scanner ui) {
        int c;
        while (true) {
            System.out.println("\n---------Author menu---------");
            System.out.println("\n[1] Create author\n" + "[2] Update author\n"
                    + "[3] Delete author\n" + "[4] List authors\n");
            System.out.println("\n[5] BACK");
            System.out.print("\nEnter your choice: ");
            c = ui.nextInt();

            switch (c) {
                case 1:
                    AuthorAction.addAuthor();
                    break;
                case 2:
                    AuthorAction.updateAuthor();
                    break;
                case 3:
                    AuthorAction.deleteAuthor();
                    break;
                case 4:
                    AuthorAction.listAllAuthors();
                    break;
                case 5:
                    Menu.showMainMenu();
                    break;
                default:
                    System.out.println("Try again.");
            }
        }
    }
}
