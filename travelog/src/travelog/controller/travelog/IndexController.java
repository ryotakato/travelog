package travelog.controller.travelog;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import travelog.model.Entry;
import travelog.service.EntryService;

public class IndexController extends Controller {

    private EntryService service = new EntryService();

    @Override
    public Navigation run() throws Exception {
        List<Entry> entryList = service.getEntryList();
        requestScope("entryList", entryList);
        return forward("index.jsp");
    }
}
