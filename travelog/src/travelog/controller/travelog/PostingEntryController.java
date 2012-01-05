package travelog.controller.travelog;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PostingEntryController extends Controller {


    @Override
    public Navigation run() throws Exception {
        return forward("postingEntry.jsp");
    }
}
