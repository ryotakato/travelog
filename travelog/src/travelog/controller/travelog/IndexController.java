package travelog.controller.travelog;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import travelog.model.Entry;
import travelog.model.Tag;
import travelog.model.TagEntry;
import travelog.service.EntryService;
import travelog.service.TagService;

public class IndexController extends Controller {

    private EntryService service = new EntryService();

    @Override
    public Navigation run() throws Exception {
        
        // 記事一覧を取得
        List<Entry> entryList = service.getEntryList();
        
        
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
        
        requestScope("entryList", entryList);
        return forward("index.jsp");
    }
}
