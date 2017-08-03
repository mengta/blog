<%--
  Created by IntelliJ IDEA.
  User: tianmeng
  Date: 2017/8/1
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${page.totalPage > 1}">
    <div>
        <ul class="pagination">
            <li><a class="pageList" href="javascript:;" pageNum="1">首页</a></li>
            <li><a class="pageList" href="javascript:;" pageNum="${page.lastPageNum}">上一页</a></li>
            <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="n">
                <li><a class="pageList" style="background-color:${n eq page.currentPageNum?'#eee':''}" href="javascript:;" pageNum="${n}">${n}</a></li>
            </c:forEach>
            <li><a class="pageList" href="javascript:;" pageNum="${page.nextPageNum}">下一页</a></li>
            <li><a class="pageList" href="javascript:;" pageNum="${page.totalPage}">尾页(${page.totalPage})</a></li>
        </ul>
    </div>
</c:if>
