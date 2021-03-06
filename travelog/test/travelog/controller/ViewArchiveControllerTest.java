package travelog.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import travelog.controller.ViewArchiveController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ViewArchiveControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/travelog/viewArchive");
        ViewArchiveController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/travelog/viewArchive.jsp"));
    }
}
