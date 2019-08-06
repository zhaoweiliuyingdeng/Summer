package com.zw.pojo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DatingGameWin extends JFrame implements ActionListener {
    private static final long serialVersionUID=1L;   
    private JPanel CenterJP,EastJP;
    private JRadioButton girl1,girl2,girl3,girl4;
    private JButton button1,button2;
    private String FileName;
    private JLabel g;
    private You you;
    private GirlStack girls;

   public DatingGameWin()
    {
        super("���ñ���¼ģʽ���������Ϸ");
        you=new You();
        girls=new GirlStack();       
        this.setBounds(0,0,900,380);            
        this.setResizable(false);
        FileName="src/memento/Photo/�Ĵ���Ů.jpg";   
        g=new JLabel(new ImageIcon(FileName),JLabel.CENTER);
        CenterJP=new JPanel();
        CenterJP.setLayout(new GridLayout(1,4));
        CenterJP.setBorder(BorderFactory.createTitledBorder("�Ĵ���Ů���£�"));
        CenterJP.add(g);   
        this.add("Center",CenterJP);
        EastJP=new JPanel();
        EastJP.setLayout(new GridLayout(1,1));
        EastJP.setBorder(BorderFactory.createTitledBorder("��ѡ��İ����ǣ�"));
        this.add("East",EastJP);
        JPanel SouthJP=new JPanel();      
        JLabel info=new JLabel("�Ĵ���Ů�С���������֮�ݡ������߻�֮ò������ѡ��˭��");
        girl1=new JRadioButton("��ʩ",true);
        girl2=new JRadioButton("����");
        girl3=new JRadioButton("���Ѿ�");       
        girl4=new JRadioButton("����");
        button1=new JButton("ȷ��");
        button2=new JButton("����");
        ButtonGroup group=new ButtonGroup();
        group.add(girl1);
        group.add(girl2);
        group.add(girl3);
        group.add(girl4);
        SouthJP.add(info);
        SouthJP.add(girl1);
        SouthJP.add(girl2);
        SouthJP.add(girl3);
        SouthJP.add(girl4);
        SouthJP.add(button1);
        SouthJP.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        this.add("South",SouthJP);        
        showPicture("�հ�");
        you.setWife("�հ�");
        girls.push(you.createMemento());    //����״̬
    }
   
   //��ʾͼƬ
   public void showPicture(String name)
   {
       EastJP.removeAll(); //����������
       EastJP.repaint(); //ˢ����Ļ
       you.setWife(name);        
       FileName="src/memento/Photo/"+name+".jpg";               
       g=new JLabel(new ImageIcon(FileName),JLabel.CENTER);                   
       EastJP.add(g);
       this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
   }
	@Override
	public void actionPerformed(ActionEvent e) {
        boolean ok=false;
        if(e.getSource()==button1)
        {
            ok=girls.push(you.createMemento());    //����״̬  
            if(ok && girl1.isSelected())
            {
                showPicture("��ʩ");
            }
            else if(ok && girl2.isSelected())
            {
                showPicture("����");
            }
            else if(ok && girl3.isSelected())
            {
                showPicture("���Ѿ�");
            }
            else if(ok && girl4.isSelected())
            {
                showPicture("����");
            }               
        }
        else if(e.getSource()==button2)
        {
            you.restoreGirl(girls.pop()); //�ָ�״̬
            showPicture(you.getWife());
        }

	}

}
