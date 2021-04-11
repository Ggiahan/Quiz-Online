<%-- 
    Document   : create_question
    Created on : 28-Jan-2021, 08:09:18
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
        <title>CREATE QUESTION</title>  
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
                            <li class="nav-item "><a class="nav-link" href="admin_page">Home</a></li>
                            <li class="nav-item active"><a class="nav-link" href="CreateQuestion">Create new Question</a></li>

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

                            <h2>CREATE QUESTION</h2>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <form id="contactForm">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="col-md-4">
                                        <div class="form-group">

                                            <select class="custom-select d-block form-control" id="guest" required data-error="Please Select Person">
                                                <option disabled selected> Major</option>
                                                <option value="1">SE</option>
                                                <option value="2">IA</option>
                                                <option value="3">3</option>

                                            </select>

                                            <select class="custom-select d-block form-control" id="guest" required data-error="Please Select Person">
                                                <option disabled selected> Subject</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                            <div class="help-block with-errors"></div>
                                        </div>  </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group"> 
                                        <textarea class="form-control" id="message" placeholder="Question " rows="4" data-error="Write your message" required></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>                              
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group"> 
                                        <textarea class="form-control" id="message" placeholder="True Answer  "  data-error="Write your message" required></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group"> 
                                        <textarea class="form-control" id="message" placeholder="Wrong answer 1"  data-error="Write your message" required></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group"> 
                                        <textarea class="form-control" id="message" placeholder="Wrong answer 2"  data-error="Write your message" required></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>


                                <div class="col-md-12">
                                    <div class="form-group"> 
                                        <textarea class="form-control" id="message" placeholder="Wrong answer 3"  data-error="Write your message" required></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                    <div class="submit-button text-center">
                                        <button class="btn btn-common" id="submit" type="submit">Submit</button>
                                        <div id="msgSubmit" class="h3 text-center hidden"></div> 
                                        <div class="clearfix"></div> 
                                    </div>
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
