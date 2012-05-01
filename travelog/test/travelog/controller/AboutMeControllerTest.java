package travelog.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import travelog.controller.AboutMeController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AboutMeControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/travelog/aboutMe");
        AboutMeController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/travelog/aboutMe.jsp"));
    }
}
