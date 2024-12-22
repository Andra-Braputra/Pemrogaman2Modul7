package application;

public class Penjualan {
    private int jumlah;
    private double totalHarga;
    private String tanggal;

    public Penjualan(int jumlah, double totalHarga, String tanggal) {
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;

    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

}

