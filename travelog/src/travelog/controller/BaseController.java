package travelog.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import travelog.model.Entry;
import travelog.model.Tag;
import travelog.service.EntryService;
import travelog.service.TagService;

public abstract class BaseController extends Controller {

    @Override
    public Navigation run() throws Exception {
        preExec();
        return exec();
    }
    
    /**
     * Abstract executable method
     * @return Navigation (= return of run())
     * @throws Exception
     */
    abstract protected Navigation exec() throws Exception;
    
    private EntryService entryService = new EntryService();
    private TagService tagService = new TagService();
    
    /**
     * Pre exec() process method
     * @throws Exception
     */
    private void preExec() throws Exception {
        
        // Get & Set Recent Entries
        List<Entry> entries = entryService.getEntryList(10);
        requestScope("recentEntries", entries);
        
        List<Tag> rootCategories = tagService.getRootCategories();
        requestScope("rootCategories", rootCategories);
    }
}
