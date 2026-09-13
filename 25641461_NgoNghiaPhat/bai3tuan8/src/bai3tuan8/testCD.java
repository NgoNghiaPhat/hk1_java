package bai3tuan8;

public class testCD {
    public static void main(String[] args) throws Exception {
        // Tạo danh sách chứa tối đa 2 CD (để test việc tự tăng kích thước)
        ListCD ds = new ListCD(2);

        // Thêm CD
        CD cd1 = new CD("CD001", "Mua dong", "Dam Vinh Hung", 10, 5000);
        CD cd2 = new CD("CD002", "Noi tinh yeu bat dau", "My Tam", 12, 6000);
        CD cd3 = new CD("CD003", "Sao chang ve", "Quang Le", 8, 4500);

        System.out.println("Them CD1: " + ds.themCD(cd1));
        System.out.println("Them CD2: " + ds.themCD(cd2));
        System.out.println("Them CD3: " + ds.themCD(cd3));

        // Thêm trùng mã
        CD cdTrung = new CD("CD001", "Trung ma", "Ai do", 5, 1000);
        System.out.println("Them CD trung ma CD001: " + ds.themCD(cdTrung));

        // In danh sách
        CD.tieuDe();
        for (int i = 0; i < ds.getCount(); i++) {
            System.out.println(ds.getCD(i));
        }

        // Cập nhật giá
        System.out.println("\nCap nhat gia CD002 -> 7000: " + ds.capNhatCD("CD002", 7000));

        // Xóa CD
        System.out.println("Xoa CD001: " + ds.xoa("CD001"));
        System.out.println("Xoa CD999: " + ds.xoa("CD999"));

        // In lại danh sách sau khi cập nhật & xóa
        System.out.println("\nDanh sach sau khi cap nhat va xoa:");
        CD.tieuDe();
        for (int i = 0; i < ds.getCount(); i++) {
            System.out.println(ds.getCD(i));
        }
    }
}