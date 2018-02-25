package logica;

public class Monitor {
	
	private int cantLectores;
	private boolean escribiendo;
	public Monitor() {
		cantLectores = 0;
		escribiendo = false;
	}
	
	public synchronized void comienzoLectura() {
		while (escribiendo) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		cantLectores ++;
	}
	
	public synchronized void terminoLectura() {
		cantLectores --;
		if( cantLectores == 0 )
			notify();
	}
	
	public synchronized void comienzoEscritura() {
		while (cantLectores != 0 || escribiendo) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		escribiendo = true;
	}
	
	public synchronized void terminoEscritura() {
		escribiendo = false;
		notify();
	}
	
}

