<script type="text/javascript" src='js/jquery.min.js'></script>
<script type='text/javascript'>
	$(document).ready(
			function() {
				$.ajax({
					type : "GET",
					url : "GetMessages",
					dataType : "json",
					success : function(data) {
						if (data.Messages.length) {
							$.each(data.Messages, function(i, data) {
								var msg_data = "<div id='msg"+data.msg_id+"'>"
										+ data.message + "</div>";
								$(msg_data).appendTo("#content");
							});
						} else {
							$("#content").html("No Results");
						}
					}
				});
			});
</script>
<br />
<div id='content'></div>