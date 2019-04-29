package come.poyu.servlet.Picture;

import Property.PropertiesTest;
import come.poyu.dao.PhotoDao;
import come.poyu.dao.impl.PhotoDaoImpl;
import come.poyu.entity.Photo;
import come.poyu.util.JDBCHelper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.extra.spath.AbsolutePath;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import poyu.core.CharsRecognise;
import poyu.core.PlateDetect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Photo photo = new Photo();
        PhotoDao photoDao = new PhotoDaoImpl();
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = null;
        String unrule_record = "";
        String time = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd HH:mm:ss aa");
        time = sdf.format(dt);
        List Files = new ArrayList();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem items : list) {
                if (items.isFormField()) {
                    if (items.getFieldName().equals("username")) {
                        name = new String(items.getString().getBytes("ISO-8859-1"), "UTF-8");
                        System.out.println("图像处理信息如下所示：" + "\n" + "*******************************" + "\n" + name);
                    }
                    if (items.getFieldName().equals("unrule_record")) {
                        unrule_record = new String(items.getString().getBytes("ISO-8859-1"), "UTF-8");
                        System.out.println(unrule_record);
                    }
                    System.out.println(items.getFieldName());
                } else {
                    Files.add(items);
                }
            }
            for (int i = 0; i < Files.size(); i++) {
                FileItem item = (FileItem) Files.get(i);
                String filename = item.getName();
                PropertiesTest pt = new PropertiesTest();
                String AbsolutePath = pt.getProperties();
                String path = ""+AbsolutePath +"res/image/test_image/" + filename + "";
                System.out.println("图片位置：" + path);
                String car_number = testCharsRecognise1(path);
                InputStream file = item.getInputStream();
                byte[] buffer = new byte[file.available()];
                file.read(buffer);
                try {
                    photo.setUsername(name);
                    photo.setCar_number(car_number);
                    photo.setTime(time);
                    photo.setUnrule_recorde(unrule_record);
                    photo.setPicture(buffer);
                    int list1 = photoDao.add(photo);
                    if (list1 == 1) {
                        System.out.println("违章记录保存成功！" + "\n" + "******************************");
                        resp.sendRedirect("Manager.jsp");
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        } catch (FileUploadException e2) {
            System.out.println(e2);
        }
    }

    public String testCharsRecognise1(String path) {
        // String imgPath = "D:/Tra/res/image/test_image/core_func_yellow.jpg";
        Mat src = imread(path);
        String result = null;
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<opencv_core.Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            CharsRecognise cr = new CharsRecognise();

            for (int i = 0; i < matVector.size(); ++i) {
                result = cr.charsRecognise(matVector.get(i));
                System.out.println("Chars Recognised: " + result);
            }
        }
        return result;
    }


    public String testCharsRecognise(String path) {
        String AbsolutePath = "D:/Tra/res/image/res/image/test_image/" + path + "";
        Mat src = imread(AbsolutePath);
        String result = null;
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<opencv_core.Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            CharsRecognise cr = new CharsRecognise();

            for (int i = 0; i < matVector.size(); ++i) {
                result = cr.charsRecognise(matVector.get(i));
                System.out.println("Chars Recognised: " + result);
            }
        }
        return result;
    }
}