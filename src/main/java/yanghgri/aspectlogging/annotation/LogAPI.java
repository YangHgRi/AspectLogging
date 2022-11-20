package yanghgri.aspectlogging.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YangHgRi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAPI {
    /**
     * 接口url
     *
     * @return {@link String}
     */
    String url();

    /**
     * 接口注释
     *
     * @return {@link String}
     */
    String comment();

    /**
     * 服务端
     *
     * @return {@link String}
     */
    String service();

    /**
     * 客户端
     *
     * @return {@link String}
     */
    String client();
}