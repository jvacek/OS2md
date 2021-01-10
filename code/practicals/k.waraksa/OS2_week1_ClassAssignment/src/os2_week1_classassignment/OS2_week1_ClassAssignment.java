/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2_week1_classassignment;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author 885233
 */
public class OS2_week1_ClassAssignment {

    private static int rtCount = 0;
    private static int ptCount = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CountDownLatch CDL = new CountDownLatch(4);
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());
        
        List<Runnable> TasksToDo = Arrays.asList(
          new ReadTask(rtCount,CDL),
          new ReadTask(rtCount,CDL),
          new ReadTask(rtCount,CDL),
          new ReadTask(rtCount,CDL),
          new ProcessingTask(ptCount),
          new ProcessingTask(ptCount),
          new ProcessingTask(ptCount),
          new ProcessingTask(ptCount)
        );
        
        TasksToDo.forEach((task) -> executor.execute(task));
        
        executor.shutdown(); 
        
    }
    
}
