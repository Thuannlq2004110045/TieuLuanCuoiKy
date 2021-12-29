package tieuluancuoiki;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HamHangHoa {
    Node head = null;// DANH SÁCH RỖNG
    Node tail = null;
    int sLHH;

    HamHangHoa(int slhh) {
        sLHH = slhh;
    }

    public HamHangHoa(){}

    /**đổi chuỗi (theo chuẩn ngày Việt Nam) sang ngày java */
    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        //ngày việt nam
        Date date;
        /**
         * dd: ngày
         * mm: tháng
         * yyyy: năm
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

    //Đổi ngày Java sang kiểu ngày việt dd/mm/yyy
    public static String chuyenNgaySangChuoi(Date date){
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        chuoiNgayViet =  simpleDateFormat.format(date);
        return chuoiNgayViet;

    }

    void khoHangHoa()throws ParseException{
        
        addTail(new HangHoa("sanh su", 1, "cai chen", 1500000.0 , 30, chuyenChuoiSangNgay("1/1/2021")));
        addTail(new HangHoa("dien may", 2, "noi com dien", 800000.0 , 40, chuyenChuoiSangNgay("5/6/2021")));
        addTail(new HangHoa("thuc pham", 3, "banh mi", 100000.0 , 30, chuyenChuoiSangNgay("3/1/2021")));
        addTail(new HangHoa("sanh su", 4, "cai to", 200000.0 , 30, chuyenChuoiSangNgay("4/12/2020")));
        addTail(new HangHoa("dien may", 5, "ban phim", 8000000.0 , 40, chuyenChuoiSangNgay("4/11/2021")));
        addTail(new HangHoa("thuc pham", 6, "ca rot", 150000.0 , 30, chuyenChuoiSangNgay("6/10/2021")));
        addTail(new HangHoa("sanh su", 7, "coc nuoc", 300000.0 , 30, chuyenChuoiSangNgay("7/4/2021")));
        addTail(new HangHoa("dien may", 8, "chuot may tinh", 100000000.0 , 40, chuyenChuoiSangNgay("8/6/2021")));
        addTail(new HangHoa("thuc pham", 9, "dua hau", 500000.0 , 30, chuyenChuoiSangNgay("30/1/2021")));
        addTail(new HangHoa("sanh su", 10, "lo hoa", 1000000.0 , 30, chuyenChuoiSangNgay("27/3/2021")));
        addTail(new HangHoa("dien may", 11, "tai nghe", 500000.0 , 40, chuyenChuoiSangNgay("16/10/2021")));
        addTail(new HangHoa("thuc pham", 12, "ca chua", 80000.0 , 30, chuyenChuoiSangNgay("18/11/2021")));
        addTail(new HangHoa("sanh su", 13, "cai dia", 1500000.0 , 30, chuyenChuoiSangNgay("20/11/2021")));
        addTail(new HangHoa("dien may", 14, "loa", 7000000.0 , 40, chuyenChuoiSangNgay("8/3/2021")));
        addTail(new HangHoa("thuc pham", 15, "mi tom", 35000.0 , 30, chuyenChuoiSangNgay("30/10/2021")));
        addTail(new HangHoa("sanh su", 16, "am tra", 1500000.0 , 30, chuyenChuoiSangNgay("10/3/2021")));
        addTail(new HangHoa("dien may", 17, "ti vi", 9000000.0 , 40, chuyenChuoiSangNgay("19/11/2021")));
        addTail(new HangHoa("thuc pham", 18, "ca", 600000.0 , 30, chuyenChuoiSangNgay("22/11/2021")));
        addTail(new HangHoa("dien may", 19, "may lanh", 10000000.0 , 30, chuyenChuoiSangNgay("14/2/2021")));
        addTail(new HangHoa("thuc pham", 20, "thit heo", 350000.0 , 40, chuyenChuoiSangNgay("13/9/2021")));
    }

    void adddauDS(HangHoa data){
        Node newNode = new Node(data);
        if (head == null) {// thêm 1 nút vào danh sách
            head = newNode;
            tail = newNode;
        } else {// danh sách không rỗng // thêm vào đầu danh sách
            newNode.next = head;
            head = newNode;
        }

    }

    void addTail(HangHoa data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void addgiuaDS(int ma, HangHoa data) {
        Node newNode = new Node(data); 
        Node current = head;
        Node after = current.next;
        while (after != null){
            if(current.data.maHang == ma){
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
            after = current.next;
        }
    }

    void removecuoiDS(){
        Node previous = head;
        Node current = previous.next;
        if(previous.next == null){
            removedauDS();
            return;
        }

        while(current != null){
            if(current.next == null){
                previous.next = null;
                return;
            }
            previous = previous.next;
            current = previous.next;
        }
    }

    void removedauDS(){
        head = head.next;
        head.next = head.next;
    }

    void removegiuaDS(int delete){
        Node previous = head;
        Node current = previous.next;
        Node after = current.next;
        if(head.data.maHang == delete){
            removedauDS();
            return;
        }
        if(tail.data.maHang == delete){
            removecuoiDS();
            return;
        }
        while(after != null){
            if(current.data.maHang == delete){
                previous.next = after;
                return;
            }
            previous = previous.next;
            current = previous.next;
            after = current.next;
        }
    }

    void sua(int suaten) throws ParseException{
        Scanner scanner = new Scanner(System.in);
        Node current = head;
        if (current == null) {
            System.out.println("Danh sach rong");
        } else 
            while (current != null) {
                if (current.data.maHang == suaten) {
                    System.out.print("Loai: ");
                    String loai = scanner.nextLine();
                    current.data.loai = loai;
                    System.out.print("Ten hang hoa: ");
                    String tenHangHoa = scanner.nextLine();
                    current.data.tenHangHoa = tenHangHoa;
                    System.out.print("Gia nhap: ");
                    Double giaNhap = scanner.nextDouble();
                    scanner.nextLine();
                    current.data.giaNhap = giaNhap;
                    System.out.print("So luong: ");
                    int soLuong = scanner.nextInt();
                    scanner.nextLine();
                    current.data.soLuong = soLuong;
                    Date ngayNhapKho;
                    System.out.println("Ngay nhap kho: ");
                    String strngayNhapKho = scanner.nextLine();
                    ngayNhapKho = chuyenChuoiSangNgay(strngayNhapKho);
                    current.data.ngayNhapKho = ngayNhapKho;
                    System.out.println("Da sua thanh cong hang hoa co ma " + suaten);
                    return;
                }
                current = current.next;
            }
        System.out.println("Ma nhap vao  khong ton tai");
    }

    public HangHoa nhapDSHH() throws ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin hang hoa muon them. ");
            System.out.print("Loai: ");
            String loai = scanner.nextLine();
            System.out.print("Ma hang hoa:");
            int maHang  = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ten hang hoa: ");
            String tenHangHoa = scanner.nextLine();
            System.out.print("Gia nhap: ");
            Double giaNhap = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("So luong: ");
            int soLuong = scanner.nextInt();
            scanner.nextLine();
            Date ngayNhapKho;
            System.out.println("Ngay nhap kho: ");
            String strngayNhapKho = scanner.nextLine();
            ngayNhapKho =chuyenChuoiSangNgay(strngayNhapKho);
            HangHoa hanghoa1 = new HangHoa(loai, maHang, tenHangHoa, giaNhap, soLuong, ngayNhapKho);
            return hanghoa1;
    }

    void print(){
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong!!!");
            return;
        }
        System.out.println("Danh sach hang hoa:");
        while(current != null){
            current.data.inThongTinHangHoa();
            current = current.next;
        }
    }

    void findTheoLoai(String loai){
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong");
        }
        while(current != null){
            if(current.data.loai.equalsIgnoreCase(loai)){
                current.data.inThongTinHangHoa();
            }
            current = current.next;
        }
    }

    void findTheoGia(Double giadau, Double giaSau){
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong");
        }
        while(current != null){
            if(giadau <= current.data.giaNhap && current.data.giaNhap <= giaSau){
                current.data.inThongTinHangHoa();
            }
            current = current.next;
        }
    }

    void findTheoNgay(String ngayTruoc, String ngaySau)throws ParseException{
        Date ngay1;
        ngay1 = chuyenChuoiSangNgay(ngayTruoc);
        Date ngay2;
        ngay2 = chuyenChuoiSangNgay(ngaySau);
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong");
        }
        while(current != null){
            if(ngay1.before(current.data.ngayNhapKho) && ngay2.after(current.data.ngayNhapKho)){
                current.data.inThongTinHangHoa();
            }
            current = current.next;
        }
    }

    void selectionSorttangdantheoGia(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node min = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (min.data.giaNhap > after.data.giaNhap)
                    min = after;
     
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = min.data;
            min.data = x;
            current = current.next;
        }
    }

    void selectionSortgiamdantheoGia(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node max = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (max.data.giaNhap < after.data.giaNhap)
                    max = after;
     
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = max.data;
            max.data = x;
            current = current.next;
        }
    }

    void selectionSorttangdantheoLoai(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node min = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (min.data.loai.compareToIgnoreCase(after.data.loai)>0)
                    min = after;
     
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = min.data;
            min.data = x;
            current = current.next;
        }
    }

    void selectionSortgiamdantheoLoai(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node max = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (max.data.loai.compareToIgnoreCase(after.data.loai)<0)
                    max = after;
     
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = max.data;
            max.data = x;
            current = current.next;
        }
    }

    void selectionSorttangdantheoLoaivaDate(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node min = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (min.data.loai.equalsIgnoreCase(after.data.loai)){
                if(min.data.ngayNhapKho.after(after.data.ngayNhapKho)){
                    min = after;
                }
            }
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = min.data;
            min.data = x;
            current = current.next;
        }
    }

    void selectionSortgiamdantheoLoaivaDate(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node max = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (max.data.loai.equalsIgnoreCase(after.data.loai)){
                if(max.data.ngayNhapKho.before(after.data.ngayNhapKho)){
                    max = after;
                }
            }
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = max.data;
            max.data = x;
            current = current.next;
        }
    }

    void selectionSorttangdantheoLoaivaGia(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node min = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (min.data.loai.equalsIgnoreCase(after.data.loai)){
                if(min.data.giaNhap > after.data.giaNhap){
                    min = after;
                }
            }
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = min.data;
            min.data = x;
            current = current.next;
        }
    }

    void selectionSortgiamdantheoLoaivaGia(){
        Node current = head;
     
        // Duyệt qua danh sách
        while (current != null) {
            Node max = current;
            Node after = current.next;
     
            // Duyệt danh sách chưa được sắp xếp
            while (after != null) {
                if (max.data.loai.equalsIgnoreCase(after.data.loai)){
                if(max.data.giaNhap < after.data.giaNhap){
                    max = after;
                }
            }
                after = after.next;
            }
     
            // Swap Data
            HangHoa x = current.data;
            current.data = max.data;
            max.data = x;
            current = current.next;
        }
    }

    public int tongSoLuongHangHoa(){
        int sLHH = 0;
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong!!!");
            return 0;
        }
        while(current != null){
            sLHH += 1;
            current = current.next;
        }
        return sLHH;
    }

    public Double tongGiaTriNhapKho(){
        Double gTNK = 0.0;
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong!!!");
            return 0.0;
        }
        while(current != null){
            gTNK += current.data.giaNhap;
            current = current.next;
        }
        return gTNK;
    }

    void soLuongTungLoaiHang(){
        int sLTP = 0;
        int sLSS = 0;
        int sLDM = 0;
        Node current = head;
        if(head == null){
            System.out.println("Danh sach rong!!!");
            return;
        }
        while(current != null){
            if(current.data.loai.equals("thuc pham")){
                sLTP += 1;
            }else if(current.data.loai.equals("sanh su")){
                sLSS += 1;
            }else if(current.data.loai.equals("dien may")){
                sLDM += 1;
            }
            current = current.next;
        }
        System.out.println("So luong hang hoa thuc pham: " + sLTP);
        System.out.println("So luong hang hoa sanh su: " + sLSS);
        System.out.println("So luong hang hoa dien may: " + sLDM);
    }
}
