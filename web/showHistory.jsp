<%-- 
    Document   : showHistory
    Created on : 21-Feb-2021, 03:57:37
    Author     : DELL
--%>

<%@page import="java.util.List"%>
<%@page import="hanlg.tblHistoryScore.tblHistoryScoreDTO"%>
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
            <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-37"  style="width:700px">

                <form class="login100-form validate-form" action="HistoryServlet">
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
                    <div class="wrap-input100 validate-input m-b-20  text-center" data-validate="Enter email"     >   
                        <div class=" pull-right col-xl-10" >
                            Subject 
                            <select name="subject">
                                <option value="prj311">Java Destop</option>
                                <option value="prj321">Java Web</option>
                            </select>

                            <input type="hidden" name="page" value="1"/>
                            <input type="hidden" name="studentID" value="${student.email} "/>
                            <button class="col-xl-2 col-lg-6 col-12 pull-right login100-form-btn" >
                                Search
                            </button> 
                        </div> </div>
                    <br/>
                    <br/>
                    <br/>

                    <%
                        List<tblHistoryScoreDTO> DTOHistory = (List<tblHistoryScoreDTO>) request.getAttribute("LISTHISTORY");
                        String currentquestion = request.getAttribute("COUNT").toString();
                        int number = Integer.parseInt(currentquestion);
                        int count = 1;
                        // boolean finish = false;
                        if (DTOHistory != null) {


                    %> 


                    <div class="text-center p-t-3 p-b-20 col-xl-2 col-lg-6 col-md-6 col-sm-8 col-12">
                        <table border="1" class="text-center " style="width:550px">
                            <thead>
                                <tr class="text-center">
                                    <th class="text-center">State</th>
                                    <th class="text-center">Correct </th>
                                    <th class="text-center">Incorrect </th>
                                    <th class="text-center">Grade/10.00</th>                                       
                                </tr>
                            </thead>
                            <tbody>
                                <%                                         for (tblHistoryScoreDTO dto : DTOHistory) {
                                %>
                                <tr>
                                    <td><%=dto.getSubmitDate()%></td>
                                    <td><%=dto.getCountCorrectAnswer()%></td>
                                    <td><%=10 - dto.getCountCorrectAnswer()%></td>
                                    <td><%=dto.getScore()%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>

                    </div>
                    <%}%>
                </form>
                <form class="login100-form validate-form" action="student">
                    <div class="container-login100-form-btn">

                        <button class="login100-form-btn" >
                            Back to the Course
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
