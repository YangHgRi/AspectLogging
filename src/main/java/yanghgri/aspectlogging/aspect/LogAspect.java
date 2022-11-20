package yanghgri.aspectlogging.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import yanghgri.aspectlogging.annotation.LogAPI;
import yanghgri.aspectlogging.model.LogModel;

/**
 * @author YangHgRi
 */
@Aspect
@Slf4j
@Component
public class LogAspect {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /*private final LogMapper mapper;*/

    /*@Autowired
    public LogAspect(LogMapper mapper) {
        this.mapper = mapper;
    }*/

    /**
     * 织入添加了@LogAPI注解的方法
     */
    @Around("@annotation(yanghgri.aspectlogging.annotation.LogAPI)&& @annotation(logApi)")
    public Object logRequest(ProceedingJoinPoint pjp, LogAPI logApi) throws Throwable {
        LogModel log = new LogModel();
        String args = OBJECT_MAPPER.writeValueAsString(pjp.getArgs());
        log.setUrl(logApi.url());
        log.setComment(logApi.comment());
        log.setService(logApi.service());
        log.setClient(logApi.client());
        log.setRequestParam(args);
        Object response;
        try {
            response = pjp.proceed();
        } catch (Throwable t) {
            log.setErrorLog(t.getMessage());
            /*mapper.insert(log);*/
            throw t;
        }
        if (response != null) {
            log.setReturnValue(response.toString());
        }
        /*mapper.insert(log);*/
        return response;
    }
}