package org.glob.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author: rimar
 * Date: Aug 15, 2006
 */
public class UploadServlet extends HttpServlet {
    private static Log log = LogFactory.getLog(UploadServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message;
        FileOutputStream fout = null;

        try {
            ServletRequestContext src = new ServletRequestContext(request);
            if (!ServletFileUpload.isMultipartContent(src))
                throw new FileUploadException("not multipart request");

            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            //noinspection unchecked
            List<FileItem> items = upload.parseRequest(request);

            FileItem file = items.get(1);

            byte[] buf = file.get();

            if (buf == null || buf.length == 0) {
                response.sendRedirect("/upload.html");
                return;
            }

            File tempFile = File.createTempFile("___", file.getName());
            fout = new FileOutputStream(tempFile);
            fout.write(buf);

            message = "Successfuly wrote: " + tempFile.getAbsolutePath();

        } catch (Exception e) {
            log.debug(e, e);
            message = "<div>Upload failed <a href=\"/upload.html\">try again</a></div>";
            if (log.isDebugEnabled()) {
                message += "<pre>" + e + "\n" + "</pre><br/>";
            }
        } finally {
            if (fout!=null) fout.close();
        }

        response.getWriter().print(message);
    }
}
