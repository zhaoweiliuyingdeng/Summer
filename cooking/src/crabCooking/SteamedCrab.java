package crabCooking;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SteamedCrab extends JLabel implements CrabCooking {

	
	    private static final long serialVersionUID=1L;
		@Override
		public void CookMedthod() {
			  this.setIcon(new ImageIcon("/cooking/strategy/SteamedCrabs.jpg"));
	          this.setHorizontalAlignment(CENTER);
		}

}
