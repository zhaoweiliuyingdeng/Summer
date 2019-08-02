package com.zw.dinner;
/**
 * 哲学家就餐问题
 * @author 赵薇
 *
 */
public class Dinner implements Runnable {
	private volatile Chopstick[] chopsticks ;
	
	class Chopstick{
		Integer id ; // 筷子的Id
		boolean isTake ; //筷子的状态
		public Chopstick() {
			this.id = 0 ;
			this.isTake = false ;
		}
		
	}
	public Dinner() {
		this.chopsticks = new Chopstick[5] ;
		for(int i = 0 ; i < 5 ;i++) {//五个筷子放到数组的五个位置，筷子的初始状态都为false
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
                    //先得到当前哲学家的id
                    Integer idOfPeople = Integer.valueOf( Thread.currentThread().getName() );
                    //然后得到哲学家id旁边两个筷子的情况
                    Integer left = (idOfPeople+4)%5;
                    Integer right = (idOfPeople++)%5;

                    //两个筷子都是空闲情况下,哲学家可以进行就餐
                    if(!chopsticks[left].isTake && !chopsticks[right].isTake){
                        chopsticks[left].isTake = true;
                        chopsticks[right].isTake = true;
                        System.out.println("哲学家"+idOfPeople+"就餐中");

                        Thread.sleep( 5000 );  //让其就餐一会后放下筷子进行思考
                        chopsticks[left].isTake = false; //模拟放下筷子的过程
                        chopsticks[right].isTake = false;
                        System.out.println("哲学家"+idOfPeople+"就餐完毕开始思考");
                        this.notifyAll();
                        this.wait();
                    }else{
                        System.out.println("哲学家"+idOfPeople+"思考中");
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
