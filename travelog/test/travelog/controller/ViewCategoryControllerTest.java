package travelog.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import travelog.controller.ViewCategoryController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ViewCategoryControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/travelog/viewCategory");
        ViewCategoryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/travelog/viewCategory.jsp"));
    }
}
