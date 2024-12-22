package application;

public class Pelanggan {
    private String nama;
    private String email;
    private String telepon;

    public Pelanggan (String nama, String email, String telepon) {
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
 