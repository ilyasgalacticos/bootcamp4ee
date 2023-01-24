<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.javaee.db.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title><%=siteName%> || Add Client</title>
</head>
<body>
<div class="container" style="min-height: 800px;">
    <%@include file="navbar.jsp"%>
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/add-client" method="post">
                <div class="row mt-3">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="user_name" placeholder="Insert name">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>AGE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select class="form-select" name="user_age">
                            <%
                                for(int i = 1; i <= 121; i++){
                            %>
                                <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>CITY : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select class="form-select" name="user_city">
                            <%
                                ArrayList<String> cities = (ArrayList<String>) request.getAttribute("goroda");
                                if(cities!=null){
                                    for(String city : cities){
                            %>
                                <option><%=city%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">ADD CLIENT</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
