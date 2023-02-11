<%-- 
    Document   : index
    Created on : 08 Feb 2023, 5:09:55 PM
    Author     : PULE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="center">
            <h1>Form Page</h1>
            <form action="CustomerServlet" method="post" enctype="multipart/form-data">


                <div class="txt_field">
                    <input type="text" name="firstName" required/>
                    <label>First Name</label>
                </div>
                <br>
                <div class="txt_field">
                    <input type="text" name="lastName" required/>
                    <label>Last Name</label>
                </div>
                <br>
                <div class="txt_field">
                    <input type="text" name="dob" required/>
                    <label>Date Of Birth</label>
                </div>
                <br>
                <br>
                <div>
                    <input type="file" name="file" accept=".csv">
                    <label>Upload FIle</label>
                    <br>
                    <br>
                    <input type="submit" name="submit" value="Submit"/>
                </div>



            </form>
        </div>

    </body>
</html>
