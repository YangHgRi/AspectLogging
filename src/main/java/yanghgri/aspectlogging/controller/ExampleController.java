package yanghgri.aspectlogging.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.aspectlogging.annotation.LogAPI;

/**
 * @author YangHgRi
 */
@RestController
public class ExampleController {
    @PostMapping("resource/query")
    @LogAPI(url = "/api/query", comment = "查询接口", service = "xx平台", client = "xx用户")
    public String queryResource(@RequestBody String query) {
        return query;
    }
}