<%-- 
    Document   : admin_page
    Created on : 26-Jan-2021, 13:27:54
    Author     : DELL
--%>

<%@page import="tblQuestionandAnswer.tblQuestionandAnswerDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><!-- Basic -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">   

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>View Question</title>  
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">    
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <c:if test= "${ empty sessionScope.ADMIN}">
            <c:redirect url="index"/>
        </c:if>
        <!-- Start header -->
        <header class="top-navbar">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">

                <div class="container">

                    <a class="navbar-brand" href="index.html">
                        <img src="images/logo.png" alt="" />

                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-rs-food" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbars-rs-food">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active"><a class="nav-link" href="LoadQuestionServlet?search=All">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="CreateQuestion">Create new Question</a></li>
                            <li style=" color: #ffffff "class="nav-item"><a class="nav-link" href="logout">Log Out</a></li>

                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <!-- End header -->

        <!-- Start All Pages -->
        <div class="all-page-title page-breadcrumb"style="background-image: url('images/inline_image_preview.jpg');">
            <div class="container text-center">
                <div class="row">
                    <div style="" class="col-lg-12">

                        <h1>MANAGEMENT QUESTION BANK</h1>


                    </div>
                </div>
            </div>
        </div>
        <!-- End All Pages -->

        <!-- Start blog details -->





        <div class="blog-box">
            <div class="container">
                <c:if test="${not empty sessionScope.ADMIN}">
                    <c:set var="admin" value="${sessionScope.ADMIN}"/>
                    <div class="row">
                        <div class="col-3">
                            <div class="heading-title text-center">
                                <h3>welcome,${admin.name}</h3>
                            </div>
                        </div>
                    </div>
                </c:if>
                <div class="row">
                    <div class="col-xl-1 col-lg-8 col-12"></div>
                    <%
                        List<tblQuestionandAnswerDTO> DTOQuestion = (List<tblQuestionandAnswerDTO>) request.getAttribute("LISTQUESTION");

                        if (DTOQuestion != null) {
                    %>   
                    <div class="col-xl-8 col-lg-12 col-12">
                        <div class="blog-inner-details-page ">

                            <div class="blog-comment-box">
                                <div class="comment-item ">
                                    <div class="col-xl-10 col-lg-8 col-12">
                                        <%
                                            for (tblQuestionandAnswerDTO dto : DTOQuestion) {
                                        %>
                                        <div class="comment-item-right right-btn-re blog-search-form">
                                            <div class="pull-left text-center">
                                                <i class="fa "></i>
                                                <span><strong><%=dto.getQuestion_content()%></strong></span>
                                            </div>

                                            <div class="des-1 text-center">
                                                </br> 
                                                <%if (dto.getCorrect_Answer().equalsIgnoreCase("A")) {%>
                                                <p style="color: #28a745"><%=dto.getAnswerA()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerB()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerC()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerD()%></p>
                                                <% } else if (dto.getCorrect_Answer().equalsIgnoreCase("B")) {%>

                                                <p style="color: #b21f2d"> <%=dto.getAnswerA()%></p>
                                                <p style="color: #28a745"><%=dto.getAnswerB()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerC()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerD()%></p>
                                                <% } else if (dto.getCorrect_Answer().equalsIgnoreCase("C")) {%>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerA()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerB()%></p> 
                                                <p style="color: #28a745"><%=dto.getAnswerC()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerD()%></p>

                                                <% } else if (dto.getCorrect_Answer().equalsIgnoreCase("D")) {%>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerA()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerB()%></p>
                                                <p style="color: #b21f2d"> <%=dto.getAnswerC()%></p> 
                                                <p style="color: #28a745"><%=dto.getAnswerD()%></p>
                                                <% }%>
                                            </div>
                                            <div class="pull-left">
                                                <u class="fa " aria-hidden="true"></u>  
                                                <i>Subject :</i><span><b><%=dto.getSubject()%></b>  </span> <i style="color: #f8f9fa">-</i><i>Status :</i><span><b><%=dto.getStatus()%></b></span><i style="color: #f8f9fa"></i>
                                            </div> 
                                            <div class="pull-right ">
                                                <form action="delete">
                                                    <input type="hidden" name="QuestionId" value="<%=dto.getQuestionid()%>"/>
                                                    <button class="btn-success-success text-center"><i class="fa fa-remove" aria-hidden="true"></i>Delete</button>
                                                </form>
                                            </div>
                                            <div class="pull-right">
                                                <form action="update">
                                                    <input type="hidden" name="questionId" value="<%=dto.getQuestionid()%>"/>
                                                    <input type="hidden" name="cbSubject" value="<%=dto.getSubject()%>"/>
                                                    <input type="hidden" name="txtQuestion" value="<%=dto.getQuestion_content()%>"/>
                                                    <input type="hidden" name="txtAnswerA" value="<%=dto.getAnswerA()%>"/>
                                                    <input type="hidden" name="txtAnswerB" value="<%=dto.getAnswerB()%>"/>
                                                    <input type="hidden" name="txtAnswerC" value="<%=dto.getAnswerC()%>"/>
                                                     <input type="hidden" name="txtAnswerD" value="<%=dto.getAnswerD()%>"/>
                                                    <input type="hidden" name="cbCorrect" value="<%=dto.getCorrect_Answer()%>"/>
                                                    <input type="hidden" name="cbStatus" value="<%=dto.getStatus()%>"/>
                                                    <input type="hidden" name="action" value="SendInfor"/>

                                                    <button  class="btn-success-success text-center"><i class="fa fa-upload" aria-hidden="true"></i>Update</button>
                                                </form>
                                            </div>
                                        </div> 
                                        <%
                                            }
                                        %> 

                                    </div>
                                </div>
                            </div>

                            <div class="pull-left text-center">
                                <%
                                    if (request.getAttribute("COUNT") != null) {
                                        String number = request.getAttribute("COUNT").toString();
                                        int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
                                        int count = Integer.parseInt(number);
                                %>
                                <a>  
                                    <%
                                        for (int i = 0; i < count; i++) {
                                    %>

                                    <form action="LoadQuestion">
                                        <input name="search" type="hidden"value="All" >
                                        <input type="hidden" name="page" value="<%=i + 1%>"/>

                                        <%if (currentpage == i + 1) {%>
                                        <button class="btn-outline-primary active" style="size: 3" name="btAction" value=""  ><h4><%=i + 1%></h4> 
                                                <%} else {%>
                                            <button class="btn-outline-primary" style="size: 3" name="btAction" value=""  ><h4><%=i + 1%></h4> 
                                                    <%}%>
                                            </button>  
                                    </form>  
                                    <%} %>
                                </a>
                                <%   }%> 


                            </div>
                        </div> 
                    </div>
                    <%
                        }
                    %> 



                    <div class="col-xl-2 col-lg-4 col-md-6 col-sm-8 col-12 blog-sidebar">
                        <div class="right-side-blog ">

                            <h3>Search</h3>
                            <div class="blog-search-form">
                                <form action="LoadQuestion">
                                    <input name="search" type="hidden"value="content" >
                                    <input name="data" placeholder="Search name" type="text">
                                    <button class="search-btn">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </form>
                            </div>
                            <h3>Subject</h3>
                            <div class="blog-categories blog-search-form">
                                <ul>
                                    <li><a href="LoadQuestionServlet?search=Subject&data=Java Desktop"><span>Java Desktop</span></a></li>
                                    <li><a href="LoadQuestionServlet?search=Subject&data=Java Web"><span>Java Web</span></a></li>

                                </ul>
                            </div>
                            <h3>Status</h3>
                            <div class="blog-categories">
                                <ul>
                                    <li><a href="LoadQuestionServlet?search=Status&data=Activate"><span>Active</span></a></li>
                                    <li><a href="LoadQuestionServlet?search=Status&data=Deactivate"><span>Deactive</span></a></li>

                                </ul>
                            </div>



                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- End details -->



        <a href="#" id="back-to-top" title="Back to top" style="display: none;"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></a>

        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->

        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
