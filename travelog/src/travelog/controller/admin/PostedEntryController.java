package travelog.controller.admin;

import java.util.List;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import travelog.model.Entry;
import travelog.model.EntryBody;
import travelog.model.Tag;
import travelog.service.EntryService;
import travelog.service.TagService;

public class PostedEntryController extends Controller {

    private EntryService eService = new EntryService();
    private TagService tService = new TagService();
    
    @Override
    public Navigation run() throws Exception {
        
        Map<String, Object> input = new RequestMap(request);
        
        // set entry to model
        Entry entry = new Entry();
        EntryBody body = new EntryBody();
        BeanUtil.copy(input, entry);
        BeanUtil.copy(input, body);
        
        // get request category
        String[] tagArray = (String[])input.get("tagArray");
        
        // post & get tags
        List<Tag> tags = tService.postTags(tagArray, entry.getPostedDate());
        
        // post entry
        eService.postEntry(entry, body, tags);
        
        return forward("postedEntry.jsp");
    }
}
