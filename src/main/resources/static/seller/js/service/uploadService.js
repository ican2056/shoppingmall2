app.service("uploadService",function($http){
	this.uploadFile = function(){
		// 向后台传递数据:
        //alert("向后台传递数据>>>");
		var formData = new FormData(document.getElementById("form_upload"));
        var file = document.getElementById("upload_img_id").files[0];
		// 向formData中添加数据:
		formData.append("file",file);
        //alert("下面的 代码");

		return $http({
			method:'post',
			url:'/seller/fileload/uploadFile.do',
			data:formData,
			headers:{'Content-Type':undefined} ,// Content-Type : text/html  text/plain
			transformRequest:angular.identity
			//浏览器会帮我们把Content-Type 设置为 multipart/form-data.
		});
	}
	
});