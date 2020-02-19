package com.example.demo.handler;

import com.example.demo.exception.CityException;
import com.example.demo.util.ResultVO;
import com.example.demo.util.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Pengfei
 * 2020-2-19 10:46
 */
@ControllerAdvice
public class CityExceptionHandler {

    @ExceptionHandler(value = CityException.class)
    @ResponseBody
    public ResultVO handlerSellerException(CityException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

}
