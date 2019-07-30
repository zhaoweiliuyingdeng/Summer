package com.zw.factory;

import java.util.ArrayList;

import com.zw.flyweight.BlackPieces;
import com.zw.flyweight.ChessPieces;
import com.zw.flyweight.WhitePieces;

public class Weiqi {
	private ArrayList<ChessPieces> qz ;
	public Weiqi() {
		qz = new ArrayList<ChessPieces>() ;
		ChessPieces w = new WhitePieces() ;
		qz.add(w) ;
		ChessPieces b = new BlackPieces() ;
		qz.add(b) ;
	}
	public ChessPieces getPieces(String type) {
		if(type.equalsIgnoreCase("w")) {
			return (ChessPieces)qz.get(0) ;
		}else if(type.equalsIgnoreCase("b")) {
			return (ChessPieces)qz.get(1) ;
		}else {
			return null ;
		}
		
	}
	

}
