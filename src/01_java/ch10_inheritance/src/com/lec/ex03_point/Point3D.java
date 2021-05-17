package com.lec.ex03_point;
// Point3D p3 = new Point3D();
// p3.pointPrint() // z값이 나오지 않는다.
public class Point3D extends Point {
	private int z;
	public void point3DPrint() {
		System.out.printf("3차원 좌표 : %d, %d, %d\n", getX(), getY(), z);
	}
	public String point3DInfoString() {
		return String.format("3차원 좌표 : %d, %d, %d\n", getX(), getY(), z);
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
