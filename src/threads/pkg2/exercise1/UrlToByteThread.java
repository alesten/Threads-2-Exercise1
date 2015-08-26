package threads.pkg2.exercise1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlToByteThread extends Thread {

    private String url;
    private long sum;
    
    public UrlToByteThread(String url) {
        this.url = url;
    }
    
    public void run() {
        sum = 0;
        
        for (byte bytesFromUrl : getBytesFromUrl(url)) {
            sum += bytesFromUrl;
        }
    }

    protected byte[] getBytesFromUrl(String url) {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();
    }
    
     public long getSum() {
        return sum;
    }
}
