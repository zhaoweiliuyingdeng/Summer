package com.zw.pojo;
/**
 * �����ߣ���Ůջ
 * @author ��ޱ
 *
 */
public class GirlStack {
	private Girl[] girl ;
	private int top ;
	public GirlStack() {
		girl = new Girl[5] ;
		top = -1 ;
	}
    public boolean push(Girl p)
    {
        if(top>=4)
        {
            System.out.println("��̫�����ˣ�������ȥ�ģ�");
            return false;
        }
        else
        {
            girl[++top]=p;
            return true;
        }
    }
    public Girl pop()
    {
        if(top<=0)
        {
            System.out.println("��Ůջ���ˣ�");
            return girl[0];
        }
        else return girl[top--]; 
    }
	

}
