<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Get past website</title>
<link href="static/bootstrap.min.css" rel="stylesheet">
<title>Hello</title>
<nav class="navbar navbar-inverse navbar-default navbar-static-top">
    <div class="container">
      <div class="navbar-header">
        <a class = "navbar-brand"> Get history of website </a>
        <button class = "navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
          </button>
      </div>
      <div class="collapse navbar-collapse navHeaderCollapse">
        <ul class="nav navbar-nav navbar-right">
            <li> <a> Home </a> </li>
        </ul>
      </div>
    </div>
  </nav>

<body><p>


<div class="container">
  <div class = "row">  
    <div class = "col-md-8 col-md-offset-2">
      <div class = "panel panel-default">
        <div class = "panel-body">
          <div class = "page-header col-md-offset-2">
            <h3 > Insert information
            </h3>
          </div>
          <div class="form-group">
            <form method="post" action="view" class = "form-horizontal">
                <label for="url" class = "col-lg-2 control-label">Website url&emsp;</label>
                <input type="text" id="url" name="url" class="form-control form-control-inline" pattern="[A-Za-z0-9_].{2,20}" maxlength="20" title="3 to 20 characters" required /><br>
                <label for="date_time" class = "col-lg-4 control-label">Date&emsp;</label>
                <input type="text" id="date_time" name="date_time" class="form-control form-control-inline" class="form-control" maxlength="20" required /><br>
              <p>
              	<input type="hidden" name="op" value="view">
                <input type="submit" value="View" class="btn btn-success pull-right">
              </p>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>




<%
	String url = (String) request.getAttribute("url");
	out.println("Fetching information for: "+ url);
%></p><p>
<%
	String date_time = (String) request.getAttribute("date_time");
	out.println("with state on date: "+ date_time);

	
	%></p>

	
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> 
<script src="static/angular.min.js"></script>
<script src="static/angular.js"></script> 
<script src="static/bootstrap.min.js"></script>
<script src="static/bootstrap.js"></script>
</body>
</html>