<%-- 
    Document   : UpdateQuestion
    Created on : 28-Jan-2021, 13:36:52
    Author     : DELL
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en"><!-- Basic -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">   

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Update Question</title>  
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
        <c:if test= "${sessionScope.role=='ADMIN'}">
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
                              <li class="nav-item "><a class="nav-link" href="LoadQuestionServlet?search=All">Home</a></li>
                            <li class="nav-item "><a class="nav-link" href="CreateQuestion">Create new Question</a></li>
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

        <!-- Start Contact -->
        <div class="contact-box">
            <div class="container">
                <div class="row">
                    <c:if test="${not empty sessionScope.ADMIN}">
                        <c:set var="admin" value="${sessionScope.ADMIN}"/>
                        <div class="col-3">
                            <div class="heading-title text-center">
                                <h3>welcome,${admin.name}</h3>

                            </div>
                        </div>
                    </c:if>
                    <div class="col-lg-12">
                        <div class="heading-title text-center">
                            <h2>UPDATE QUESTION</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <form id="" action="update">

                            <div class="col-md-8">
                                <div class="col-md-4">
                                    <div class="form-group">

                                        <select name="cbSubject" class="custom-select d-block form-control" id="guest" required data-error="Please Select Subject">
                                            <option disabled selected > Subject</option>
                                            <%
                                                if (request.getAttribute("cbSubject").toString().equals("Java Desktop")) {
                                            %>
                                            <option selected value="Prj311">Java Desktop</option> 
                                            <% } else {
                                            %>
                                            <option value="Prj311">Java Desktop</option>   
                                            <%
                                                }
                                                if (request.getAttribute("cbSubject").toString().equals("Java Web")) {
                                            %>
                                            <option selected value="Prj321">Java Web</option>  
                                            <% } else {   %>
                                            <option value="Prj321">Java Web</option>  
                                            <% }%>
                                        </select>
                                        <div class="help-block with-errors"></div>
                                    </div>  
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group"> 
                                    <input type="hidden" name="questionId" value="<%=request.getAttribute("questionId")%>"/>
                                    <input type="hidden" name="action" value="Update"/>

                                    <textarea name="txtQuestion"  class="form-control" id="message" placeholder="Question" rows="4" 
                                              data-error="Write your message" required><%=request.getAttribute("txtQuestion")%></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>                              
                            </div>
                            <div class="col-md-12">
                                <div class="form-group"> 
                                    <textarea name="txtAnswerA" class="form-control" id="message" placeholder="Answer A" data-error="Write your message" required>
                                        <%=request.getAttribute("txtAnswerA")%></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group"> 

                                    <textarea  name="txtAnswerB" class="form-control" id="message" placeholder="Answer B" data-error="Write your message" required>
                                        <%=request.getAttribute("txtAnswerB")%></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group"> 
                                    <textarea  name="txtAnswerC" class="form-control" id="message" placeholder="Answer C" data-error="Write your message" required>
                                        <%=request.getAttribute("txtAnswerC")%></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group"> 
                                    <textarea name="txtAnswerD" class="form-control" id="message" placeholder="Answer D" data-error="Write your message" required>
                                        <%=request.getAttribute("txtAnswerD")%></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="col-md-2 text-center">
                                    <div class="form-group text-center">
                                        <select name="cbCorrect" class="custom-select d-block form-control" id="guest" required data-error="Please Select Major">
                                            <option disabled selected> Correct Answer</option>
                                            <%
                                                if (request.getAttribute("cbCorrect").toString().equals("A")) {
                                            %>
                                            <option selected value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <%
                                            } else if (request.getAttribute("cbCorrect").toString().equals("B")) {
                                            %>
                                            <option value="A">A</option>
                                            <option selected value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <%
                                            } else if (request.getAttribute("cbCorrect").toString().equals("c")) {
                                            %>
                                            <option value="A">A</option>
                                            <option  value="B">B</option>
                                            <option selectedvalue="C">C</option>
                                            <option value="D">D</option>

                                            <%
                                            } else if (request.getAttribute("cbCorrect").toString().equals("D")) {
                                            %>
                                            <option value="A">A</option>
                                            <option  value="B">B</option>
                                            <option value="C">C</option>
                                            <option selected value="D">D</option>
                                            <% }%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-2 text-center">
                                    <div class="form-group text-center">
                                        <select name="cbStatus" class="custom-select d-block form-control" id="guest" required data-error="Please Select Major">

                                            <%
                                                if (request.getAttribute("cbStatus").toString().equals("Activate")) {
                                            %>
                                            <option selected value="2">Activate</option>
                                            <% } else {
                                            %>
                                            <option value="2">Activate</option>
                                            <%
                                                }
                                                if (request.getAttribute("cbStatus").toString().equals("Deactivate")) {
                                            %>
                                            <option selected value="3">Deactivate</option>
                                            <% } else {   %>
                                            <option value="3">Deactivate</option>
                                            <% }%>
                                        </select>
                                    </div>
                                </div>
                                <div class="submit-button text-center">
                                    <button class="btn btn-common" id="submit" type="submit">Submit</button>
                                    <div id="msgSubmit" class="h3 text-center hidden"></div> 
                                    <div class="clearfix"></div> 
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Contact -->




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
        <script src="js/jquery.mapify.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
        <script>
            $('.map-full').mapify({
                points: [
                    {
                        lat: 40.7143528,
                        lng: -74.0059731,
                        marker: true,
                        title: 'Marker title',
                        infoWindow: 'Live Dinner Restaurant'
                    }
                ]
            });
        </script>
    </body>
</html>
