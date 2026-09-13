package bai3tuan8;

public class ListCD {
    private CD[] cdr;
    private int count = 0;

    public ListCD(int n) {
        cdr = new CD[n];   // sửa: không khai báo lại biến
        count = 0;
    }

    // Tăng kích thước mảng khi đầy
    public void tangKT() {
        if (cdr.length == count) {
            CD[] tam = new CD[cdr.length * 2];
            System.arraycopy(cdr, 0, tam, 0, count);  // sửa: System (không phải systerm)
            cdr = tam;
        }
    }

    public boolean themCD(CD crom) {
        for (int i = 0; i < count; i++) {
            if (cdr[i].getMaCD().equalsIgnoreCase(crom.getMaCD())) {
                return false;
            }
        }
        tangKT();
        cdr[count] = crom;
        count++;
        return true;
    }

    public boolean xoa(String maXoa) {
        for (int i = 0; i < count; i++) {
            if (cdr[i].getMaCD().equalsIgnoreCase(maXoa)) {
                for (int j = i; j < count - 1; j++) {
                    cdr[j] = cdr[j + 1];
                }
                cdr[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public boolean capNhatCD(String maCD, float gia) {
        for (int i = 0; i < count; i++) {
            if (cdr[i].getMaCD().equalsIgnoreCase(maCD)) {
                cdr[i].setGia(gia);
                return true;
            }
        }
        return false;
    }

    // In kết quả
    public CD[] getAll() {
        return cdr;
    }

    public int getCount() {
        return count;
    }

    public CD getCD(int i) {
        if (i >= 0 && i < count) return cdr[i];
        return null;
    }
}