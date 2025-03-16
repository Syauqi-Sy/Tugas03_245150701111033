class PengirimanBarang {
    String namaPengirim;
    String alamatTujuan;
    double berat;
    double biayaDasar;
    int jarakPaket;
    PengirimanBarang() {
        namaPengirim = "";
        alamatTujuan = "";
        berat = 0;
        biayaDasar = 0;
        jarakPaket = 0;
    }
    PengirimanBarang(String sender, String toAdd, double weight, double basePrice) {
        namaPengirim = sender;
        alamatTujuan = toAdd;
        berat = weight;
        biayaDasar = basePrice;
    }
    double hitungOngkir(double diskonPersen) {
        return biayaDasar -= (biayaDasar * diskonPersen / 100);
    }
    double hitungOngkir(double diskonPersen, double biayaTambahan) {
        return biayaDasar = (biayaDasar - (biayaDasar * diskonPersen / 100)) + biayaTambahan;
    }
    void hitungOngkir(int jarak) {
        double surcharge = 0;
        double disc = 0;
        jarakPaket = jarak;
        System.out.println("Jarak pengiriman               : " + jarakPaket + " km");
        if (jarak > 50) {
            surcharge = biayaDasar * 10/100;
            biayaDasar += surcharge;
            System.out.println("Biaya tambahan (jarak > 50 km) : Rp" + surcharge);
        } else if (jarak <= 0) {
            System.out.println("Error: Jarak tidak boleh sama dengan atau lebih dari 0.");
        } else {
            disc = biayaDasar * 5/100;
            biayaDasar -= disc;
            System.out.println("Diskon (jarak <= 50 km)        : Rp" + disc);
        }
        System.out.println("Biaya pengiriman akhir         : Rp" + biayaDasar);
    }

    void displayInfoLogistik() {
        System.out.println("---Status paket xX_BoltExpress_Xx---");
        System.out.println("Nama pengirim                  : " + namaPengirim);
        System.out.println("Alamat tujuan                  : " + alamatTujuan);
        System.out.println("Berat paket                    : " + berat + " kg");
        System.out.println("Biaya ongkir dasar             : Rp" + biayaDasar);
    }
}

public class ekspedisi {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama pengirim           : ");
        String pengirim = input.next();
        System.out.print("Masukkan alamat tujuan           : ");
        String alamat = input.next();
        System.out.print("Masukkan berat paket             : ");
        double berat = input.nextDouble();
        System.out.print("Masukkan biaya pengiriman        : ");
        double biaya = input.nextDouble();
        System.out.print("Masukkan diskon yang valid       : ");
        double dsc = input.nextDouble();
        System.out.print("Masukkan biaya tambah (opsional) : ");
        double plus = input.nextDouble();
        System.out.print("Masukkan jarak pengiriman        : ");
        int jarak = input.nextInt();
        System.out.println("");
        input.close();
        PengirimanBarang paket1 = new PengirimanBarang(pengirim, alamat, berat, biaya);
        paket1.displayInfoLogistik();
        if (plus != 0) {
            paket1.hitungOngkir(dsc, plus);
        } else {
            paket1.hitungOngkir(dsc);
        }
        paket1.hitungOngkir(jarak);
    }
}
