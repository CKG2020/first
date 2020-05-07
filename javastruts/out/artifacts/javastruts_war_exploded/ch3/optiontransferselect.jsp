<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form>
    <s:optiontransferselect
        label="Favourite Cartoons Characters"
        name="leftSideCartoonCharacters"
        list="{'陈凯歌', '陈', '陈'}"
        doubleName="rightSideCartoonCharacters"
        doubleList="{'0304', '1802', '16'}" />
</s:form>



<%--<select>--%>
<%--</select>--%>
<%--<s:form>--%>
<%--<s:optiontransferselect--%>
             <%--label="选择你喜欢图书" --%>
<%--              name="cnbook"--%>
                <%--leftTitle="中文图书"  list="#request.lists"  listValue="name" listKey="name"--%>
<%--              doubleName="enBook"  rightTitle="外文图书" doubleList="{'JavaScrip:The definitive Guide','export one-to-one'}"  multiple="true"--%>
<%--              addToLeftLabel="向左移动" addToRightLabel="向右移动" addAllToRightLabel="全部右移" addAllToLeftLabel="全部左移"--%>
<%--               allowSelectAll="true" headerKey="cnKey" headerValue="选择图书" emptyOption="true"   doubleHeaderKey="enKey"--%>
<%--               doubleHeaderValue="选择外文图书" doubleMultiple="true" doubleEmptyOption="true">--%>
<%--   </s:form>--%>



</body>
</html>
