<%--
    Document   : Now.jsp
    Created on : 3 Mar, 2016, 4:40:56 PM
    Author     : Sanjoth Shaw
    Version    : 1.2
    Description: Read data from the database & print it out on a web page.
--%>

<%@page import="com.employee.demo.ConnectionHandler"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%--<%@page import="com.employee.demo.ConnectionHandler"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <!--<link rel="stylesheet" href="css/login_style.css" /> -->
        <title>Temperature Sensor Live</title>
    </head>
    <body>
                 <%
//allow access only if session exists
String user = null;
String branch_name = null;
ResultSet rsltst = null;
//if(session.getAttribute("user_id") == null){
 //   response.sendRedirect("login.html");
// }else
 //   user = (String) session.getAttribute("user_id");
  //  branch_name = (String) session.getAttribute("branch_name");
    try{
        response.setIntHeader("Refresh", 5);
    ConnectionHandler con = new ConnectionHandler();
    ConnectionHandler.getConnection();
     Statement statement = ConnectionHandler.conn.createStatement();
       //  rsltst = statement.executeQuery("SELECT * FROM employeedatabase.enery_details WHERE user_id = '"+user+"'");
         rsltst = statement.executeQuery("SELECT * FROM temp" ); //WHERE user_id = '"+user+"'");


    }catch(Exception e){
        e.printStackTrace();
}
%>
        <div class="top">
<%--	<div class="logobase"><img src="images/.png" /></div>  --%>
<div class="menu">
<ul>
 <%-- <li><a href="underdevelopment.jsp">Home</a></li>
  <li><a href="underdevelopment.jsp">News</a></li>
  <li><a href="underdevelopment.jsp">Contact</a></li>
  <li><a href="underdevelopment.jsp">About</a></li>
 <h1 align=left><font color=White><%=branch_name %> </font></h1> --%>
</ul>
    </div>
</div>


        <div id="tablebodymain">
        <div class="tablebodybase_inner">



<%-- <TABLE BORDER="1" cellpadding="5" style="border-collapse: collapse;" > --%>

<center><h1> <p style="font-family:courier;">IoT DB Model</p></h1></center>
    <TABLE BORDER="1" cellpadding="5" style="border-collapse: collapse; width: 100%; background-color: lemonchiffon; ">
         <th>S.No</th>
        <th>Sender IP</th>
        <th>Module</th>
        <th>Temperature Data</th>
        <th>Date & Time</th>
        <%
    while(rsltst.next()){
        %>
        <tr>
             <td align="center"><%=rsltst.getString("id") %></td>
            <td align="center"><%=rsltst.getString("Client_IP") %></td>
            <td align="center"><%=rsltst.getString("Module") %></td>
             <td align="center"><%=rsltst.getString("Temp") %></td>
              <td align="center"><%=rsltst.getString("Datetime") %></td>

        </tr>
        <%
    }
    rsltst.close();
    %>

    </table>
    </div>
</div>

    </body>
</html>
