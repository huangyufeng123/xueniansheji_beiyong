package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.user;
import generator.service.userService;
import generator.mapper.userMapper;
import org.springframework.stereotype.Service;

/**
* @author Hasee
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-02-29 17:48:13
*/
@Service
public class userServiceImpl extends ServiceImpl<userMapper, user>
    implements userService{

}




