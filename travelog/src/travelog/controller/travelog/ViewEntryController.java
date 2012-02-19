package travelog.controller.travelog;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;

import travelog.model.Comment;
import travelog.model.Entry;
import travelog.service.CommentService;
import travelog.service.EntryService;

public class ViewEntryController extends BaseController {

    private EntryService eService = new EntryService();
    private CommentService cService = new CommentService();
    
    protected static final Logger logger =
            Logger.getLogger(ViewEntryController.class.getName());

    @Override
    public Navigation exec() throws Exception {

        // get request entry id
        String id = asString("id");

        Entry entry = null;
        try {
            // get entry
            entry = eService.getEntry(id);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO convert log4j ?
            logger.info("Entry Not Found");
            return forward("notExist");
        }

        // Get & Set entry body
        requestScope("entry", entry);
        requestScope("body", entry.getBodyRef().getModel());

        // Get & Set comments
        List<Comment> comments = cService.getCommentList(entry);
        requestScope("comments", comments);

        return forward("viewEntry.jsp");
    }
}
