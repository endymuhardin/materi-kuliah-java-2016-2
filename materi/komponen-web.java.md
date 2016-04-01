# Komponen dalam Aplikasi Web Java #

Aplikasi Web Java memiliki 3 komponen:

* Servlet
* Filter
* Listener

Penjelasan lengkap bisa dibaca [di sini](http://software.endy.muhardin.com/java/dasar-dasar-aplikasi-web-java/)

## Use Case ##

* Filter

    * mengecek sudah login atau belum
    * menambahkan header/footer/menu aplikasi
    * mencatat informasi request (mis: user agent)
    * kompresi response
    * mengubah response sesuai user agent

* Listener

    * connect/disconnect ke database
    * connect/disconnect ke komputer lain via socket
    * set variabel global
    * inisialisasi aplikasi (misal: setup skema database, insert data awal, dsb)