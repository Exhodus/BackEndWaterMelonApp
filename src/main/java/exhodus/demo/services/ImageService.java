package exhodus.demo.services;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {

    private final Cloudinary cloudinary;

    public ImageService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );
            // secure_url = URL https pública que vas a guardar en tu BD
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Error subiendo imagen a Cloudinary", e);
        }
    }
}
