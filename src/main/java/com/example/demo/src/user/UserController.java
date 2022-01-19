package com.example.demo.src.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.example.demo.config.BaseResponseStatus.*;
import static com.example.demo.utils.ValidationRegex.isRegexEmail;

@RestController
@RequestMapping("/app/users")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final UserProvider userProvider;
    @Autowired
    private final UserService userService;
    @Autowired
    private final JwtService jwtService;




    public UserController(UserProvider userProvider, UserService userService, JwtService jwtService){
        this.userProvider = userProvider;
        this.userService = userService;
        this.jwtService = jwtService;
    }


    //테스트
    @ResponseBody
    @GetMapping("/test")
    public BaseResponse<List<GetUserRes>> testlogin() {
        List<GetUserRes> getUserRes = userProvider.logintest();
        return new BaseResponse<>(getUserRes);


    }



    @ResponseBody
    @GetMapping("/mainPage")
    public BaseResponse<List<GetMainPage>> getmain(){
        List<GetMainPage> getMainPages = userProvider.getMainPages();
        return new BaseResponse<>(getMainPages);
    }

    //


    /**
     * 카테고리
     */
    @ResponseBody
    @GetMapping("/category")
    public BaseResponse<List<GetCategory>> getcategory(@RequestParam(value = "pageCategory", required = true) String category){
            List<GetCategory> getCategories = userProvider.getCategories(category);
            return new BaseResponse<>(getCategories);

    }

    /** 세부화면
     *
     */
    @ResponseBody
    @GetMapping("/detailPage")
    public BaseResponse<GetDetailPage> getDetailPageBaseResponse(@RequestParam(value = "name", required = true) String name){
            GetDetailPage getDetailPage = userProvider.getDetailPage(name);
            return new BaseResponse<>(getDetailPage);

    }

    /**
     * 메인뷰 가로화면
     *
     */
    @ResponseBody
    @GetMapping("/mainPageListView")
    public BaseResponse<GetCategoryListView> getCategoryListViewBaseResponse() {
        GetCategoryListView getCategoryListView = userProvider.getCategoryListView();
        return new BaseResponse<>(getCategoryListView);
    }





}
