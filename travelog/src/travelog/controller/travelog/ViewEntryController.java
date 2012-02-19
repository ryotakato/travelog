package travelog.controller.travelog;

import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;

import travelog.model.Comment;
import travelog.model.Entry;
import travelog.service.CommentService;
import travelog.service.EntryService;

public class ViewEntryController extends BaseController {

    private EntryService eService = new EntryService();
    private CommentService cService = new CommentService();

    @Override
    public Navigation exec() throws Exception {

        // ブログ記事のidを特定
        String id = asString("id");

        // idからブログ記事を取得してリクエストに設定
        Entry entry = null;
        try {
            entry = eService.getEntry(id);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO ログの出し方
            e.printStackTrace();
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
