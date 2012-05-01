package travelog.controller;

import java.util.List;

import org.slim3.controller.Navigation;

import travelog.model.Comment;
import travelog.model.Entry;
import travelog.service.CommentService;

public class IndexController extends BaseController {

    private CommentService commentService = new CommentService();
    
    @Override
    public Navigation exec() throws Exception {
        
        // "recentEntries" is already getted by BaseController#preExec
        @SuppressWarnings("unchecked")
        List<Entry> entries = (List<Entry>)requestScope("recentEntries");
        
        if (!entries.isEmpty()) {
            Entry entry = entries.get(0);
            
            // Get & Set entry body
            requestScope("entry", entry);
            requestScope("body", entry.getBodyRef().getModel());

            // Get & Set comments
            List<Comment> comments = commentService.getCommentList(entry);
            requestScope("comments", comments);
        }     
        
        return forward("index.jsp");
    }
}
