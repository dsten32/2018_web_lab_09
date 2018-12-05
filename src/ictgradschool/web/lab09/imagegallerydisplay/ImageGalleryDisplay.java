package ictgradschool.web.lab09.imagegallerydisplay;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ImageGalleryDisplay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private File getFullSizeImage(String iName, File[] photoList) {
        String fullsizeImgName = iName.split("_thumbnail")[0];
        File fullSizeImage = null;

        for (int i = 0; i < photoList.length; i++) {
            if (photoList[i].getName().contains(fullsizeImgName + ".")) {
                fullSizeImage = photoList[i];
                return fullSizeImage;
            }
        }

        return fullSizeImage;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletContext servletContext = getServletContext();
        String fullPhotoPath = servletContext.getRealPath("/Photos");


        File pfolder = new File(fullPhotoPath);

        File[] photoList = pfolder.listFiles();
//
//        out.println(pfolder.getAbsolutePath());
//        out.println(photoList[0].getName());
        out.print("<body>");
        if(photoList.length<1){
            out.print("<h1>images not found, sorry.<h1><br> <h3>Here's a sloth instead<p> <br>");
            out.print("<img src='https://images.mentalfloss.com/sites/default/files/styles/mf_image_16x9/public/monster_primary.png?itok=QWN7T3o-&resize=1100x1100' >");
        }else {

            for (int i = 0; i < photoList.length; i++) {
                String pName = photoList[i].getName();

                if (pName.contains("_thumbnail.png")) {
                    File fullSizeImage = getFullSizeImage(pName, photoList);

                    out.print("<a href=../Photos/" + fullSizeImage.getName() + ">");
                    out.print("<img src=../Photos/" + photoList[i].getName() + ">");
                    out.print("</a>");
                    out.print(" " + fullSizeImage.getName());
                    out.print(" " + fullSizeImage.length() + " bytes<br>");

                }
            }
        }
//            else {
////                out.print("not found" + i);
//
//            }
//    }


        out.println("</body>");

    }
}
