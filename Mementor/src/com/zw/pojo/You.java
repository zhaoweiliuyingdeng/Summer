package com.zw.pojo;
/**
 * �����ˣ���
 * @author ��ޱ
 *
 */
public class You {
	private String wifeName ;

	public String getWife() {
		return wifeName;
	}

	public void setWife(String wifeName) {
		this.wifeName = wifeName;
	}
	public Girl createGirl() {
		return new Girl(wifeName) ;
	}
	public void restoreGirl(Girl g) {
		setWife(g.getName()) ;
	}
	

}
