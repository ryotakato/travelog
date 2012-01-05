package travelog.controller.travelog;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PostEntryController extends Controller {

    @Override
    public Navigation run() throws Exception {
        // TODO 何番目の記事かわかるようにする
        return forward("postEntry.jsp");
    }
}
