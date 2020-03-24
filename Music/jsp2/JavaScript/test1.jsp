<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-1="6
  Time: 下午7:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h2> javascripte能够做什么</h2>--%>
<%--<p  id="demo" > javascript 能够改变 HTML元素的样式 </p>--%>
<%--<button type="button" onclick="document.getElementById('demo').style.fontSize='35px'">点击</button>--%>
<%--<p id="demo1"> javascript 能够隐藏HTML元素</p>--%>
<%--    <button type="button" onclick="document.getElementById('demo1').style.display='none'">--%>
<%--        点击--%>
<%--    </button>--%>
<%--<p id="demo2"></p>--%>
<%--<script>document.getElementById("demo2").innerHTML="第一段";</script>--%>



<%--<script > function x() {--%>
<%--    documentpe.getElementById("demo3").innerHTML = "是是是";--%>
<%--}--%>
<%--</script>--%>
<%--<p id="demo3">一个测试</p>--%>
<%--<button type="button" onclick="x()">试试</button>--%>
<script>
document.write(5+6);
</script>

<button onclick="document.write(5+8);">haha</button>


<script>
    window.alert(5+6); //可自行定义警告框的内容
</script>

<script>
console.log(555)
</script>

<script>
    function myfunction(){
        // window.alert("lalala");
        // console.log("ok");
        document.getElementById("xxx").innerHTML="nishishui";

    }
</script>
<p id="xxx"> 这是 默写的，厉害吧</p>
<button type="button" onclick="myfunction()">按吧</button>





</body>
</html>
