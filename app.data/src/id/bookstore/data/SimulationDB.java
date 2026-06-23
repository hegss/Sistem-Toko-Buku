package id.bookstore.data;

import java.util.ArrayList;
import java.util.List;

public class SimulationDB {
    private static List<Book> bookDatabase = new ArrayList<>();

    static {
        // Data simulasi awal
        bookDatabase.add(new Book("B001", "Pemrograman Java Modern", "Teknologi", 120000, 10));
        bookDatabase.add(new Book("B002", "Struktur Data & Algoritma", "Teknologi", 95000, 5));
        bookDatabase.add(new Book("B003", "Laskar Pelangi", "Fiksi", 80000, 3));
    }

    public static List<Book> getAllBooks() {
        return bookDatabase;
    }

    public static Book findBookById(String id) {
        for (Book book : bookDatabase) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }
}