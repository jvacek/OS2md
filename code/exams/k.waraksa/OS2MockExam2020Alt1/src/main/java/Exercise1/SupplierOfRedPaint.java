package Exercise1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kazik
 */

public class SupplierOfRedPaint implements Runnable {

	PaintMonitor m;
	Container c;
	
	// code for the constructor
	public SupplierOfRedPaint( PaintMonitor m, Container c){
            this.m = m;
            this.c = c;
        }

	@Override
	public void run()
	{
		while (true)
		{
			// produce red paint
			

			// bring red paint
			m.enterSupplierOfRed();
			c.addRedPaint();  // the critical section
			m.exitSupplierOfRed();
		}
	}
}

