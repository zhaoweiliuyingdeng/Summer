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
    private Kitchen cf;    //����
    private CrabCooking qzx,hsx;    //��բз�ӹ���   
    public CrabCookStrategy() {
    	jf = new JFrame("����ģʽ�ڴ�բз�����е�Ӧ��") ;
    	jf.setBounds(100,100,500,400);
    	jf.setVisible(true);
    	jf.setResizable(false);
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	SouthJP = new JPanel() ;
    	CenterJP = new JPanel() ;
    	jf.add("South",SouthJP);
    	jf.add("Center",CenterJP) ;
        qz=new JRadioButton("������բз");
        hs=new JRadioButton("���մ�բз");
        qz.addItemListener(this);
        hs.addItemListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(qz);
        group.add(hs);
        SouthJP.add(qz);
        SouthJP.add(hs);
        //---------------------------------
        cf=new Kitchen();    //����
        qzx=new SteamedCrab();    //������բз��
        hsx=new BraiseCrabs();    //���մ�բз��
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
        JRadioButton jc=(JRadioButton) e.getSource();
        if(jc==qz)
        {
            cf.setCrab(qzx);
            cf.CookMedthod(); //����
        }
        else if(jc==hs)
        {
            cf.setCrab(hsx);
            cf.CookMedthod(); //����
        }
        CenterJP.removeAll();
        CenterJP.repaint();
        CenterJP.add((Component)cf.getCrab());       
        jf.setVisible(true);

	}

}
