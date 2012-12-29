package travelog.controller.admin;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PostedImageControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/postedImage");
        PostedImageController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/postedImage.jsp"));
    }
}
