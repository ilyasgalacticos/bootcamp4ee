<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.javaee.db.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%@include file="head.jsp"%>
        <title><%=siteName%> || Home Page</title>
    </head>
    <body>
        <div class="container" style="min-height: 800px;">
            <%@include file="navbar.jsp"%>
            <div class="row mt-3">
                <div class="col-12">
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#addUserModal">
                        + Add User
                    </button>
                    <div class="modal fade" id="addUserModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="/add-client" method="post">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Add User</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
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
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button class="btn btn-success">ADD CLIENT</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <%
                    ArrayList<User> users = (ArrayList<User>) request.getAttribute("polzovateli");
                    if(users != null){
                        for(User user : users){
                %>
                    <div class="col-3 mt-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title"><%=user.getName()%></h5>
                                <p class="card-text">With ID - <%=user.getId()%> from <%=user.getCity()%>
                                   <%=user.getAge()%> years old</p>
                                <a href="/details?id=<%=user.getId()%>" class="btn btn-primary btn-sm">Details</a>
                            </div>
                        </div>
                    </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
