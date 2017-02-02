package com.epam.task03.lib.dao.impl;

import com.epam.task03.lib.bean.Category;
import com.epam.task03.lib.bean.News;
import com.epam.task03.lib.bean.Request;
import com.epam.task03.lib.dao.exception.DAOException;
import org.testng.annotations.*;

/**
 * Created by Yauheni_Borbut on 2/1/2017.
 */
public class NewsDAOTxtImplTest {

    NewsDAOTxtImpl newsDAOTxt;

    @BeforeMethod
    public void setUp(){
        newsDAOTxt = new NewsDAOTxtImpl();
    }

    @AfterMethod
    public void tearDown() {
        newsDAOTxt = null;
    }

    @DataProvider(name = "Illegal objects of news")
    public Object[][] getIllegalNews() {
        return new Object[][] {
                {new News()},
                {null}
        };
    }

    @DataProvider(name = "Illegal objects of request")
    public Object[][] getIllegalRequests() {
        return new Object[][] {
                {new Request()},
                {null}
        };
    }

    @Test
    public void tstPositiveAddNews() throws Exception {
        News news = new News("News", Category.BOOK, "12:21:2334");
        newsDAOTxt.addNews(news);
    }

    @Test
    public void tstPositiveGetNewsByDate() throws Exception {
        Request request = new Request();
        request.setDateToRequest("12:21:2034");
        newsDAOTxt.getNewsByDate(request);
    }

    @Test
    public void tstPositiveGetNewsByCategory() throws Exception {
        Request request = new Request();
        request.setCategoryToRequest(Category.BOOK);
        newsDAOTxt.getNewsByCategory(request);
    }

    @Test
    public void tstPositiveGetNewsByTitle() throws Exception {
        Request request = new Request();
        request.setTitleToRequest("Some title");
        newsDAOTxt.getNewsByTitle(request);
    }

    @Test(dataProvider = "Illegal objects of news", expectedExceptions = DAOException.class)
    public void tstNegativeAddNews(News news) throws Exception {
        newsDAOTxt.addNews(news);
    }

    @Test(dataProvider = "Illegal objects of request", expectedExceptions = DAOException.class)
    public void tstNegativeGetNewsByTitle(Request request) throws Exception {
        newsDAOTxt.getNewsByTitle(request);
    }

    @Test(dataProvider = "Illegal objects of request", expectedExceptions = DAOException.class)
    public void tstNegativeGetNewsByCategory(Request request) throws Exception {
        newsDAOTxt.getNewsByCategory(request);
    }

    @Test(dataProvider = "Illegal objects of request", expectedExceptions = DAOException.class)
    public void tstNegativeGetNewsByDate(Request request) throws Exception {
        newsDAOTxt.getNewsByDate(request);
    }
}