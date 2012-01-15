package travelog.controller.travelog;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import travelog.model.Tag;
import travelog.service.TagService;

public class PostEntryController extends Controller {
    
    @Override
    public Navigation run() throws Exception {
        
        // TODO 現在投稿されている記事数を検索して、何番目の記事かわかるようにする
        return forward("postEntry.jsp");
    }
}
