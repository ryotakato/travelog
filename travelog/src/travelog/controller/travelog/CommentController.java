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
            service.postComment(new RequestMap(request), entryId);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO JSP未作成
            e.printStackTrace();
            return forward("noEntry.jsp");
        }
        return forward("viewEntry?id=" + entryId);
    }
}
