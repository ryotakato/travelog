package travelog.controller.travelog;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.RequestMap;

import travelog.service.CommentService;

public class CommentController extends Controller {

    private CommentService service = new CommentService();
    
    protected static final Logger logger =
            Logger.getLogger(CommentController.class.getName());

    @Override
    public Navigation run() throws Exception {

        String entryId = asString("entryId");
        try {
            // post comment 
            service.postComment(new RequestMap(request), entryId);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO convert log4j ?
            logger.info("Entry Not Found");
            return forward("notExist");
        }
        return forward("viewEntry?id=" + entryId);
    }
}
