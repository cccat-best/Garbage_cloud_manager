import org.junit.jupiter.api.Test;
import org.sipc.userserver.util.PasswordUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author tzih
 * @version v1.0
 * @since 2023.10.13
 */
//@SpringBootTest
//@ContextConfiguration(classes = PasswordUtil.class)
public class MyTest {

//    @Test
    public void nowTest() {
        System.out.println(PasswordUtil.getBPassword("123456"));
    }

}
