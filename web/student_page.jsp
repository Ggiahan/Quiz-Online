<%-- 
    Document   : student_page
    Created on : 30-Jan-2021, 15:00:35
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
  <c:if test= "${ empty sessionScope.STUDENT}">
        <c:redirect url="index"/>
    </c:if>

        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-37">

                <form class="login100-form validate-form" action="getlistquestion">
                    <c:if test="${not empty sessionScope.STUDENT}">
                        <c:set var="student" value="${sessionScope.STUDENT}"/>
                        <a class="txt2 hov1 ">
                            Wellcome,${student.name} </a>  <a style="color: #ffffff"> || </a> 
                        </a>      
                         </c:if>
                        <div class="right">
                            <%  long millis = System.currentTimeMillis();
                                java.sql.Date date = new java.sql.Date(millis);
                                out.print(date.toString());
                            %>
                        </div><a  href="logout" style="column-fill: auto;color: #004085"class="txt1 hov1">
                            <h5> Log Out </h5>
                        </a>
                        <span class="login100-form-title p-b-37">
                            Quiz

                        </span>

                        <div class="wrap-input100 validate-input m-b-20 text-center" data-validate="Enter email"                       
                             <span class="focus-input100 ">
                                Subject 
                            </span>
                            <select name="subject">
                                <option value="prj311">Java Destop</option>
                                <option value="prj321">Java Web</option>
                            </select>
                        </div>

                        <div class="text-center p-t-3 p-b-20">

                        </div>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" >
                                Attempt quiz now
                            </button>
                        </div>
                        </form>
                        <div class="text-center p-t-1 p-b-20"> </div>
                          <form class="login100-form validate-form" action="SearchHistoryServlet">
                        <div class="container-login100-form-btn">
                            <input type="hidden" name="page" value="1"/>
                             <input type="hidden" name="studentID" value="${student.email} "/>
                              <input type="hidden" name="subject" value="All"/>
                            <button style="background-color:#005cbf"class="login100-form-btn" >
                                View Transcript
                            </button>
                        </div>

                </form>
            </div>
        </div>
        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>