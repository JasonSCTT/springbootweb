package com.jason.springbootweb.Base;

import com.jason.springbootweb.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController {
    public ResponseVo responseVo = new ResponseVo();

}
