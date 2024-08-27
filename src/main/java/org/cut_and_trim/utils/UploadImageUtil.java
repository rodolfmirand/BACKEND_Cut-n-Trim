package org.cut_and_trim.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Component
public class UploadImageUtil {

    public boolean uploadImage(MultipartFile image) {
        if (!image.isEmpty()) {
            String imageName = image.getOriginalFilename();

            try {
                String path = "src\\main\\resources\\static\\images";

                File directory = new File(path);

                if (!directory.exists()) directory.mkdirs();

                File fileToSave = new File(directory.getAbsolutePath() + File.separator + imageName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileToSave));

                stream.write(image.getBytes());
                stream.close();

                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
