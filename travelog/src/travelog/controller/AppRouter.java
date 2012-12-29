package travelog.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {
    
    public AppRouter() {
        addRouting("/image/{imgId}", "/image?id={imgId}");
    }
}
