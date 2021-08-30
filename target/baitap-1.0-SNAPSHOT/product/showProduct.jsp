<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.83.1">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/headers/">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Product Management</title>
    <style>
        nav li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }
        nav li a.active {
            background-color: #04AA6D;
            color: white;
        }
        nav li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
        a {
            text-decoration: none;
        }
        .slide {
            border-radius: 20px;
            width: 40%;
            float: left;
            box-shadow: 3px 3px 3px 0px green;
        }
        .order {
            float: left;
            width: 40%;
        }
        .description {
            clear: both;
        }
        .slide .slideshow-container {
            max-width: 1000px;
            position: relative;
            margin: auto;
        }
        .slide .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }
        .slide .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }
        .slide .dot {
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }
        .slide .active {
            background-color: #717171;
        }
        .slide .fade {
            -webkit-animation-name: fade;
            -webkit-animation-duration: 3s;
            animation-name: fade;
            animation-duration: 3s;
        }
        @-webkit-keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }
        @keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }
    </style>
</head>
<body style="width: 85vw; margin: auto">
<%@include file="include/header.jsp" %>
<%@include file="include/navbarleft.jsp" %>
<%@include file="include/navbarright.jsp" %>
<div style="margin: auto; text-align: center; width: 75%">
    <br>
    <div class="slide">
        <div class="slideshow-container">

            <div class="mySlides fade">
                <div class="numbertext">1 / 3</div>
                <img src=${product.folder}${product.img1} style="width:100%">
                <div class="text"></div>
            </div>

            <div class="mySlides fade">
                <div class="numbertext">2 / 3</div>
                <img src=${product.folder}${product.img2} style="width:100%">
                <div class="text"></div>
            </div>

            <div class="mySlides fade">
                <div class="numbertext">3 / 3</div>
                <img src=${product.folder}${product.img3} style="width:100%">
                <div class="text"></div>
            </div>

        </div>
        <br>

        <div style="text-align:center">
            <span class="dot"></span>
            <span class="dot"></span>
            <span class="dot"></span>
        </div>
    </div>
    <div class="order">
        <c:if test="${product != null}">
            <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
        </c:if>
        <h2>
            <c:out value='${product.name}' />
        </h2>
        <h4>
            HSD còn <c:out value='${product.hsd}' /> ngày
        </h4>
        <h2>
            <c:out value='${product.price}' />
        </h2>
    </div>
    <div class="description">
        <table border="1" cellpadding="5">
            <tr>
                <th>Trademark:</th>
                <td>
                    <c:out value='${product.trademark}' />
                </td>
            </tr>
            <tr>
                <th>Made In:</th>
                <td>
                    <c:out value='${product.madeIn}' />
                </td>
            </tr>
            <tr>
                <th>Type Product:</th>
                <td>
                    <c:out value='${product.type}' />
                </td>
            </tr>
            <tr>
                <th>Volume:</th>
                <td>
                    <c:out value='${product.volume}' />
                </td>
            </tr>
            <tr>
                <th>Using Product:</th>
                <td>
                    <c:out value='${product.using}' />
                </td>
            </tr>
        </table>
    </div>
    <div>
        <br>
        <div align="center">
        </div>
    </div>
</div>
<%@include file="include/footer.jsp" %>
<script>
    window.onscroll = function() {scrollFunction()};
    function scrollFunction() {
        if (document.body.scrollTop > 40 || document.documentElement.scrollTop > 40) {
            document.getElementById("navbarleft").style.left = "0px";
            document.getElementById("navbarright").style.right = "0px";
        } else {
            document.getElementById("navbarleft").style.left = "-300px";
            document.getElementById("navbarright").style.right = "-300px";
        }
    }
    let slideIndex = 0;
    showSlides();

    function showSlides() {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
        setTimeout(showSlides, 2000); // Change image every 2 seconds
    }
</script>
</body>
</html>
