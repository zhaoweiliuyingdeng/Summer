package com.zw.proxy;
/**
 * æ≤Ã¨¥˙¿Ì≤‚ ‘
 * @author ’‘ﬁ±
 *
 */
public class TestDemo {

	public static void main(String[] args) {
		ISinger singer = new Singer() ;
		ISinger target = new SingerProxy(singer) ;
		target.sing();

	}

}
