package come.poyu.servlet.Picture;
import org.opencv.core.Core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

public class Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loaddllDynamically();



    }
    //动态加载dll
    private void loaddllDynamically() {
        String yourdllpath= "D:/Program Files/openCV/opencv/build/java/x64/opencv_java310.dll";//输入你要的dll路径，例如“c:/opencv/”，路径下为opencv_320,dll位置
        try {
            //设置路径
            System.setProperty("java.library.path",yourdllpath + System.getProperty("java.library.path"));
            System.out.printf("java.library.path: %s%n",System.getProperty("java.library.path"));
            Field fieldSysPath;
            fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        } catch (NoSuchFieldException  |SecurityException | IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
