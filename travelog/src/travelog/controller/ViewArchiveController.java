package travelog.controller.travelog;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import travelog.model.Entry;
import travelog.model.Tag;
import travelog.model.TagEntry;

public class ViewArchiveController extends BaseController {

    @Override
    public Navigation exec() throws Exception {
        
        String year = asString("year");
        
        // get year tag and entries
        Tag yearTag = Tag.getTag(year, true);
        List<TagEntry> tagEntries = yearTag.getTagEntryListRef().getModelList();
        List<Entry> entries = new ArrayList<Entry>();
        for (TagEntry tagEntry : tagEntries) {
            entries.add(tagEntry.getEntriesRef().getModel());
        }
        
        // set to request
        requestScope("entries", entries);
        
        return forward("viewArchive.jsp");
    }
}
