package tieuluancuoiki;

import java.util.Date;

public class HangHoa {
    public String loai;
    public int maHang;
    public String tenHangHoa;
    public Double giaNhap;
    public int soLuong;
    public Date ngayNhapKho;
    public int soHangHoa;

    public HangHoa(){};

    public HangHoa(String l, int mHH, String tHH, Double gN, int sL, Date nNK){
        loai = l;
        maHang = mHH;
        tenHangHoa = tHH;
        giaNhap = gN;
        soLuong = sL;
        ngayNhapKho = nNK;
    }

    public HangHoa(int sHH){
        soHangHoa = sHH;
    }

    void inThongTinHangHoa(){
        System.out.println("=====================================");
        System.out.println("Loai: " + loai);
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang hoa: " + tenHangHoa);
        System.out.println("Gia nhap: " + giaNhap);
        System.out.println("So luong: " + soLuong);
        System.out.println("Ngay nhap kho: " + ngayNhapKho);
        System.out.println("=====================================");
    }
}
