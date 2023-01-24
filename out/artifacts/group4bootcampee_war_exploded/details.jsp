<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.javaee.db.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <%
        User clientUser = (User) request.getAttribute("user");
    %>
    <title>
        <%=siteName%> ||
        <%
            if(clientUser!=null){
                out.print(clientUser.getName());
            }
        %>
    </title>
</head>
<body>
<div class="container" style="min-height: 800px;">
    <%@include file="navbar.jsp"%>
    <div class="row">
        <div class="col-6 mx-auto">
            <%
                if(clientUser!=null){
            %>
            <form>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=clientUser.getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>AGE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=clientUser.getAge()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>CITY : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=clientUser.getCity()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editUserModal">
                            EDIT USER
                        </button>
                        <button type="button" class="btn btn-danger ms-2" data-bs-toggle="modal" data-bs-target="#deleteUserModal">
                            DELETE USER
                        </button>
                    </div>
                </div>
            </form>
            <div class="modal fade" id="editUserModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/update-client" method="post">
                            <input type="hidden" name="user_id" value="<%=clientUser.getId()%>">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit User</h1>
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
                                        <input type="text" class="form-control" name="user_name"
                                               placeholder="Insert name" value="<%=clientUser.getName()%>">
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
                                                <option <%=(clientUser.getAge()==i?"selected":"")%> ><%=i%></option>
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
                                                <option <%=(city.equals(clientUser.getCity())?"selected":"")%> ><%=city%></option>
                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
                                <button class="btn btn-success">UPDATE CLIENT</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="deleteUserModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/delete-client" method="post">
                            <input type="hidden" name="user_id" value="<%=clientUser.getId()%>">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5">Delete User</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h3 class="text-center">
                                    Are you sure?
                                </h3>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
                                <button class="btn btn-danger">DELETE CLIENT</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%
                }else{
            %>
                <h1 class="text-center mt-3">CLIENT NOT FOUND</h1>
            <%
                }
            %>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
