package travelog.controller.travelog;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.util.StringUtil;

import travelog.model.Entry;
import travelog.model.Tag;
import travelog.model.TagEntry;

public class ViewCategoryController extends BaseController {
    
    protected static final Logger logger =
            Logger.getLogger(ViewCategoryController.class.getName());
    
    @Override
    protected Navigation exec() throws Exception {
        
        // request category name
        String reqName = asString("name");
        
        // check empty
        if (StringUtil.isEmpty(reqName)) {
            // TODO convert log4j ?
            logger.info("Category Not Found");
            return forward("notExist");
        }
        
        // check exist
        Tag reqTag = Tag.getCategory(reqName);
        if (reqTag == null) {
            // TODO convert log4j ?
            logger.info("Category Not Found");
            return forward("notExist");            
        }
        
        // get children tags and get entries
        List<Tag> categories = reqTag.getChildrenTagRef().getModelList();
        List<TagEntry> tagEntries = reqTag.getTagEntryListRef().getModelList();
        List<Entry> entries = new ArrayList<Entry>();
        for (TagEntry tagEntry : tagEntries) {
            entries.add(tagEntry.getEntriesRef().getModel());
        }
        
        // set to request
        requestScope("categories", categories);
        requestScope("entries", entries);
        
        return forward("viewCategory.jsp");
    }
}
