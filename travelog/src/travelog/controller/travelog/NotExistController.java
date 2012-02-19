package travelog.controller.travelog;

import org.slim3.controller.Navigation;

public class NotExistController extends BaseController {

    @Override
    public Navigation exec() throws Exception {
        return forward("notExist.jsp");
    }
}
