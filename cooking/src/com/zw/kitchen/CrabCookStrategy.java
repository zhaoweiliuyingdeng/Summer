package com.zw.kitchen;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import crabCooking.BraiseCrabs;
import crabCooking.CrabCooking;
import crabCooking.SteamedCrab;

public class CrabCookStrategy implements ItemListener {
	private JFrame jf ;
	private JRadioButton qz , hs ;
	private JPanel CenterJP,SouthJP;
    private Kitchen cf;    //厨房
    private CrabCooking qzx,hsx;    //大闸蟹加工者   
    public CrabCookStrategy() {
    	jf = new JFrame("策略模式在大闸蟹做菜中的应用") ;
    	jf.setBounds(100,100,500,400);
    	jf.setVisible(true);
    	jf.setResizable(false);
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	SouthJP = new JPanel() ;
    	CenterJP = new JPanel() ;
    	jf.add("South",SouthJP);
    	jf.add("Center",CenterJP) ;
        qz=new JRadioButton("清蒸大闸蟹");
        hs=new JRadioButton("红烧大闸蟹");
        qz.addItemListener(this);
        hs.addItemListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(qz);
        group.add(hs);
        SouthJP.add(qz);
        SouthJP.add(hs);
        //---------------------------------
        cf=new Kitchen();    //厨房
        qzx=new SteamedCrab();    //清蒸大闸蟹类
        hsx=new BraiseCrabs();    //红烧大闸蟹类
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
        JRadioButton jc=(JRadioButton) e.getSource();
        if(jc==qz)
        {
            cf.setCrab(qzx);
            cf.CookMedthod(); //清蒸
        }
        else if(jc==hs)
        {
            cf.setCrab(hsx);
            cf.CookMedthod(); //红烧
        }
        CenterJP.removeAll();
        CenterJP.repaint();
        CenterJP.add((Component)cf.getCrab());       
        jf.setVisible(true);

	}

}
