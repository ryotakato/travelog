package travelog.controller.travelog;

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
        
//        // タグを取得
//        for (Entry entry : entryList) {
//            StringBuilder tagName = new StringBuilder();
//            for (TagEntry te : entry.getTagEntryListRef().getModelList()) {
//                Tag t = te.getTagsRef().getModel();
//                tagName.append(t.getName());
//                if (t.getParentTagRef().getModel() != null) {
//                    tagName.append("(").append(t.getParentTagRef().getModel().getName()).append(")").append(",");   
//                }
//            }
//            entry.setTitle(entry.getTitle() + " : " + tagName.toString());
//        }
//        
//        // タグから記事取得
//        TagService ts = new TagService();
//        List<Tag> tagList = ts.getTagList("a");
//        for (Tag tag : tagList) {
//            StringBuilder entryName = new StringBuilder();
//            for (TagEntry te : tag.getTagEntryListRef().getModelList()) {
//                Entry e = te.getEntriesRef().getModel();
//                entryName.append(e.getTitle()).append(",");
//            }
//            tag.setName(tag.getName() + " : " + entryName.toString());
//        }
//        requestScope("tagList", tagList);        
        
        return forward("index.jsp");
    }
}
