package com.example.demo.src.user;

//import com.example.demo.src.main.model.GetDemoDayAlarmReq;
import com.fasterxml.jackson.databind.ser.Serializers;
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


//
//    @ResponseBody
//    @GetMapping("/mainPage")
//    public BaseResponse<List<GetMainPage>> getmain(){
//        List<GetMainPage> getMainPages = userProvider.getMainPages();
//        return new BaseResponse<>(getMainPages);
//    }

    //

    /**
     * 1d월20일 메인페이지
     * @return
     */
    @ResponseBody
    @GetMapping("/mainPage")
    public BaseResponse<GetMainNation> getMainNationBaseResponse(){
        GetMainNation getMainNation = userProvider.getMainPages();
        return new BaseResponse<>(getMainNation);
    }

//    /**
//     * 1월 20일 두번째 화면 페이지
//     */
//    @ResponseBody
//    @GetMapping("moviedrama")
//    public BaseResponse<>

//    /**
//     * 세부화면 1/20
//     */
//    @ResponseBody
//    @GetMapping("/detailPage")
//    public BaseResponse<GetDetailPage> getDetailPageBaseResponse(@RequestParam(value = "name", required = true) String name){
//        GetDetailPage getDetailPage = userProvider.getDetailPage(name);
//        return new BaseResponse<>(getDetailPage);
//    }


    /**
     * 메인페이지 윗부분 1/21
     */
//    @ResponseBody
//    @GetMapping("/mainPageOne")
//    public BaseResponse<List<GetMainPage>> getMainPageBaseResponse(){
//        List<GetMainPage> getMainPage = userProvider.getMainPage();
//        return new BaseResponse<>(getMainPage);
//    }

    @ResponseBody
    @GetMapping("/mainPageOne")
    public BaseResponse<List<GetMainPage>> getMainPageBaseResponse(){
        List<GetMainPage> getMainPage = userProvider.getMainPage();
        return new BaseResponse<>(getMainPage);
    }

    /**
     * 국가별 추천
     * @return
     */
    @ResponseBody
    @GetMapping("/mainPageTwo")
    public BaseResponse<List<GetMainPage>> getmainpagenation(){
        List<GetMainPage> getMainPages = userProvider.getmainpagenation();
        return new BaseResponse<>(getMainPages);
    }

    /**
     * 상세페이지 하나
     */
    @ResponseBody
    @GetMapping("/detailPageOne")
    public BaseResponse<GetDetailPageOne> getDetailPageOneBaseResponse(@RequestParam(value = "name", required = true) String name){
            GetDetailPageOne getDetailPageOne = userProvider.getDetailPageOne(name);
            return new BaseResponse<>(getDetailPageOne);
    }

    /**
     * 리뷰데이터
     */
    @ResponseBody
    @GetMapping("/review")
    public BaseResponse<List<GetReview>> getrivew(){
        List<GetReview> getReview = userProvider.getReview();
        return new BaseResponse<>(getReview);
    }
    




//
//    /**
//     * 카테고리
//     */
//    @ResponseBody
//    @GetMapping("/category")
//    public BaseResponse<List<GetCategory>> getcategory(@RequestParam(value = "pageCategory", required = true) String category){
//            List<GetCategory> getCategories = userProvider.getCategories(category);
//            return new BaseResponse<>(getCategories);
//
//    }
//
//    /** 세부화면
//     *
//     */
//    @ResponseBody
//    @GetMapping("/detailPage")
//    public BaseResponse<GetDetailPage> getDetailPageBaseResponse(@RequestParam(value = "name", required = true) String name){
//            GetDetailPage getDetailPage = userProvider.getDetailPage(name);
//            return new BaseResponse<>(getDetailPage);
//
//    }
//
//    /**
//     * 메인뷰 가로화면
//     *
//     */
//    @ResponseBody
//    @GetMapping("/mainPageListView")
//    public BaseResponse<GetCategoryListView> getCategoryListViewBaseResponse() {
//        GetCategoryListView getCategoryListView = userProvider.getCategoryListView();
//        return new BaseResponse<>(getCategoryListView);
//    }

    //
//    /**
//     *
//     */
//    @ResponseBody
//    @GetMapping("/demoday")
//    public BaseResponse<String> demodayalarm(@RequestBody GetDemoDayAlarmReq getDemoDayAlarmReq,
//                                             @RequestHeader (value = "userUid") String userUid,
//                                             @RequestHeader (value = "welfareUid") String welfareUid) throws BaseException{
//        String  test = "success";
//        mainService.demodayalarm(getDemoDayAlarmReq,userUid,welfareUid);
//        return new BaseResponse<>(test);
//
//    }





}
