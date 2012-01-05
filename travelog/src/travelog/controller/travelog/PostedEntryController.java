package travelog.controller.travelog;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import travelog.service.EntryService;

public class PostedEntryController extends Controller {

    private EntryService service = new EntryService();

    @Override
    public Navigation run() throws Exception {
        service.postEntry(new RequestMap(request));
        return forward("postedEntry.jsp");
    }
}
