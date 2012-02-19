package travelog.controller.admin;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import travelog.model.Tag;
import travelog.service.TagService;

public class TagAutoCompleteController extends Controller {

    private TagService service = new TagService();
    
    protected static final Logger logger =
            Logger.getLogger(TagAutoCompleteController.class.getName());

    @Override
    public Navigation run() throws Exception {
        
        // Ajaxにて送られた検索文字を取得
        String q = asString("q");
        
        // 検索文字を使用して、DBから取得
        List<Tag> tags = service.getTagList(q);
        
        // カンマ区切り文字列に連結
        StringBuilder tagNames = new StringBuilder();
        for (int i = 0; i < tags.size(); i++) {
            tagNames.append(tags.get(i).getName()).append(",");
        }
        
        // レスポンスに書き込み
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(tagNames.toString());
        response.flushBuffer();
        
        return null;
    }
}
