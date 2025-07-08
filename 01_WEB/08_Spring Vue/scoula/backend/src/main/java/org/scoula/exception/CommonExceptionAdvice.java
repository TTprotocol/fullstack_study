package org.scoula.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice   // 모든 컨트롤러에서 발생하는 예외처리
@Log4j2
@Order(2)
public class CommonExceptionAdvice {
    @ExceptionHandler(Exception.class)  // 모든 예외를 이 메서드에서 처리한다
    // 예외와 뷰에 출력하기 위한 Model을 받는다.
    // Model로 예외 객체를 뷰에 전달
    public String except(Exception ex, Model model) {
        log.error("Exception..................." + ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);

        return "error_page";    // jsp 이름을 반환한다.
    }

    @ExceptionHandler(NoHandlerFoundException.class)    // 404 요청 전용 처리
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(
        NoHandlerFoundException ex      // 404 예외 객체
    ) {
        return "/resources/index.html";
    }
}
