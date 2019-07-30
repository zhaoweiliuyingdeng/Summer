package com.zw.flyweight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class WhitePieces implements ChessPieces {

	@Override
	public void DownPieces(Graphics g, Point p) {
		g.setColor(Color.WHITE);
		g.fillOval(p.x, p.y, 30, 30);

	}

}
