# Scope Variabel dalam HTTP #

Scope Variabel :

* umur / lifetime variabel
* visibility : di mana variabel bisa digunakan

Scope variabel dalam kode program:

* local : berlaku di dalam blok
* instance : berlaku di dalam objek
* static : berlaku di seluruh aplikasi

Scope variabel dalam HTTP :

* request
* session : akan terus ada selama session hidup

	* sisi client :

	    * belum menutup browser

	* sisi server :

	    * session belum timeout / expire. Default 30 menit
	    * session belum dihapus

* aplikasi : akan terus ada selama aplikasi hidup. Istilah di Java : context variable

## Use Case Scope Variable ##

* Request

    * Input Form
    * Link

* Session

    * Login
    * Halaman yang terakhir diakses
    * Popup Window

* Aplikasi : info global

    * Nama aplikasi
    * Versi aplikasi
    * Jumlah visitor
