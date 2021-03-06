package com.sparrow.controller;

import com.sparrow.constant.SPARROW_ERROR;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.pager.PagerQuery;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.vo.HelloVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry on 2016/12/15.
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    private static Logger logger = LoggerFactory.getLogger(DefaultController.class);

    //@Autowired
    /**
     * same bean throw exception
     */
    private H2Controller sameHelloVo;

    @RequestMapping("/welcome")
    public ModelAndView welcome(HttpServletRequest request) {
        return new ModelAndView(request.getPathInfo());
    }

    @RequestMapping("/*")
    public ModelAndView all(HttpServletRequest request) {
        return new ModelAndView(request.getPathInfo());
    }

    //ResponseBody必须加才起作用

    @ResponseBody
    @RequestMapping("/business-error")
    public void error() throws BusinessException {
        Asserts.isTrue(true, SPARROW_ERROR.SYSTEM_SERVER_ERROR);
    }

    @ResponseBody
    @RequestMapping("/hello")
    public HelloVO hello() throws BusinessException {
        logger.error("sparing error");
        return new HelloVO("hello world", "zlz", "30");
    }

    @ResponseBody
    @RequestMapping("/hello-result")
    public Result helloResult() throws BusinessException {
        logger.error("sparing error");
        return Result.OK();
    }

    @ResponseBody
    @RequestMapping("/hello-list")
    public List<HelloVO> helloList() throws BusinessException {
        List<HelloVO> list = new ArrayList<HelloVO>();
        list.add(new HelloVO("hello", "zhangsn", "20"));
        list.add(new HelloVO("world", "lisi", "34"));
        return list;
    }

    @ResponseBody
    @RequestMapping("/hello-page-list")
    public PagerResult<HelloVO> helloPageList(PagerQuery pagerSearch) throws BusinessException {
        List<HelloVO> list = new ArrayList<HelloVO>();
        list.add(new HelloVO("hello", "zhangsn", "20"));
        list.add(new HelloVO("world", "lisi", "34"));

        PagerResult<HelloVO> pagerResult = new PagerResult<HelloVO>(pagerSearch.getCurrentPageIndex(),pagerSearch.getPageSize());
        pagerResult.setList(list);
        return pagerResult;
    }


}
