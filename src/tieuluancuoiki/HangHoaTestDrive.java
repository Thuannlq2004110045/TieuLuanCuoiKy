package tieuluancuoiki;

import java.text.ParseException;
import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Danh sach hang hoa trong kho ");
        HamHangHoa listHangHoa = new HamHangHoa(); 
        listHangHoa.khoHangHoa();
        listHangHoa.print();
        int luaChon;
        do {
            System.out.println("===========================MENU============================");
            System.out.println("  1.Them mot hang hoa vao danh sach.                      =");
            System.out.println("  2.Xoa mot hang hoa trong danh sach.                     =");
            System.out.println("  3.Sua thong tin mot hang hoa trong danh sach.           =");
            System.out.println("  4.Tim kiem hang hoa.                                    =");
            System.out.println("  5.Sap xep tang dan.                                     =");
            System.out.println("  6.Sap xep giam dan.                                     =");
            System.out.println("  7.Thong ke.                                             =");
            System.out.println("  8.In danh sach hang hoa.                                =");
            System.out.println("  9.Thoat chuong trinh.                                   =");
            System.out.println("===========================================================");
            System.out.print("Lua chon(bang so): ");
            luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                int luaChon1;
                do{
                    System.out.println("  ===================================================");
                    System.out.println(" =  1. Them mot hang hoa vao dau danh sach.          =");
                    System.out.println(" =  2. Them mot hang hoa vao cuoi danh sach.         =");
                    System.out.println(" =  3. Them mot hang hoa vao sau hang hoa đa chon.   =");
                    System.out.println(" =  4. Thoat ra menu chinh.                          =");
                    System.out.println("  ===================================================");
                    System.out.print("Lua chon: ");
                    luaChon1 = scanner.nextInt();
                    switch(luaChon1){
                        case 1:
                        HangHoa themDau = listHangHoa.nhapDSHH();
                        listHangHoa.adddauDS(themDau);
                        break;
                        case 2: 
                        HangHoa themCuoi = listHangHoa.nhapDSHH();
                        listHangHoa.addTail(themCuoi);
                        break;
                        case 3:
                        System.out.print("Nhap ma muon them vao phia sau no ");
                        int ma = scanner.nextInt();
                        scanner.nextLine();
                        HangHoa themgiua = listHangHoa.nhapDSHH();
                        listHangHoa.addgiuaDS(ma, themgiua);
                        break;
                        case 4:
                        luaChon1 = 4;
                    }
                }while(luaChon1 <=3);
                break;
                case 2:
                    System.out.print("Nhap ma can xoa ");
                    int delete = scanner.nextInt();
                    scanner.nextLine();
                    listHangHoa.removegiuaDS(delete);
                    System.out.println("Da xoa hang hoa co ma " + delete);
                    break;
                case 3:
                    System.out.print("Nhap ma muon sua ");
                    int suaten = scanner.nextInt();
                    scanner.nextLine();
                    listHangHoa.sua(suaten);
                    break;
                case 4:
                    int luaChon2;
                    do{ 
                        System.out.println("  ==============================================");
                        System.out.println(" =  1.Tim kiem hang hoa theo loai               =");
                        System.out.println(" =  2.Tim kiem hang hoa theo khoang gia nhap    =");
                        System.out.println(" =  3.Tim kiem hang hoa theo khoang thoi gian   =");
                        System.out.println(" =  4.Thoat ra menu chinh.                      =");
                        System.out.println("  ==============================================");
                        System.out.print("Lua chon: ");
                        luaChon2 = scanner.nextInt();
                        scanner.nextLine();
                        switch(luaChon2){
                            case 1:
                                System.out.print("Nhap loai can tim: ");
                                String loai = scanner.nextLine();
                                listHangHoa.findTheoLoai(loai);
                                break;
                            case 2: 
                                System.out.print("Tim theo khoang gia tu ");
                                Double giadau = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("den ");
                                Double giaSau = scanner.nextDouble();
                                scanner.nextLine();
                                listHangHoa.findTheoGia(giadau, giaSau);
                                break;
                            case 3:
                                System.out.print("Tim theo khoang thoi gian tu ngay(--ngay/thang/nam--): ");
                                String ngayTruoc = scanner.nextLine();
                                System.out.print("den ngay(--ngay/thang/nam--): ");
                                String ngaySau = scanner.nextLine();
                                listHangHoa.findTheoNgay(ngayTruoc, ngaySau);
                                break;
                            case 4:
                                luaChon2 = 4;
                        }
                    }while(luaChon2 <=3);
                    break;
                case 5:
                    int luaChon3;
                    do{
                        System.out.println("  ==================================================");
                        System.out.println(" =  1.Sap xep tang dan theo gia nhap                 =");
                        System.out.println(" =  2.Sap xep tang dan theo loai va ngay nhap        =");
                        System.out.println(" =  3.Sap xep tang dan theo loai va theo gia         =");
                        System.out.println(" =  4.Thoat ra menu chinh.                           =");
                        System.out.println("  ==================================================");
                        System.out.print("Lua chon: ");
                        luaChon3 = scanner.nextInt();
                        scanner.nextLine();
                        switch(luaChon3){
                            case 1:
                                listHangHoa.selectionSorttangdantheoGia();
                                listHangHoa.print();
                                break;
                            case 2: 
                                listHangHoa.selectionSorttangdantheoLoai();
                                listHangHoa.selectionSorttangdantheoLoaivaDate();;
                                listHangHoa.print();
                                break;
                            case 3:
                                listHangHoa.selectionSorttangdantheoLoai();
                                listHangHoa.selectionSorttangdantheoLoaivaGia();
                                listHangHoa.print();
                                break;
                            case 4:
                                luaChon3 = 4;
                        }
                    }while(luaChon3 <=3);
                    break;
                case 6:
                    int luaChon4;
                    do{
                        System.out.println("  ==================================================");
                        System.out.println(" =  1.Sap xep giam dan theo gia nhap                 =");
                        System.out.println(" =  2.Sap xep giam dan theo loai va ngay nhap        =");
                        System.out.println(" =  3.Sap xep giam dan theo loai va theo gia         =");
                        System.out.println(" =  4.Thoat ra menu chinh.                           =");
                        System.out.println("  ==================================================");
                        System.out.print("Lua chon: ");
                        luaChon4 = scanner.nextInt();
                        scanner.nextLine();
                        switch(luaChon4){
                            case 1:
                                listHangHoa.selectionSortgiamdantheoGia();
                                listHangHoa.print();
                                break;
                            case 2: 
                                listHangHoa.selectionSortgiamdantheoLoai();
                                listHangHoa.selectionSortgiamdantheoLoaivaDate();
                                listHangHoa.print();
                                break;
                            case 3:
                                listHangHoa.selectionSortgiamdantheoLoai();
                                listHangHoa.selectionSortgiamdantheoLoaivaGia();
                                listHangHoa.print();
                                break;
                            case 4:
                                luaChon4 = 4;
                        }
                    }while(luaChon4 <=3);
                    break;
                case 7:
                    int luaChon5;
                    do{
                        System.out.println("  ========================================");
                        System.out.println(" =       1.Tong so luong hang hoa         = ");
                        System.out.println(" =       2.Tong gia tri nhap kho          = ");
                        System.out.println(" =       3.So luong tung loai hang        = ");
                        System.out.println(" =       4.Thoat ra menu chinh.           = ");
                        System.out.println("  ========================================");
                        System.out.print("Lua chon: ");
                        luaChon5 = scanner.nextInt();
                        scanner.nextLine();
                        switch(luaChon5){
                            case 1:
                                int sLHH = listHangHoa.tongSoLuongHangHoa();
                                System.out.println("Tong so luong hang hoa la: " + sLHH);
                                break;
                            case 2: 
                                Double gTNK = listHangHoa.tongGiaTriNhapKho();
                                System.out.println("Tong gia tri nhap kho la: " + gTNK);
                                break;
                            case 3:
                                System.out.println("So luong tung loai hang: ");
                                listHangHoa.soLuongTungLoaiHang();
                                break;
                            case 4:
                                luaChon4 = 4;
                        }
                    }while(luaChon5 <=3);
                    break;
                case 8:
                    listHangHoa.print();
                    break;
                case 9: 
                    System.exit(0);
            }

        } while (luaChon != 10);
    }
}
