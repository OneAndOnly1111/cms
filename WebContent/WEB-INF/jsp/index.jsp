<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台首页</title>
<link rel="stylesheet" type="text/css" href="theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="theme/1/css/front/style.css">
</head>

<body>
<div id="main">
    <div class="top">
    	<div class="topbg">
            <div class="logo_sign">
            	<div class="logo"></div>
                <div class="sign">
                	<span>欢迎您系统管理员</span>
                    <span class="sp_home">
                      <a href="toIndex.action">首页</a>
                    </span>
                    <span class="sp_backstage">
                      <a href="manager/toIndex.action">后台管理</a>
                    </span>
                    <span class="sp_signout">退出</span>
                </div>
            </div> 
            <div class="nav">
            	<ul class="navUI">
                	<li><a href="javascript:void(0);">首页</a></li>
                	<li><a href="javascript:void(0);">特色活动</a></li>
                    <c:forEach items="${categoryList}" var ="c">
                      <li><a href="javascript:void(0);">${c.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="banner">
            	<div class="banimg"><img src="theme/1/images/front/banner.png"></div>
            </div>
        </div>
    </div>
    <!-- 主体部分 -->
    <div class="content">
    	<div class="congw">
            
            <div class="clear"></div>
            
            <div class="box">
                <h2>热销商品展示区域</h2> 
                 <figure>
                    <img src="theme/1/images/front/image1.jpg"/>
                    <figcaption>
                        <strong>商品介绍：新品尝鲜，厨师长热荐</strong>
                        <span class="price"><strong>￥39.8</strong></span>
                        <div id="buy"><a href="###">立即抢购</a></div>
                    </figcaption>
                 </figure>
                 <figure>
                    <img src="theme/1/images/front/image5.jpg"/>
                    <figcaption>
                        <strong>商品介绍:特色沙拉，甜美可口</strong>
                        <span class="price"><strong>￥35.8</strong></span>
                        <div id="buy"><a href="###">立即抢购</a></div>
                    </figcaption>
                 </figure>
                 <figure>
                    <img src="theme/1/images/front/image7.jpg"/>
                    <figcaption>
                        <strong>商品介绍：意大利黑椒牛排，嚼劲十足</strong>
                        <span class="price"><strong>￥79.9</strong></span>
                        <div id="buy"><a href="###">立即抢购</a></div>
                    </figcaption>
                 </figure>
                 <figure>
                    <img src="theme/1/images/front/image8.jpg"/>
                    <figcaption>
                        <strong>商品介绍:新鲜的水果沙拉</strong>
                        <span class="price"><strong>￥35.8</strong></span>
                        <div id="buy"><a href="###">立即抢购</a></div>
                    </figcaption>
                 </figure>
                 <figure>
                    <img src="theme/1/images/front/image6.jpg"/>
                    <figcaption>
                        <strong>商品介绍:饭后甜点，红豆冰沙</strong>
                        <span class="price"><strong>￥12.9</strong></span>
                        <div id="buy"><a href="###">立即抢购</a></div>
                    </figcaption>
                 </figure>
                 <figure>
                    <img src="theme/1/images/front/image2.jpg"/>
                    <figcaption>
                        <strong>商品介绍:饭后甜点</strong>
                        <span class="price"><strong>￥15.5</strong></span>
                        <div id="buy"><a href="###">立即抢购</a></div>
                    </figcaption>
                 </figure>      
            </div>
            <div class="box">
            	
            </div>
            <div class="link">
            	<div class="linelink">
            		<span>友情链接：</span><a href="http://www.carrefour.com.cn/">家乐福</a><a href="http://www.rt-mart.com.cn/">大润发</a><a href="http://www.crv.com.cn/">华润万家</a><a href="http://www.metro.com.cn/">麦德龙</a>
                </div>
            </div>
        </div>
    </div>
    
    <div class="footer">
    	<div class="foot">
        	<p>杰普信息发布系统 技术支持：<a href="javascript:void(0)">上海杰普软件科技有限公司</a>      电话：021-xxxxxxx</p>
        </div>
    </div>
</div>
</body>
</html>
