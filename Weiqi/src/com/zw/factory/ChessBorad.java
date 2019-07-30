package com.zw.factory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.zw.flyweight.ChessPieces;

public class ChessBorad extends MouseAdapter{
	private Weiqi wq ;
	private JFrame jf ;
	private Graphics g ;
    private JRadioButton wz;
    private JRadioButton bz;
    private final int x=50;
    private final int y=50;      //С�����Ⱥ͸߶�
    private final int w=40;    
    private final int rw=400;    //���̿�Ⱥ͸߶�
    public ChessBorad() {
    	wq = new Weiqi() ;
    	jf = new JFrame("��Ԫģʽ��Χ���е�Ӧ��") ;
    	jf.setBounds(100, 100, 500, 550) ;
    	jf.setVisible(true);
    	jf.setResizable(false);
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JPanel jp = new JPanel() ;
    	jf.add("south", jp) ;
        wz=new JRadioButton("����");
        bz=new JRadioButton("����",true);
        ButtonGroup group=new ButtonGroup();
        group.add(wz);
        group.add(bz);
        jp.add(wz);
        jp.add(bz);      
        JPanel CenterJP=new JPanel();
        CenterJP.setLayout(null);
        CenterJP.setSize(500, 500);
        CenterJP.addMouseListener(this);
        jf.add("Center",CenterJP);      
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }               
        g=CenterJP.getGraphics();
        g.setColor(Color.BLUE);   
        g.drawRect(x, y, rw, rw);
        for(int i=1;i<10;i++)
        {
            //���Ƶ�i����ֱ��
            g.drawLine(x+(i*w),y,x+(i*w),y+rw);
            //���Ƶ�i��ˮƽ��
            g.drawLine(x,y+(i*w),x+rw,y+(i*w));
    }
    }
    
    public void mouseClicked(MouseEvent e)
    {
        Point pt=new Point(e.getX()-15,e.getY()-15);
        if(wz.isSelected())
        {
            ChessPieces c1=wq.getPieces("w");
            c1.DownPieces(g,pt);
        }
        else if(bz.isSelected())
        {
            ChessPieces c2=wq.getPieces("b");       
            c2.DownPieces(g,pt);  
        }
    }

}
