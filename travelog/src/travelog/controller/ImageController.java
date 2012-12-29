package travelog.controller;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;

import travelog.model.Image;
import travelog.service.ImageService;

public class ImageController extends Controller {
    
    private ImageService service = new ImageService();
    
    protected static final Logger logger =
            Logger.getLogger(ImageController.class.getName());

    @Override
    public Navigation run() throws Exception {
        
        // get request image id
        String id = asString("id");
        
        Image img = null;
        try {
            // get image
            img = service.getImage(id);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO convert log4j ?
            logger.info("Image Not Found");
            return null;
        }
        
        // write to response
        response.getOutputStream().write(img.getData());
        
        return null;
    }
}
