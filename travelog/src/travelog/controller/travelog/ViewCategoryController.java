package travelog.controller.travelog;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.util.StringUtil;

import travelog.model.Entry;
import travelog.model.Tag;
import travelog.model.TagEntry;
import travelog.service.TagService;

public class ViewCategoryController extends BaseController {

    private TagService tService = new TagService();
    
    @Override
    protected Navigation exec() throws Exception {
        
        // request category name
        String reqName = asString("name");
        
        if (StringUtil.isEmpty(reqName)) {
            // TODO not yet make JSP
            return forward("noCategory.jsp");
        }
        
        Tag reqTag = Tag.getTag(reqName);
        if (reqTag == null) {
            // TODO not yet make JSP
            return forward("noCategory.jsp");            
        }
        
        List<Tag> categories = reqTag.getChildrenTagRef().getModelList();
        List<TagEntry> tagEntries = reqTag.getTagEntryListRef().getModelList();
        List<Entry> entries = new ArrayList<Entry>();
        for (TagEntry tagEntry : tagEntries) {
            entries.add(tagEntry.getEntriesRef().getModel());
        }
        
        requestScope("categories", categories);
        requestScope("entries", entries);
        
        return forward("viewCategory.jsp");
    }
}
