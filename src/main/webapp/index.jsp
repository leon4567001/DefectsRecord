<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>缺陷记录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/my.css">

    <script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/json/json-minified.js"></script>

    <!--通过jquery设定窗口样式-->
    <script>
        jQuery(document).ready(function($) {
            $('.theme-login').click(function(){
                $('.theme-popover-mask').fadeIn(100);
                $('.theme-popover').slideDown(200);
            })
            $('.theme-poptit .close').click(function(){
                $('.theme-popover-mask').fadeOut(100);
                $('.theme-popover').slideUp(200);
            })
        })
    </script>
</head>

<body>
<!--不隐藏的按钮-->
<div class="theme-buy">
    <a class="btn btn-primary btn-large theme-login" href="javascript:">缺陷录入</a>
</div>
<!--隐藏的界面-->
<div class="theme-popover">
    <div class="theme-poptit">
        <a href="javascript:" title="关闭" class="close">×</a>
        <h3>缺陷录入</h3>
    </div>
    <div class="theme-popbod dform">
        <form class="theme-signin" name="inputform" action="services/Definput" method="post">
            <ol>
                <li><h4>请录入缺陷描述后点击提交!</h4></li>
                <li><strong>产线：</strong>
                    <select name="line" id="line" onchange="onSelectChange(this,'category');" style="width:100px" >
                    </select>
                </li>
                <li><strong>类型：</strong>
                    <select name="category" id="category" onchange="onSelectChange(this,'detail');" style="width:100px" >
                    </select>
                </li>
                <li><strong>缺陷：</strong>
                    <select name="detail" id="detail" style="width:100px">
                    </select>
                </li>
                <li><strong>班次：</strong>
                    <select name="banci" id="banci" style="width:100px">
                        <option value="">--请选择班次--</option>
                        <option value="A">A班</option>
                        <option value="B">B班</option>
                    </select>
                </li>
                <li><strong>车型：</strong><input class="ipt" type="text" name="cx" value="XXX" size="20" /></li>
                <li>
                </li>
                <li><strong>零件号：</strong><input class="ipt" type="text" name="ljh" value="001" size="20" /></li>
                <li>
                    <strong>发生日期：</strong>
                    <input id="dotime" type="date" name="def_time" value="2018-01-01"/>
                </li>
                <li><input class="btn btn-primary" type="submit" name="submit" value=" 提 交 " /></li>
            </ol>
        </form>
    </div>
</div>
<!--增加弹出窗口后的遮盖效果-->
<div class="theme-popover-mask"></div>
</body>

<script type="text/javascript">

    function onSelectChange(obj,toSelId){
        //alert(obj.value);
        setSelect(obj.value,toSelId);
    }

    function setSelect(fromSelVal,toSelId){
        //alert(fromSelVal);
        //alert(toSelId);
        document.getElementById(toSelId).innerHTML="";
        jQuery.ajax({
            url: "<%=path%>/services/GetMenu",
            cache: false,
            data:{"code":fromSelVal,"grade":toSelId},
            success: function(data){
                createSelectObj(data,toSelId);
            }
        });
    }

    function createSelectObj(data,toSelId){
        var arr = jsonParse(data);
        if(arr != null && arr.length>0){
            var obj = document.getElementById(toSelId);
            obj.innerHTML="";
            var nullOp = document.createElement("option");
            nullOp.setAttribute("value","");
            obj.appendChild(nullOp);
            for(var o in arr){
                var op = document.createElement("option");
                op.setAttribute("value",arr[o].code);
                //op.text=arr[o].name;//这一句在ie下不起作用，用下面这一句或者innerHTML
                op.appendChild(document.createTextNode(arr[o].name));
                obj.appendChild(op);
            }
        }
    }
    setSelect('1','line');
</script>

</html>