<%@ include file="../common/_frag/include/include.inc.jsp" %>

<script type="text/javascript">
	var statusCode="${statusCode}";
	var message="${message}";
	var navTabId = "${param.navTabId}";
	var forwardUrl="${forwardUrl}"; 
	var callbackType="${param.callbackType}"
	
	if (!statusCode) statusCode="${param.statusCode}";
	if (!message) message="${param.message}";

	var response = {statusCode:statusCode, 
		message:message, 
		navTabId:navTabId, 
		forwardUrl:forwardUrl, 
		callbackType:callbackType
	}
	if(window.parent.donecallback) window.parent.donecallback(response);
</script>