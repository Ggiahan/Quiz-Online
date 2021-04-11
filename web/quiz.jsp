<%-- 
    Document   : quiz
    Created on : 31-Jan-2021, 11:59:53
    Author     : DELL
--%>

<%@page import="java.util.Map"%>
<%@page import="hanlg.AnswerQuiz.AnswerQuizObject"%>
<%@page import="tblQuestionandAnswer.tblQuestionandAnswerDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Quiz</title>
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
        <style>
            span1{border: solid 1px #ACACAC; padding: 2px; size:12px ;color: mediumvioletred}
        </style>
        <script language="javascript">
            function startTimer(duration, display) {
                var timer = duration, minutes, seconds;
                timeout = setInterval(function () {
                    minutes = parseInt(timer / 60, 10);
                    seconds = parseInt(timer % 60, 10);
                    var timeout = null;
                    var fiveMinutes = 60 * m + s,
                            minutes = minutes < 10 ? "0" + minutes : minutes;
                    seconds = seconds < 10 ? "0" + seconds : seconds;
                    if (minutes == 0 && seconds == 0) {
                        clearTimeout(timeout);
                        document.getElementById("Submit").click();
                        //if (confirm("Timeout")) {
                        // document.getElementById("Submit").click();
                        // } else{
                        // document.getElementById("Submit").click;
                        //}
                        return false;
                    }
                    display.textContent = "00:" + minutes + ":" + seconds;
                    var Phút = document.getElementById('Phút');
                    Phút.setAttribute("value", minutes);
                    var Giây = document.getElementById('Giây');
                    Giây.setAttribute("value", seconds);
                    if (--timer < 0) {
                        clearTimeout(timeout);
                    }
                }, 1000);
            }

            window.onload = function () {
                h = parseInt(document.getElementById('h_val').value);
                m = parseInt(document.getElementById('m_val').value);
                s = parseInt(document.getElementById('s_val').value);
                var fiveMinutes = 60 * m + s,
                        display = document.querySelector('#time');
                startTimer(fiveMinutes, display);
            };

            function stop() {
                clearTimeout(timeout);
            }


        </script>

        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div class="wrap-login100 col-xl-7 p-l-55 p-r-55 p-t-1 p-b-30">
                <div >
                    <input type="hidden" id="h_val" placeholder="Giờ" value="0"/> <br/>
                    <%String phut = request.getAttribute("Phút").toString();%>
                    <input type="hidden" id="m_val" placeholder="Phút" value="<%=phut%>"/> <br/>
                    <%String giay = request.getAttribute("Giây").toString();%>
                    <input type="hidden" id="s_val" placeholder="Giây" value="<%=giay%>"/>
                </div>


                <form  action="AnswerAction">

                    <input type="hidden" id="Giờ" name="Giờ" /> <br/>
                    <input type="hidden"  id="Phút" name="Phút"/> <br/>
                    <input type="hidden"  id="Giây"name="Giây" />
                    <c:if test="${not empty sessionScope.STUDENT}">
                        <c:set var="student" value="${sessionScope.STUDENT}"/>
                        <a class="txt2 hov1">
                            Wellcome,${student.name} 
                        </a>    <a href="logout" class="txt2 hov1">
                            Log Out
                        </a>
                    </c:if>
                    <div class=" pull-right
                         des-1 col-xl-2">
                        <%  long millis = System.currentTimeMillis();
                            java.sql.Date date = new java.sql.Date(millis);
                            out.print(date.toString());
                        %>
                    </div> <br/>
                    <div class=" pull-right  col-xl-2"> <strong><span1 id="time">00:<%=phut%>:<%=giay%></span1>  </strong></div>
                                <%--
                                <div class=" pull-right  col-xl-2"> <strong>
                                        <span1 id="h">0</span1> :
                                        <span1 id="m">0</span1> :
                                        <span1 id="s">0</span1><br/>
                                        <input type="hidden" value="Start" ondblclick ="start()"/>
                                        <input type="hidden" value="Stop" onclick="stop()"/> 
                                    </strong>
                                </div> --%>
                    <br/><br/>

                    <%
                        List<tblQuestionandAnswerDTO> DTOQuestion = (List<tblQuestionandAnswerDTO>) session.getAttribute("LISTQUESTION");
                        String currentquestion = request.getAttribute("COUNT").toString();
                        int number = Integer.parseInt(currentquestion);
                        int count = 1;
                        boolean finish = false;
                        if (DTOQuestion != null) {
                            for (tblQuestionandAnswerDTO dto : DTOQuestion) {
                                if (finish == false) {
                                    if (count != number) {
                                        count += 1;
                                    } else {
                                        finish = true;
                    %> 

                    <input type="hidden" name="studentID" value="${student.email} "/>
                    <input type="hidden" name="Subject" value="<%=dto.getSubject()%>"/>
                    <span class="login100-form-title p-b-37">
                        <%=currentquestion%> .<%=dto.getQuestion_content()%>
                        <input type="hidden" name="currentquestion" value="<%=currentquestion%>"/>
                        <input type="hidden" name="QuestionId" value="<%=dto.getQuestionid()%>"/>
                        <input type="hidden" name="correctAnswer" value="<%=dto.getCorrect_Answer()%>"/>
                        <input type="hidden" name="correctAnswer" value="<%=dto.getCorrect_Answer()%>"/>
                    </span>
                    <br/>
                    <div class="wrap-input100 validate-input m-b-20 text-center" data-validate="Enter email"                       
                         <span class="focus-input100 ">

                        </span>
                        <%
                            AnswerQuizObject SelectAnswers = (AnswerQuizObject) session.getAttribute("SELECTANSWERS");
                            boolean selected = false;
                            if (SelectAnswers != null) {
                                //3. Cust get items
                                Map<Integer, String> SelectAnswer = SelectAnswers.getSelectAnswers();
                                for (int questionid : SelectAnswer.keySet()) {
                                    if (selected == false) {

                                        if (questionid == number) {
                                            selected = true;
                                            if (SelectAnswer.get(questionid).equalsIgnoreCase("A")) {
                        %>

                        <input type="radio" name="Answer" value="A" onclick="start()" checked="" /> a)<%=dto.getAnswerA()%> <br/>
                        <input type="radio" name="Answer" value="B" onclick="start()"/>b)<%=dto.getAnswerB()%><br/>
                        <input type="radio" name="Answer" value="C"onclick="start()" />c)<%=dto.getAnswerC()%> <br/>
                        <input type="radio" name="Answer" value="D"onclick="start()" />d)<%=dto.getAnswerD()%> <br/>
                        <%} else if (SelectAnswer.get(questionid).equalsIgnoreCase("B")) {%>
                        <input type="radio" name="Answer" value="A" onclick="start()" /> a)<%=dto.getAnswerA()%> <br/>
                        <input type="radio" name="Answer" value="B" onclick="start()" checked="" />b)<%=dto.getAnswerB()%><br/>
                        <input type="radio" name="Answer" value="C"onclick="start()" />c)<%=dto.getAnswerC()%> <br/>
                        <input type="radio" name="Answer" value="D"onclick="start()" />d)<%=dto.getAnswerD()%> <br/>

                        <%} else if (SelectAnswer.get(questionid).equalsIgnoreCase("C")) {%>
                        <input type="radio" name="Answer" value="A" onclick="start()" /> a)<%=dto.getAnswerA()%> <br/>
                        <input type="radio" name="Answer" value="B" onclick="start()"  />b)<%=dto.getAnswerB()%><br/>
                        <input type="radio" name="Answer" value="C"onclick="start()" checked=""/>c)<%=dto.getAnswerC()%> <br/>
                        <input type="radio" name="Answer" value="D"onclick="start()" />d)<%=dto.getAnswerD()%> <br/>

                        <%} else if (SelectAnswer.get(questionid).equalsIgnoreCase("C")) {%>
                        <input type="radio" name="Answer" value="A" onclick="start()" /> a)<%=dto.getAnswerA()%> <br/>
                        <input type="radio" name="Answer" value="B" onclick="start()" />b)<%=dto.getAnswerB()%><br/>
                        <input type="radio" name="Answer" value="C"onclick="start()" />c)<%=dto.getAnswerC()%> <br/>
                        <input type="radio" name="Answer" value="D"onclick="start()"checked="" />d)<%=dto.getAnswerD()%> <br/>
                        <%}
                                        }
                                    }
                                }
                            }
                            if (selected == false) {%>


                        <input type="radio" name="Answer" value="A" onclick="start()"  /> a)<%=dto.getAnswerA()%> <br/>
                        <input type="radio" name="Answer" value="B" onclick="start()"/>b)<%=dto.getAnswerB()%><br/>
                        <input type="radio" name="Answer" value="C"onclick="start()" />c)<%=dto.getAnswerC()%> <br/>
                        <input type="radio" name="Answer" value="D"onclick="start()" />d)<%=dto.getAnswerD()%> <br/>
                        <%}%>
                    </div>

                    <div class="text-center p-t-3 p-b-20">

                    </div>

                    <div class="container-login100-form-btn col-xl-4 pull-left">
                        <%if (number != 1) {%>
                        <button class="login100-form-btn"  name="btAction" value="Previous" type="submit" >
                            <a class="fa fa-reply">  </a> Previous 
                        </button>
                        <%}%>

                    </div>

                    <div class="container-login100-form-btn col-xl-4 pull-right">
                        <%if (number != 10) {%>
                        <button class="login100-form-btn" name="btAction" value="Next" type="submit" >
                            <a class="fa fa-check"></a>  Next
                        </button>
                        <%}%>
                    </div>
                    <%}
                                }
                            }
                        }%>


                    <div class="container-login100-form-btn">

                        <button class=" col-xl-5 login100-form-btn" id="Submit" name="btAction" value="Submit" type="submit" >
                            <a class="fa fa-check"></a>  SUBMIT
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