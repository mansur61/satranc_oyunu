package Satranc.dsa;

public enum Uyusma {
	Kahverengi {
		@Override
		public boolean renk() {
			// TODO Auto-generated method stub
			return true;
		}
	},
	Siyah {
		@Override
		public boolean renk() {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	public abstract boolean renk();
		
	
}
