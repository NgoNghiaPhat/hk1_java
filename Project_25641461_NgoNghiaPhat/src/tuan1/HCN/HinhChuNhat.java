package tuan1.HCN;

import java.util.Scanner;

public class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    // Constructor mặc định
    public HinhChuNhat() {
    }

    // Constructor có tham số
    public HinhChuNhat(double cD, double cR) throws Exception {
        setChieuDai(cD);
        setChieuRong(cR);
    }

    // Getter & Setter
    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double cD) throws Exception {
        if (cD > 0) {
            this.chieuDai = cD;
        } else {
            throw new Exception("Chiều dài phải > 0");
        }
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double cR) throws Exception {
        if (cR > 0) {
            this.chieuRong = cR;
        } else {
            throw new Exception("Chiều rộng phải > 0");
        }
    }

    // Tính diện tích
    public double getDt() {
        return chieuDai * chieuRong;
    }

    // Tính chu vi
    public double getCv() {
        return (chieuDai + chieuRong) * 2;
    }

    // Override toString để in thông tin
    @Override
    public String toString() {
        return "Hình chữ nhật [Chiều dài=" + chieuDai +
               ", Chiều rộng=" + chieuRong +
               ", Diện tích=" + getDt() +
               ", Chu vi=" + getCv() + "]";
    }

    // Hàm main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập chiều dài: ");
            double cd = sc.nextDouble();
            System.out.print("Nhập chiều rộng: ");
            double cr = sc.nextDouble();

            HinhChuNhat hcn = new HinhChuNhat(cd, cr);
            System.out.println(hcn);

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
