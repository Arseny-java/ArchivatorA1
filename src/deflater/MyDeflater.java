package deflater;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class MyDeflater {
    public static void deflateFile(String dfPth, String svPth) throws Exception {
        FileInputStream fis = new FileInputStream(dfPth);
        FileOutputStream fos = new FileOutputStream(svPth);
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);

        doCopy(fis, dos);
    }
    public static void inflateFile(String infPth, String svPth) throws Exception {
        FileInputStream fis2 = new FileInputStream(infPth);
        InflaterInputStream iis = new InflaterInputStream(fis2);
        FileOutputStream fos2 = new FileOutputStream(svPth);

        doCopy(iis, fos2); // copy deflated.txt to inflated.txt and uncompress it
    }

    public static void doCopy(InputStream is, OutputStream os) throws Exception {
        int oneByte;
        while ((oneByte = is.read()) != -1) {
            os.write(oneByte);
        }
        os.close();
        is.close();
    }

}
