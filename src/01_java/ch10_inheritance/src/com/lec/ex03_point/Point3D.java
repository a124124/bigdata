package com.lec.ex03_point;
// Point3D p3 = new Point3D();
// p3.pointPrint() // z���� ������ �ʴ´�.
public class Point3D extends Point {
	private int z;
	public void point3DPrint() {
		System.out.printf("3���� ��ǥ : %d, %d, %d\n", getX(), getY(), z);
	}
	public String point3DInfoString() {
		return String.format("3���� ��ǥ : %d, %d, %d\n", getX(), getY(), z);
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}