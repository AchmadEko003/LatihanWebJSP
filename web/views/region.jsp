<%-- 
    Document   : region
    Created on : Dec 11, 2018, 9:32:26 AM
    Author     : Ignatius
--%>

<%@page import="java.util.List"%>
<%@page import="models.Region"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="controllers.services.RegionService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Region JSP Page</title>
    </head>
    <body>
        <%  String idEdit = "", nameEdit = "";
            if (session.getAttribute("isiRegion") != null) {
                Region r = (Region) session.getAttribute("isiRegion");
                idEdit = r.getRegionId().toString();
                nameEdit = r.getRegionName();
            }
            if (session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
            }
        %>
        <a href="../loadRegion">Home</a>
        <form action="../addRegion" method="POST">
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <td>Region Id</td>
                        <td>:</td>
                        <td><input type="text" name="regionId" value="<%= idEdit%>" /></td>
                    </tr>
                    <tr>
                        <td>Region Name</td>
                        <td>:</td>
                        <td><input type="text" name="regionName" value="<%= nameEdit%>" /></td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center">
                            <input type="submit" value="Simpan" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <hr>
        <form action="../searchRegion">
            <select name="categories">
                <option value="regionId" selected="">Region Id</option>
                <option value="regionName">Region Name</option>
            </select>
            <input type="text" name="data" value="" />
            <input type="submit" value="Search" />
        </form>
        <hr>
        <h1 align="center">Tabel Region</h1>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>Region ID</th>
                    <th>Region Name</th>
                    <th colspan="2">Action(s)</th>
                </tr>
            </thead>
            <tbody>
                <% if (session.getAttribute("datas") != null) {
                        List<Region> regions = (List<Region>) session.getAttribute("datas");
                        for (Region region : regions) {%>
                <tr>
                    <td><%= region.getRegionId()%></td>
                    <td><%= region.getRegionName()%></td>
                    <td><a href="../editRegion?id=<%= region.getRegionId()%>">
                            <input type="submit" value="Edit" /></a></td>
                    <td><a href="../deleteRegion?id=<%= region.getRegionId()%>">
                            <input type="submit" value="Delete" /></a></td>
                </tr>
                <%}
                } else {%>
                <tr><td colspan="4">Data tidak ditemukan</td></tr>
                    <%}
                    %>
            </tbody>
        </table>
        <%  session.removeAttribute("isiRegion");
            session.removeAttribute("message");
            session.removeAttribute("datas");%>
    </body>
</html>
