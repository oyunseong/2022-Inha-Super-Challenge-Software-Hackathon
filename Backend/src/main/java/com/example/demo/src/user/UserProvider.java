package com.example.demo.src.user;


import com.example.demo.config.BaseException;
import com.example.demo.config.secret.Secret;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.AES128;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class UserProvider {

    private final UserDao userDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserProvider(UserDao userDao, JwtService jwtService) {
        this.userDao = userDao;
        this.jwtService = jwtService;
    }

    /**
     * 메인페이지
     * @return
     */

    public GetMainNation getMainPages() {
            List<GetMainPage> movie = userDao.mainPageRes();
            List<GetMainPage> nation = userDao.mainPageResnation();
            GetMainNation getMainNation = new GetMainNation(movie,nation);
            return getMainNation;
    }


    /**
     * 카테고리
     * @return
     */
    public List<GetCategory> getCategories(String category) {
        List<GetCategory> getCategories = userDao.getCategories(category);
        return getCategories;
    }

    /**
     * 세부화면
     * @return
     */
    public GetDetailPage getDetailPage(String name) {
        GetDetailPage getDetailPage = userDao.getDetailPage(name);
        return getDetailPage;
    }


    /**
     * 메인화면 가로뷰
     * @return
     */
    public GetCategoryListView getCategoryListView() {
        List<GetCategory> dramaview = userDao.getCategoriesview("drama");
        List<GetCategory> movieview = userDao.getCategoriesview("movie");
        List<GetCategory> musicview = userDao.getCategoriesview("music");
        List<GetCategory> foodview = userDao.getCategoriesview("food");

        GetCategoryListView getCategoryListView = new GetCategoryListView(dramaview,movieview,musicview,foodview);
        return getCategoryListView;
    }


//    public List<GetUserRes> getUsers() throws BaseException{
//        try{
//            List<GetUserRes> getUserRes = userDao.getUsers();
//            return getUserRes;
//        }
//        catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
//
//    public List<GetUserRes> getUsersByEmail(String email) throws BaseException{
//        try{
//            List<GetUserRes> getUsersRes = userDao.getUsersByEmail(email);
//            return getUsersRes;
//        }
//        catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//                    }
//
//
//    public GetUserRes getUser(int userIdx) throws BaseException {
//        try {
//            GetUserRes getUserRes = userDao.getUser(userIdx);
//            return getUserRes;
//        } catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
//
//    public int checkEmail(String email) throws BaseException{
//        try{
//            return userDao.checkEmail(email);
//        } catch (Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
//
//    public PostLoginRes logIn(PostLoginReq postLoginReq) throws BaseException{
//        User user = userDao.getPwd(postLoginReq);
//        String password;
//        try {
//            password = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(user.getPassword());
//        } catch (Exception ignored) {
//            throw new BaseException(PASSWORD_DECRYPTION_ERROR);
//        }
//
//        if(postLoginReq.getPassword().equals(password)){
//            int userIdx = userDao.getPwd(postLoginReq).getUserIdx();
//            String jwt = jwtService.createJwt(userIdx);
//            return new PostLoginRes(userIdx,jwt);
//        }
//        else{
//            throw new BaseException(FAILED_TO_LOGIN);
//        }
//
//    }


    public List<GetUserRes> logintest() {
        List<GetUserRes> getUserRes = userDao.logintest();
        return getUserRes;
    }
}
