package tuan1.HinhTron;

public class HinhTron {
    private double banKinh;
    private ToaDo tam;
    private final double PI = 3.1415926;

    // Constructor mặc định
    public HinhTron() {
    }

    // Constructor có tham số
    public HinhTron(ToaDo tam, double banKinh) throws Exception {
        setTam(tam);
        setBanKinh(banKinh);
    }

    // Getter & Setter
    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) throws Exception {
        if (banKinh > 0) {
            this.banKinh = banKinh;
        } else {
            throw new Exception("Bán kính phải > 0");
        }
    }

    public ToaDo getTam() {
        return tam;
    }

    public void setTam(ToaDo tam) {
        this.tam = tam;
    }

    // Tính diện tích
    public double getDienTich() {
        return PI * banKinh * banKinh;
    }

    // Tính chu vi
    public double getChuVi() {
        return 2 * PI * banKinh;
    }

    // Override toString để hiển thị thông tin
    @Override
    public String toString() {
        return "Hình tròn [Tâm=" + tam +
               ", Bán kính=" + banKinh +
               ", Diện tích=" + getDienTich() +
               ", Chu vi=" + getChuVi() + "]";
    }

    // Hàm main để test
    public static void main(String[] args) {
        try {
            HinhTron h1 = new HinhTron(new ToaDo("O", 3, 4), 12);
            System.out.println("Thông tin hình tròn:");
            System.out.println(h1);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
