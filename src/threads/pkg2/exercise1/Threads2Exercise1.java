/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg2.exercise1;

/**
 *
 * @author AlexanderSteen
 */
public class Threads2Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        UrlToByteThread t1 = new UrlToByteThread("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");        
        UrlToByteThread t3 = new UrlToByteThread("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png ");
        UrlToByteThread t2 = new UrlToByteThread("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        
        long start = System.nanoTime();

        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
//
//        t1.run();
//        t2.run();
//        t3.run();

        long sum = 0;
        sum += t1.getSum();        
        sum += t2.getSum();
        sum += t3.getSum();
        
        System.out.println("Sum: " + sum);
        
        long end = System.nanoTime(); 
        System.out.println("Time: "+(end-start));
    }
    
}


/*
    Tid brugt med sequential execution  1589651058
    Tid brugt med threads               834095132
    
    Med sequential execution går det næsten 2x så lang tid
    som med threads. Dette er fordi threads køre ved siden
    af hindanden er forved går hurtigere.
*/