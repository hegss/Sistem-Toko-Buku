# Sistem Manajemen Toko Buku Digital

Proyek ini merupakan tugas kelompok mata kuliah Pemrograman Berorientasi Objek berbasis modular untuk pembuatan sistem manajemen toko buku digital. Sistem dibangun dengan memisahkan fungsi ke dalam tiga modul independen:

- `app.data` : Menyimpan data dan simulasi database buku.
- `app.logic` : Menangani logika bisnis seperti validasi stok, perhitungan harga, dan proses pembelian.
- `app.ui` : Menyediakan antarmuka pengguna berbasis console.

## Fitur

- Menampilkan daftar buku.
- Validasi stok buku.
- Pembelian buku.
- Diskon 10% untuk pembelian lebih dari 2 buku.
- Pembaruan stok setelah transaksi berhasil.

## Cara Menjalankan

### Compile Modul

```bash
javac -d mods/app.data app.data/src/module-info.java app.data/src/id/bookstore/data/*.java

javac --module-path mods -d mods/app.logic app.logic/src/module-info.java app.logic/src/id/bookstore/logic/*.java

javac --module-path mods -d mods/app.ui app.ui/src/module-info.java app.ui/src/id/bookstore/ui/MainApp.java
```

### Jalankan Program

```bash
java --module-path mods -m app.ui/id.bookstore.ui.MainApp
```

## Struktur Proyek

```text
app.data
app.logic
app.ui
mods
pom.xml
```

## Teknologi

- Java 17

## Author

- Muhammad Haikal Al Jaba (202333500781)
- Gias Hegy Tamara (202333500804)
- Sharma Rizky Adhitama (202333500809)
