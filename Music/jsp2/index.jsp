<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-9-4
  Time: ����8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="GBK" import="java.lang.String" %>
<html>
  <head>
    <title>$ע���û�$</title>
  </head>
  <body>
  <form  action="HttpServletSample" method="post" enctype="multipart/form-data" name="form1" >
    <table width="551" border="6">
      <tr> <td>�û�����</td>  <td> <input  type="text" name="username"></td></tr><br>
      <tr>       <td>��   �룺</td>  <td> <input type="password" name="password"></td></tr><br>
      <tr>    <td> ȷ   �ϣ�</td>    <td> <input type="password" name="repassword"></td> </tr><br>
      <tr> <td>�Ա�</td> <td><input  name=sex type="radio" value="��" checked="checked">��
        <input name="sex" type="radio" value="Ů" checked="checked">Ů</td>
      </tr><br>
      <tr>  <td> ѧ����</td>
        <td>
          <select name="schoolAge">  name="photo"
            <option   value="��ר"> ��ר </option>
            <option   value="����">   ����</option>
            <option value="�о���">�о���</option>
            <option value="��ʿ��"> ��ʿ��</option>
          </select>
        </td>
      </tr><br>
      <tr>
        <td> ���ã�</td>
        <td> <input  name="like" type="checkbox" value="��Ӿ">��Ӿ
          <input  name="like" type="checkbox" value="����">����
          <input name="like" type="checkbox" value="�ܲ�">�ܲ�
        </td>
      </tr><br>
      <tr>
        <td>��Ƭ��</td> <td>  <input   type="file" name="photo" > </td>
      </tr><br>
      <tr>
        <td> ���ܣ�</td> <td><textarea  name="introduce" rows="5" id="introduce"></textarea> </td>
      </tr><br>
      <tr>
        <td>   <input type="submit" name="Submit" value="ע��">
          <input   type="submit" name="Submit2" value="����">
        </td>
      </tr><br>

    </table>

  </form>
  </body>
</html>
