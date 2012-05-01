package travelog.controller;

import org.slim3.controller.Navigation;

public class AboutMeController extends BaseController {

    @Override
    public Navigation exec() throws Exception {
        return forward("aboutMe.jsp");
    }
}
