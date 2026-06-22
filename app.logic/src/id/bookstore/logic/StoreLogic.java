package id.bookstore.logic;

import id.bookstore.data.Book;
import id.bookstore.data.SimulationDB;

public class StoreLogic {

    // Validasi ketersediaan stok
    public boolean validateStock(String bookId, int quantity) {
        Book book = SimulationDB.findBookById(bookId);
        if (book != null && book.getStock() >= quantity) {
            return true;
        }
        return false;
    }

    // Menghitung harga total setelah diskon jika beli > 2 buku
    public double calculateTotal(String bookId, int quantity) {
        Book book = SimulationDB.findBookById(bookId);
        if (book == null) return 0;

        double basePrice = book.getPrice() * quantity;
        double discount = 0;

        // Logika Bisnis: Diskon 10% jika beli lebih dari 2 buku
        if (quantity > 2) {
            discount = 0.10 * basePrice;
        }

        return basePrice - discount;
    }

    // Mengurangi stok setelah pembelian berhasil
    public boolean processPurchase(String bookId, int quantity) {
        if (validateStock(bookId, quantity)) {
            Book book = SimulationDB.findBookById(bookId);
            book.setStock(book.getStock() - quantity);
            return true;
        }
        return false;
    }
}