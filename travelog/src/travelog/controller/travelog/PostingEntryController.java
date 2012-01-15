package travelog.controller.travelog;

import java.util.MissingResourceException;

import org.slim3.controller.Controller;
import org.slim3.controller.ControllerConstants;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Errors;
import org.slim3.controller.validator.Validators;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.RequestMap;
import org.slim3.util.StringUtil;

import travelog.service.EntryService;

public class PostingEntryController extends Controller {
    
    private EntryService service = new EntryService();

    @Override
    public Navigation run() throws Exception {
        
        // バリデーション
        validate();
        // タグのチェック
        requestScope("tagArray", service.postingEntry(new RequestMap(request))); 
        
        return forward("postingEntry.jsp");
    }

    /**
     * バリデーションメソッド
     * @return バリデーションOKならtrue
     */
    private boolean validate() {
        Validators v = new Validators(request);
        // タイトル
        v.add("title", v.required());
        
        // 本文
        v.add("content", v.required());
        
        // バリデーション実行
        boolean validate = v.validate();
        
        // タグ
        // Slim3には配列に対する一括バリデーションは用意されてないので、自作
        String[] tagArray = (String[])requestScope("tagArray");
        boolean tagValidate = false;
        for (String tagName : tagArray) {
            if ( ! StringUtil.isEmpty(tagName)) {
                tagValidate = true;
            }
        }
        
        if ( ! tagValidate) {
            Errors errors = requestScope(ControllerConstants.ERRORS_KEY);
            String name = "tag";
            errors.put(name, ApplicationMessage.get("validator.required", getLabel(name)));
        }
        
        return validate && tagValidate;
    }
    
    /**
     * TODO 以下、{@link AbstractValidator#getLabel(String)}のコピペ
     * クラスにできないかどうか、試す必要あり
     * 
     * Returns the label.
     * 
     * @param name
     *            the name
     * @return the label
     */
    protected String getLabel(String name) {
        try {
            String label = ApplicationMessage.get("label." + name);
            if (label != null) {
                return label;
            }
        } catch (MissingResourceException ignore) {
        }
        return name;
    }
}
