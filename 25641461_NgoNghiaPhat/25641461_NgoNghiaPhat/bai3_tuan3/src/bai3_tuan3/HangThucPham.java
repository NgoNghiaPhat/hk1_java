package bai3_tuan3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class HangThucPham {

	    private int id;
	    private final String maHang;      // final → không thể sửa
	    private String tenHang;
	    private LocalDate ngaySanXuat;
	    private LocalDate ngayHetHan;
	    private float gia;

	    private static int demSoLuong = 0;

	    // ---------- Constructor mặc định ----------
	    public HangThucPham() {
	        this.id = ++demSoLuong;
	        this.maHang = "MAC_DINH";
	        this.tenHang = "Hàng mặc định";
	        this.ngaySanXuat = LocalDate.now();
	        this.ngayHetHan = LocalDate.now().plusDays(7);
	        this.gia = 1.0f;
	    }

	    // ---------- Phương thức kiểm tra ngày ----------
	    private boolean kiemTraNgaySanXuat(LocalDate ngaySX) {
	        return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
	    }

	    private boolean kiemTraNgayHetHan(LocalDate ngaySX, LocalDate ngayHH) {
	        return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
	    }

	    // ---------- Constructor có tham số ----------
	    public HangThucPham(String maHang, String tenHang,
	                        LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) {
	        this.id = ++demSoLuong;

	        if (maHang == null || maHang.trim().isEmpty())
	            throw new IllegalArgumentException("Mã hàng không được để trống!");
	        if (tenHang == null || tenHang.trim().isEmpty())
	            throw new IllegalArgumentException("Tên hàng không được để trống!");
	        if (gia <= 0)
	            throw new IllegalArgumentException("Giá phải lớn hơn 0!");
	        if (!kiemTraNgaySanXuat(ngaySanXuat))
	            throw new IllegalArgumentException("Ngày sản xuất không được là ngày trong tương lai!");
	        if (!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan))
	            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất!");

	        this.maHang = maHang;
	        this.tenHang = tenHang;
	        this.ngaySanXuat = ngaySanXuat;
	        this.ngayHetHan = ngayHetHan;
	        this.gia = gia;
	    }

	    // ---------- Getter ----------
	    public int getId() { return id; }
	    public String getMaHang() { return maHang; }
	    public String getTenHang() { return tenHang; }
	    public LocalDate getNgaySanXuat() { return ngaySanXuat; }
	    public LocalDate getNgayHetHan() { return ngayHetHan; }
	    public float getGia() { return gia; }

	    // ---------- Setter (không có setMaHang) ----------
	    public void setTenHang(String tenHang) {
	        if (tenHang == null || tenHang.trim().isEmpty())
	            throw new IllegalArgumentException("Tên hàng không được để trống!");
	        this.tenHang = tenHang;
	    }

	    public void setNgaySanXuat(LocalDate ngaySanXuat) {
	        if (!kiemTraNgaySanXuat(ngaySanXuat))
	            throw new IllegalArgumentException("Ngày sản xuất không được là tương lai!");
	        if (this.ngayHetHan != null && !kiemTraNgayHetHan(ngaySanXuat, this.ngayHetHan))
	            throw new IllegalArgumentException("Ngày sản xuất phải trước ngày hết hạn!");
	        this.ngaySanXuat = ngaySanXuat;
	    }

	    public void setNgayHetHan(LocalDate ngayHetHan) {
	        if (this.ngaySanXuat == null)
	            throw new IllegalArgumentException("Chưa có ngày sản xuất để so sánh!");
	        if (!kiemTraNgayHetHan(this.ngaySanXuat, ngayHetHan))
	            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất!");
	        this.ngayHetHan = ngayHetHan;
	    }

	    public void setGia(float gia) {
	        if (gia <= 0)
	            throw new IllegalArgumentException("Giá phải lớn hơn 0!");
	        this.gia = gia;
	    }

	    // ---------- Kiểm tra hết hạn ----------
	    public boolean kiemTraHetHan() {
	        return LocalDate.now().isAfter(this.ngayHetHan);
	    }

	    public String trangThaiChiTiet() {
	        LocalDate homNay = LocalDate.now();
	        if (homNay.isBefore(ngaySanXuat))
	            return "Chưa sản xuất";
	        if (homNay.isAfter(ngayHetHan))
	            return "Hết hạn";
	        if (homNay.isEqual(ngayHetHan))
	            return "Hết hạn hôm nay";
	        long con = ngayHetHan.toEpochDay() - homNay.toEpochDay();
	        return "Còn " + con + " ngày";
	    }

	    @Override
	    public String toString() {
	        return "HangThucPham{" +
	                "id=" + id +
	                ", maHang='" + maHang + '\'' +
	                ", tenHang='" + tenHang + '\'' +
	                ", ngaySX=" + ngaySanXuat +
	                ", ngayHH=" + ngayHetHan +
	                ", gia=" + gia +
	                '}';
	    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ArrayList<HangThucPham> danhSach = new ArrayList<>();

        HangThucPham htp1 = new HangThucPham();
        HangThucPham htp2 = new HangThucPham("HP123456", "May tinh", LocalDate.of(2015, 12, 12), LocalDate.of(2015, 12, 20), 120000000);
        
        danhSach.add(htp1);
        danhSach.add(htp2);

        System.out.print("Nhập số lượng hàng thực phẩm muốn bổ sung thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin mặt hàng bổ sung thứ " + (i + 1) + " ---");
            try {
                System.out.print("Nhập mã hàng: ");
                String maHang = sc.nextLine();
                
                System.out.print("Nhập tên hàng: ");
                String tenHang = sc.nextLine();
                
                System.out.println("Nhập ngày sản xuất:");
                System.out.print(" - Năm: "); int namSX = Integer.parseInt(sc.nextLine());
                System.out.print(" - Tháng: "); int thangSX = Integer.parseInt(sc.nextLine());
                System.out.print(" - Ngày: "); int ngaySX = Integer.parseInt(sc.nextLine());
                LocalDate ngaySanXuat = LocalDate.of(namSX, thangSX, ngaySX);

                System.out.println("Nhập ngày hết hạn:");
                System.out.print(" - Năm: "); int namHH = Integer.parseInt(sc.nextLine());
                System.out.print(" - Tháng: "); int thangHH = Integer.parseInt(sc.nextLine());
                System.out.print(" - Ngày: "); int ngayHH = Integer.parseInt(sc.nextLine());
                LocalDate ngayHetHan = LocalDate.of(namHH, thangHH, ngayHH);

                System.out.print("Nhập giá: ");
                float gia = Float.parseFloat(sc.nextLine());

                HangThucPham itemMoi = new HangThucPham(maHang, tenHang, ngaySanXuat, ngayHetHan, gia);
                danhSach.add(itemMoi);
                System.out.println("-> Thêm thành công!");
                
            } catch (Exception e) {
                System.out.println("-> Lỗi: " + e.getMessage());
                System.out.println("-> Vui lòng nhập lại thông tin cho mặt hàng này!");
                i--; 
            }
        }

        System.out.println("\n=== DANH SÁCH TẤT CẢ HÀNG THỰC PHẨM ===");
        for (HangThucPham htp : danhSach) {
            System.out.println(htp.toString());
        }
        
        sc.close();
	}
}
