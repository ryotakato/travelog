package travelog.service;

import java.util.Date;
import java.util.Map;

import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;

import com.google.appengine.api.datastore.Transaction;

import travelog.model.Image;


public class ImageService {

    /**
     * Get image from DB by image id
     * @param imageId image id
     * @return target image object
     */
    public Image getImage(String imageId) {
        return Image.getImage(imageId);
    }
    
    public String postImage(Map<String, Object> input) throws Exception {
        Image img = new Image();
        
        // set image
        FileItem fileImage = (FileItem)input.get("fileImage");
        img.setData(fileImage.getData());
        
        // set key
        // TODO Enum pattern ?
        Date postedDate = new Date();
        String imgId = DateUtil.toString(postedDate, "yyyyMMddHHmmss");
        img.setKey(Image.createKey(imgId));
        
        // DB access
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, img);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        
        return imgId;
    }
}
