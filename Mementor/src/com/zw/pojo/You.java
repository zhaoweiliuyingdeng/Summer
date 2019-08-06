package com.zw.pojo;
/**
 * ·¢ÆğÈË£ºÄã
 * @author ÕÔŞ±
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
