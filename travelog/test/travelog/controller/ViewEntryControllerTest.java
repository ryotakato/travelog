package travelog.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import travelog.controller.ViewEntryController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ViewEntryControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/travelog/viewEntry");
        ViewEntryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/travelog/viewEntry.jsp"));
    }
}
