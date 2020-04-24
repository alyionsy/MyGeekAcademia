package console.action;

import domain.Book;
import domain.Order;
import service.ReaderService;
import service.BookService;
import service.OrderService;
import service.impl.ReaderServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.OrderServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderAction {

    private static OrderService service = new OrderServiceImpl();
    private static BookService bookService = new BookServiceImpl();
    private static ReaderService readerService = new ReaderServiceImpl();

    public static void addOrder() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter reader's ID:");
        Order order = new Order();
        if (scanner.hasNext()) {
            order.setReader(readerService.read(scanner.nextLong()));
        }
        System.out.println(order.getReader());
        int c;
        boolean indicator = true;
        List<Book> books = new ArrayList<>();
        while (indicator) {
            System.out.println("[1] Add book" + "\n[2] Cancel");
            c = scanner.nextInt();
            switch (c) {
                case 1: System.out.println("Enter book's ID:");
                    books.add(bookService.read(scanner.nextLong()));
                    break;
                case 2: indicator = false;
                    break;
                default: System.out.println("error.");
            }
        }
        order.setBook(books);
        order = service.create(order);

        System.out.println(order);
    }
    public static void updateOrder() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Order order = new Order();
        System.out.println("Enter order's ID:");
        if (scanner.hasNext()) {
            order = service.read(scanner.nextLong());
        }
        System.out.println(order);

        int c;
        boolean indicator = true;
        while (indicator) {
            System.out.println("[1] Add book" + "\n[2] Delete book"
                    + "\n[3] Cancel");
            c = scanner.nextInt();
            switch (c) {
                case 1: System.out.println("Enter book's ID:");
                    order.getBook().add(bookService.read(scanner.nextLong()));
                    break;
                case 2:  System.out.println("Enter book's ID:");
                    order.getBook().remove(bookService.read(scanner.nextLong()));
                    break;
                case 3: indicator = false;
                    break;
                default: System.out.println("error.");
            }
        }

        order = service.update(order);

        System.out.println(order);
    }

    public static void deleteOrder() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Order order = new Order();
        System.out.println("Enter order's ID:");
        if (scanner.hasNext()) {
            order = service.read(scanner.nextLong());
        }
        service.delete(order);
    }

    public static void listAllOrders() throws IOException, ClassNotFoundException {
        service.listAllOrders();
    }
}