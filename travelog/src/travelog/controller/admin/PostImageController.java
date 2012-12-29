package travelog.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PostImageController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("postImage.jsp");
    }
}
