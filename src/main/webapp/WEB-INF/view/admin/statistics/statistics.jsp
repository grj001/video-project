<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>"> 
<title>统计 - 统计分析</title>
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/echarts.js"></script>

<script type="text/javascript">
	$(function(){
		var theData = "${data}".split(",");
		var theTimes = "${times}".split(",");
		 // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
               var option = {
            color:['#7cb5ed'],
        	title: {
                text: '课程平均播放次数',
                subtext: '数据来源:zhiyou100.com',
                sublink:'http://www.zhiyou100.com',
                left: 'center',
                textStyle: {
                    color: '#323232',
                    fontWeight: 'normal',
                    fontSize: 20
                },
                subtextStyle:{
                    color: '#323232'
                }
            },
            legend: {
                y: 'bottom',
                data: ['平均播放次数'],
                textStyle: {
                	color:'#323232',
                    fontSize: 14,
                    fontWeight:'600'
                },
                icon:'circle'
            },
            tooltip: {},
            xAxis: {
                //data: ["1","2","3","4","5","6"],
               	data: theData,
                axisLabel: {
                    textStyle: {
                        color: '#888'
                    }
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: '#cdd7eb',
                    }
                }
            },
            yAxis: {
            	 name: '平均播放次数(times)',
                 nameLocation: 'middle',
                 nameGap: 40,
                 nameTextStyle: {
                     color: '#888',
                     //fontSize: 16
                 },
                 axisLine: {
                     show: false
                 },
                 axisTick: {
                     show: false
                 }
            },
            series: [{
                name: '平均播放次数',
                type: 'bar',
                barWidth: '33%',
                //data: [1,2,3,4,5,6]
                data: theTimes
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option); 
	});
	</script>
</head>
<body>
	
	<!-- 引入公用的导航信息 -->
	<jsp:include page="/WEB-INF/view/admin/header.jsp">
		<jsp:param value="statistics" name="fromJsp"/>
	</jsp:include>
	
	<div class="container">
		<div class="jumbotron">
  			<h2>统计 - 统计分析</h2>
		</div>
		<div class="row">
			<div id="main" style="min-width:400px;height:400px"></div>
		</div>
	</div>
</body>
</html>