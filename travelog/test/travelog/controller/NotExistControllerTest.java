package travelog.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import travelog.controller.NotExistController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NotExistControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/travelog/notExist");
        NotExistController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/travelog/notExist.jsp"));
    }
}
