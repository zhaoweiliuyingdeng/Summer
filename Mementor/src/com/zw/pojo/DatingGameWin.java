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
        super("利用备忘录模式设计相亲游戏");
        you=new You();
        girls=new GirlStack();       
        this.setBounds(0,0,900,380);            
        this.setResizable(false);
        FileName="src/memento/Photo/四大美女.jpg";   
        g=new JLabel(new ImageIcon(FileName),JLabel.CENTER);
        CenterJP=new JPanel();
        CenterJP.setLayout(new GridLayout(1,4));
        CenterJP.setBorder(BorderFactory.createTitledBorder("四大美女如下："));
        CenterJP.add(g);   
        this.add("Center",CenterJP);
        EastJP=new JPanel();
        EastJP.setLayout(new GridLayout(1,1));
        EastJP.setBorder(BorderFactory.createTitledBorder("您选择的爱人是："));
        this.add("East",EastJP);
        JPanel SouthJP=new JPanel();      
        JLabel info=new JLabel("四大美女有“沉鱼落雁之容、闭月羞花之貌”，您选择谁？");
        girl1=new JRadioButton("西施",true);
        girl2=new JRadioButton("貂蝉");
        girl3=new JRadioButton("王昭君");       
        girl4=new JRadioButton("杨玉环");
        button1=new JButton("确定");
        button2=new JButton("返回");
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
        showPicture("空白");
        you.setWife("空白");
        girls.push(you.createMemento());    //保存状态
    }
   
   //显示图片
   public void showPicture(String name)
   {
       EastJP.removeAll(); //清除面板内容
       EastJP.repaint(); //刷新屏幕
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
            ok=girls.push(you.createMemento());    //保存状态  
            if(ok && girl1.isSelected())
            {
                showPicture("西施");
            }
            else if(ok && girl2.isSelected())
            {
                showPicture("貂蝉");
            }
            else if(ok && girl3.isSelected())
            {
                showPicture("王昭君");
            }
            else if(ok && girl4.isSelected())
            {
                showPicture("杨玉环");
            }               
        }
        else if(e.getSource()==button2)
        {
            you.restoreGirl(girls.pop()); //恢复状态
            showPicture(you.getWife());
        }

	}

}
