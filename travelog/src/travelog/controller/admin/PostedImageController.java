package travelog.controller.admin;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import travelog.service.ImageService;

public class PostedImageController extends Controller {
    
    private ImageService service = new ImageService();

    @Override
    public Navigation run() throws Exception {
        Map<String, Object> input = new RequestMap(request);
        
        // post image
        String imgId = service.postImage(input);
        
        // set image id
        requestScope("imgId", imgId);
        
        return forward("postedImage.jsp");
    }
}
