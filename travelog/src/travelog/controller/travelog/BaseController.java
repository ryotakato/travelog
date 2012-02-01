package travelog.controller.travelog;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import travelog.model.Entry;
import travelog.service.EntryService;

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
    
    /**
     * Pre exec() process method
     * @throws Exception
     */
    private void preExec() throws Exception {
        
        // Get & Set Recent Entries
        List<Entry> entries = entryService.getEntryList(10);
        requestScope("recentEntries", entries);
    }
}
