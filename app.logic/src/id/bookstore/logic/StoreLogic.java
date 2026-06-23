package id.bookstore.logic;

import id.bookstore.data.Book;
import id.bookstore.data.SimulationDB;

public class StoreLogic {
    public void tampilkanDaftarBuku() {

    System.out.printf("%-6s | %-25s | %-12s | %-10s | %-5s%n",
            "ID", "Judul", "Kategori", "Harga", "Stok");

    System.out.println("------------------------------------------------------------------");

    for (Book b : SimulationDB.getAllBooks()) {
        System.out.printf("%-6s | %-25s | %-12s | Rp%,.0f | %-5d%n",
                b.getId(),
                b.getTitle(),
                b.getCategory(),
                b.getPrice(),
                b.getStock());
    }
}
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