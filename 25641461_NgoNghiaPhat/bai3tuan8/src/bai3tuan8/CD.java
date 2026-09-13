package bai3tuan8;

public class CD {
    private String maCD;
    private String tuaCD;
    private String caSy;
    private int soBaiHat;
    private float gia;

    // Getter / Setter
    public String getMaCD() { return maCD; }
    public void setMaCD(String maCD) { this.maCD = maCD; }
    public String getTuaCD() { return tuaCD; }
    public void setTuaCD(String tuaCD) { this.tuaCD = tuaCD; }
    public String getCaSy() { return caSy; }
    public void setCaSy(String caSy) { this.caSy = caSy; }
    public int getSoBaiHat() { return soBaiHat; }
    public void setSoBaiHat(int soBai) throws Exception {
        if (soBai > 0) this.soBaiHat = soBai;
        else throw new Exception("So Bai Hat Phai > 0");
    }
    public float getGia() { return gia; }
    public void setGia(float gia) { this.gia = gia; }

    // Constructor duy nhất
    public CD(String maCD, String tuaCD, String caSy, int soBai, float gia) throws Exception {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        if (soBai > 0) this.soBaiHat = soBai;
        else throw new Exception("So Bai Hat Phai > 0");
        this.gia = gia;
    }

    public CD() { }

    public static void tieuDe() {
        System.out.println("In danh sach CD");
        for (int i = 0; i < 100; i++) System.out.print("-");
        System.out.println();
        String s = String.format("|%10s|%10s|%10s|%10s|%10s|%10s|",
                "Ma CDRom", "Tua CDRom", "Ten CaSy", "So Bai Hat", "Don Gia", "Thanh tien");
        System.out.println(s);
        for (int i = 0; i < 100; i++) System.out.print("-");
        System.out.println();
    }

    public double getThanhTien() {
        return getSoBaiHat() * getGia();
    }

    @Override
    public String toString() {
        return String.format("|%10s|%10s|%10s|%10s|%10s|%10s|",
                getMaCD(), getTuaCD(), getCaSy(), getSoBaiHat(), getGia(), getThanhTien());
    }

    public static void main(String[] args) throws Exception {
        tieuDe();
        CD cd1 = new CD("Cd10000", "Mua dong", "Dam Vinh Hung", 10, 5000);
        System.out.println(cd1);
    }
}