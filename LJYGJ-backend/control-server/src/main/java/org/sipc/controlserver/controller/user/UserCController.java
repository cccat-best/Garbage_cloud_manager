package org.sipc.controlserver.controller.user;

import org.apache.dubbo.config.annotation.DubboReference;
import org.sipc.controlserver.pojo.dto.CommonResult;
import org.sipc.controlserver.pojo.dto.user.param.userC.UserCLoginParam;
import org.sipc.controlserver.pojo.dto.user.param.userC.UserCRegistParam;
import org.sipc.controlserver.pojo.dto.user.result.userC.CreditResult;
import org.sipc.controlserver.pojo.dto.user.result.userC.SearchResult;
import org.sipc.controlserver.pojo.dto.user.result.userC.UserCLoginResult;
import org.sipc.controlserver.service.user.UserCService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/c")
//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserCController {
    @DubboReference
    private UserCService userCService;

    @PostMapping("/login")
    public CommonResult<UserCLoginResult> userCLogin(@Validated @RequestBody UserCLoginParam param){
        return userCService.login(param);
    }

    @PostMapping("/regist")
    public CommonResult<String> userCRegister(@Validated @RequestBody UserCRegistParam param){
        return userCService.register(param);
    }

    @GetMapping("/search")
    public CommonResult<SearchResult> search(@RequestParam String content) {
        return userCService.search(content);
    }

    @GetMapping("/credit")
    public CommonResult<CreditResult> credit(@RequestParam Integer userId) {
        return userCService.credit(userId);
    }
}
