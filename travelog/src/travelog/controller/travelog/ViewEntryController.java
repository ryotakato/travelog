package travelog.controller.travelog;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;

import travelog.model.Comment;
import travelog.model.Entry;
import travelog.service.CommentService;
import travelog.service.EntryService;

public class ViewEntryController extends Controller {

    private EntryService eService = new EntryService();
    private CommentService cService = new CommentService();

    @Override
    public Navigation run() throws Exception {

        // ブログ記事のidを特定
        String id = asString("id");

        // idからブログ記事を取得してリクエストに設定
        Entry entry = null;
        try {
            entry = eService.getEntry(id);
        } catch (EntityNotFoundRuntimeException e) {
            // TODO JSP未作成
            e.printStackTrace();
            return forward("noEntry.jsp");
        }

        requestScope("entry", entry);
        requestScope("body", entry.getBodyRef().getModel());

        // コメント一覧を取得してリクエストに設定
        List<Comment> commentList = cService.getCommentList(entry);
        requestScope("commentList", commentList);

        return forward("viewEntry.jsp");
    }
}
