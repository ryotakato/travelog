package travelog.controller.travelog;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.RequestMap;

import travelog.service.CommentService;

public class CommentController extends Controller {

    private CommentService service = new CommentService();

    @Override
    public Navigation run() throws Exception {

        String entryId = null;
        try {
            entryId = asString("entryId");
            // post comment 
            service.postComment(new RequestMap(request), entryId);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO ログの出し方
            e.printStackTrace();
            return forward("notExist");
        }
        return forward("viewEntry?id=" + entryId);
    }
}
