<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-9-4
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="GBK" import="java.lang.String" %>
<html>
  <head>
    <title>$注册用户$</title>
  </head>
  <body>
  <form  action="HttpServletSample" method="post" enctype="multipart/form-data" name="form1" >
    <table width="551" border="6">
      <tr> <td>用户名：</td>  <td> <input  type="text" name="username"></td></tr><br>
      <tr>       <td>密   码：</td>  <td> <input type="password" name="password"></td></tr><br>
      <tr>    <td> 确   认：</td>    <td> <input type="password" name="repassword"></td> </tr><br>
      <tr> <td>性别：</td> <td><input  name=sex type="radio" value="男" checked="checked">男
        <input name="sex" type="radio" value="女" checked="checked">女</td>
      </tr><br>
      <tr>  <td> 学历：</td>
        <td>
          <select name="schoolAge">  name="photo"
            <option   value="大专"> 大专 </option>
            <option   value="本科">   本科</option>
            <option value="研究生">研究生</option>
            <option value="博士生"> 博士生</option>
          </select>
        </td>
      </tr><br>
      <tr>
        <td> 爱好：</td>
        <td> <input  name="like" type="checkbox" value="游泳">游泳
          <input  name="like" type="checkbox" value="听歌">听歌
          <input name="like" type="checkbox" value="跑步">跑步
        </td>
      </tr><br>
      <tr>
        <td>照片：</td> <td>  <input   type="file" name="photo" > </td>
      </tr><br>
      <tr>
        <td> 介绍：</td> <td><textarea  name="introduce" rows="5" id="introduce"></textarea> </td>
      </tr><br>
      <tr>
        <td>   <input type="submit" name="Submit" value="注册">
          <input   type="submit" name="Submit2" value="重置">
        </td>
      </tr><br>

    </table>

  </form>
  </body>
</html>
