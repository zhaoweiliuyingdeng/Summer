package com.zw.dinner;
/**
 * ��ѧ�ҾͲ�����
 * @author ��ޱ
 *
 */
public class Dinner implements Runnable {
	private volatile Chopstick[] chopsticks ;
	
	class Chopstick{
		Integer id ; // ���ӵ�Id
		boolean isTake ; //���ӵ�״̬
		public Chopstick() {
			this.id = 0 ;
			this.isTake = false ;
		}
		
	}
	public Dinner() {
		this.chopsticks = new Chopstick[5] ;
		for(int i = 0 ; i < 5 ;i++) {//������ӷŵ���������λ�ã����ӵĳ�ʼ״̬��Ϊfalse
			chopsticks[i] = new Chopstick() ;
			chopsticks[i].id = i ;
			chopsticks[i].isTake = false ;
		}
	}

	@Override
	public void run() {
		while(true) {
			synchronized(this) {
				try{
                    //�ȵõ���ǰ��ѧ�ҵ�id
                    Integer idOfPeople = Integer.valueOf( Thread.currentThread().getName() );
                    //Ȼ��õ���ѧ��id�Ա��������ӵ����
                    Integer left = (idOfPeople+4)%5;
                    Integer right = (idOfPeople++)%5;

                    //�������Ӷ��ǿ��������,��ѧ�ҿ��Խ��оͲ�
                    if(!chopsticks[left].isTake && !chopsticks[right].isTake){
                        chopsticks[left].isTake = true;
                        chopsticks[right].isTake = true;
                        System.out.println("��ѧ��"+idOfPeople+"�Ͳ���");

                        Thread.sleep( 5000 );  //����Ͳ�һ�����¿��ӽ���˼��
                        chopsticks[left].isTake = false; //ģ����¿��ӵĹ���
                        chopsticks[right].isTake = false;
                        System.out.println("��ѧ��"+idOfPeople+"�Ͳ���Ͽ�ʼ˼��");
                        this.notifyAll();
                        this.wait();
                    }else{
                        System.out.println("��ѧ��"+idOfPeople+"˼����");
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}

	}
	public static void main(String[] args) {
        Dinner dinner = new Dinner();
        for (int i = 0; i < 5; i++) {
            new Thread( dinner,String.valueOf( i ) ).start();
        }
    }

}
