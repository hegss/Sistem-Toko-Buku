package id.bookstore.ui;

import id.bookstore.data.Book;
import id.bookstore.data.SimulationDB;
import id.bookstore.logic.StoreLogic;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StoreLogic storeLogic = new StoreLogic();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== SISTEM MANAJEMEN TOKO BUKU DIGITAL ===");

        while (running) {
            System.out.println("\n--- Daftar Buku Tersedia ---");
            System.out.printf("%-6s | %-25s | %-12s | %-10s | %-5s\n", "ID", "Judul", "Kategori", "Harga", "Stok");
            System.out.println("------------------------------------------------------------------");
            for (Book b : SimulationDB.getAllBooks()) {
                System.out.printf("%-6s | %-25s | %-12s | Rp%,-8.0f | %-5d\n", 
                        b.getId(), b.getTitle(), b.getCategory(), b.getPrice(), b.getStock());
            }

            System.out.println("\nMenu:");
            System.out.println("1. Beli Buku");
            System.out.println("2. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Masukkan ID Buku: ");
                String id = scanner.next();
                System.out.print("Masukkan Jumlah: ");
                int qty = scanner.nextInt();

                if (storeLogic.validateStock(id, qty)) {
                    double totalHarga = storeLogic.calculateTotal(id, qty);
                    System.out.printf("Total yang harus dibayar (Diskon 10%% jika > 2 pcs): Rp%,.0f\n", totalHarga);
                    
                    System.out.print("Konfirmasi pembayaran? (y/n): ");
                    String confirm = scanner.next();
                    
                    if (confirm.equalsIgnoreCase("y")) {
                        storeLogic.processPurchase(id, qty);
                        System.out.println("Pembelian sukses! Stok telah diperbarui.");
                    } else {
                        System.out.println("Pembelian dibatalkan.");
                    }
                } else {
                    System.out.println("Error: Stok tidak mencukupi atau ID Buku salah!");
                }
            } else if (choice == 2) {
                running = false;
                System.out.println("Terima kasih telah menggunakan sistem toko buku.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}