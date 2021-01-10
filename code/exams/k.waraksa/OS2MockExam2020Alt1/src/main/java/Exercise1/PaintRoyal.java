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
public class PaintRoyal {
    public static void main(String[] args)
	{
		PaintMonitor m = new PaintMonitor();
		Container c = new Container();
		final int NROFYELLOWPAINTSUPPLIERS = 65; //(a large number)
		final int NROFREDPAINTSUPPLIERS = 28; //(a large number)

		
		for (int i=0; i<NROFYELLOWPAINTSUPPLIERS; i++)
		{
			new Thread(new SupplierOfYellowPaint(m,c)).start();
		}

		for (int i=0; i<NROFREDPAINTSUPPLIERS; i++)
		{
			new Thread(new SupplierOfRedPaint(m,c)).start();
		}

		new Thread(new Painter(m,c)).start();

    }
}
