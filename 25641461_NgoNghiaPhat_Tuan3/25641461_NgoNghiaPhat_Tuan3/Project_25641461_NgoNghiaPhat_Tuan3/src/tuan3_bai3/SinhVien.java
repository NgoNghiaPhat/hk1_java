package tuan3_bai3;

import java.util.Iterator;
import java.util.Scanner;

public class SinhVien {
	private int maSV;
	private String hoten;
	private float diemLT,diemTH;
	private Object system;

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int ma) throws Exception {
	if (ma>0) {
		this.maSV = ma;
	} else {
		throw new Exception("Ma phai >0" );
	}
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	public SinhVien() {
		super();
		this.maSV = 1;
		this.hoten = "Chua nhap";
		this.diemLT = 0.0f;
		this.diemTH = 0.0f;
	}
	
	public SinhVien(int ma, String hoten, float diemLT, float diemTH) throws Exception {
		super();
		if (ma>0) {
			this.maSV = ma;
		} else {
			throw new Exception("Ma phai >0" );
		}
		this.hoten = hoten;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	
	public double getDiemTB(){
		return (getDiemLT()+getDiemTH())/2;
	}
	
	public static final void tieuDe() {
		for (int i = 0; i < 60; i++) {
			System.out.printf("-");
		}
		System.out.println();
		String s="";
		s=s+s.format("|%-10s|%-10s|%-10s|%-10s|%-10s|","Ma sinh vien","Ho ten","Diem LT","Diem Th","Diem TB");
		System.out.println(s);
		for (int i = 0; i < 60; i++) {
			System.out.printf("-");
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		String s="";
		s=s+s.format("|%-10s|%-10s|%-10s|%-10s|%-10s|", getMaSV(),getHoten(),getDiemLT(),getDiemTH(),getDiemTB());
		return s;
	}
	public static SinhVien nhap() throws Exception {
		Scanner sc=new Scanner(System.in);
		int maSV;
		String hoten;
		float diemLT,diemTH;
		System.out.println("Nhap ma SV:");
		maSV=sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ho ten:");
		hoten=sc.nextLine();
		System.out.println("Nhap diem Lt:");
		diemLT=sc.nextFloat();
		System.out.println("Nhap diem Th:");
		diemTH=sc.nextFloat();
		SinhVien s=new SinhVien(maSV, hoten, diemLT, diemTH);
		return s;
	}
	
	public static void xuat(SinhVien s) {
		System.out.println(s.toString());
	}
	
	public static void main(String[] args) throws Exception {
		tieuDe();
		SinhVien s1=new SinhVien(2, "Ha thi hskd", 7, 8);
		System.out.println(s1.toString());
		System.out.println("NHap tu ban phim");
		tieuDe();
		xuat(nhap());
	}

}
