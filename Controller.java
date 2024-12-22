package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

    @FXML
    private TableView<Pelanggan> pelangganTable;
    @FXML
    private TableColumn<Pelanggan, String> pelangganNamaColumn;
    @FXML
    private TableColumn<Pelanggan, String> pelangganEmailColumn;
    @FXML
    private TableColumn<Pelanggan, String> pelangganTeleponColumn;
    @FXML
    private TextField pelangganNamaField;
    @FXML
    private TextField pelangganEmailField;
    @FXML
    private TextField pelangganTeleponField;

    @FXML
    private TableView<Buku> bukuTable;
    @FXML
    private TableColumn<Buku, String> bukuJudulColumn;
    @FXML
    private TableColumn<Buku, String> bukuPenulisColumn;
    @FXML
    private TableColumn<Buku, Double> bukuHargaColumn;
    @FXML
    private TableColumn<Buku, Integer> bukuStokColumn;
    @FXML
    private TextField bukuJudulField;
    @FXML
    private TextField bukuPenulisField;
    @FXML
    private TextField bukuHargaField;
    @FXML
    private TextField bukuStokField;

    @FXML
    private TableView<Penjualan> penjualanTable;
    @FXML
    private TableColumn<Penjualan, Integer> penjualanJumlahColumn;
    @FXML
    private TableColumn<Penjualan, Double> penjualanTotalHargaColumn;
    @FXML
    private TableColumn<Penjualan, String> penjualanTanggalColumn;
    @FXML
    private TextField penjualanJumlahField;
    @FXML
    private TextField penjualanTotalHargaField;
    @FXML
    private TextField penjualanTanggalField;

    private ObservableList<Pelanggan> pelangganData;
    private ObservableList<Buku> bukuData;
    private ObservableList<Penjualan> penjualanData;

    @FXML
    public void initialize() {
        pelangganData = FXCollections.observableArrayList();
        bukuData = FXCollections.observableArrayList();
        penjualanData = FXCollections.observableArrayList();

        pelangganNamaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        pelangganEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        pelangganTeleponColumn.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        pelangganTable.setItems(pelangganData);

        bukuJudulColumn.setCellValueFactory(new PropertyValueFactory<>("judul"));
        bukuPenulisColumn.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        bukuHargaColumn.setCellValueFactory(new PropertyValueFactory<>("harga"));
        bukuStokColumn.setCellValueFactory(new PropertyValueFactory<>("stok"));
        bukuTable.setItems(bukuData);

        penjualanJumlahColumn.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        penjualanTotalHargaColumn.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        penjualanTanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        penjualanTable.setItems(penjualanData);
    }

    @FXML
    private void addPelanggan() {
        Pelanggan pelanggan = new Pelanggan(
            pelangganNamaField.getText(),
            pelangganEmailField.getText(),
            pelangganTeleponField.getText()
        );
        pelangganData.add(pelanggan);
        clearPelangganFields();
    }

    @FXML
    private void deletePelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            pelangganData.remove(selected);
        }
    }

    // actions
    @FXML
    private void addBuku() {
        Buku buku = new Buku(
            bukuJudulField.getText(),
            bukuPenulisField.getText(),
            Double.parseDouble(bukuHargaField.getText()),
            Integer.parseInt(bukuStokField.getText())
        );
        bukuData.add(buku);
        clearBukuFields();
    }

    @FXML
    private void deleteBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            bukuData.remove(selected);
        }
    }

    // actions
    @FXML
    private void addPenjualan() {
        Penjualan penjualan = new Penjualan(
            Integer.parseInt(penjualanJumlahField.getText()),
            Double.parseDouble(penjualanTotalHargaField.getText()),
            penjualanTanggalField.getText()
        );
        penjualanData.add(penjualan);
        clearPenjualanFields();
    }

    @FXML
    private void deletePenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            penjualanData.remove(selected);
        }
    }
    @FXML
    private void editPelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setNama(pelangganNamaField.getText());
            selected.setEmail(pelangganEmailField.getText());
            selected.setTelepon(pelangganTeleponField.getText());

            pelangganTable.refresh();
            clearPelangganFields();
        }
    }

    @FXML
    private void editBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setJudul(bukuJudulField.getText());
            selected.setPenulis(bukuPenulisField.getText());
            selected.setHarga(Double.parseDouble(bukuHargaField.getText()));
            selected.setStok(Integer.parseInt(bukuStokField.getText()));

            bukuTable.refresh();
            clearBukuFields();
        }
    }

    @FXML
    private void editPenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setJumlah(Integer.parseInt(penjualanJumlahField.getText()));
            selected.setTotalHarga(Double.parseDouble(penjualanTotalHargaField.getText()));
            selected.setTanggal(penjualanTanggalField.getText());

            penjualanTable.refresh();
            clearPenjualanFields();
        }
    }

    private void clearPelangganFields() {
        pelangganNamaField.clear();
        pelangganEmailField.clear();
        pelangganTeleponField.clear();
    }

    private void clearBukuFields() {
        bukuJudulField.clear();
        bukuPenulisField.clear();
        bukuHargaField.clear();
        bukuStokField.clear();
    }

    private void clearPenjualanFields() {
        penjualanJumlahField.clear();
        penjualanTotalHargaField.clear();
        penjualanTanggalField.clear();
    }
}